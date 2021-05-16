package com.example.joiner.dataGenerator;

import com.github.javafaker.Faker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class DataGen {
    private String[] instruments;
    private String[] musicStyle;
    private String[] code;
    private String[] asistanceCompanies;
    private String[] editorPrograms;
    private String[] artStudies;
    private String[] techCompanies;
    private String[] generalStudies;
    private String[] Level;
    private Faker faker;

    private static Locale loc = new Locale("en");

    private static final Random r = new Random();

    public DataGen(){
        instruments = new String[]{"piano","drums","producer","fiddle","saxo","vocalist","guitar"};
        musicStyle = new String[]{"pop","rock","jass","balland","country","oldies","EDM","hip-hop","metal","classical","r&b","techno"};
        code = new String[]{"C++","Python","JavaScript", "C#","Java", "Haskell", "Go", "Scala", "Ruby", "Kotlin", "Swift","Ruby","Dart","Fortran","Node","Pascal","PHP"};
        generalStudies = new String[]{"High School in", "Master's degree in", "College in", "Vocational School in", "Bechelor's degree in", "University degree in", "PhD in", "Middle school in"};
        asistanceCompanies = new String[]{"MCDonald's","HM","Mercadona","Zara","Pull&Bear","Vodafone","HP","Fnac","DIA", "Condis", "Bershka","Springfield", "Cortefiel","Desigual",
                "Orange","Subway","Restaurant Alpha","Delicious","Dream Dishes","Durum Kebab"};
        editorPrograms = new String[]{"Photoshop","Premier","After Effect","Davinci Resolve","Gimp","OBS","Blender","TinkerCAD","SolidWorks","Catia","Autodesk Inventor","FreeCAD","SketchUP","Paint 3D"};
        artStudies = new String[]{"3D Edition course","Fine Arts Degree in Ireland","Fine Arts Degree in París","Fine Arts Degree in Clifornia","Fine Arts Degree in LUxemburgo",
            "Fine Arts Degree in Roma", "Fine Arts Degree in Barcelona", "3D master in Scotland","3D master in London","3D master in Toronto","3D master in Athens","self teaching"};
        techCompanies = new String[]{"Google", "Facebook", "InfoJobs","Tesla","Nvidia","Apple","Microsoft","Tecent","Lenovo","HP","Huawei","Intel","Amazon","Dell","IBM",
            "LG","Intel","Typeform", "Floorfy", "HappyScribe", "Discord", "Nintendo", "Oracle","Asus","Toyota","CCTV","Panasonic","Sonic"};
        Level = new String[]{"mother tongue", "A1","A2","B1","B2","C1", "C2"};
    }
    private static final String[] languages = Locale.getISOLanguages();

    private static String getLanguage(){
        return loc.getDisplayLanguage(new Locale(languages[r.nextInt(languages.length)]));
    }
    public String getInstruments(){
        int ran = r.nextInt(4);
        StringBuilder ans = new StringBuilder("Instruments:");
        for (int i = 0; i <= ran; i++) {
            int p = r.nextInt(instruments.length);
            ans.append("\n\t").append(instruments[p]);
        }
        return ans.toString();
    }
    public String getmusicStyle(){
        int ran = r.nextInt(5);
        StringBuilder ans = new StringBuilder("Music Styles:");
        for (int i = 0; i <= ran; i++) {
            int p = r.nextInt(musicStyle.length);
            ans.append("\n\t").append(musicStyle[p]);
        }
        return ans.toString();
    }
    public String getCode(){
        int ran = r.nextInt(4);
        StringBuilder ans = new StringBuilder("Code Languajes:");
        for (int i = 0; i <= ran; i++) {
            int p = r.nextInt(code.length);
            ans.append("\n\t").append(code[p]);
        }
        return ans.toString();
    }
    public String getAsistanceCompanies(){
        int ran = r.nextInt(4);
        String ans = "Studies:";
        int p = r.nextInt(generalStudies.length);
        ans += "\n\t"+generalStudies[p]+" "+faker.university().name();
        return ans;
    }
    public String getEditorPrograms(){
        int ran = r.nextInt(4);
        StringBuilder ans = new StringBuilder("Programs:");
        for (int i = 0; i <= ran; i++) {
            int p = r.nextInt(editorPrograms.length);
            ans.append("\n\t").append(editorPrograms[p]);
        }
        return ans.toString();
    }
    public String getTechCompanies(){
        int ran = r.nextInt(3);
        StringBuilder ans = new StringBuilder("Worked in:");
        for (int i = 0; i <= ran; i++) {
            int years = r.nextInt(8);
            int p = r.nextInt(techCompanies.length);
            ans.append("\n\t").append(techCompanies[p]).append(" for ").append(years).append(" years");
        }
        return ans.toString();
    }
    public String getLanguages(){
        int ran = r.nextInt(4);
        StringBuilder ans = new StringBuilder("Languages:");
        for (int i = 0; i <= ran; i++) {
            int years = r.nextInt(8);
            int p = r.nextInt(techCompanies.length);
            ans.append("\n\t").append(techCompanies[p]).append(" for ").append(years).append(" years");
        }
        return ans.toString();
    }
}
