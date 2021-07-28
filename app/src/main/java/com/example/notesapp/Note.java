package com.example.notesapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    @ColumnInfo(name = "note")
    private String mNote;

    public Note(@NonNull String note) {this.mNote = note;
        id = 0;
    }

    public String getmNote(){return this.mNote;}
}
