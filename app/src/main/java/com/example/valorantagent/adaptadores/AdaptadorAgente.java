package com.example.valorantagent.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.valorantagent.R;
import com.example.valorantagent.modelos.Agente;

import java.util.List;

public class AdaptadorAgente extends RecyclerView.Adapter<AdaptadorAgente.AgentViewHolder> {

    public interface OnAgentClickListener {
        void onAgentClick(Agente agent);
    }

    private List<Agente> lista;
    private OnAgentClickListener listener;

    public AdaptadorAgente(List<Agente> lista, OnAgentClickListener listener) {
        this.lista = lista;
        this.listener = listener;
    }

    public void updateList(List<Agente> nuevaLista) {
        this.lista = nuevaLista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AgentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_agente, parent, false);
        return new AgentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AgentViewHolder holder, int position) {
        Agente a = lista.get(position);
        holder.tvNombre.setText(a.getNombre());
        holder.tvNumero.setText(String.format("#%02d", a.getId()));
        holder.imgAgent.setImageResource(a.getImagenResId());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onAgentClick(a);
        });
    }

    @Override
    public int getItemCount() {
        return lista != null ? lista.size() : 0;
    }

    static class AgentViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombre, tvNumero;
        ImageView imgAgent;

        public AgentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombreAgent);
            tvNumero = itemView.findViewById(R.id.tvNumeroAgent);
            imgAgent = itemView.findViewById(R.id.imgAgent);
        }
    }
}
