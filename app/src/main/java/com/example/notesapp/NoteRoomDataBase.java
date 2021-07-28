package com.example.notesapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NoteRoomDataBase extends RoomDatabase {

    public abstract NoteDao noteDao();

    private static volatile NoteRoomDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static NoteRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NoteRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NoteRoomDataBase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

