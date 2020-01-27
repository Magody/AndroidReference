package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

import android.content.Context;

public interface SeguimientoContracts {

    interface View{
        void mostrarMensaje(String mensaje); //codigo generado
        void mostrarProgressBar();
        void ocultarProgressBar();
    }

    interface Presentador{
        void botonGenerarCodigo();
        void botonCambiarEstado();
        void botonAtendido(String codigo);
        void botonEnCamino(String codigo);
        void botonHaLlegado(String codigo);
        void generarExitoso(String codigo);
        void generarFallido(String error);
    }

    interface Interactor{
        void generarCodigo();
        void cambiarEstado(String codigo, int estado);
    }


}
