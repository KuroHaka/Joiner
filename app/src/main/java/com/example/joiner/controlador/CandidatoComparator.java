package com.example.joiner.controlador;

import java.util.Comparator;

public class CandidatoComparator implements Comparator<Candidato> {
    public int compare(Candidato o1, Candidato o2)
    {
        return ((Integer) o1.getKinness()).compareTo((Integer) o2.getKinness());
    }
}
