package com.chajiu.util;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

/**
 * 用于把当前日期转为中文日期，如 二零二零年四月六日
 */
public class DateUtil {

    private static String u[] = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    public static String todayInChinese(){
        LocalDate today=LocalDate.now();
        int year = today.getYear();
        int month = today.getMonth().getValue();
        int day = today.getDayOfMonth();

        return yearInChinese(year)+"年"+numInChinese(month)+"月"+numInChinese(day)+"日";



    }
    private static String yearInChinese(int num){
        char[] chars = String.valueOf(num).toCharArray();
        String out="";
        for(char c:chars){
            out+=u[Integer.parseInt(c+"")];
        }
        return out;

    }

    private static String numInChinese(int num){
        if(num<10){
            return u[num];
        }else if(num==10){
            return "十";
        }else if(num<20){
            return "十"+numInChinese(num%10);
        }else{
            return u[num/10]+"十"+numInChinese(num%10);
        }
    }

    /**
     * 判断是否同一天
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if(date1 != null && date2 != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            return isSameDay(cal1, cal2);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    private static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if(cal1 != null && cal2 != null) {
            return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }


}
