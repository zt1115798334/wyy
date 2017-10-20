package com.zt.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <p>Title: DateUtils</p>
 * <p>Description: 日期工具类</p>
 *
 * @author wjc
 * @date 2017年4月6日
 */
public class DateUtils {

    public static final String DATE_FORMAT_SIMPLE = "MM-dd HH:mm";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_SECOND_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_SECOND_FORMAT_2 = "yyyyMMddHHmmss";
    public static final String DATE_SECOND_FORMAT_3 = "yyyy/MM/dd  HH:mm:ss";
    public static final String DATE_SECOND_FORMAT_4 = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String CN_DATE_FORMAT = "yyyy年MM月dd日";

    private DateUtils() {
    }
    public static LocalDateTime currentDate() {
        return LocalDateTime.now();
    }
    public static LocalDateTime parseDate(String date) {
        return parseDate(date, DATE_SECOND_FORMAT);
    }

    public static LocalDateTime parseDate(String date, String dateFormat) {
        LocalDateTime result = null;
        if (StringUtils.isNotEmpty(date) && StringUtils.isNotEmpty(dateFormat)) {
            DateTimeFormatter format = DateTimeFormatter.ofPattern(dateFormat);
            result = LocalDateTime.parse(date, format);
        }

        return result;
    }

    public static String formatDate(LocalDateTime date) {
        if (date == null) {
            return null;
        }
        return formatDate(date, DATE_FORMAT);
    }

    public static String formatDate(LocalDateTime date, String dateFormat) {
        String result = null;
        if (date != null && StringUtils.isNotEmpty(dateFormat)) {
            DateTimeFormatter format = DateTimeFormatter.ofPattern(dateFormat);
            result = date.format(format);
        }
        return result;
    }
}
