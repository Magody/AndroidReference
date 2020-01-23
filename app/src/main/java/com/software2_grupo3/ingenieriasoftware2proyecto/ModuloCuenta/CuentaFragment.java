package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloCuenta;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.software2_grupo3.ingenieriasoftware2proyecto.R;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Utilidad;


public class CuentaFragment extends Fragment {


    private Context mContext;

    public CuentaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cuenta, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContext = getContext();

        //todo: cosas de la cuenta por definir


        Utilidad.mostrarToast(mContext, getString(R.string.debugMsg), Toast.LENGTH_SHORT);

    }
}
