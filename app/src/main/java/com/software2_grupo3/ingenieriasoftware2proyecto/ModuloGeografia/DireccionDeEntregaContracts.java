package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloGeografia;

public interface DireccionDeEntregaContracts {

    interface View{

        void mostrarToast(String mensaje);

        void mostrarProgressBar();
        void ocultarProgressBar();

        void volver(android.view.View view);
        void salirDeAplicacion();

    }

    interface Presenter{

        void enBotonConfirmarPresionado(double latitud, double longitud);
        void enActualizarPosicionPExitoso(String mensaje);
        void enActualizarPosicionPFallido(String error);

        void enUsuarioNoIdentificado(String mensaje);
    }

    interface Interactor{

        void actualizarPosicionPreferida(double latitud, double longitud);
    }


}
