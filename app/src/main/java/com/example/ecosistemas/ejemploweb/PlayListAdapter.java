package com.example.ecosistemas.ejemploweb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class PlayListAdapter extends BaseAdapter {

    ArrayList<PlayList> listaCanciones;
    Activity activity;

    public PlayListAdapter(Activity activity){
        this.activity = activity;
        listaCanciones = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return listaCanciones.size();
    }

    @Override
    public Object getItem(int position) {
        return listaCanciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final PlayList pista = listaCanciones.get(position);

        LayoutInflater inflater = activity.getLayoutInflater();

        View reglon = inflater.inflate(R.layout.activity_item_play_list, null, false);

        TextView tv_nombre_lista = reglon.findViewById(R.id.tv_nombre_lista);
        TextView tv_creador = reglon.findViewById(R.id.tv_creador);
        TextView tv_numero_items = reglon.findViewById(R.id.tv_numero_items);

        LinearLayout ly_item_play_list = reglon.findViewById(R.id.ly_item_play_list);

        String nombre = pista.getName();
        String creador = pista.getCreador();
        String nItems = pista.getnItems();

        tv_nombre_lista.setText(nombre);
        tv_creador.setText(creador);
        tv_numero_items.setText(nItems);

        ly_item_play_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Funciona");

                Intent i = new Intent(activity, ViewPlayList.class);

                Bundle b = new Bundle();
                ArrayList<Cancion> musica = getListaCanciones(position);
                b.putSerializable("canciones", musica);


                i.putExtras(b);

                activity.startActivity(i);
            }
        });



        return reglon;
    }

    public void agregar (PlayList pista){
        listaCanciones.add(pista);
        notifyDataSetChanged();
    }

    public ArrayList<Cancion> getListaCanciones(int position) {
        return listaCanciones.get(position).getCanciones();
    }
}
