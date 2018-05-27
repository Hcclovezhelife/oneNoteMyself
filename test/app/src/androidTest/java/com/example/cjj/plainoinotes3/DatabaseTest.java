package com.example.cjj.plainoinotes3;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.widget.TextViewCompat;
import android.util.Log;

import com.example.cjj.plainoinotes3.database.AppDatabase;
import com.example.cjj.plainoinotes3.database.NoteDao;
import com.example.cjj.plainoinotes3.database.NoteEntity;
import com.example.cjj.plainoinotes3.utilities.SampleData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import javax.security.auth.login.LoginException;

/***
 * author：caijj1
 * time：2018/5/27
 * mail:caijj1@chanjet.com
 **/
@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    public static final String TAG = "CAIJINJINQQ";

    private AppDatabase mDb;

    private NoteDao mDao;

    @Before
    public void createDb(){
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context,AppDatabase.class).build();
        mDao = mDb.noteDao();
        Log.i(TAG, "createdbTest");
    }


    @After
    public void closeDb(){
        mDb.close();
        Log.i(TAG, "closeDb: ");
    }

    @Test
    public void createAndRetrieveNotes(){
        mDao.insertAll(SampleData.getNotes());
        int count = mDao.getCount();
        Log.i(TAG, "createAndRetrieveNotes: count"+count);
        assertEquals(SampleData.getNotes().size(),count);
    }

    @Test
    public void compareString(){
        mDao.insertAll(SampleData.getNotes());
        NoteEntity original = SampleData.getNotes().get(0);
        NoteEntity fromDatebase = mDao.getNoteById(1);
        assertEquals(original.getText(),fromDatebase.getText());
        assertEquals(1,fromDatebase.getId());

    }
}
