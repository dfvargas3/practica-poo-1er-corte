# Guía de estudio — POO básica en Java


Este README está pensado para que puedas **repasar** y **practicar**: **clases, atributos, encapsulación, constructores, herencia simple y polimorfismo**. Incluye ejemplos breves, errores comunes, Retos y un checklist de autoevaluación.

---

## ¿Para quién es este material?
- Estudiantes que están **empezando** con Java y POO.
- Cursos donde **aún no** se han visto listas/arrays/colecciones.
- Quienes necesitan una **ruta práctica** y clara para dominar lo básico.

### Objetivos de aprendizaje
Al terminar este README podrás:
- Diferenciar **clase** y **objeto**.
- Aplicar **encapsulación** con `private` + getters/setters y **validación**.
- Escribir **constructores** (vacío y con parámetros) y usar `super(...)`.
- Modelar **herencia simple** con `extends`.
- Reconocer y demostrar **polimorfismo** por **sobrescritura**.

---

## 1) Clases y objetos
- **Clase**: plantilla que define datos (**atributos**) y acciones (**métodos**).
- **Objeto**: instancia concreta de una clase.

**Ejemplo:**
```java
public class Animal {
    private String nombre;
    private int    edad;

    // Métodos (comportamientos) vendrán después
}
```
**Crear un objeto (instanciar):**
```java
Animal a = new Animal();
```

**Reto (5 min):** crea una clase `Persona` con atributos `nombre` y `edad` y un método `saludar()` que imprima `"Hola, soy <nombre>"`.

---

## 2) Atributos y **encapsulación**
- Los **atributos** deben ser `private` para proteger los datos.
- Se accede a ellos con **getters y setters** (controlados).

```java
public class Animal {
    private String nombre;
    private int edad;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) {
        if (edad < 0) throw new IllegalArgumentException("la edad no puede ser negativa");
        this.edad = edad;
    }
}
```
> **Idea clave:** valida en `setters` o en **constructores** para evitar estados inválidos.

**Reto (5 min):** agrega a `Persona` validación en `setEdad(int)` para que no acepte valores negativos.

---

## 3) **Constructores** y sobrecarga
- Se llaman **igual que la clase** y **no** tienen tipo de retorno.
- Se usan para **inicializar** objetos.
- **Sobrecarga**: varios constructores con parámetros distintos.

```java
public class Animal {
    private String nombre;
    private int edad;

    public Animal() {}                      // constructor vacío
    public Animal(String nombre, int edad) { // con parámetros
        this.nombre = nombre;
        setEdad(edad); // reutiliza validación
    }
}
```
**Reto (5 min):** agrega a `Persona` un constructor vacío y otro con `nombre` y `edad`.

---

## 4) **Herencia simple** (`extends`)
Permite **reutilizar** y **especializar** una clase base.

```java
public class Perro extends Animal {
    public Perro() { super(); }
    public Perro(String nombre, int edad) { super(nombre, edad); }
}
```
- `Animal` es la **clase padre**.
- `Perro` es la **clase hija** y hereda atributos y métodos del padre.
- Usa `super(...)` para llamar al **constructor del padre**.

**Reto (5 min):** crea `Gato` y `Loro` que extiendan de `Animal`.

---

## 5) **Polimorfismo** por **sobrescritura**
La **misma llamada** a un método produce comportamientos **distintos** según el **tipo real** del objeto.

En `Animal` definimos un comportamiento **genérico**:
```java
public class Animal {
    // ...
    public String hablar() {
        return "(sonido genérico)";
    }
}
```

Las hijas **sobrescriben** (override) ese método:
```java
public class Perro extends Animal {
    @Override
    public String hablar() { return "Guau!"; }
}

public class Gato extends Animal {
    @Override
    public String hablar() { return "Miau!"; }
}

public class Loro extends Animal {
    @Override
    public String hablar() { return "¡Hola, hola!"; }
}
```

**Demostración:**
```java
Animal a1 = new Perro("Fido", 2);
Animal a2 = new Gato("Mishi", 3);
System.out.println(a1.hablar()); // Guau!
System.out.println(a2.hablar()); // Miau!
```
> Aunque la **referencia** es `Animal`, Java invoca la versión **sobrescrita** según el **objeto real** (`Perro`, `Gato`, etc.).

**Reto (5 min):** sobrescribe también `presentacion()` en cada hija para personalizar el texto.

---

## 6) **Composición** (sin colecciones)
Una clase puede **contener** otras como **campos**. Sin listas: usa **dos campos**.

