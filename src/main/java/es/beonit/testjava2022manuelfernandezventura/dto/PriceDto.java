package es.beonit.testjava2022manuelfernandezventura.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {
    private Integer brandId;
    private Integer priceList;
    private Integer productId;
    private String date;
    private Double price;
    private String currency;
}
