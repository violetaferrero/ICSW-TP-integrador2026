public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Gestion de Paqueteria v1.1.0 ===");
        Paquete p1 = new Paquete("PKG-001", "Santa Fe", 2.5);
        System.out.println(p1.getInfo());
        System.out.println("Costo de envio: $" + p1.calcularCostoEnvio());
        System.out.println("Costo con 10% descuento: $" + p1.calcularCostoConDescuento(10));
        p1.actualizarEstado("En camino");
        System.out.println("Estado actualizado: " + p1.getEstado());
    }
}