```java
public class ClinicaVeterinaria {
    private String nombre;
    private Animal animalA; // "tiene un" Animal
    private Animal animalB; // "tiene otro" Animal

    public ClinicaVeterinaria(String nombre) { this.nombre = nombre; }

    // getters/setters
}
```

**En `App` (ejemplo):**
```java
Animal a1 = new Perro("Fido", 2);
Animal a2 = new Gato("Mishi", 3);

ClinicaVeterinaria clinica = new ClinicaVeterinaria("Clínica Animalitos");
clinica.setAnimalA(a1);
clinica.setAnimalB(a2);

System.out.println(clinica.getAnimalA().presentacion());
System.out.println(clinica.getAnimalB().presentacion());
```

---

## 7) Buenas prácticas y errores comunes
**Buenas prácticas**
- Atributos `private`; expón solo lo necesario con getters/setters.
- Valida datos en `setters` **o** en constructores.
- Métodos cortos y con nombres claros.
- Usa `@Override` siempre que sobrescribas.

**Errores frecuentes**
- Poner atributos `public` y perder control de cambios.
- Olvidar llamar a `super(...)` en el constructor de la hija que necesita inicializar el padre.
- Sobrescribir un método pero **cambiar la firma** (eso ya no es override, es **sobrecarga**).
- Dejar el objeto en estado inválido (ej. edades negativas).

---

## 8) Retos guiados (15–30 min)
1) **Validador de nombres:** en `Animal.setNombre`, no permitas `null`/vacío.
2) **Especialización:** agrega a `Perro` un método `traerPelota()` y a `Gato` `arunar()`. En `App` llámalos **cast** seguro si es necesario.
3) **Presentación enriquecida:** personaliza `presentacion()` en `Perro/Gato/Loro` (incluye especie en el texto).
4) **Clínica robusta:** en `ClinicaVeterinaria`, evita asignar el **mismo** objeto en `animalA` y `animalB` (si es el mismo, lánzalo con `IllegalArgumentException`).

---

## 9) Cómo ejecutar el proyecto
Requisitos: **Java 17** y **Maven** instalados.
```bash
mvn -q -DskipTests package
mvn -q exec:java
```
EN IntelliJ ejecuta `App`.

---

## 10) Glosario rápido
- **Clase**: plantilla para crear objetos (define atributos y métodos).
- **Objeto**: instancia concreta de una clase.
- **Atributo**: dato almacenado dentro del objeto.
- **Método**: acción que puede hacer el objeto.
- **Encapsulación**: proteger datos (`private`) y exponer acceso controlado.
- **Constructor**: método especial que inicializa el objeto (sin tipo de retorno).
- **Herencia**: relación “es‑un” (`Perro` **es un** `Animal`).
- **Sobrescritura**: redefinir en la hija el comportamiento de un método del padre.
- **Polimorfismo**: un mismo mensaje (método) produce distintas respuestas según el objeto.

---

## 11) Checklist de autoevaluación
- [ ] Puedo explicar la diferencia entre **clase** y **objeto** con un ejemplo.
- [ ] Mis atributos son `private` y uso getters/setters.
- [ ] Mis setters/constructores **validan** datos.
- [ ] Creé al menos **un** constructor vacío y **uno** con parámetros.
- [ ] Usé `extends` para heredar y `super(...)` para inicializar al padre.
- [ ] Implementé **sobrescritura** y demostré **polimorfismo** con `hablar()` o `presentacion()`.
- [ ] Usé **composición** sin colecciones (`animalA`, `animalB`).
- [ ] Mi código compila y la salida por consola tiene sentido.

---

## 12) Preguntas de repaso (sin respuestas)
1) ¿Por qué es recomendable que los atributos sean `private`?
2) ¿Qué diferencia hay entre **sobrecarga** y **sobrescritura**?
3) ¿Qué hace `super(...)` y cuándo debes llamarlo?
4) ¿Cómo demostrarías polimorfismo con `Animal` y `Perro`?
5) ¿Qué riesgos hay si no validas en setters o constructores?

> Intenta **responder en voz alta** o escribir tus respuestas antes de mirar el código.

---

## 13) Siguientes pasos (cuando estés listo)
- Introducir **arrays** y luego **listas** (`ArrayList`) para manejar **muchos** objetos.
- Agregar **interfaces** (por ejemplo, `Hablador`) y **clases abstractas**.
- Escribir **pruebas unitarias** (JUnit) para validar comportamiento.

---

### Créditos
Este proyecto de práctica fue construido para enfocarse en lo esencial de POO sin distracciones.
