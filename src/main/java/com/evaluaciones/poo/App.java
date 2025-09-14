package com.evaluaciones.poo;

import com.evaluaciones.poo.model.*;

public class App {
    public static void main(String[] args) {
        Animal a1 = new Perro("Fido", 2);
        Animal a2 = new Gato("Mishi", 3);
        Animal a3 = new Loro();
        a3.setNombre("Paco");
        a3.setEdad(1);

        ClinicaVeterinaria clinica = new ClinicaVeterinaria("Clínica Animalitos");
        clinica.setAnimalA(a1);
        clinica.setAnimalB(a2);

        System.out.println("=== Resumen de la clínica ===");
        System.out.println("Nombre: " + clinica.getNombre());
        System.out.println("Animal A: " + clinica.getAnimalA().presentacion());
        System.out.println("Animal B: " + clinica.getAnimalB().presentacion());

        System.out.println("\n=== Polimorfismo: hablar() ===");
        System.out.println("a1 dice: " + a1.hablar());
        System.out.println("a2 dice: " + a2.hablar());
        System.out.println("a3 dice: " + a3.hablar());

        System.out.println("\n=== Encapsulación (validaciones) ===");
        try {
            a1.setEdad(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado al asignar edad inválida: " + e.getMessage());
        }
        System.out.println("Edad válida de " + a1.getNombre() + ": " + a1.getEdad());
    }
}
