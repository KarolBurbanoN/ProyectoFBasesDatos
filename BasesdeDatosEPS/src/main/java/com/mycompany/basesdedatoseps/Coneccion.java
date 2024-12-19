package com.mycompany.basesdedatoseps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    
    public void  cerrar(){
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "desconexion exitosa","desconexion",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "desconexion fallida"+e,"desconexion",JOptionPane.ERROR_MESSAGE);
        }
    }
}
