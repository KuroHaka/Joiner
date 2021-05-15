package com.example.joiner.controlador;

import java.util.Random;

public class RandomDesc {
    private static final Random r = new Random();

    private static final String[] experience = {
            "Worked for %d years.",
            "%d years of experience.",
            "%d years in the field.",
            "Hard-worker for %d years."
    };

    public static String getExperience(){
        return String.format(experience[r.nextInt(20)+1]);
    }
}
