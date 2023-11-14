package br.com.project.parkcontroll.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

@Data
public class InfoDetailMovimentCarDto implements Serializable {

    private String placa;
    private String modelo;
    private String cor;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime entrada;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime saida;
}
