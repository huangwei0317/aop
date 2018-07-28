package com.hww.aop;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;

public class DateUtils {

//    public static List<String> regs;
//    public static LocalDate fomart;
//    public static List<LocalDateTime> fomart2;
//    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    static {
//        regs= Arrays.asList(
//                "yyyy-MM-dd",
//                "yyyy-MM-dd HH:mm:ss",
//                "yyyy-MM-dd HH:mm:ss SSS"
//        );
//        fomart = LocalDate.parse("yyyy-MM-dd");
//        fomart2=Arrays.asList(
//                LocalDateTime.parse("yyyy-MM-dd HH:mm:ss"),
//                LocalDateTime.parse("yyyy-MM-dd HH:mm:ss SSS")
//        );
//    }
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime parse = now.parse("2007-12-03 10:15:30",formatter);
        System.out.println(parse);
    }
}
