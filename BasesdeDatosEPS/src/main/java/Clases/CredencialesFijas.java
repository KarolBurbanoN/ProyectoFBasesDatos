/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.HashMap;
import java.util.Map;

public class CredencialesFijas {
    private static final Map<String, String> credencialesAdministrador = new HashMap<>();
    private static final Map<String, String> credencialesBanco = new HashMap<>();

    static {
        // Credenciales del Administrador
        credencialesAdministrador.put("123456", "admin123"); // DI: 123456, Contraseña: admin123

        // Credenciales del Banco
        credencialesBanco.put("654321", "banco123"); // DI: 654321, Contraseña: banco123
    }

    public static boolean validarAdministrador(String di, String contrasena) {
        return credencialesAdministrador.containsKey(di) && credencialesAdministrador.get(di).equals(contrasena);
    }

    public static boolean validarBanco(String di, String contrasena) {
        return credencialesBanco.containsKey(di) && credencialesBanco.get(di).equals(contrasena);
    }
}
