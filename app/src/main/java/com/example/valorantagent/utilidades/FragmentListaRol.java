package com.example.valorantagent.utilidades;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.valorantagent.R;
import com.example.valorantagent.adaptadores.AdaptadorAgente;
import com.example.valorantagent.modelos.Agente;
import com.example.valorantagent.modelos.RepoAgente;
import com.example.valorantagent.viewmodel.ViewModelCompartido;

import java.util.List;
import java.util.stream.Collectors;

public class FragmentListaRol extends Fragment {

    private static final String ARG_ROL = "rol";
    private String rol;

    private ViewModelCompartido viewModel;

    public static FragmentListaRol newInstance(String rol) {
        FragmentListaRol f = new FragmentListaRol();
        Bundle args = new Bundle();
        args.putString(ARG_ROL, rol);
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grupo_agentes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(ViewModelCompartido.class);

        rol = getArguments().getString(ARG_ROL);

        RecyclerView rv = view.findViewById(R.id.rvGen);
        rv.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        List<Agente> agentesFiltrados =
                RepoAgente.getAll().stream()
                        .filter(a -> a.getRol().equals(rol))
                        .collect(Collectors.toList());

        rv.setAdapter(new AdaptadorAgente(agentesFiltrados, agente -> {

            viewModel.setSelectedAgent(agente);

            Navigation.findNavController(view)
                    .navigate(R.id.fragmentDetalleAgentes);
        }));
    }
}
