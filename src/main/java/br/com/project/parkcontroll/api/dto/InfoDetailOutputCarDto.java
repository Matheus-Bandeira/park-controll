package br.com.project.parkcontroll.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class InfoDetailOutputCarDto {

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime entrada;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime saida;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private BigDecimal tarifa;
}
