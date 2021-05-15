package com.example.joiner.interfaz;

public class ModeloStatus extends Modelo{
    private boolean like;

    public ModeloStatus(boolean like) {
        this.like = like;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
