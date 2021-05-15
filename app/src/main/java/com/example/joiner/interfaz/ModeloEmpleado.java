package com.example.joiner.interfaz;

public class ModeloEmpleado extends Modelo{
    private int image;
    private String empleadoName;
    private String desc;

    public ModeloEmpleado(int image, String empleadoName, String desc) {
        this.image = image;
        this.empleadoName = empleadoName;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getEmpleadoName() {
        return empleadoName;
    }

    public void setTitle(String empleadoName) {
        this.empleadoName = empleadoName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
