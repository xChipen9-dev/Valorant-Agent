package com.example.valorantagent.modelos;

import com.example.valorantagent.R;
import java.util.ArrayList;
import java.util.List;

public class RepoAgente {

    private static List<Agente> lista;

    public static List<Agente> getAll() {
        if (lista == null) {
            lista = new ArrayList<>();

            // CONTROLADORES
            lista.add(new Agente(
                    1, "Astra", "Controlador", R.drawable.astra,
                    "Controladora ghanesa que manipula el campo de batalla desde el plano astral.",
                    "Nebulosa", "Pozo Gravitacional", "Pulso Estelar", "Forma Astral / Divisa Cósmica (Ultimate)"
            ));

            lista.add(new Agente(
                    2, "Brimstone", "Controlador", R.drawable.brim,
                    "Comandante estadounidense que despliega utilidades orbitales.",
                    "Baliza Estimulante", "Humo Celestial", "Incendiario", "Golpe Orbital (Ultimate)"
            ));

            lista.add(new Agente(
                    3, "Harbor", "Controlador", R.drawable.harbor,
                    "Controlador que usa agua para crear muros y proteger zonas.",
                    "Marea Alta", "Oleaje", "Bola Marina", "Cascada (Ultimate)"
            ));

            lista.add(new Agente(
                    4, "Omen", "Controlador", R.drawable.omen,
                    "Sombra misteriosa que manipula la mente y la visión del enemigo.",
                    "Paranoia", "Velo Tenebroso", "Mantillo Sombrío", "Desde las Sombras (Ultimate)"
            ));

            lista.add(new Agente(
                    5, "Viper", "Controlador", R.drawable.viper,
                    "Química manipuladora de toxinas mortales.",
                    "Nube Venenosa", "Pantalla Tóxica", "Mordedura de Serpiente", "Fosa Viperina (Ultimate)"
            ));

            lista.add(new Agente(
                    6, "Clove", "Controlador", R.drawable.clove,
                    "Controladora escocesa que puede regresar temporalmente del más allá.",
                    "Remedy", "Ruse", "Pick-me-up", "Not Dead Yet (Ultimate)"
            ));

            // DUELISTAS
            lista.add(new Agente(
                    7, "Jett", "Duelista", R.drawable.jett,
                    "Duelista coreana extremadamente móvil, especializada en flanqueos rápidos.",
                    "Viento de Cola", "Cuchillas", "Ráfaga Ascendente", "Tormenta de Cuchillas (Ultimate)"
            ));

            lista.add(new Agente(
                    8, "Neon", "Duelista", R.drawable.neon,
                    "Velocista capaz de esprintar y soltar descargas eléctricas.",
                    "Carrera Rápida", "Rayo Relámpago", "Vía Rápida", "Sobrecarga (Ultimate)"
            ));

            lista.add(new Agente(
                    9, "Phoenix", "Duelista", R.drawable.phoenix,
                    "Duelista británico que controla fuego para atacar y curarse.",
                    "Combustión", "Bola Curva", "Llamarada", "Renacer (Ultimate)"
            ));

            lista.add(new Agente(
                    10, "Raze", "Duelista", R.drawable.raze,
                    "Experta en explosivos, ideal para limpiar zonas.",
                    "Bot Explosivo", "Carga de Pintura", "Paquete Explosivo", "Bum Bot (Ultimate)"
            ));

            lista.add(new Agente(
                    11, "Reyna", "Duelista", R.drawable.reyna,
                    "Duelista que destaca en el 1v1 absorbiendo almas del enemigo.",
                    "Mirada Lasciva", "Devorar", "Disipar", "Emperatriz (Ultimate)"
            ));

            lista.add(new Agente(
                    12, "Yoru", "Duelista", R.drawable.yoru,
                    "Engañador que utiliza portales y teletransportes.",
                    "Infiltración", "Punto Ciego", "Engaño", "Dimensión Fugitiva (Ultimate)"
            ));

            lista.add(new Agente(
                    13, "Iso", "Duelista", R.drawable.iso,
                    "Duelista chino que puede aislar enemigos en un duelo 1v1 forzado.",
                    "Velo Contundente", "Doble Toque", "Contención", "Kill Contract (Ultimate) "
            ));

            // INICIADORES
            lista.add(new Agente(
                    14, "Breach", "Iniciador", R.drawable.breach,
                    "Conmociona y despeja zonas mediante explosiones sísmicas.",
                    "Explosión Cegadora", "Falla", "Réptica", "Terremoto (Ultimate)"
            ));

            lista.add(new Agente(
                    15, "Fade", "Iniciador", R.drawable.fade,
                    "Iniciadora turca que usa sombras para revelar y cazar enemigos.",
                    "Atrapahorizontes", "Acechadores", "Pasos Nocturnos", "Caída (Ultimate)"
            ));

            lista.add(new Agente(
                    16, "Gekko", "Iniciador", R.drawable.gekko,
                    "Líder de criaturas capaces de controlar zonas y desactivar la Spike.",
                    "Wingman", "Dizzy", "Mosh Pit", "Thrash (Ultimate)"
            ));

            lista.add(new Agente(
                    17, "KAY/O", "Iniciador", R.drawable.kayo,
                    "Robot militar cuya especialidad es suprimir habilidades enemigas.",
                    "Frag/ment", "Cuchillo de Supresión", "Flashdrive", "NULL/cmd (Ultimate)"
            ));

            lista.add(new Agente(
                    18, "Skye", "Iniciador", R.drawable.skye,
                    "Controla animales espirituales que curan y exploran.",
                    "Refugio", "Luz Guía", "Perseguidoras", "Buscadores (Ultimate)"
            ));

            lista.add(new Agente(
                    19, "Sova", "Iniciador", R.drawable.sova,
                    "Rastreador que localiza enemigos con drones y flechas.",
                    "Flecha Rastreada", "Flecha Explosiva", "Dron Explorador", "Furia del Cazador (Ultimate)"
            ));

            // CENTINELAS
            lista.add(new Agente(
                    20, "Chamber", "Centinela", R.drawable.chamber,
                    "Centinela francés que combina armas personalizadas con teletransporte.",
                    "Marca Registrada", "Rendezvous", "Cazador de Cabezas", "Tour De Force (Ultimate)"
            ));

            lista.add(new Agente(
                    21, "Cypher", "Centinela", R.drawable.cypher,
                    "Experto en información capaz de controlar a los enemigos desde la distancia.",
                    "Cable Trampa", "Jaula Cibernética", "Cámara Espía", "Roba Almas (Ultimate)"
            ));

            lista.add(new Agente(
                    22, "Deadlock", "Centinela", R.drawable.deadlock,
                    "Agente noruega que usa campos tecnológicos para inmovilizar enemigos.",
                    "Enredadera Sónica", "Barrera", "Sensor de Vibración", "Aniquilación (Ultimate)"
            ));

            lista.add(new Agente(
                    23, "Killjoy", "Centinela", R.drawable.killjoy,
                    "Ingeniera que usa torretas y robots para defender zonas.",
                    "Nanoswim", "Torreta", "Bot de Alarmas", "Confinamiento (Ultimate)"
            ));

            lista.add(new Agente(
                    24, "Sage", "Centinela", R.drawable.sage,
                    "Sanadora china que protege y revive a sus aliados.",
                    "Orbe de Ralentización", "Orbe de Barrera", "Orbe Curativo", "Resurrección (Ultimate)"
            ));

            lista.add(new Agente(
                    25, "Vyse", "Centinela", R.drawable.vyse,
                    "Centinela capaz de manipular filamentos metálicos para controlar zonas.",
                    "Lámina Trampa", "Red de Acero", "Lanza Metálica", "Cortina de Cuchillas (Ultimate)"
            ));
        }

        return lista;
    }
}
