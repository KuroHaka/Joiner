package com.example.joiner.controlador;

import java.util.ArrayList;

public class Puesto {
    private String nombre;
    private Restricciones restricciones;
    private ArrayList<Tag> tags;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public Restricciones getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(Restricciones restricciones) {
        this.restricciones = restricciones;
    }
}
