package com.example.joiner.dataGenerator;

import com.github.javafaker.Faker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

public class DataGen {
    private String[] instruments;
    private String[] musicStyle;
    private String[] code;
    private String[] asistanceCompanies;
    private String[] editorPrograms;
    private String[] artStudies;
    private String[] techCompanies;
    private String[] generalStudies;
    private String[] level;
    private Faker faker;
    private String[] language;

    private static Locale loc = new Locale("en");

    private static final Random r = new Random();

    public DataGen(){
        faker = new Faker(loc);
        instruments = new String[]{"piano","drums","guitar","piano","drums","guitar","piano","drums","guitar","piano","drums","guitar","producer","fiddle","saxo","vocalist"};
        musicStyle = new String[]{"pop","rock","pop","rock","pop","rock","pop","rock","pop","rock","pop","rock","jass","balland","country","oldies","EDM","hip-hop","metal","classical","r&b","techno"};
        code = new String[]{"C++","Python","JavaScript","C#","Java","C++","Python","JavaScript","C#","Java","C++","Python","JavaScript","C#","Java", "Haskell", "Go", "Scala", "Ruby", "Kotlin", "Swift","Ruby","Dart","Fortran","Node","Pascal","PHP"};
        generalStudies = new String[]{"High School in", "Master's degree in", "College in", "Vocational School in", "Bechelor's degree in", "University degree in", "PhD in", "Middle school in"};
        asistanceCompanies = new String[]{"MCDonald's","HM","Mercadona","Zara","Pull&Bear","Vodafone","HP","Fnac","DIA", "Condis", "Bershka","Springfield", "Cortefiel","Desigual",
                "Orange","Subway","Restaurant Alpha","Delicious","Dream Dishes","Durum Kebab"};
        editorPrograms = new String[]{"Photoshop","Premier","After Effect","Davinci Resolve","Gimp","OBS","Blender","TinkerCAD","SolidWorks","Catia","Autodesk Inventor","FreeCAD","SketchUP","Paint 3D"};
        artStudies = new String[]{"3D Edition course","Fine Arts Degree in Ireland","Fine Arts Degree in París","Fine Arts Degree in Clifornia","Fine Arts Degree in LUxemburgo",
            "Fine Arts Degree in Roma", "Fine Arts Degree in Barcelona", "3D master in Scotland","3D master in London","3D master in Toronto","3D master in Athens","self teaching"};
        techCompanies = new String[]{"Google", "Facebook", "InfoJobs", "InfoJobs", "InfoJobs", "InfoJobs","Tesla","Nvidia","Apple","Microsoft","Tecent","Lenovo","HP","Huawei","Intel","Amazon","Dell","IBM",
            "LG","Intel","Typeform","Typeform","Typeform","Typeform", "Floorfy", "HappyScribe", "Discord", "Nintendo", "Oracle","Asus","Toyota","CCTV","Panasonic","Sonic"};
        level = new String[]{"mother tongue", "A1","A2","B1","B2","C1", "C2"};
        language = new String[]{"English","English","English","English", "Germany","Japanese","Portuguese","Turkish","Chinese", "Italian","Polish","Dutch","Russian","Korean","Spanish"};
    }
    private static final String[] languages = Locale.getISOLanguages();

    private String getLanguage(){
        int p = r.nextInt(language.length);
        return(language[p]);

    }
    private String getLevel(){
        int p = r.nextInt(level.length);
        return(level[p]);
    }
    public String getInstruments(){
        int ran = r.nextInt(3);
        StringBuilder ans = new StringBuilder("Instruments:");
        Set<String> s = new HashSet<>();
        for (int i = 0; i <= ran; i++) {
            int p = r.nextInt(instruments.length);
            s.add(instruments[p]);
        }
        for (String str: s) {
            ans.append("\n\t\t-").append(str);
        }
        return ans.toString();
    }

    public String getMusicStyle(){
        int ran = r.nextInt(3);
        StringBuilder ans = new StringBuilder("Music styles:");
        Set<String> s = new HashSet<>();
        for (int i = 0; i <= ran; i++) {
            int p = r.nextInt(musicStyle.length);
            s.add(musicStyle[p]);
        }
        for (String str: s) {
            ans.append("\n\t\t-").append(str);
        }
        return ans.toString();
    }


    public String getCode(){
        int ran = r.nextInt(3);
        StringBuilder ans = new StringBuilder("Code Languages:");
        Set<String> s = new HashSet<>();
        for (int i = 0; i <= ran; i++) {
            int p = r.nextInt(code.length);
            s.add(code[p]);
        }
        for (String str: s) {
            ans.append("\n\t\t-").append(str);
        }
        return ans.toString();
    }

    public String getStudies(){
        String ans = "Studies:";
        int p = r.nextInt(generalStudies.length);
        ans += "\n\t\t-"+generalStudies[p]+" "+faker.university().name();
        return ans;
    }

    public String getEditorPrograms(){
        int ran = r.nextInt(3);
        StringBuilder ans = new StringBuilder("Programs:");
        Set<String> s = new HashSet<>();
        for (int i = 0; i <= ran; i++) {
            int p = r.nextInt(editorPrograms.length);
            s.add(editorPrograms[p]);
        }
        for (String str: s) {
            ans.append("\n\t\t-").append(str);
        }
        return ans.toString();
    }

    public String getCompanies(){
        int ran = r.nextInt(3);
        StringBuilder ans = new StringBuilder("Worked in:");
        Set<String> s = new HashSet<>();
        for (int i = 0; i <= ran; i++) {
            s.add(faker.company().name());
        }
        for (String str: s) {
            int years = r.nextInt(7)+1;
            int p = r.nextInt(asistanceCompanies.length);
            ans.append("\n\t\t-").append(str).append(" for ").append(years).append(" years");
        }
        return ans.toString();
    }

    public String getAsistanceCompanies(){
        int ran = r.nextInt(3);
        StringBuilder ans = new StringBuilder("Worked in:");
        for (int i = 0; i <= ran; i++) {
            int p = r.nextInt(asistanceCompanies.length);
            int years = r.nextInt(7)+1;
            ans.append("\n\t\t-").append(asistanceCompanies[p]).append(" for ").append(years).append(" years");
        }
        return ans.toString();
    }
    public String getTechCompanies(){
        int ran = r.nextInt(3);
        StringBuilder ans = new StringBuilder("Worked in:");
        Set<String> s = new HashSet<>();
        for (int i = 0; i <= ran; i++) {
            int p = r.nextInt(techCompanies.length);
            s.add(techCompanies[p]);
        }
        for (String str: s) {
            int years = r.nextInt(7)+1;
            int p = r.nextInt(techCompanies.length);
            ans.append("\n\t\t-").append(str).append(" for ").append(years).append(" years");
        }
        return ans.toString();
    }
    public String getLanguages(){
        int ran = r.nextInt(4);
        StringBuilder ans = new StringBuilder("Languages:");
        Set<String> s = new HashSet<>();
        for (int i = 0; i <= ran; i++) {
            s.add(getLanguage());
        }
        for (String str: s) {
            ans.append("\n\t\t-").append(str).append(": ").append(getLevel());
        }

        return ans.toString();
    }
}
