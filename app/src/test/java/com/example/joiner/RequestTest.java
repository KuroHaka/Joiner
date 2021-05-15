package com.example.joiner;

import com.example.joiner.conectividad.ApiRequest;

import org.junit.Test;

import static org.junit.Assert.*;

public class RequestTest {

    @Test
    public void test_get(){
        try {
            String request = ApiRequest.get("https://api.infojobs.net/api/1/candidate/skillcategory");
        } catch (Exception e){fail(e.toString());}
        assertTrue(true);
    }
}
