package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

import android.content.Context;

public class CarritoPresenter implements CarritoContracts.Presentador {

    CarritoContracts.View carritoView;
    CarritoContracts.Interactor carritoInteractor;


    public CarritoPresenter(CarritoContracts.View view, Context mContext) {
        this.carritoView = view;
        this.carritoInteractor = new CarritoInteractor(this, mContext);
    }

    @Override
    public void botonGenerarCodigo() {
        carritoView.mostrarProgressBar();
        carritoInteractor.generarCodigo();
    }

    @Override
    public void generarExitoso(String codigo) {
        carritoView.ocultarProgressBar();
        carritoView.mostrarMensaje(codigo);
        carritoView.mostrarPantallaSeguimiento();
    }

    @Override
    public void generarFallido(String error) {
        carritoView.ocultarProgressBar();
        carritoView.mostrarMensaje(error);
    }
}
