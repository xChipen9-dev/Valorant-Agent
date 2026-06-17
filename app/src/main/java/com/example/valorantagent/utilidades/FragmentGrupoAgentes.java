package com.example.valorantagent.utilidades;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentGrupoAgentes extends FragmentStateAdapter {

    public FragmentGrupoAgentes(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0: return FragmentListaRol.newInstance("Controlador");
            case 1: return FragmentListaRol.newInstance("Duelista");
            case 2: return FragmentListaRol.newInstance("Iniciador");
            case 3: return FragmentListaRol.newInstance("Centinela");
        }
        return FragmentListaRol.newInstance("Controlador");
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
