package com.example.joiner.controlador;

import java.util.Locale;
import java.util.Random;

public class RandomGen {
    private static Locale loc = new Locale("en");

    private static final Random r = new Random();

    private static final String[] experience = {
            "Worked for %d years.",
            "%d years of experience.",
            "%d years in the field.",
            "Hard-worker for %d years."
    };

    private static final String[] languages = Locale.getISOLanguages();

    public static String getExperience(){
        return String.format(experience[r.nextInt(experience.length)], r.nextInt(20)+1);
    }

    public static String getLanguage(){
        return loc.getDisplayLanguage(new Locale(languages[r.nextInt(languages.length)]));
    }
}
