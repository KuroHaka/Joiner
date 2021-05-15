package com.example.joiner.controlador;

import java.util.Comparator;

public class CandidatoComparator implements Comparator<Candidato> {
    public int compare(Candidato o1, Candidato o2)
    {
        return o1.getKinness().compareTo(o2.getKinness());
    }
}
