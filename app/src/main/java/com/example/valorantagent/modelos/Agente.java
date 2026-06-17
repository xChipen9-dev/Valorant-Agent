package com.example.valorantagent.modelos;

public class Agente {

    private int id;
    private String nombre;
    private String rol;
    private int imagenResId;
    private String descripcion;

    private String habilidadE;
    private String habilidadQ;
    private String habilidadC;
    private String habilidadX;

    public Agente(int id, String nombre, String rol, int imagenResId, String descripcion,
                  String habilidadE, String habilidadQ, String habilidadC, String habilidadX) {

        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.imagenResId = imagenResId;
        this.descripcion = descripcion;

        this.habilidadE = habilidadE;
        this.habilidadQ = habilidadQ;
        this.habilidadC = habilidadC;
        this.habilidadX = habilidadX;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getRol() { return rol; }
    public int getImagenResId() { return imagenResId; }
    public String getDescripcion() { return descripcion; }

    public String getHabilidadE() { return habilidadE; }
    public String getHabilidadQ() { return habilidadQ; }
    public String getHabilidadC() { return habilidadC; }
    public String getHabilidadX() { return habilidadX; }
}
