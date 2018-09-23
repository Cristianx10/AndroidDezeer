package com.example.ecosistemas.ejemploweb;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class PlayList {

    private String name;
    private String creador;
    private String nItems;

    private ArrayList<Cancion> canciones;



    public PlayList(String name, String creador, String nItems) {

        this.name = name;
        this.creador = creador;
        this.nItems = nItems;
        canciones = new ArrayList<Cancion>();


    }

    public String getName() {
        return name;
    }

    public String getCreador() {
        return creador;
    }

    public String getnItems() {
        return nItems;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void agregarCancion(Cancion cancion) {

        canciones.add(cancion);

    }
}
