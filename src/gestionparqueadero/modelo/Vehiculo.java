package gestionparqueadero.modelo;

public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private int idCliente;
    private int idTipo;

    public Vehiculo() {}

    public Vehiculo(String placa, String marca, String modelo, String color, int idCliente, int idTipo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.idCliente = idCliente;
        this.idTipo = idTipo;
    }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdTipo() { return idTipo; }
    public void setIdTipo(int idTipo) { this.idTipo = idTipo; }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + " " +
                ", marca='" + marca + " " +
                ", modelo='" + modelo + " " +
                ", color='" + color + " " +
                ", idCliente=" + idCliente +
                ", idTipo=" + idTipo +
                '}';
    }
}
