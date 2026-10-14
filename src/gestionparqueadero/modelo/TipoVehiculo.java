package gestionparqueadero.modelo;

public class TipoVehiculo {
    private int idTipo;
    private String nombreTipo;
    private double tarifaPorHora;

    public TipoVehiculo() {}

    public TipoVehiculo(int idTipo, String nombreTipo, double tarifaPorHora) {
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
        this.tarifaPorHora = tarifaPorHora;
    }

    public int getIdTipo() { return idTipo; }
    public void setIdTipo(int idTipo) { this.idTipo = idTipo; }

    public String getNombreTipo() { return nombreTipo; }
    public void setNombreTipo(String nombreTipo) { this.nombreTipo = nombreTipo; }

    public double getTarifaPorHora() { return tarifaPorHora; }
    public void setTarifaPorHora(double tarifaPorHora) { this.tarifaPorHora = tarifaPorHora; }

    @Override
    public String toString() {
        return "TipoVehiculo: " + "idTipo=" + idTipo + ", nombreTipo='" + nombreTipo + ", tarifaPorHora=" + tarifaPorHora + '}';
    }
}
