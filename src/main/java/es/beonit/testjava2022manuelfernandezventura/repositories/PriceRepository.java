package es.beonit.testjava2022manuelfernandezventura.repositories;

import es.beonit.testjava2022manuelfernandezventura.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<PriceEntity, PriceEntity.Pk> {
    //TODO ver por que esto no busca bien las fechas
    PriceEntity findFirstByIdBrandIdAndIdProductIdAndIdStartDateGreaterThanEqualAndIdEndDateLessThanEqualOrderByPriorityDesc(Integer brandId, Integer productId, LocalDateTime startDate, LocalDateTime endDate);

    //TODO ver el limit
    @Query(
            "select p from PriceEntity p where p.id.brandId = :brandId and p.id.productId = :productId and :date between p.id.startDate and p.id.endDate order by p.priority desc"
    )
    List<PriceEntity> findByBrandIdAndProductIdAndValidDate(
            @Param("brandId") Integer brandId,
            @Param("productId") Integer productId,
            @Param("date") LocalDateTime localDateTime
    );
}
