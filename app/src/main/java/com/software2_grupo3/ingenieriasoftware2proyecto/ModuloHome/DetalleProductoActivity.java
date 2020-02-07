package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloHome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.software2_grupo3.ingenieriasoftware2proyecto.R;
import com.squareup.picasso.Picasso;

public class DetalleProductoActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        imageView = findViewById(R.id.imageViewDetalleProductoFoto);
        Bundle bundle = getIntent().getExtras();

        String url = bundle.getString("url", null);

        if(url != null)
            Picasso.get().load(url)
                         .placeholder(R.drawable.ic_home_black_24dp)
                         .into(imageView);
    }
}
