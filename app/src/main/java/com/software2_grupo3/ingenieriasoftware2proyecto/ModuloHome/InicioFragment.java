package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloHome;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Adapters.RecyclerViewAdapter;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Utilidad;


public class InicioFragment extends Fragment implements InicioContracts.View {
    ProgressBar progressBar;
    InicioContracts.Presenter inicioFragmentPresenter;
    private Context mContext;
    RecyclerView recyclreView;


    public InicioFragment() {
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
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar = view.findViewById(R.id.progressBarFragmentInicio);
        recyclreView = view.findViewById(R.id.RecyclerViewInicioFragment);
        mContext = getContext();

        inicioFragmentPresenter = new InicioPresenter(this, mContext);
        inicioFragmentPresenter.enInicioActividad();

        //todo: crear GridLayout con todos los productos


        Utilidad.mostrarToast(mContext, getString(R.string.debugMsg), Toast.LENGTH_SHORT);

    }

    @Override
    public void mostrarMensaje(String mensaje) {
        Utilidad.mostrarToast(mContext, mensaje, 1);
    }

    @Override
    public void mostarProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void ocultarProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void mostrarProductos(RecyclerViewAdapter adapter) {
        recyclreView.setLayoutManager(new GridLayoutManager(mContext, 3));
        recyclreView.setAdapter(adapter);
    }
}
