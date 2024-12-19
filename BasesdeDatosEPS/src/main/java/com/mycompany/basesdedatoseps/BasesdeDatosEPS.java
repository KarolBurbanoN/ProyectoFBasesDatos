/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.basesdedatoseps;

import com.mycompany.basesdedatoseps.IniciarSesion;
import com.mycompany.basesdedatoseps.Coneccion;

/**
 *
 * @author Karol
 */
public class BasesdeDatosEPS {

    public static void main(String[] args) {
        Coneccion coneccion = new Coneccion();
        coneccion.conectar();
        IniciarSesion iniciar = new IniciarSesion();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }
}
