package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Producto;
import com.software2_grupo3.ingenieriasoftware2proyecto.ModuloHome.DetalleProductoActivity;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    public static final String TAG = "TiendasAdapter";

    private Context mContext ;
    private final List<Producto> mData ;


    public RecyclerViewAdapter(Context mContext, List<Producto> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.layout_producto,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        final Producto producto = mData.get(position);
        //Log.d(TAG, "Precios recibidos: " + mData.get(position).getPrecio());


        holder.precioProducto.setText("" + mData.get(position).getPrecio());

        Picasso.get().load(producto.getUrl())
                .placeholder(R.drawable.ic_account_box_black_24dp)
                .into(holder.imagenProducto);



        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetalleProductoActivity.class);
                intent.putExtra("url", producto.getUrl());
               mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView precioProducto;
        ImageView imagenProducto;
        CardView cardView ;

        MyViewHolder(View itemView) {
            super(itemView);

            precioProducto = itemView.findViewById(R.id.textViewPrecio) ;
            imagenProducto = itemView.findViewById(R.id.imageViewProducto);
            cardView = itemView.findViewById(R.id.cardViewTienda);

        }
    }




}
