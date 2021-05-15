package com.example.joiner.controlador;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CandidatoTest {
    @Test
    public void test_inicializar() {
        Candidato candidato = new Candidato();
        candidato.getDbUsername();
    }


}
