package com.evaluaciones.poo.model;

public class Loro extends Animal {
    public Loro() {
        super();
    }

    public Loro(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public String hablar() {
        return "¡Hola, hola!";
    }

    @Override
    public String presentacion() {
        return "Soy el loro " + getNombre() + " y tengo " + getEdad() + " años.";
    }
}
