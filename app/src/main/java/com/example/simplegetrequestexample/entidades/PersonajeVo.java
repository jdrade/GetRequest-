package com.example.simplegetrequestexample.entidades;

public class PersonajeVo {

    private String nombre;
    private String info;
    private int imagenId;

    public PersonajeVo(){

    }

    public PersonajeVo(String nombre, String info, int imagenId) {
        this.nombre = nombre;
        this.info = info;
        this.imagenId = imagenId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
