/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominioProblema;

import java.util.ArrayList;

public class Persona {

    private String nombre;
    private boolean alumno;
    private String rut;
    private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();

    public Persona(String nombre, boolean alumno, String rut, ArrayList<Cuenta> cuentas) {
        this.nombre = nombre;
        this.alumno = alumno;
        this.rut = rut;
        this.cuentas = cuentas;
    }

    //Métodos getter y setter de los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAlumno() {
        return alumno;
    }

    public void setBaes(boolean alumno) {
        this.alumno = alumno;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    //Métdodo toString
    public String toString() {
        return nombre+","+alumno+","+rut;
    }
}
