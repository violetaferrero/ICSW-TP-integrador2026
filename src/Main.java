public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema de Gestion de Paqueteria");
        Paquete p1 = new Paquete("PKG-001", "Santa Fe", 2.5);
        System.out.println(p1.getInfo());
        System.out.println("Costo de envio: $" + p1.calcularCostoEnvio());
        p1.actualizarEstado("En camino");
        System.out.println("Estado actualizado: " + p1.getEstado());
    }
}