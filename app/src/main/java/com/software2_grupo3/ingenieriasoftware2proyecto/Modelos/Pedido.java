package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pedido {
    @Expose
    @SerializedName("id")
    public int id;
    @Expose
    @SerializedName("codigo")
    public String codigo;
    @Expose
    @SerializedName("cliente_usuario")
    public String cliente_usuario;
    @Expose
    @SerializedName("estado")
    public int estado;
}
