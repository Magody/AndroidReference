package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

import android.content.Context;

public class CambiarEstadosPresenter implements CambiarEstadosContracts.Presentador {


    private CambiarEstadosContracts.View cambiarEstadosView;
    private CambiarEstadosContracts.Interactor cambiarEstadosInteractor;

    public CambiarEstadosPresenter(CambiarEstadosContracts.View view, Context mContext) {
        this.cambiarEstadosView = view;
        this.cambiarEstadosInteractor = new CambiarEstadosInteractor(this, mContext);
    }


    @Override
    public void enBotonAtendidoPresionado(int id) {
        cambiarEstadosView.mostrarProgressBar();
        cambiarEstadosInteractor.cambiarEstado(id, 1);
    }

    @Override
    public void enBotonEnCaminoPresionado(int id) {
        cambiarEstadosView.mostrarProgressBar();
        cambiarEstadosInteractor.cambiarEstado(id, 2);
    }

    @Override
    public void enBotonHaLlegadoPresionado(int id) {
        cambiarEstadosView.mostrarProgressBar();
        cambiarEstadosInteractor.cambiarEstado(id, 3);
    }

    @Override
    public void enCambiarEstadoExitoso(String codigo) {
        cambiarEstadosView.ocultarProgressBar();
        cambiarEstadosView.mostrarMensaje("Actualizado: " + codigo);
    }

    @Override
    public void enCambiarEstadoFallido(String error) {
        cambiarEstadosView.ocultarProgressBar();
        cambiarEstadosView.mostrarMensaje(error);
    }
}
