package com.example.ecosistemas.ejemploweb;

import java.io.Serializable;
import java.util.Collection;

public class Cancion implements Serializable{

    String nombre;
    String artista;
    String lanzamiento;



    public Cancion(String nombre, String artista, String lanzamiento) {
        this.nombre = nombre;
        this.artista = artista;
        this.lanzamiento = lanzamiento;

    }

    public String getNombre() {
        return nombre;
    }

    public String getArtista() {
        return artista;
    }

    public String getLanzamiento() {
        return lanzamiento;
    }

}
