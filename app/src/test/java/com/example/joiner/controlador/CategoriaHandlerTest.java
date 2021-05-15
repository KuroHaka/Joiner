package com.example.joiner.controlador;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CategoriaHandlerTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test_inicializar() {
        CategoriaHandler handler = new CategoriaHandler();
        assertTrue(handler.inicializar());
    }

    @Test
    public void test_buscar(){
        CategoriaHandler handler = new CategoriaHandler();
        handler.inicializar();
        Categoria base = new Categoria(1, "test");
        Categoria busqueda = handler.getById(1);
        assertEquals(base, busqueda);
    }


}
