package gestionparqueadero.principal;

import gestionparqueadero.controlador.VehiculoControlador;
import gestionparqueadero.modelo.Vehiculo;
import java.util.List;

public class PruebaDao {
    public static void main(String[] args) {
        VehiculoControlador controlador = new VehiculoControlador();

        System.out.println("=== REGISTRANDO VEHÍCULO ===");
        boolean guardado = controlador.registrarVehiculo("ABC123", "Chevrolet", "Onix", "Blanco", 1, 1);
        System.out.println("Resultado registro: " + (guardado ? "Éxito" : "Fallo"));

        System.out.println("\n=== LISTANDO VEHÍCULOS REGISTRADOS ===");
        List<Vehiculo> lista = controlador.listarVehiculos();
        for (Vehiculo v : lista) {
            System.out.println(v);
        }

        System.out.println("\n=== BUSCANDO VEHÍCULO POR PLACA ===");
        Vehiculo vBuscado = controlador.buscarVehiculo("ABC123");
        System.out.println("Vehículo encontrado: " + vBuscado);
    }
}
