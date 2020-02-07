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
    public int botonAceptarCodigo(String codigoVerificacion, String cedula) {
        int resultado = registrarClienteCodigoInteractor.aceptarCodigo(codigoVerificacion, cedula);
        return resultado;

    }

    @Override
    public void aceptarExitoso(String mensaje) {

    }

    @Override
    public void aceptarFallido(String error) {

    }
}
