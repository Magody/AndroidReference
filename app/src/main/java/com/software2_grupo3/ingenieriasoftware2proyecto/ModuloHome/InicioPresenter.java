package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloHome;

import android.content.Context;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Adapters.RecyclerViewAdapter;

public class InicioPresenter implements InicioContracts.Presenter {

    InicioContracts.View observarProductosView;
    InicioContracts.Interactor observarProductosInteractor;

    public InicioPresenter(InicioContracts.View observarProductosView, Context context){
        this.observarProductosView = observarProductosView;
        this.observarProductosInteractor = new InicioInteractor(this, context);

    }



    @Override
    public void enConsultaProductoExitoso(RecyclerViewAdapter adapter) {
        observarProductosView.ocultarProgressBar();
        observarProductosView.mostrarProductos(adapter);
    }

    @Override
    public void enConsultaProductoFallido(String error) {
        observarProductosView.ocultarProgressBar();
        observarProductosView.mostrarMensaje(error);
    }

    @Override
    public void enInicioActividad() {
        observarProductosView.mostarProgressBar();
        observarProductosInteractor.consultarProductoTest();
    }
}
