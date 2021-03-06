package com.example.joiner.controlador;

import java.util.ArrayList;
import java.util.Objects;

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

    public Categoria(int id, String name){
        this.id = id;
        this.name = name;
        subcategorias = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id == categoria.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
