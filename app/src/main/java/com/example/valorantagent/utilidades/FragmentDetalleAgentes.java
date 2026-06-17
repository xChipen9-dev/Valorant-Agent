package com.example.valorantagent.utilidades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.valorantagent.R;
import com.example.valorantagent.modelos.Agente;
import com.example.valorantagent.viewmodel.ViewModelCompartido;

public class FragmentDetalleAgentes extends Fragment {

    private ViewModelCompartido viewModel;
    private ImageView imgDetail;
    private TextView tvNumber, tvName, tvDescription, tvRole;

    private TextView tvSkillE, tvSkillQ, tvSkillC, tvSkillX;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle_agente, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgDetail = view.findViewById(R.id.imgDetailAgent);
        tvNumber = view.findViewById(R.id.tvDetailAgentNumber);
        tvName = view.findViewById(R.id.tvDetailAgentName);
        tvDescription = view.findViewById(R.id.tvDetailAgentDescription);
        tvRole = view.findViewById(R.id.tvDetailAgentRole);
        tvSkillE = view.findViewById(R.id.tvSkillE);
        tvSkillQ = view.findViewById(R.id.tvSkillQ);
        tvSkillC = view.findViewById(R.id.tvSkillC);
        tvSkillX = view.findViewById(R.id.tvSkillX);


        viewModel = new ViewModelProvider(requireActivity()).get(ViewModelCompartido.class);

        viewModel.getSelectedAgent().observe(getViewLifecycleOwner(), agent -> {
            if (agent == null) return;
            bindAgent(agent);
        });
    }

    private void bindAgent(Agente agent) {
        imgDetail.setImageResource(agent.getImagenResId());
        tvName.setText(agent.getNombre());
        tvNumber.setText(String.format("#%02d", agent.getId()));
        tvDescription.setText(agent.getDescripcion());
        tvRole.setText(agent.getRol());

        tvSkillE.setText("E — " + agent.getHabilidadE());
        tvSkillQ.setText("Q — " + agent.getHabilidadQ());
        tvSkillC.setText("C — " + agent.getHabilidadC());
        tvSkillX.setText("X — " + agent.getHabilidadX());
    }

}
