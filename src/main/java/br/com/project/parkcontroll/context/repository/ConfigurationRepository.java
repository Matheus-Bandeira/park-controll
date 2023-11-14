package br.com.project.parkcontroll.context.repository;

import br.com.project.parkcontroll.context.entity.ParkSpacesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConfigurationRepository extends JpaRepository<ParkSpacesEntity, Long> {

    @Query(
            value = "SELECT spaces FROM CONFIGURATION ORDER BY ID DESC LIMIT 1;",
            nativeQuery = true)
    Long getPakingSpaces();
}
