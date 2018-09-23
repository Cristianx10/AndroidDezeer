package com.example.ecosistemas.ejemploweb;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class CancionesAdapter extends BaseAdapter {

    private ArrayList<Cancion> canciones;
    private Activity activity;

    public CancionesAdapter(Activity activity, ArrayList<Cancion> canciones){
        this.activity = activity;
        this.canciones = new ArrayList<>();
        agregarCanciones(canciones);

    }


    @Override
    public int getCount() {
        return canciones.size();
    }

    @Override
    public Object getItem(int position) {
        return canciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();

        Cancion c = canciones.get(position);

        View cancion = inflater.inflate(R.layout.activity_item_cancion, null, false);

        TextView tv_nombre = cancion.findViewById(R.id.tv_cancion_nombre);
        TextView tv_artista = cancion.findViewById(R.id.tv_cancion_artista);
        TextView tv_lanzamiento = cancion.findViewById(R.id.tv_cancion_lanzamiento);

        LinearLayout objeto = cancion.findViewById(R.id.ly_item_cancion);

        String nombre = c.getNombre();
        String artista = c.getArtista();
        String lanzamiento = c.getLanzamiento();

        tv_nombre.setText(nombre);
        tv_artista.setText(artista);
        tv_lanzamiento.setText(lanzamiento);

        objeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(activity, ViewCancion.class);
                activity.startActivity(i);
            }
        });

        System.out.println("Aqui se agrego");

        return cancion;
    }


    public void agregarCanciones(ArrayList<Cancion> c){
        canciones.addAll(c);
        notifyDataSetChanged();
    }

}
