package com.example.cjj.plainoinotes3.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.cjj.plainoinotes3.database.AppRepository;
import com.example.cjj.plainoinotes3.database.NoteEntity;
import com.example.cjj.plainoinotes3.utilities.SampleData;

import java.util.List;


/***
 * author：caijj1
 * time：2018/5/27
 * mail:caijj1@chanjet.com
 **/
public class MainViewModel extends AndroidViewModel {

    public LiveData<List<NoteEntity>> mNotes ;
    private AppRepository mRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mRepository = AppRepository.getInstance();
        mNotes = mRepository.mNotes;
    }
}
