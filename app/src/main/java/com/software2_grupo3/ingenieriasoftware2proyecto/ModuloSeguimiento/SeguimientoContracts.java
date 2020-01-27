package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

public interface SeguimientoContracts {

    interface View{
        void mostrarMensaje(String mensaje); //codigo generado
        void mostrarProgressBar();
        void ocultarProgressBar();
    }

    interface Presentador{
        void botonGenerarCodigo();
        void generarExitoso(String codigo);
        void generarFallido(String error);
    }

    interface Interactor{
        void generarCodigo();

    }


}
