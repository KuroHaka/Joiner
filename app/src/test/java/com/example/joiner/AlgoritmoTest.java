package com.example.joiner;

import com.example.joiner.controlador.Algoritmo;
import com.example.joiner.controlador.Candidato;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import com.example.joiner.controlador.Tag;
import java.util.Random;

import org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AlgoritmoTest {
    @Test
    public void addition_isCorrect() {
        Random r = new Random();
        ArrayList<Candidato> candidatos = new ArrayList<>();
        Algoritmo al = new Algoritmo();


        for (int i = 0; i < 6; i++) {
            candidatos.add(new Candidato("Juan"));
            for (int j=0;j<4;j++){
                candidatos.get(j).getTags().add(new Tag(String.format("%d", r.nextInt(10)), r.nextInt(10)-20));
            }
        }


        al.setCandidatosAceptados(candidatos);
        al.addKinTags(candidatos.get(3));
        assert(true);

    }

}
