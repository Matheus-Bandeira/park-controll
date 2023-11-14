package br.com.project.parkcontroll.context.repository;

import br.com.project.parkcontroll.context.entity.FlowCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlowCarRepository extends JpaRepository<FlowCarEntity, Long> {

    Optional<FlowCarEntity> findByPlaca(String placa);
}
