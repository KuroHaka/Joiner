package com.example.joiner.controlador;

import org.json.JSONArray;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CategoriaHandler {
    private ArrayList<Categoria> categorias;
    private JSONArray categsJson;

    public CategoriaHandler(){
        categorias = new ArrayList<>();
        try{
            categsJson = new JSONArray(archivoAString("src/main/files/Categorias"));
        }catch (Exception ignored){

        }
    }

    public boolean inicializar() {
        int id;
        String name;
        JSONArray subcategsJson;
        Categoria categ;
        for (int i = 0; i < categsJson.length(); i++) { //recorrer categorías
            try {
                id = categsJson.getJSONObject(i).getInt("id");
                name = categsJson.getJSONObject(i).getString("name");
                subcategsJson = categsJson.getJSONObject(i).getJSONArray("subcategories");
            } catch (org.json.JSONException e) {
                System.out.println(e);
                return false;
            }
            categ = new Categoria(id, name);

            for (int j = 0; j < subcategsJson.length(); j++) { //recorrer subcategorías
                try {
                    id = subcategsJson.getJSONObject(j).getInt("id");
                    name = subcategsJson.getJSONObject(j).getString("name");
                } catch (org.json.JSONException e) {
                    return false;
                }
                categ.getSubcategorias().add(new Categoria(id, name));
            }

            categorias.add(categ);

        }
        return true;
    }

    public Categoria get(int index){
        return categorias.get(index);
    }
    public Categoria getById(int id){
        return categorias.get(categorias.indexOf(new Categoria(id, "searcher")));
    }

    private String archivoAString(String archivo) throws Exception{
        return new String(Files.readAllBytes(Paths.get(archivo)));
    }
}
