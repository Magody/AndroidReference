package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

import android.content.Context;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Pedido;

public interface SeguimientoContracts {

    interface View{
        void mostrarMensaje(String mensaje); //codigo generado
        void mostrarProgressBar();
        void ocultarProgressBar();


        void mostrarEstado(int estado);
    }

    interface Presentador{
        //void enInicioActivity(String codigo);




        void enConsultaEstadoExitoso(int estado);
        void enConsultaEstadoFallido(String error);



    }

    interface Interactor{
        void consultarEstado();

    }


}
