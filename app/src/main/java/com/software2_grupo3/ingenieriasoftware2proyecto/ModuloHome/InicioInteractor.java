package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloHome;

import android.content.Context;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Adapters.RecyclerViewAdapter;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class InicioInteractor implements InicioContracts.Interactor {
    public static final String TAG = "InicioInteractor";

    Context context;
    List<Producto> lista;

    InicioContracts.Presenter callbackObservarProductosPresenter;

    public InicioInteractor(InicioContracts.Presenter callbackObservarProductosPresenter, Context context){
        this.context = context;
        this.callbackObservarProductosPresenter = callbackObservarProductosPresenter;

    }


    @Override
    public void consultarProductoTest() {
        lista = new ArrayList<>();
        lista.add(new Producto(1, "Primero", "https://www.toystrains.com.mx/images/inicio/regalo.jpg", 10));
        lista.add(new Producto(2, "Segundo", "https://images-na.ssl-images-amazon.com/images/I/81J4TvhJx1L._SX425_.jpg", 20));
        lista.add(new Producto(3, "Tercero", "https://www.tiposde.com/wp-content/uploads/2010/01/tipos-de-productos-tangibles.jpg", 30));
        lista.add(new Producto(1, "Primero", "https://source.unsplash.com/random", 10));
        lista.add(new Producto(2, "Segundo", "https://images-na.ssl-images-amazon.com/images/I/81J4TvhJx1L._SX425_.jpg", 20));
        lista.add(new Producto(3, "Tercero", "https://www.tiposde.com/wp-content/uploads/2010/01/tipos-de-productos-tangibles.jpg", 30));
        lista.add(new Producto(1, "Primero", "https://source.unsplash.com/random", 10));
        lista.add(new Producto(2, "Segundo", "https://images-na.ssl-images-amazon.com/images/I/81J4TvhJx1L._SX425_.jpg", 20));
        lista.add(new Producto(3, "Tercero", "https://www.tiposde.com/wp-content/uploads/2010/01/tipos-de-productos-tangibles.jpg", 30));
        lista.add(new Producto(1, "Primero", "https://www.toystrains.com.mx/images/inicio/regalo.jpg", 10));
        lista.add(new Producto(1, "Primero", "https://source.unsplash.com/random", 10));lista.add(new Producto(3, "Tercero", "https://www.tiposde.com/wp-content/uploads/2010/01/tipos-de-productos-tangibles.jpg", 30));
        lista.add(new Producto(1, "Primero", "https://www.toystrains.com.mx/images/inicio/regalo.jpg", 10));
        lista.add(new Producto(2, "Segundo", "https://images-na.ssl-images-amazon.com/images/I/81J4TvhJx1L._SX425_.jpg", 20));
        lista.add(new Producto(1, "Primero", "https://source.unsplash.com/random", 10));lista.add(new Producto(1, "Primero", "https://www.toystrains.com.mx/images/inicio/regalo.jpg", 10));
        lista.add(new Producto(2, "Segundo", "https://images-na.ssl-images-amazon.com/images/I/81J4TvhJx1L._SX425_.jpg", 20));
        lista.add(new Producto(1, "Primero", "https://source.unsplash.com/random", 10));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(context, lista);
        callbackObservarProductosPresenter.enConsultaProductoExitoso(adapter);
    }
}
