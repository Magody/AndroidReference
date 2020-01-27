package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloHome;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Adapters.RecyclerViewAdapter;

public interface InicioContracts {
    interface View {
        void mostrarMensaje(String mensaje);
        void mostarProgressBar();
        void ocultarProgressBar();
        void mostrarProductos(RecyclerViewAdapter adapter);
    }
    interface Presenter{
        void enConsultaProductoExitoso(RecyclerViewAdapter adapter);
        void enConsultaProductoFallido(String error);
        void enInicioActividad();
    }
    interface Interactor{
        void consultarProductoTest();
    }

}
