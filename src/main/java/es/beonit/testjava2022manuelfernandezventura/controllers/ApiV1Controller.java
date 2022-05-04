package es.beonit.testjava2022manuelfernandezventura.controllers;

import es.beonit.testjava2022manuelfernandezventura.dto.PriceDto;
import es.beonit.testjava2022manuelfernandezventura.services.PriceService;
import es.beonit.testjava2022manuelfernandezventura.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ApiV1Controller {

    /* Servicios */
    @Autowired
    private PriceService priceService;

    @GetMapping("/{idBrand}/productos/{idProduct}/tarifa")
    public PriceDto findPrices(
            @PathVariable(name = "idProduct") Integer idProduct,
            @PathVariable(name = "idBrand") Integer idBrand,
            @RequestParam(name = "date") String dateStr
    ){
        //TODO validar date con un modelo y un custom validator
        final var localDate = DateUtils.parseLocalDateTimeFromString(dateStr, "yyyy-MM-dd-HH.mm.ss");
        return priceService.findPrice(idBrand, idProduct, localDate);
    }
}
