package br.com.project.parkcontroll.context.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Table(name = "TEMP_FLOW_CAR")
@Entity
@Data
public class FlowCarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "placa", length = 50, unique = true)
    private String placa;

    @Column(name = "modelo", length = 100)
    private String modelo;

    @Column(name = "cor", length = 30)
    private String cor;

    //@Column(columnDefinition = "TIMESTAMP")
    @Column
    private LocalDateTime entrada;

    //@Column(columnDefinition = "TIMESTAMP")
    @Column
    private LocalDateTime saida;

    @Column(precision = 18, scale = 2)
    private BigDecimal tarifa;
    //TODO: UTILIZAR LOCALDATETIME OU INSTANT

}
