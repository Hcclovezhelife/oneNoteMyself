package com.example.cjj.plainoinotes3.database;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.cjj.plainoinotes3.utilities.SampleData;

import java.util.List;

/***
 * author：caijj1
 * time：2018/5/27
 * mail:caijj1@chanjet.com
 **/
public class AppRepository {

    public LiveData<List<NoteEntity>> mNotes ;
    private static final AppRepository ourInstance ;
    private AppDatabase mDb;

    public static AppRepository getInstance() {
        return ourInstance;
    }

    private  AppRepository(){

    }
    private AppRepository(Context context) {
        mNotes = getAllNotes();
        mDb = AppDatabase.getInstance(context);
    }

    private LiveData<List<NoteEntity>> getAllNotes(){
        return mDb.noteDao().getAll();
    }
}
