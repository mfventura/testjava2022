package es.beonit.testjava2022manuelfernandezventura.services;

import es.beonit.testjava2022manuelfernandezventura.dto.PriceDto;
import es.beonit.testjava2022manuelfernandezventura.repositories.PriceRepository;
import es.beonit.testjava2022manuelfernandezventura.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public PriceDto findPrice(Integer idBrand, Integer idProduct, LocalDateTime localDate) {
        final var priceEntityList = priceRepository.findByBrandIdAndProductIdAndValidDate(idBrand, idProduct, localDate);

        return priceEntityList != null && !priceEntityList.isEmpty() ?

                PriceDto.builder()
                .brandId(priceEntityList.get(0).getId().getBrandId())
                .productId(priceEntityList.get(0).getId().getProductId())
                .price(priceEntityList.get(0).getPrice())
                .currency(priceEntityList.get(0).getCurrency())
                .priceList(priceEntityList.get(0).getId().getPriceList())
                .date(DateUtils.formatLocalDateTimeToStr(localDate, "yyyy-MM-dd-HH.mm.ss"))
                .build()

                : null;
    }
}
