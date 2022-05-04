package es.beonit.testjava2022manuelfernandezventura.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static LocalDateTime parseLocalDateTimeFromString(String dateString, String patternDate){
        final var formatter = DateTimeFormatter.ofPattern(patternDate);
        return LocalDateTime.parse(dateString, formatter);
    }

    public static String formatLocalDateTimeToStr(LocalDateTime localDate, String patternDate) {
        final var formatter = DateTimeFormatter.ofPattern(patternDate);
        return localDate.format(formatter);
    }
}
