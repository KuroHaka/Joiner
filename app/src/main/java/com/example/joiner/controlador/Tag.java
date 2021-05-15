package com.example.joiner.controlador;

import java.util.Objects;

public class Tag {
    private String nombre;
    private int peso;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    public Tag(String nombre, int peso){
        this.nombre = nombre;
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(nombre, tag.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
