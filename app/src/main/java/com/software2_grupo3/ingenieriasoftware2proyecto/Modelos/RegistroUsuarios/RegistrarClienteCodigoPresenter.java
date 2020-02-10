package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.RegistroUsuarios;

import android.content.Context;

public class RegistrarClienteCodigoPresenter implements RegistrarClienteCodigoContracts.Presentador {

    RegistrarClienteCodigoContracts.View registrarClienteCodigoView;
    RegistrarClienteCodigoContracts.Interactor registrarClienteCodigoInteractor;


    public RegistrarClienteCodigoPresenter(RegistrarClienteCodigoContracts.View registrarClienteCodigoView, Context context){
        this.registrarClienteCodigoView = registrarClienteCodigoView;
        registrarClienteCodigoInteractor = new RegistrarClienteCodigoInteractor(this, context);
    }


    @Override
    public void botonAceptarCodigo(String codigoVerificacion, String cedula) {
        registrarClienteCodigoInteractor.aceptarCodigo(codigoVerificacion, cedula);

    }

    @Override
    public void aceptarExitoso(String mensaje) {
        registrarClienteCodigoView.mostrarMensaje(mensaje);
        registrarClienteCodigoView.navegarMainActivity();
    }

    @Override
    public void aceptarFallido(String error) {
        registrarClienteCodigoView.mostrarMensaje(error);
    }
}
