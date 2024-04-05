package com.leetcode.easy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        try {
            System.out.println(getNthSundayOfMonth("31.03.2024", 5));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Hello world!");
        String d1 = "2024-03-11 23:59:59";
        String[] patterns = {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"};
        String check = Arrays.asList(patterns).stream()
                .filter(pattern -> {
                    try {
                        LocalDate.parse(d1, DateTimeFormatter.ofPattern(pattern));
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }).findFirst().get();
//        Date dateValue1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d1);
//        System.out.println(dateValue1);
    }

    public static Date getNthSundayOfMonth(String dateStr, int nth) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date = sdf.parse(dateStr);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);

        cal.set(year, month, 1);

        while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }

        cal.add(Calendar.DAY_OF_MONTH, (nth - 1) * 7);
        return cal.getTime();
    }
}