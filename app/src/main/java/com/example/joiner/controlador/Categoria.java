package com.example.joiner.controlador;

import java.util.ArrayList;

public class Categoria {
    private int id;
    private String name;
    private ArrayList<Categoria> subcategorias;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Categoria> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(ArrayList<Categoria> subcategorias) {
        this.subcategorias = subcategorias;
    }
}
