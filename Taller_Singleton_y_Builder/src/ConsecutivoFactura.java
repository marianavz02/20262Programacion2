public class ConsecutivoFactura {
    // Pieza 1 - la clase guarda su unica instancia:
    private static final ConsecutivoFactura INSTANCIA = new ConsecutivoFactura();
    private int ultimo = 0;

    // Pieza 2 - LA LINEA DEL PATRON (Constructor privado):
    private ConsecutivoFactura() {}

    // Pieza 3 - la unica puerta (es static para acceder sin instanciar la clase):
    public static ConsecutivoFactura getInstancia() {
        return INSTANCIA;
    }

    public int siguiente() {
        return ++ultimo;
    }

    
}
