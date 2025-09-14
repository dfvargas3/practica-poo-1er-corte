package com.evaluaciones.poo.model;

public class Perro extends Animal {

    public Perro() {
        super();
    }

    public Perro(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public String hablar() {
        return "Guau!";
    }

    @Override
    public String presentacion() {
        return "Soy el perro " + getNombre() + " y tengo " + getEdad() + " años.";
    }
}
