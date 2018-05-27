package com.example.cjj.plainoinotes3.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/***
 * author：caijj1
 * time：2018/5/27
 * mail:caijj1@chanjet.com
 **/
public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp){
        return timestamp == null ? null:new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date){
        return date == null ? null:date.getTime();
    }
}
