package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

public class CarritoContracts {

    interface View{
        void mostrarMensaje(String mensaje); //codigo generado
        void mostrarProgressBar();
        void ocultarProgressBar();
        void mostrarPantallaSeguimiento();
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
