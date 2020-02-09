package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Producto {
    @Expose
    @SerializedName("id") private int id;
    @Expose
    @SerializedName("nombre") private String nombre;
    @Expose
    @SerializedName("url") private String url;
    @Expose
    @SerializedName("precio") private float precio;

    public Producto(int id, String nombre, String url, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @NonNull
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", url='" + url + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}
