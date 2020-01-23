package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloGeografia;

import android.content.Context;

public class DireccionDeEntregaPresenter implements DireccionDeEntregaContracts.Presenter {

    private DireccionDeEntregaContracts.View direccionDeEntregaView;
    private DireccionDeEntregaContracts.Interactor direccionDeEntregaInteractor;

    public DireccionDeEntregaPresenter(DireccionDeEntregaContracts.View view, Context mContext) {
        this.direccionDeEntregaView = view;
        this.direccionDeEntregaInteractor = new DireccionDeEntregaInteractor(this, mContext);
    }


    @Override
    public void enBotonConfirmarPresionado(double latitud, double longitud) {
        direccionDeEntregaView.mostrarProgressBar();
        direccionDeEntregaInteractor.actualizarPosicionPreferida(latitud, longitud);
    }

    @Override
    public void enActualizarPosicionPExitoso(String mensaje) {
        direccionDeEntregaView.ocultarProgressBar();
        direccionDeEntregaView.mostrarToast(mensaje);
        //direccionDeEntregaView.volver(null); no vuelve inmediatamente
    }

    @Override
    public void enActualizarPosicionPFallido(String error) {
        direccionDeEntregaView.ocultarProgressBar();
        direccionDeEntregaView.mostrarToast(error);
    }

    @Override
    public void enUsuarioNoIdentificado(String mensaje) {
        direccionDeEntregaView.ocultarProgressBar();
        direccionDeEntregaView.mostrarToast(mensaje);
        direccionDeEntregaView.salirDeAplicacion();
    }
}
