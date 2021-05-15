package com.example.joiner.controlador;

import java.util.ArrayList;

public class Restricciones {
    private ArrayList<Categoria> categorias;
    private ArrayList<Idioma> minIdiomas;

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public ArrayList<Idioma> getMinIdiomas() {
        return minIdiomas;
    }

    public void setMinIdiomas(ArrayList<Idioma> minIdiomas) {
        this.minIdiomas = minIdiomas;
    }
}
