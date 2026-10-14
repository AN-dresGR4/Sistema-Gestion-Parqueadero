package gestionparqueadero.controlador;

import gestionparqueadero.dao.VehiculoDAO;
import gestionparqueadero.dao.VehiculoDAOImpl;
import gestionparqueadero.modelo.Vehiculo;
import java.util.List;

public class VehiculoControlador {
    private final VehiculoDAO vehiculoDAO;

    public VehiculoControlador() {
        this.vehiculoDAO = new VehiculoDAOImpl();
    }

    public boolean registrarVehiculo(String placa, String marca, String modelo, String color, int idCliente, int idTipo) {
        Vehiculo vehiculo = new Vehiculo(placa, marca, modelo, color, idCliente, idTipo);
        return vehiculoDAO.insertar(vehiculo);
    }

    public Vehiculo buscarVehiculo(String placa) {
        return vehiculoDAO.obtenerPorPlaca(placa);
    }

    public List<Vehiculo> listarVehiculos() {
        return vehiculoDAO.obtenerTodos();
    }

    public boolean actualizarVehiculo(String placa, String marca, String modelo, String color, int idCliente, int idTipo) {
        Vehiculo vehiculo = new Vehiculo(placa, marca, modelo, color, idCliente, idTipo);
        return vehiculoDAO.actualizar(vehiculo);
    }

    public boolean eliminarVehiculo(String placa) {
        return vehiculoDAO.eliminar(placa);
    }
}
