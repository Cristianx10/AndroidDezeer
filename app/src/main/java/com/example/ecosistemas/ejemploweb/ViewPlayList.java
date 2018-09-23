package com.example.ecosistemas.ejemploweb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ViewPlayList extends AppCompatActivity {

    private ListView lv_canciones;
    private CancionesAdapter cancionesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_play_list);

        lv_canciones = findViewById(R.id.lv_play_list_canciones);

        Serializable extras = getIntent().getSerializableExtra("canciones");
        ArrayList<Cancion> canciones = (ArrayList<Cancion>) extras;

       cancionesAdapter = new CancionesAdapter(this, canciones);


       lv_canciones.setAdapter(cancionesAdapter);



    }
}
