package com.example.joiner.controlador;

import java.util.ArrayList;

public class Algoritmo {
    private ArrayList<ArrayList<Object>> candidatos;
    private ArrayList<Candidato> candidatosAceptados;
    private Puesto puesto;

    public Algoritmo(){
        candidatos = new ArrayList<>();
        candidatosAceptados = new ArrayList<>();
    }

    /**
     *
     * @return candidato que cumpla condiciones
     */
    public Candidato getSimilarUser(){
        return new Candidato();
    }

    /**
     * Asigna una puntuación de como de compatible es un candidato con los tags de ese puesto
     * @return puntuación
     */
    private int compareTags(Candidato candidato){
        int puntuacion = 0;
        for(Tag tag: puesto.getTags()){
            candidato.getTags().get(candidato.getTags().indexOf(tag));
        }
        return puntuacion;
    }
}
