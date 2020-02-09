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
    public void enConsultaEstadoExitoso(int estado) {
        seguimientoView.mostrarEstado(estado);
    }

    @Override
    public void enConsultaEstadoFallido(String error) {
        seguimientoView.mostrarMensaje(error);
    }
}
