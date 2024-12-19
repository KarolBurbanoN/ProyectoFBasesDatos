/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Karol
 */
// Clase Beneficiario (debe estar en su propio archivo Beneficiario.java)
public class Beneficiario {
    private int id;
    private String parentesco;

    public Beneficiario(int id, String parentesco) {
        this.id = id;
        this.parentesco = parentesco;
    }

    public int getId() {
        return id;
    }

    public String getParentesco() {
        return parentesco;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - Parentesco: " + parentesco;
    }
}
