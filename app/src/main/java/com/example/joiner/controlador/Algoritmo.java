package com.example.joiner.controlador;

import java.util.ArrayList;

public class Algoritmo {
    private ArrayList<Candidato> candidatos;
    private ArrayList<Candidato> candidatosAceptados;
    private Puesto puesto;

    public Algoritmo(){
        setCandidatos(new ArrayList<>());
        setCandidatosAceptados(new ArrayList<>());
    }

    /**
     *
     * @return candidato que cumpla condiciones
     */
    //public Candidato getSimilarUser(){

        //candidatos

        //return new Candidato();
    //}

    /**
     * Asigna una puntuación de como de compatible es un candidato con los tags de ese puesto.
     * Si la puntuacción del candidato supera a la del puesto, le da 2 puntos.
     * Si la puntuacción del candidato es igual a la del puesto, le da 1 puntos.
     * @return puntuación
     */
    public void compareTags(Candidato candidato){
        int puntuacion = 0, tempIndex;
        Tag tagTemp;
        for(Tag tag: getPuesto().getTags()){
            tempIndex = candidato.getTags().indexOf(tag);
            if(tempIndex>0){
                tagTemp = candidato.getTags().get(tempIndex);
                if(tagTemp.getPeso()>tag.getPeso()) puntuacion+=2;
                else if(tagTemp.getPeso()==tag.getPeso()) puntuacion++;
            }
        }
        candidato.setKinness(puntuacion);
    }

    /**
     * Hace una media del peso de las tags de todos los candidatos aceptados y reasigna ese peso a las tags del puesto
     */
    public void addKinTags(Candidato candidato){
        ArrayList<Tag> tagsCandidato = candidato.getTags();
        Puesto p = getPuesto();
        int divider = getCandidatosAceptados().size();
        for(Candidato ca : getCandidatosAceptados()){
            for(Tag t : ca.getTags())
            {
                int index = getPuesto().getTags().indexOf(t);
                if(index != -1)
                    getPuesto().getTags().set(index, t);
            }
        }

        for(Tag t : p.getTags())
        {
            int valuemedia = t.getPeso()/ divider;
            t.setPeso(valuemedia);
        }
    }

    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(ArrayList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public ArrayList<Candidato> getCandidatosAceptados() {
        return candidatosAceptados;
    }

    public void setCandidatosAceptados(ArrayList<Candidato> candidatosAceptados) {
        this.candidatosAceptados = candidatosAceptados;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
}
