package com.jaycee.rda.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static Date toDate(String dateInString){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date date = formatter.parse(dateInString);
            return date;

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String toStr(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }

    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    public static void main(String []args){
        toDate("17-03-2018");
    }
}
