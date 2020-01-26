package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

public interface SeguimientoContracts {

    interface View{
        void mostrarMensaje(String mensaje); //codigo generado
    }

    interface Presentador{
        void botonGenerarCodigo();
        void generarExitoso();
        void generarFallido();
    }

    interface Interactor{
        void generarCodigo();

    }


}
