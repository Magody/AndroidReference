package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

import android.content.Context;

public class SeguimientoPresenter implements SeguimientoContracts.Presentador {

    SeguimientoContracts.View seguimientoView;
    SeguimientoContracts.Interactor seguimientoInteractor;

    public SeguimientoPresenter(SeguimientoContracts.View seguimientoView, Context context) {
        this.seguimientoView = seguimientoView;
        seguimientoInteractor = new SeguimientoInteractor(this, context);
    }

    @Override
    public void botonGenerarCodigo() {
        seguimientoView.mostrarProgressBar();
        seguimientoInteractor.generarCodigo();
    }

    @Override
    public void generarExitoso(String codigo) {
        seguimientoView.ocultarProgressBar();
        seguimientoView.mostrarMensaje(codigo);
    }

    @Override
    public void generarFallido(String error) {
        seguimientoView.ocultarProgressBar();
        seguimientoView.mostrarMensaje(error);
    }
}
