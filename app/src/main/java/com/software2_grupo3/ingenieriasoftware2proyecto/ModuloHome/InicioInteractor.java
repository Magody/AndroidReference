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

        lista.add(new Producto(4, "Primero", "https://webcomicms.net/sites/default/files/clipart/129693/book-pictures-129693-9465160.jpg", 10));
        lista.add(new Producto(5, "Segundo", "https://image.shutterstock.com/image-vector/vector-basket-christmas-gifts-260nw-746365573.jpg", 25));
        lista.add(new Producto(6, "Tercero", "https://cdn.ticbeat.com/src/uploads/2019/10/vino.jpg", 35));
        lista.add(new Producto(7, "Primero", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRq_kPlrchOwvUv_k9g1jAV9gC4Nr30Kh3KZqPm1GSJ-5jaU1MX&s", 15));
        lista.add(new Producto(8, "Segundo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfuLuZ6Z5s6dZ0tSg-f34NgPbyRxSfCe5bVG4JUBjNu-iIbwWGvg&s", 22));
        lista.add(new Producto(9, "Tercero", "https://brumano.b-cdn.net/wp-content/uploads/2018/12/Royal-Blue-Casual-Check-Shirt-1-min-600x800.jpg", 38));
        lista.add(new Producto(10, "Primero", "https://res.cloudinary.com/demo/image/upload/shoes.jpg", 50));
        lista.add(new Producto(11, "Segundo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQs6915fgMNpkXuf44gL8NcHpekj7BZ7AknDzy8uj3z9M0bkxVS&s", 40));
        lista.add(new Producto(12, "Tercero", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR98FMq_v2_B96lsNT7nq66jXRQAQK1RZU6P6rVImSKAcwiQ5BE&s", 33));RecyclerViewAdapter adapter = new RecyclerViewAdapter(context, lista);
        lista.add(new Producto(5, "Segundo", "https://image.shutterstock.com/image-vector/vector-basket-christmas-gifts-260nw-746365573.jpg", 25));
        lista.add(new Producto(6, "Tercero", "https://cdn.ticbeat.com/src/uploads/2019/10/vino.jpg", 35));
        lista.add(new Producto(7, "Primero", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRq_kPlrchOwvUv_k9g1jAV9gC4Nr30Kh3KZqPm1GSJ-5jaU1MX&s", 15));
        lista.add(new Producto(8, "Segundo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfuLuZ6Z5s6dZ0tSg-f34NgPbyRxSfCe5bVG4JUBjNu-iIbwWGvg&s", 22));
        lista.add(new Producto(9, "Tercero", "https://brumano.b-cdn.net/wp-content/uploads/2018/12/Royal-Blue-Casual-Check-Shirt-1-min-600x800.jpg", 38));
        lista.add(new Producto(10, "Primero", "https://res.cloudinary.com/demo/image/upload/shoes.jpg", 50));
        lista.add(new Producto(11, "Segundo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQs6915fgMNpkXuf44gL8NcHpekj7BZ7AknDzy8uj3z9M0bkxVS&s", 40));
        lista.add(new Producto(12, "Tercero", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR98FMq_v2_B96lsNT7nq66jXRQAQK1RZU6P6rVImSKAcwiQ5BE&s", 33));

        callbackObservarProductosPresenter.enConsultaProductoExitoso(adapter);
    }
}
