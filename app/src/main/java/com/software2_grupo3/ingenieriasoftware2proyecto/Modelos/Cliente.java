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
    @Expose
    @SerializedName("cedula") public String cedula;
    @Expose
    @SerializedName("nombre") private String nombre;
    @Expose
    @SerializedName("direccion") private String direccion;
    @Expose
    @SerializedName("telefono") private String telefono;
    @Expose
    @SerializedName("tarjeta") private String tarjeta;
    @Expose
    @SerializedName("fechaNacimiento") private String fechaNacimiento;
    @Expose
    @SerializedName("password") private String password;


    public Cliente(String usuario, String correo) {
        this.usuario = usuario;
        this.correo = correo;
    }

    public Cliente(String usuario, String correo, String cedula, String nombre, String direccion, String telefono, String tarjeta, String fechaNacimiento, String password) {
        this.usuario = usuario;
        this.correo = correo;
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tarjeta = tarjeta;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;

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
