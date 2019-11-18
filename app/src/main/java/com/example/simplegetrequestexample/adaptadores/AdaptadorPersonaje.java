package com.example.simplegetrequestexample.adaptadores;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplegetrequestexample.R;
import com.example.simplegetrequestexample.entidades.PersonajeVo;

import java.util.ArrayList;

public class AdaptadorPersonaje extends RecyclerView.Adapter<AdaptadorPersonaje.PersonajesViewHolder> implements View.OnClickListener {

    ArrayList<PersonajeVo> listaPersonajes;
    private View.OnClickListener listener;

    public AdaptadorPersonaje(ArrayList<PersonajeVo> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @NonNull
    @Override
    public AdaptadorPersonaje.PersonajesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        view.setOnClickListener(this);
        return new PersonajesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonaje.PersonajesViewHolder holder, int position) {
        holder.txtNombre.setText(listaPersonajes.get(position).getNombre());
        holder.txtInformacion.setText(listaPersonajes.get(position).getInfo());
        holder.foto.setImageResource(listaPersonajes.get(position).getImagenId());

    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;

    }
    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }

    }

    public class PersonajesViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre,txtInformacion;
        ImageView foto;

        public PersonajesViewHolder(View itemView){
            super(itemView);
            txtNombre = itemView.findViewById(R.id.idNombre);
            txtInformacion = itemView.findViewById(R.id.idInfo);
            foto = itemView.findViewById(R.id.idImagen);

    }
    }
}

