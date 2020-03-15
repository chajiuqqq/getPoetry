package com.chajiu.util;


import com.spreada.utils.chinese.ZHConverter;

public class LangConverter {

    private static ZHConverter toSimpleConverter= ZHConverter.getInstance(ZHConverter.SIMPLIFIED);
    private static ZHConverter toTraditionConverter=ZHConverter.getInstance(ZHConverter.TRADITIONAL);

    public static String toSimple(String in){
        return toSimpleConverter.convert(in);
    }


    public static String toTradition(String in){
        return toTraditionConverter.convert(in);
    }

}
