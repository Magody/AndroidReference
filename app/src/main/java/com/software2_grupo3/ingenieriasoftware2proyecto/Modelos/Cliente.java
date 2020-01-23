package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cliente {

    @Expose
    @SerializedName("usuario") private String usuario;
    @Expose
    @SerializedName("correo") private String correo;
    @Expose
    @SerializedName("latitud_preferida") private double latitud_preferida;
    @Expose
    @SerializedName("longitud_preferida") private double longitud_preferida;

    public Cliente(String usuario, String correo) {
        this.usuario = usuario;
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setLatitud_preferida(double latitud_preferida) {
        this.latitud_preferida = latitud_preferida;
    }

    public void setLongitud_preferida(double longitud_preferida) {
        this.longitud_preferida = longitud_preferida;
    }
}
