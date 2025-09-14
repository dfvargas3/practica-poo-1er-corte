package com.evaluaciones.poo.model;

public class Animal {
    private String nombre;
    private int edad;

    public Animal() {}

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 0) throw new IllegalArgumentException("la edad no puede ser negativa");
        this.edad = edad;
    }

    public String presentacion() {
        return "Soy " + (nombre != null ? nombre : "(sin nombre)") + " y tengo " + edad + " años.";
    }

    public String hablar() {
        return "(sonido genérico)";
    }
}
