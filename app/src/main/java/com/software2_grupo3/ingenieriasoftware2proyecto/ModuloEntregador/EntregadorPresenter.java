package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloEntregador;

import android.content.Context;

import com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento.SeguimientoContracts;

public class EntregadorPresenter implements EntregadorContracts.Presentador {

    EntregadorContracts.View entregadorView;
    EntregadorContracts.Interactor entregadorInteractor;

    public EntregadorPresenter(EntregadorContracts.View entregadorView, Context context){
        this.entregadorView = entregadorView;
        entregadorInteractor = new EntregadorInteractor(this, context);
    }

    @Override
    public void botonAceptarRegistro(String nombre, String cedula, String correo, String fechanacimiento, String telefono, String usuario, String pwd) {
        entregadorInteractor.aceptarRegistro(nombre, cedula, correo, fechanacimiento, telefono, usuario, pwd);
    }

    @Override
    public void enRegistroExitoso(String mensaje) {
        entregadorView.mostrarMensaje(mensaje);
        entregadorView.mostrarMainActivity();
    }

    @Override
    public void enRegistroFallido(String error) {
        entregadorView.mostrarMensaje(error);
    }
}
