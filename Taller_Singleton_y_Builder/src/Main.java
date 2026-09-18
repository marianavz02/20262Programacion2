import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("     DEMOSTRACIÓN EJERCICIO 1: SINGLETON");

        // 1. Obtener instancias mediante getInstancia()
        ConsecutivoFactura a = ConsecutivoFactura.getInstancia();
        ConsecutivoFactura b = ConsecutivoFactura.getInstancia();

        // Verificación 1: Comprobar si a == b es true
        System.out.println("¿a == b? " + (a == b) + " (Esperado: true)");

        // Verificación 2: NO compila
        //ConsecutivoFactura c = new ConsecutivoFactura(); // Error: ConsecutivoFactura() has private access

        // Verificación 3: Pedir tres números seguidos desde dos variables distintas
        System.out.println("Número desde 'a': " + a.siguiente()); // imprime 1
        System.out.println("Número desde 'b': " + b.siguiente()); // imprime 2
        System.out.println("Número desde 'a': " + a.siguiente()); // imprime 3
        System.out.println("(Esperado: 1, 2, 3)");


        System.out.println("\n    DEMOSTRACIÓN EJERCICIO 2: BUILDER");


        // 1. Crear una compra MÍNIMA (solo obligatorios) usando encadenamiento fluido
        Compra compraMinima = new Compra.Builder()
                .conCliente("Carlos Pérez")
                .conFuncion("Avatar 3 - 4:00 PM")
                .conAsientos(List.of("A1", "A2"))
                .build();

        System.out.println("Compra mínima creada con éxito.");

        // 2. Crear una compra COMPLETA (obligatorios + opcionales)
        Compra compraCompleta = new Compra.Builder()
                .conCliente("María Gómez")
                .conFuncion("Batman - 7:00 PM")
                .conAsientos(List.of("C5", "C6"))
                .conCombo("Combo Pareja 2D")
                .conPuntos(150)
                .build();

        System.out.println("Compra completa creada con éxito.");

        // 3. Probar validaciones (Debe lanzar IllegalStateException)
        System.out.println("\nPrueba de validación (intentar crear sin cliente):");
        try {
            Compra compraInvalida = new Compra.Builder()
                    .conFuncion("Batman - 7:00 PM")
                    .conAsientos(List.of("D1"))
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
    }
}