package gestionparqueadero.conexion;

import java.sql.Connection;

public class PruebaConexion {
    public static void main(String[] args) {
        try (Connection conn = Conexion.getConexion()) {
            if (conn != null) {
                System.out.println("¡Conexión exitosa a la base de datos gestion_parqueadero!");
            }
        } catch (Exception e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}
