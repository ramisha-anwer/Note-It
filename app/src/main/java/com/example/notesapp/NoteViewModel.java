package com.example.notesapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    NoteRepo repo;
    LiveData<List<Note>> allNotes;
    public NoteViewModel(@NonNull Application application) {
        super(application);
        NoteDao dao= NoteRoomDataBase.getDatabase(getApplication()).noteDao();
        repo= new NoteRepo(dao);
        allNotes= repo.getAllNotes();
    }
    LiveData<List<Note>> getAllNotes (){ return  allNotes;}
    public  void  insert(Note note){repo.insert(note);}
    public void delete(Note note){repo.delete(note);}


}
