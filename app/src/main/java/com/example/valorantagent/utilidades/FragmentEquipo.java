package com.example.valorantagent.utilidades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.valorantagent.MainActivity;
import com.example.valorantagent.R;
import com.example.valorantagent.adaptadores.AdaptadorAgente;
import com.example.valorantagent.modelos.Agente;
import com.example.valorantagent.viewmodel.ViewModelCompartido;

import java.util.ArrayList;
import java.util.List;

public class FragmentEquipo extends Fragment {

    private ViewModelCompartido viewModel;
    private AdaptadorAgente adapter;
    private RecyclerView rv;
    private TextView tvEmpty;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_equipo, container, false);
        rv = v.findViewById(R.id.rvTeam);
        tvEmpty = v.findViewById(R.id.tvEmpty);
        rv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(ViewModelCompartido.class);

        adapter = new AdaptadorAgente(new ArrayList<>(), agent -> {
            viewModel.setSelectedAgent(agent);
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.fragmentDetalleAgentes);
        });

        rv.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback callback =
                new ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView,
                                          @NonNull RecyclerView.ViewHolder viewHolder,
                                          @NonNull RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                        int position = viewHolder.getAdapterPosition();
                        List<Agente> current = viewModel.getTeam().getValue();
                        if (current != null && position >= 0 && position < current.size()) {
                            Agente a = current.get(position);
                            viewModel.removeAgent(a);
                        }
                    }
                };

        new ItemTouchHelper(callback).attachToRecyclerView(rv);

        viewModel.getTeam().observe(getViewLifecycleOwner(), agents -> {
            adapter.updateList(agents);
            tvEmpty.setVisibility(agents.isEmpty() ? View.VISIBLE : View.GONE);
        });
    }
}
