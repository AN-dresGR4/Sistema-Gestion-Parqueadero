package gestionparqueadero.modelo;

import java.sql.Timestamp;

public class RegistroParqueadero {
    private int idRegistro;
    private String placa;
    private int idCelda;
    private Timestamp fechaIngreso;
    private Timestamp fechaSalida;
    private Double totalPagar;
    private String estado;

    public RegistroParqueadero() {}

    public RegistroParqueadero(int idRegistro, String placa, int idCelda, Timestamp fechaIngreso, Timestamp fechaSalida, Double totalPagar, String estado) {
        this.idRegistro = idRegistro;
        this.placa = placa;
        this.idCelda = idCelda;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.totalPagar = totalPagar;
        this.estado = estado;
    }

    public int getIdRegistro() { return idRegistro; }
    public void setIdRegistro(int idRegistro) { this.idRegistro = idRegistro; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public int getIdCelda() { return idCelda; }
    public void setIdCelda(int idCelda) { this.idCelda = idCelda; }

    public Timestamp getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(Timestamp fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public Timestamp getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(Timestamp fechaSalida) { this.fechaSalida = fechaSalida; }

    public Double getTotalPagar() { return totalPagar; }
    public void setTotalPagar(Double totalPagar) { this.totalPagar = totalPagar; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "RegistroParqueadero :" + "idRegistro=" + idRegistro + ", placa='" + placa + ", idCelda=" + idCelda + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + ", totalPagar=" + totalPagar + ", estado='" + estado;
    }
}
