package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NotesAdapter.INotesAdapter {
    NoteViewModel viewModel;
    Observer<List<Note>> observer;
    EditText inputText=findViewById(R.id.input);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView= findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        NotesAdapter adapter= new NotesAdapter(this,this);
        recyclerView.setAdapter(adapter);

        viewModel=new ViewModelProvider(this).get(NoteViewModel.class);
        viewModel.allNotes.observe(this, notes -> {
            // Update the cached copy of the words in the adapter.
            adapter.updateList(notes);
        });


    }

    @Override
    public void onItemclicked(Note note) {
        viewModel.delete(note);
        Toast.makeText(this,"Note Deleted",Toast.LENGTH_LONG).show();
    }

    public void AddNote(View view) {
        String noteText= inputText.getText().toString();
        if (!noteText.isEmpty()){
            viewModel.insert(new Note(noteText));
        }
    }
}