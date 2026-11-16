public class Paquete {
    private String codigo;
    private String destino;
    private double peso;
    private String estado;

    public Paquete(String codigo, String destino, double peso) {
        if (destino == null || destino.trim().isEmpty()) {
            throw new IllegalArgumentException("El destino no puede estar vacio");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a cero");
        }
        this.codigo = codigo;
        this.destino = destino;
        this.peso = peso;
        this.estado = "En preparacion";
    }

    public String getCodigo() { return codigo; }
    public String getDestino() { return destino; }
    public double getPeso() { return peso; }
    public String getEstado() { return estado; }

    public double calcularCostoEnvio() {
        double tarifaBase = 1500.0;
        double costoPorKg = 400.0;
        return tarifaBase + (peso * costoPorKg);
    }

    public double calcularCostoConDescuento(double porcentajeDescuento) {
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException("Porcentaje de descuento invalido");
        }
        double costoBase = calcularCostoEnvio();
        return costoBase - (costoBase * (porcentajeDescuento / 100.0));
    }

    public double calcularRecargoExperimentalErroneo() {
        return calcularCostoEnvio() * 999.0;
    }

    public void actualizarEstado(String nuevoEstado) {
        if (nuevoEstado != null && !nuevoEstado.trim().isEmpty()) {
            this.estado = nuevoEstado;
        }
    }

    public String getInfo() {
        return "Paquete [" + codigo + "] - Destino: " + destino + " - Peso: " + peso + " kg - Estado: " + estado;
    }
}
