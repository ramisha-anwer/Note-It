package com.example.notesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder>  {
    ArrayList<Note> allNotes= new ArrayList<>();

    Context mcontext;
    INotesAdapter mlistener;

    NotesAdapter(Context context, INotesAdapter listener){
        this.mcontext=context;
        this.mlistener=listener;
    }

    @NonNull

    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        NotesViewHolder viewHolder= new NotesViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.item_note, parent,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  NotesViewHolder holder, int position) {
      Note currentNote=allNotes.get(position);
      holder.textView.setText(currentNote.getmNote());
    }

    @Override
    public int getItemCount() {
        return allNotes.size();
    }

    void updateList(List<Note> newlist){
        allNotes.clear();
        allNotes.addAll(newlist);
        notifyDataSetChanged();


    }

    static class NotesViewHolder extends RecyclerView.ViewHolder{


        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        TextView textView=itemView.findViewById(R.id.textview);
        Button deletebutton=itemView.findViewById(R.id.deletebutton);


    }

    interface INotesAdapter {
        void onItemclicked(Note note);
    }


}
