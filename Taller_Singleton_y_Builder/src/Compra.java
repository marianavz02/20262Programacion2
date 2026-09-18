import java.util.List;

public class Compra {
    private final String cliente;
    private final String funcion;
    private final List<String> asientos;
    private final String combo;
    private final int puntosRedimidos;

    private Compra(Builder b) {
        this.cliente = b.cliente;
        this.funcion = b.funcion;
        this.asientos = b.asientos;
        this.combo = b.combo;
        this.puntosRedimidos = b.puntosRedimidos;
    }

    public static class Builder {
        private String cliente;
        private String funcion;
        private List<String> asientos;
        private String combo;
        private int puntosRedimidos = 0;

        public Builder conCliente(String cliente) {
            this.cliente = cliente;
            return this; // Retorna this para permitir la interfaz fluida (method chaining)
        }

        public Builder conFuncion(String funcion) {
            this.funcion = funcion;
            return this;
        }

        public Builder conAsientos(List<String> asientos) {
            this.asientos = asientos;
            return this;
        }

        public Builder conCombo(String combo) {
            this.combo = combo;
            return this;
        }

        public Builder conPuntos(int puntos) {
            this.puntosRedimidos = puntos;
            return this;
        }

        public Compra build() {
            // VALIDACIÓN 1: Cliente y función son obligatorios
            if (cliente == null || cliente.isBlank() || funcion == null || funcion.isBlank()) {
                throw new IllegalStateException("El cliente y la función son obligatorios.");
            }
            // VALIDACIÓN 2: Debe tener al menos un asiento seleccionado
            if (asientos == null || asientos.isEmpty()) {
                throw new IllegalStateException("La compra debe incluir al menos un asiento.");
            }
            return new Compra(this);
        }
    }
}