package com.evaluaciones.poo.model;

public class Gato extends Animal {
    public Gato() {
        super();
    }

    public Gato(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public String hablar() {
        return "Miau!";
    }

    @Override
    public String presentacion() {
        return "Soy el gato " + getNombre() + " y tengo " + getEdad() + " años.";
    }
}
