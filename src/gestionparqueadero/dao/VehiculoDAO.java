package gestionparqueadero.dao;

import gestionparqueadero.modelo.Vehiculo;
import java.util.List;

public interface VehiculoDAO {
    boolean insertar(Vehiculo vehiculo);
    Vehiculo obtenerPorPlaca(String placa);
    List<Vehiculo> obtenerTodos();
    boolean actualizar(Vehiculo vehiculo);
    boolean eliminar(String placa);
}
