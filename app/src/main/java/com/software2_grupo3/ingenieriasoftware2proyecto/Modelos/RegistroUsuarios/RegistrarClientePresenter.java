package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.RegistroUsuarios;

import android.content.Context;

public class RegistrarClientePresenter implements RegistrarClienteContracts.Presentador{

    RegistrarClienteContracts.View mainView;
    RegistrarClienteContracts.Interactor mainInteractor;

    public RegistrarClientePresenter(RegistrarClienteContracts.View mainView, Context context){
        this.mainView = mainView;
        mainInteractor = new RegistrarClienteInteractorActivity(this, context);

    }




    @Override
    public void enBotonPresionado(String cedula, String correo, String direccion, String fechaNacimiento, String password, String tarjeta, String telefono, String usuario, String nombre) {
        mainInteractor.insertarRegistro( cedula,  correo,  direccion,  fechaNacimiento,  password,  tarjeta,  telefono,  usuario,  nombre);

    }

    @Override
    public void enInsertarExitoso(String data) {
        mainView.mostrarMensaje(data);
        mainView.navegarMainActivity();

    }

    @Override
    public void enInsertarFallido(String error) {
        mainView.mostrarMensaje(error);

    }
}
