package com.example.valorantagent.utilidades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.valorantagent.R;
import com.example.valorantagent.modelos.Agente;
import com.example.valorantagent.modelos.RepoAgente;
import com.example.valorantagent.viewmodel.ViewModelCompartido;

import java.util.List;
import java.util.Random;

public class FragmentGeneradorAgentes extends Fragment {

    private ImageView img;
    private TextView tvName, tvNumber, tvRole;
    private ViewModelCompartido viewModel;
    private final Random random = new Random();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_generador_agentes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        img = view.findViewById(R.id.imgGeneratorAgent);
        tvName = view.findViewById(R.id.tvGeneratorAgentName);
        tvNumber = view.findViewById(R.id.tvGeneratorAgentNumber);
        tvRole = view.findViewById(R.id.tvGeneratorAgentRole);
        Button btnGenerate = view.findViewById(R.id.btnGenerateAgent);

        viewModel = new ViewModelProvider(requireActivity()).get(ViewModelCompartido.class);

        btnGenerate.setOnClickListener(v -> {
            List<Agente> all = RepoAgente.getAll();
            Agente a = all.get(random.nextInt(all.size()));

            img.setImageResource(a.getImagenResId());
            tvName.setText(a.getNombre());
            tvNumber.setText(String.format("#%02d", a.getId()));
            tvRole.setText(a.getRol());

            boolean added = viewModel.addAgent(a);
            if (added) {
                Toast.makeText(getContext(),
                        "Se ha añadido " + a.getNombre() + " a tu equipo",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(),
                        "Ya tienes a " + a.getNombre() + " en tu equipo",
                        Toast.LENGTH_SHORT).show();
            }
            viewModel.setSelectedAgent(a);

            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.fragmentDetalleAgentes);
        });
    }
}
