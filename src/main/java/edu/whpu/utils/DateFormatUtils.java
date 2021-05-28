package edu.whpu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {
    private SimpleDateFormat simpleDateFormat;

    public Date dateFormat(String date) throws ParseException {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(date);
    }
}
