/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoArchivos;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Nadie
 */
public class GestorArchivos {

    /**
     * Devuelve los datos de un texto separados por un carácter.
     * @param ubicacionArchivo Ubicación texto.
     * @return Datos del texto ordenados en un conjunto de arreglos String.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public ArrayList<String[]> obtenerLineas(String ubicacionArchivo) throws FileNotFoundException, IOException {
        File f = new File(ubicacionArchivo);
        if (f.exists()) {
            ArrayList<String[]> lineas = new ArrayList<String[]>();
            String linea;
            FileReader fr = new FileReader(ubicacionArchivo);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            while ((linea = br.readLine()) != null) {
                lineas.add(linea.split(";"));
            }
            br.close();
            return lineas;
        } else {
            return null;
        }
    }

    /**
     * Verifica si las credenciales ingresadas corresponden a algún usuario en el texto.
     * @param usuario
     * @param clave
     * @param ubicacionArchivo
     * @return boolean que confirma la existencia del usuario.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public boolean autorizarAcceso(String usuario, String clave, String ubicacionArchivo) throws FileNotFoundException, IOException {
        File f = new File(ubicacionArchivo);
        if (f.exists()) {
            String linea;
            FileReader fr = new FileReader(ubicacionArchivo);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                if (linea.split(";")[0].equals(usuario) && linea.split(";")[1].equals(clave)) {
                    return true;
                }
            }
            br.close();
            return false;
        } else {
            return false;
        }
    }

    /**
     * Devuelve el arreglo de String de datos perteneciente al usuario ingresado.
     * @param usuario
     * @param personas datos de personas.
     * @return Arreglo de String
     */
    public String[] extraerDatosPersona(String usuario, ArrayList<String[]> personas) {
        for (int i = 0; i < personas.size(); i++) {
            if (usuario.equals(personas.get(i)[0])) {
                return personas.get(i);
            }
        }
        return null;
    }

    /**
     * Extrae los datos de las cuentas asociadas a un usuario
     * @param usuario
     * @param cuentas datos de las cuentas.
     * @return arreglo con datos pertenecientes al usuario.
     */
    public String[] extraerDatosCuenta(String usuario, ArrayList<String[]> cuentas) {
        for (int i = 0; i < cuentas.size(); i++) {
            if (usuario.equals(cuentas.get(i)[0])) {
                return cuentas.get(i);
            }
        }
        return null;
    }

    /**
     * Devuelve los datos del almuerzo correspondiente al día indicado.
     * @param dia
     * @param ubicacionArchivo
     * @return datos del almuerzo.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String[] extraerAlmuerzoDelDia(String dia, String ubicacionArchivo) throws FileNotFoundException, IOException {
        File f = new File(ubicacionArchivo);
        if (f.exists()) {
            String linea;
            FileReader fr = new FileReader(ubicacionArchivo);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            while ((linea = br.readLine()) != null) {
                if (linea.contains(dia)) {
                    return linea.split(";");
                }
            }
        }
        return null;
    }

    /**
     * Agrega una línea al final de un texto ingresado por parámetros.
     * @param textoParaEscribir
     * @param ubicacionArchivo
     * @throws IOException
     */
    public void agregarLineaTexto(String textoParaEscribir,String ubicacionArchivo) throws IOException{
        File f = new File(ubicacionArchivo);
        if(f.exists()){
            FileWriter fw = new FileWriter(ubicacionArchivo, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println();
            pw.print(textoParaEscribir);
            pw.close();
            fw.close();
        }
    }

    /**
     * Verifica si un rut existe en un archivo que contenga dicha información.
     * @param ubicacionArchivo
     * @param rut
     * @return Confirmación de la existencia del rut.
     * @throws IOException
     */
    public boolean vereficarExistenciaRut(String ubicacionArchivo, String rut)throws IOException{
        File f = new File(ubicacionArchivo);
        if (f.exists()) {
            String linea;
            FileReader fr = new FileReader(ubicacionArchivo);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                if (linea.split(";")[0].equals(rut)) {
                    return true;
                }
            }
            br.close();
            return false;
        } else {
            return false;
        }
    }

    /**
     * Devuelve todo el contenido de un texto.
     * @param ubicacionTexto
     * @return String con contenido del texto.
     * @throws IOException
     */
    public String leerArchivo(String ubicacionTexto)throws IOException{
        File f = new File(ubicacionTexto);
        if (f.exists()) {
            String linea;
            String lineaResultante = "";
            FileReader fr = new FileReader(ubicacionTexto);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            while ((linea = br.readLine()) != null) {
                lineaResultante = lineaResultante+linea+"\n";
            }
            br.close();
            return lineaResultante;
        } else {
            return null;
        }
    }

    /**
     * Cambia cierta línea perteneciente al contenido de un texto por otra.
     * @param texto
     * @param linea
     * @return contenido del texto con línea cambiada.
     */
    public String cambiarLinea(String texto, String linea){
        String [] lineas = texto.split("\n");
        for (int i = 0; i < lineas.length; i++){
            if (linea.substring(0,9).equals(lineas[i].substring(0,9))){
                lineas[i] = linea;
            }
        }
        String lineaFinal="";
        for (int i = 0; i < lineas.length; i++){
            lineaFinal = lineaFinal+lineas[i]+"\n";
        }
        return lineaFinal;
    }

    /**
     * Reescribe el contenido de un archivo.
     * @param ubicacionTexto
     * @param texto Nuevo contenido del texto.
     * @throws IOException
     */
    public void escribirArchivo(String ubicacionTexto, String texto)throws IOException{
        File f = new File(ubicacionTexto);
        if (f.exists()) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ubicacionTexto));
            bw.write("rut;tipoCuenta;saldo;clave;tipoCuenta;saldo;clave\n"+texto);
            bw.close();
        }
    }
}
