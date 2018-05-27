package com.example.cjj.plainoinotes3.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/***
 * author：caijj1
 * time：2018/5/27
 * mail:caijj1@chanjet.com
 **/
@Entity(tableName = "notes")
public class NoteEntity {
@PrimaryKey (autoGenerate = true)
    private int id;
    //创建时间或者修改时间
    private Date date;

    private String text;

    @Ignore
    public NoteEntity() {

    }

    @Ignore
    public NoteEntity( Date date,String text) {
        this.text = text;
        this.date = date;
    }

    public NoteEntity(int id, Date date, String text) {
        this.id = id;
        this.date = date;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "id=" + id +
                ", date=" + date +
                ", text='" + text + '\'' +
                '}';
    }
}
