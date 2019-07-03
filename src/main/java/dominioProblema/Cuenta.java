/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominioProblema;

public class Cuenta {

    private double saldo;
    private String usuario;
    private String clave;
    private String tipoCuenta;

    public Cuenta(String usuario, String tipoCuenta, double saldo ,String clave) {
        this.saldo = saldo;
        this.usuario = usuario;
        this.clave = clave;
        this.tipoCuenta = tipoCuenta;
    }

    //Métodos getter y setter de los atributos

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    //Método toString
    public String toString(){
        return usuario+","+tipoCuenta+","+saldo+","+clave;
    }

}
