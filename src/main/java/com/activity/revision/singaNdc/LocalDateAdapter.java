package com.activity.revision.singaNdc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public LocalDate unmarshal(String dateString) throws Exception {
        return LocalDate.parse(dateString, DATE_FORMATTER);
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return localDate.format(DATE_FORMATTER);
    }
}
