package br.com.project.parkcontroll.api.controller;

import br.com.project.parkcontroll.api.dto.InfoDetailMovimentCarDto;
import br.com.project.parkcontroll.api.dto.InfoDetailOutputCarDto;
import br.com.project.parkcontroll.api.service.FlowCarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/flow-cars")
@RequiredArgsConstructor
@RestController
public class FlowCarsController {

    // TODO: 2 ENDPOINTS ENTRADA DE VEÍCULO E SAÍDA

    private final FlowCarsService flowCarsService;


    @PostMapping("/input")
    public InfoDetailMovimentCarDto inputFlowCars(@RequestBody InfoDetailMovimentCarDto dto) {
        return this.flowCarsService.inputFlowCars(dto);
    }

    @GetMapping("/output/{placa}")
    public InfoDetailOutputCarDto outputFlowCars(@PathVariable("placa") String placa) {
        return this.flowCarsService.outputFlowCars(placa);
    }
}
