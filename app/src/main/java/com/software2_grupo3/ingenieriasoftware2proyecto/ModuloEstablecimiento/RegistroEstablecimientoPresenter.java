package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloEstablecimiento;

import android.content.Context;

public class RegistroEstablecimientoPresenter implements RegistrarEstablecimientoContracts.Presentador{


    private RegistrarEstablecimientoContracts.View classView;
    private RegistrarEstablecimientoContracts.Interactor classInteractor;

    public RegistroEstablecimientoPresenter(RegistrarEstablecimientoContracts.View view, Context mContext) {
        this.classView = view;
        this.classInteractor = new RegistrarEstablecimientoInteractor(this, mContext);
    }


    @Override
    public void enBotonPresionado(String RUC, String nombre, String password, String direccion, String telefonoFijo, String cuentaBancaria, String correo) {
        classInteractor.insertarRegistroEstablecimiento(RUC, nombre, password, direccion, telefonoFijo, cuentaBancaria, correo);
    }

    @Override
    public void enInsertarExitoso(String data) {
        classView.mostrarMensaje(data);
        classView.navegarComprobacionCorreo();
    }

    @Override
    public void enInsertarFallido(String error) {
        classView.mostrarMensaje(error);
    }
}
