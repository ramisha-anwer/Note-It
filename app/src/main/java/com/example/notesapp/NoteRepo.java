package com.example.notesapp;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;

import java.util.List;

class NoteRepo {


    private LiveData<List<Note>> mAllNotes;
    private NoteDao mNoteDao;

    NoteRepo(NoteDao noteDao) {
        this.mNoteDao=noteDao;
        mAllNotes = noteDao.getAllNotes();
    }


    LiveData<List<Note>> getAllNotes() {
        return mAllNotes;
    }

    void delete(Note note){
        mNoteDao.delete(note);
    }

    void insert(Note note) {
        NoteRoomDataBase.databaseWriteExecutor.execute(() -> {
            mNoteDao.insert(note);
        });
    }
}
