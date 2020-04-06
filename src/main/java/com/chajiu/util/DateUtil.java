package com.chajiu.util;

import java.time.LocalDate;
import java.time.Month;

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


}
