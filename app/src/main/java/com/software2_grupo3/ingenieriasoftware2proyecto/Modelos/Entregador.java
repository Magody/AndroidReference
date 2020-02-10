package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entregador {
    @Expose
    @SerializedName("nombre")
    public String nombre;
    @Expose
    @SerializedName("correo")
    public String correo;
    @Expose
    @SerializedName("cedula")
    public String cedula;
    @Expose
    @SerializedName("telefono")
    public String telefono;
    @Expose
    @SerializedName("fechaNacimiento")
    public String fechanacimiento;
    @Expose
    @SerializedName("usuario")
    public String usuario;
    @Expose
    @SerializedName("password")
    public String password;
}
