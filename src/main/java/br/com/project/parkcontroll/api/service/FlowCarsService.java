package br.com.project.parkcontroll.api.service;

import br.com.project.parkcontroll.api.dto.InfoDetailMovimentCarDto;
import br.com.project.parkcontroll.api.dto.InfoDetailOutputCarDto;
import br.com.project.parkcontroll.context.entity.FlowCarEntity;
import br.com.project.parkcontroll.context.repository.FlowCarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class FlowCarsService {

    private final FlowCarRepository flowCarRepository;


    public InfoDetailMovimentCarDto inputFlowCars(InfoDetailMovimentCarDto infoDetailMovimentCarDto) {
        ModelMapper modelMapper = new ModelMapper();
        infoDetailMovimentCarDto.setEntrada(LocalDateTime.now());
        FlowCarEntity flowCarEntity = modelMapper.map(infoDetailMovimentCarDto, FlowCarEntity.class);
        var FlowCarEntitySave = flowCarRepository.save(flowCarEntity);

        var resposta = modelMapper.map(FlowCarEntitySave, InfoDetailMovimentCarDto.class);
        return  resposta;
    }

    public InfoDetailOutputCarDto outputFlowCars(String placa) {

        InfoDetailMovimentCarDto infoDetailMovimentCarDto = new InfoDetailMovimentCarDto();
        ModelMapper modelMapper = new ModelMapper();
        var response = flowCarRepository.findByPlaca(placa);
        if(response.isPresent()) {
            var entity = response.get();
            entity.setSaida(LocalDateTime.now());
            entity.setTarifa(calcularTarifa(entity.getEntrada(), entity.getSaida()));
            flowCarRepository.save(entity);
//            infoDetailMovimentCarDto = modelMapper.map(entity, InfoDetailMovimentCarDto.class);
            var infoDetailOutuput = modelMapper.map(entity, InfoDetailOutputCarDto.class);

            return infoDetailOutuput;
        }
        return null;
    }

    // TODO: PARTINDO DO PRINCIPIO QUE 60 MIN = R$6.00
    // TODO: VAI COBRAR O PROPORCIONAL DOS MINUTOS
    private BigDecimal calcularTarifa(LocalDateTime entrada, LocalDateTime saida) {
        Duration duracao = Duration.between(entrada, saida);
        BigDecimal tarifa = new BigDecimal(duracao.toMinutes() * 0.1);
        return tarifa;
    }

    private InfoDetailOutputCarDto montaResposta() {
        return null;
    }
}
