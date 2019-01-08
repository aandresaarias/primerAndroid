package com.example.root.primerandroid.Fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.root.primerandroid.Adapters.NotesAdapter;
import com.example.root.primerandroid.POJOs.Note;
import com.example.root.primerandroid.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentPrincipal extends Fragment
{
    RecyclerView recyclerView;
    List<Note>  noteList;
    NotesAdapter adapter;
    FloatingActionButton floatingActionButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_principal,container,false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fabAddNote);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewPrincipal);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);

        getData();

        adapter = new NotesAdapter(getActivity().getApplicationContext(),noteList);

        recyclerView.setAdapter(adapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

                final EditText editText  = new EditText(getActivity());
                editText.setBackgroundColor(Color.DKGRAY);
                alert.setMessage("agregar Elemento");
                alert.setTitle("coloque nombre");
                alert.setView(editText);

                alert.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        noteList.add(new Note( 200, editText.getText().toString(),"Se agregó nueva reunion"));
                        //Toast.makeText(getApplicationContext(),"pendientes",Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext(), "Se agrego " + editText, Toast.LENGTH_SHORT).show();
                        adapter.notifyDataSetChanged();
                    }
                });

                alert.setNegativeButton("NO", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                    }
                });
                alert.show();

            }
        });
    }

    public void getData()
    {
        noteList = new ArrayList<>();
        noteList.add(new Note(1,"Reunión 1", "Descripción reunion 1" ));
        noteList.add(new Note(2,"Reunión 2", "Descripción reunion 2" ));
        noteList.add(new Note(3,"Reunión 3", "Descripción reunion 3" ));
        noteList.add(new Note(4,"Reunión 4", "Descripción reunion 4" ));
        noteList.add(new Note(5,"Reunión 3", "Descripción reunion 3" ));
        noteList.add(new Note(6,"Reunión 4", "Descripción reunion 4" ));
        noteList.add(new Note(7,"Reunión 3", "Descripción reunion 3" ));
        noteList.add(new Note(8,"Reunión 4", "Descripción reunion 4" ));
    }


}
