package es.beonit.testjava2022manuelfernandezventura.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity implements Serializable{

    @Data
    @Builder
    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Pk implements Serializable{
        @Column(name = "BRAND_ID")
        private Integer brandId;
        @Column(name = "START_DATE")
        private LocalDateTime startDate;
        @Column(name = "END_DATE")
        private LocalDateTime endDate;
        @Column(name = "PRICE_LIST")
        private Integer priceList;
        @Column(name = "PRODUCT_ID")
        private Integer productId;
    }

    @EmbeddedId
    private Pk id;
    @Column(name = "PRIORITY")
    private Integer priority;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "CURR")
    private String currency;
}
