package com.example.valorantagent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.valorantagent.viewmodel.ViewModelCompartido;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;
    private BottomNavigationView bottomNav;
    private ViewModelCompartido viewModel;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNav = findViewById(R.id.bottom_nav);

        viewModel = new ViewModelProvider(this).get(ViewModelCompartido.class);

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment);

        navController = navHostFragment.getNavController();

        NavigationUI.setupWithNavController(bottomNav, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            int id = destination.getId();
            if (id == R.id.fragmentEquipo) {
                toolbar.setTitle("Tu equipo");
            } else if (id == R.id.fragmentAgentes) {
                toolbar.setTitle("Agentes");
            } else if (id == R.id.fragmentGeneradorAgentes) {
                toolbar.setTitle("Generador de agente");
            } else if (id == R.id.fragmentDetalleAgentes) {
                toolbar.setTitle("Detalles del agente");
            }
        });
    }
}
