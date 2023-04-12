package com.trasulov.currency.helpers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

public class DateHelper {

    private static final ZoneOffset ZONE_OFFSET = ZoneOffset.UTC;

    public static Instant toInstant(LocalDate date) {
        return date.atStartOfDay().toInstant(ZONE_OFFSET);
    }
}
