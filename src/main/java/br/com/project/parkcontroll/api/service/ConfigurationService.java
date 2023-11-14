package br.com.project.parkcontroll.api.service;

import br.com.project.parkcontroll.api.dto.ParkingSpacesDto;
import br.com.project.parkcontroll.context.entity.ParkSpacesEntity;
import br.com.project.parkcontroll.context.repository.ConfigurationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    public ResponseEntity configurarVaga(ParkingSpacesDto parkingSpacesDto) {
        ModelMapper modelMapper = new ModelMapper();
        ParkSpacesEntity parkSpacesEntity = modelMapper.map(parkingSpacesDto, ParkSpacesEntity.class);
        configurationRepository.save(parkSpacesEntity);
        return ResponseEntity.ok(parkingSpacesDto);
    }

    public Long getParkingSpaces() throws Exception {
        try {
            return configurationRepository.getPakingSpaces();
        } catch (Exception e) {
            throw  new Exception("Não há vagas configuradas");
        }

    }
}
