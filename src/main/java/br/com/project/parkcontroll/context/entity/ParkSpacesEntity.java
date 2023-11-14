package br.com.project.parkcontroll.context.entity;

import jakarta.persistence.*;
import lombok.Data;


@Table(name = "CONFIGURATION")
@Entity
@Data
public class ParkSpacesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long spaces;
}
