package br.com.project.parkcontroll.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ParkingSpacesDto {

    @NotNull
    private Long spaces;
}
