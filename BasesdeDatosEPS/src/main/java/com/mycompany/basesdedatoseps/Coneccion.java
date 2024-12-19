package com.mycompany.basesdedatoseps;

import Clases.Cotizante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Coneccion {
    Connection conn = null;
    String url = "jdbc:postgresql://localhost/EPS";
    String usuario = "postgres";
    String clave = "2459";
    
    
    public void conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url,usuario,clave);
            JOptionPane.showMessageDialog(null, "conexion exitosa","conexion",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "conexion fallida"+e,"conexion",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public boolean validarCredencialesCotizantes(String di, String telefono) {
    boolean esValido = false;
    String sql = "SELECT * FROM Afiliados a " +
                 "JOIN Cotizante c ON a.ID = c.ID_Cotizante " +
                 "WHERE a.ID = ? AND a.Telefono = ?";

    try {
        if (conn == null || conn.isClosed()) {
            conectar();
        }

        // Si a.ID es INTEGER, usa setInt
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            // Si a.ID es INTEGER, usa setInt
            pst.setInt(1, Integer.parseInt(di)); // Convierte di a entero
            pst.setString(2, telefono);         // Telefono sigue siendo String
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                esValido = true; // Las credenciales son válidas si se encuentra un resultado
            }
            
            rs.close();
        } // Convierte di a entero
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "El DI debe ser un número: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al validar credenciales: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    return esValido;
}
    
    
    public Cotizante obtenerDatosCotizante(String di, String telefono) {
        Cotizante cotizante = null;
        String sql = "SELECT a.ID, a.Tipo_ID, a.Apellidos, a.Nombres, a.Fecha_nacimiento, a.Genero, " +
                     "a.Direccion, a.Ciudad_Residencia, a.Telefono, a.Estado_Civil, a.Correo_electronico, " +
                     "a.Fecha_primera_afiliacion, a.Estado, a.salario, a.rango_salarial,  " +
                     "FROM Afiliados a " +
                     "JOIN Cotizante c ON a.ID = c.ID_Cotizante " +
                     "WHERE a.ID = ? AND a.Telefono = ?";

        try {
            conectar();
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, Integer.parseInt(di));
                pst.setString(2, telefono);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        cotizante = new Cotizante(
                            rs.getInt("ID"),                           // int id
                            rs.getString("Tipo_ID"),                   // String tipoID
                            rs.getString("Apellidos"),                 // String apellidos
                            rs.getString("Nombres"),                   // String nombres
                            rs.getDate("Fecha_nacimiento"),           // Date fechaNacimiento
                            rs.getString("Genero"),                   // String genero
                            rs.getString("Direccion"),                // String direccion
                            rs.getString("Ciudad_Residencia"),        // String ciudadResidencia
                            rs.getString("Telefono"),                 // String telefono
                            rs.getString("Estado_Civil"),             // String estadoCivil
                            rs.getString("Correo_electronico"),       // String correoElectronico
                            rs.getDate("Fecha_primera_afiliacion"),   // Date fechaPrimeraAfiliacion
                            rs.getString("Estado"),                   // String estado
                            rs.getDouble("salario"),                  // double salario (corregido de iogetDouble)
                            rs.getString("rango_salarial")            // String rangoSalarial
                            
                        );
                    }
                }

                if (cotizante != null) {
                    obtenerBeneficiarios(cotizante);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al obtener datos: " + e.getMessage());
            e.printStackTrace(); // Agregado para mejor diagnóstico
    }

    return cotizante;
}

    // Método para obtener los beneficiarios del cotizante
    private void obtenerBeneficiarios(Cotizante cotizante) {
        String sql = "SELECT b.Parentesco, b.ID_Beneficiario FROM Beneficiario b " +
                     "WHERE b.ID_cotizante = ?";
        try {
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, cotizante.getId());

                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        cotizante.addBeneficiario(rs.getInt("ID_Beneficiario"), rs.getString("Parentesco"));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener beneficiarios: " + e.getMessage());
        }
    }


    
    public void cerrar(){
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "desconexion exitosa","desconexion",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "desconexion fallida"+e,"desconexion",JOptionPane.ERROR_MESSAGE);
        }
    }
}
