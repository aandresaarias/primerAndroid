package com.example.root.primerandroid.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.primerandroid.Activities.RegistrarActivity;
import com.example.root.primerandroid.POJOs.Note;
import com.example.root.primerandroid.R;

import org.w3c.dom.Text;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder>
{
    Context context;
    List<Note> noteList;

    public NotesAdapter(Context context, List<Note> noteList)
    {
        this.context = context;
        this.noteList = noteList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate (R.layout.note_items, viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position)
    {

        viewHolder.id.setText(String.valueOf(noteList.get(position).getId()));
        viewHolder.tittle.setText(String.valueOf(noteList.get(position).getTittle()));
        viewHolder.body.setText(String.valueOf(noteList.get(position).getBody()));

        viewHolder.imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                noteList.remove(position);
                notifyDataSetChanged();

                Toast.makeText(context, "Nota " + position + " eliminado", Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public int getItemCount()
    {
        return noteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        CardView cardView;
        TextView id;
        TextView tittle;
        TextView body;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            id = (TextView) itemView.findViewById(R.id.id);
            tittle = (TextView) itemView.findViewById(R.id.Tittle);
            body = (TextView) itemView.findViewById(R.id.Body);
            imageView  = (ImageView) itemView.findViewById(R.id.trash);
        }
    }

}
