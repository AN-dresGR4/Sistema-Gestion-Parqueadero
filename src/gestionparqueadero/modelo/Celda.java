package gestionparqueadero.modelo;

public class Celda {
    private int idCelda;
    private String numeroCelda;
    private int idTipo;
    private String estado;

    public Celda() {}

    public Celda(int idCelda, String numeroCelda, int idTipo, String estado) {
        this.idCelda = idCelda;
        this.numeroCelda = numeroCelda;
        this.idTipo = idTipo;
        this.estado = estado;
    }

    public int getIdCelda() { return idCelda; }
    public void setIdCelda(int idCelda) { this.idCelda = idCelda; }

    public String getNumeroCelda() { return numeroCelda; }
    public void setNumeroCelda(String numeroCelda) { this.numeroCelda = numeroCelda; }

    public int getIdTipo() { return idTipo; }
    public void setIdTipo(int idTipo) { this.idTipo = idTipo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Celda: " + "idCelda=" + idCelda + ", numeroCelda='" + numeroCelda + ", idTipo=" + idTipo + ", estado='" + estado + '}';
    }
}
