package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

public class CambiarEstadosContracts {

    interface View{
        void mostrarMensaje(String mensaje); //codigo generado
        void mostrarProgressBar();
        void ocultarProgressBar();
    }

    interface Presentador{

        void enBotonAtendidoPresionado(int id);
        void enBotonEnCaminoPresionado(int id);
        void enBotonHaLlegadoPresionado(int id);

        void enCambiarEstadoExitoso(String codigo);
        void enCambiarEstadoFallido(String error);


    }

    interface Interactor{
        void cambiarEstado(int id, int estado);


    }


}
