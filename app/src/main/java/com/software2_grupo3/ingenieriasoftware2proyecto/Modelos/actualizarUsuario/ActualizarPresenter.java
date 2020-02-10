package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.actualizarUsuario;


import android.content.Context;

public class ActualizarPresenter implements ActualizarContracts.Presentador{


    ActualizarContracts.View actualizarView;
    ActualizarContracts.Interactor actualizarInteractor ;

    public ActualizarPresenter( ActualizarContracts.View actualizarView,Context context){
        this.actualizarView = actualizarView;
        this.actualizarInteractor = new ActualizarInteractor(this, context);
    }

    @Override
    public void enBotonPresionado(String cedula, String correo, String direccion, String fechaNacimiento, String password, String tarjeta, String telefono, String usuario, String nombre) {
        actualizarInteractor.actualizarRegistro(cedula,correo,direccion,fechaNacimiento, password,tarjeta,telefono,usuario,nombre);
    }

    @Override
    public void enInsertarExitoso(String data) {

    }

    @Override
    public void enInsertarFallido(String error) {

    }
}
