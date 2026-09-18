# Ejercicio 3 - Análisis de Patrones

### a) ¿Cuál es la limitación de Singleton frente a DIP, y cómo se resuelve?
La limitación principal es que acopla el código directamente a una clase concreta en lugar de una abstracción, rompiendo el Principio de Inversión de Dependencias (DIP) y dificultando crear pruebas unitarias. Se resuelve inyectando la instancia a través de una interfaz en lugar de llamarla directamente desde el código.

### b) ¿En cuántos lugares del proyecto debe aparecer getInstancia()? ¿Cuáles?
Debe aparecer únicamente en 1 lugar (o los mínimos indispensables), concretamente en el punto de configuración inicial del sistema (Main) para inyectar la dependencia donde se necesite, asi evitando llenar todo el código de llamadas directas.

### c) Singleton y Builder usan los dos un constructor privado. ¿Para qué sirve en cada uno?
* **Singleton:** Sirve para bloquear la creación de nuevos objetos con `new` desde afuera y garantizar que solo exista una única instancia en toda la aplicación.
* **Builder:** Sirve para obligar a que el objeto solo se pueda instanciar a través del Builder, garantizando que pase por el método `build()` con sus validaciones antes de crearse.

### d) De estas clases de su proyecto, ¿cuál llevaría Builder y cuál no? Justifiquen en una línea:
* **Compra:** Sí lleva Builder porque tiene bastantes campos, algunos obligatorios y otros opcionales, además de requerir validaciones.
* **Asiento, Función, Combo, Cliente:** No llevan Builder porque son clases sencillas con pocos atributos que se pueden manejar fácilmente con un constructor normal.

### e) ConfiguracionCine es Singleton y el Builder de Compra necesita el IVA que ella guarda. ¿El Builder debe llamar a ConfiguracionCine.getInstancia() por dentro? ¿Por qué?
No, porque acoplaría el Builder directamente al Singleton de forma rígida. Es mejor pasarle el valor del IVA como parámetro o inyectárselo para mantener las clases desacopladas y facilitar las pruebas.

---

### Reto (SOLID)
* **Llamadas modificadas:** 0 llamadas.
* **Principio SOLID:** Se cumple el **Principio Abierto/Cerrado (OCP)**, ya que se puede extender la clase `Compra` agregando un nuevo campo sin necesidad de modificar ni romper el código inicial.