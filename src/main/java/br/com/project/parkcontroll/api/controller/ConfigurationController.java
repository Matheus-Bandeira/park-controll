package br.com.project.parkcontroll.api.controller;

import br.com.project.parkcontroll.api.dto.ParkingSpacesDto;
import br.com.project.parkcontroll.api.service.ConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping("/configuration")
@RequiredArgsConstructor
@RestController
public class ConfigurationController {

    private final ConfigurationService configurationService;

    @PostMapping
    public ResponseEntity configurationParkingSpaces(@RequestBody ParkingSpacesDto parkingSpaces) {
        configurationService.configurarVaga(parkingSpaces);
        return ResponseEntity.ok(parkingSpaces);
    }

    @GetMapping
    public Long getParkingSpaces() throws Exception {
        return configurationService.getParkingSpaces();
    }
}
