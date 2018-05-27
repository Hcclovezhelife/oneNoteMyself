package com.example.cjj.plainoinotes3.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.google.common.primitives.Ints;

/***
 * author：caijj1
 * time：2018/5/27
 * mail:caijj1@chanjet.com
 **/
@Database(entities = {NoteEntity.class},version=1)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "AppDatabase.db";

    public static final Object LOCK = new Object();

    private static volatile AppDatabase instance;

    public abstract NoteDao noteDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK){
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,DATABASE_NAME).build();

                }
            }
        }

        return instance;
    }
}
