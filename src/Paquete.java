public class Paquete {
    private String codigo;
    private String destino;
    private double peso;

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
    }

    public String getCodigo() { return codigo; }
    public String getDestino() { return destino; }
    public double getPeso() { return peso; }

    // Bug intencional para el hotfix: muestra codigo en lugar de destino
    public String getInfo() {
        return "Paquete [" + codigo + "] - Destino: " + codigo + " - Peso: " + peso + " kg";
    }
}
