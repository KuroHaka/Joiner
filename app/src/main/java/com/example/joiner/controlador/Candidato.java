package com.example.joiner.controlador;

import android.location.Location;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class Candidato {
    private String nombre;
    private String foto; //url a foto
    private String descripcion;
    private Location ubicacion;
    private ArrayList<Formacion> formaciones;
    private ArrayList<Categoria> categorias;
    private ArrayList<Idioma> idiomas;
    private ArrayList<Tag> tags;
    private ArrayList<Habilidad> habilidades;
    private int kinness;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Location getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Location ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<Formacion> getFormaciones() {
        return formaciones;
    }

    public void setFormaciones(ArrayList<Formacion> formaciones) {
        this.formaciones = formaciones;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public ArrayList<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(ArrayList<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    public ArrayList<Tag> getTags() {
        Collections.sort(tags, new TagComparator());
        Collections.reverse(tags);
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public ArrayList<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    private Map<String, Object> email;

    public Candidato(String name){
        this.nombre = name;
    }

    public int getKinness() {
        return kinness;
    }

    public void setKinness(int kinness) {
        this.kinness = kinness;
    }

    /*public String getDbUsername(FirebaseFirestore db){

        db.collection("email")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                email = document.getData();

                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
        for (Object o : email.values()) {
            System.out.println((String) o);
        }

        return "wip";
    }*/
}
