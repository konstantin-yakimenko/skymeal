package ru.jakimenko.skymeal.util.converter;

import org.springframework.format.Formatter;
import ru.jakimenko.skymeal.util.TimeUtil;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by konst on 06.05.17.
 */
public class LocalDateFormatter implements Formatter<LocalDate> {
    @Override
    public LocalDate parse(String s, Locale locale) throws ParseException {
        return TimeUtil.parseLocalDate(s);
    }

    @Override
    public String print(LocalDate localDate, Locale locale) {
        return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
