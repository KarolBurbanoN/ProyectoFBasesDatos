/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cotizante {

    public Cotizante(int aInt, String string, String string1, String string2, Date date, String string3, String string4, String string5, String string6, String string7, String string8, Date date1, String string9, double aDouble, String string10) {
    }
    private int id;
    private String tipoID;
    private String apellidos;
    private String nombres;
    private Date fechaNacimiento;
    private String genero;
    private String direccion;
    private String ciudadResidencia;
    private String telefono;
    private String estadoCivil;
    private String correoElectronico;
    private Date fechaPrimeraAfiliacion;
    private String estado;
    private double salario;
    private String rangoSalarial;
    private List<Beneficiario> beneficiarios;

    // Constructor se mantiene igual...

    // Getter corregido para coincidir con la llamada en la interfaz
    // Getters ajustados según las llamadas en tu interfaz
    public int getId() {
        return id;
    }

    public String getTipoId() {  // Cambiado para coincidir con la llamada
        return tipoID;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getGenero() {
        return genero;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getSalario() {
        return salario;
    }

    public String getRangoSalarial() {  // Cambiado para coincidir con la llamada
        return rangoSalarial;
    }

    public List<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public void addBeneficiario(int id, String parentesco) {
        beneficiarios.add(new Beneficiario(id, parentesco));
    }
}

