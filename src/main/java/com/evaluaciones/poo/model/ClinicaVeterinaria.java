package com.evaluaciones.poo.model;

public class ClinicaVeterinaria {
    private String nombre;
    private Animal animalA;
    private Animal animalB;

    public ClinicaVeterinaria(String nombre) { this.nombre = nombre; }

    public String getNombre() {
        return nombre;
    }

    public Animal getAnimalA() {
        return animalA;
    }

    public void setAnimalA(Animal animalA) {
        this.animalA = animalA;
    }

    public Animal getAnimalB() {
        return animalB;
    }

    public void setAnimalB(Animal animalB) {
        this.animalB = animalB;
    }
}
