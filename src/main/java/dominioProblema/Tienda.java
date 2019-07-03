package dominioProblema;

import manejoArchivos.GestorArchivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class Tienda {
    private Persona persona;
    private ArrayList<Producto> productos = new ArrayList<Producto>();

    /**
     * Inicia la clase persona solicitada en el inicio de sesión, para lo cual esta se elige desde un texto.
     * @param usuario usado para ingresar a la aplicación es de tipo String.
     * @throws IOException
     * @return void
     */
    public void iniciarPersona(String usuario)throws  IOException{
        GestorArchivos gestor = new GestorArchivos();
            String[] datosPersona = gestor.extraerDatosPersona(usuario, gestor.obtenerLineas("src\\main\\java\\archivos\\PersonasAplicacion.txt"));
            String nombre = datosPersona[2];
            boolean alumno = false;
            if (datosPersona[3].equals("alumno")) {
                alumno = true;
            }
            String rut = datosPersona[0];
            String[] datosCuentas = gestor.extraerDatosCuenta(usuario, gestor.obtenerLineas("src\\main\\java\\archivos\\Cuentas.txt"));
            ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
            cuentas.add(new Cuenta(datosCuentas[0], datosCuentas[1], Double.parseDouble(datosCuentas[2]), datosCuentas[3]));
            if (datosCuentas.length > 4) {
                cuentas.add(new Cuenta(datosCuentas[4], datosCuentas[5], Double.parseDouble(datosCuentas[6]), datosCuentas[7]));
            }
            persona = new Persona(nombre, alumno, rut, cuentas);
    }

    /**
     * Inicia todos los productos que se encuentran en los textos de alimentos.
     *
     * @throws IOException
     * @return void
     */
    public void iniciarProductos() throws IOException {
        GestorArchivos gestor = new GestorArchivos();
        ArrayList<String[]> datosProductos = gestor.obtenerLineas("src\\main\\java\\archivos\\Alimentos.txt");
        for (int i = 0; i < datosProductos.size(); i++) {
            productos.add(new Producto(datosProductos.get(i)[0], Double.parseDouble(datosProductos.get(i)[1])));
        }
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DAY_OF_WEEK);
        String diaReal = "("+(dia-1)+")";
        String[] almuerzosDelDia = gestor.extraerAlmuerzoDelDia(diaReal, "src\\main\\java\\archivos\\Almuerzos.txt");
        productos.add(new Producto(almuerzosDelDia[0], Double.parseDouble(almuerzosDelDia[1])));
        productos.add(new Producto(almuerzosDelDia[2], Double.parseDouble(almuerzosDelDia[3])));
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    /**
     * Valida una entrada de usuario compuesta por nombre de usuario y contraseña.
     * @param usuario ingresado en el inicio de sesión.
     * @param clave ingresada en el inicio de sesión.
     * @return confirmación de si existe o no el usuario que se ingresó.
     * @throws IOException
     */
    public boolean autentificarIdentidad(String usuario, String clave)throws  IOException {
        GestorArchivos gestor = new GestorArchivos();
        return gestor.autorizarAcceso(usuario, clave,"src\\main\\java\\archivos\\PersonasAplicacion.txt");
    }

    /**
     * Devuelve los atributos de los productos en múltiples arreglos de String.
     * @return Múltiples arreglos de String.
     */
    public ArrayList<String[]> devolverProductos(){
        ArrayList<String[]> mensajes = new ArrayList<String[]>();
        for (int i = 0; i < productos.size(); i++){
            mensajes.add(productos.get(i).toString().split(","));
        }
        return mensajes;
    }

    /**
     * Devuelve los datos de las cuentas de la persona ingresada.
     * @return Arraglo de String con las datos de las cuentas.
     */
    public String[] devolverCuentas(){
        String lineaCompleta="";
        for (int i = 0; i < persona.getCuentas().size(); i++) {
            if(i == 0){
                lineaCompleta= lineaCompleta +persona.getCuentas().get(i).toString()+",";
            }
            else {
                lineaCompleta = lineaCompleta + persona.getCuentas().get(i).toString();
            }
        }
        System.out.println(lineaCompleta);
        return lineaCompleta.split(",");
    }

    /**
     * Devuelve los datos de la cuenta ingresada existosamente en un arreglo de String.
     * @return Arraglo de String con las datos de la cuenta.
     */
    public String[] devolverPersona(){
        ArrayList<String[]> mensajes = new ArrayList<String[]>();
            return persona.toString().split(",");
    }

    /**
     * Devuelve el nombre del día de la semana en el que nos encontramos.
     * @return Nombre día de la semana.
     */
    public String devolverDia(){
        Calendar c = Calendar.getInstance();
        String valor_dia = "";
        int diaSemana = c.get(Calendar.DAY_OF_WEEK);
        if (diaSemana == 1) {
            valor_dia = "Domingo";
        } else if (diaSemana == 2) {
            valor_dia = "Lunes";
        } else if (diaSemana == 3) {
            valor_dia = "Martes";
        } else if (diaSemana == 4) {
            valor_dia = "Miercoles";
        } else if (diaSemana == 5) {
            valor_dia = "Jueves";
        } else if (diaSemana == 6) {
            valor_dia = "Viernes";
        } else if (diaSemana == 7) {
            valor_dia = "Sabado";
        }
        return valor_dia;
    }

    /**
     * Devuelve la información de cada uno de los alimentos en múltiples arreglos de String.
     * @return Múltiples arreglos de String.
     */
    public ArrayList<String[]> devolverInformacionAlimentos()throws  IOException{
        GestorArchivos gestor = new GestorArchivos();
        return gestor.obtenerLineas("src\\main\\java\\archivos\\informacionAlimentos.txt");
    }

    /**
     * Agrega a una persona a la base de datos de usuarios después de un registro exitoso
     * @param rut de la persona.
     * @param clave de la persona.
     * @param nombre de la persona.
     * @throws IOException
     * @return void.
     */
    public void agregarPersona(String rut, String clave, String nombre)throws  IOException{
        GestorArchivos gestor = new GestorArchivos();
        String linea = rut+";"+clave+";"+nombre+";nada";
        gestor.agregarLineaTexto(linea, "src\\main\\java\\archivos\\PersonasAplicacion.txt");
    }

    /**
     * Verifica si cierto rut se encuentra en la base de datos de usuarios.
     * @param rut de la persona tratando de registrarse.
     * @return Confirmación de la existencia del usuario.
     * @throws IOException
     */
    public boolean vereficarRegistro(String rut)throws  IOException{
        GestorArchivos gestor = new GestorArchivos();
        return gestor.vereficarExistenciaRut("src\\main\\java\\archivos\\PersonasAplicacion.txt",rut);
    }

    /**
     * Calcula del nuevo saldo resultante si se plantea comprar un nuevo producto.
     * @param precios en arreglo de String de todos los productos a comprar.
     * @param datosCuenta en arreglo de String los datos de las cuentas del usuario.
     * @param tipoPago Tipo de pago del usuario relativo al tipo de cuenta que va a usar.
     * @return
     */
    public String calcularTotal(String [] precios, String[] datosCuenta,int tipoPago){
        Double precioTotal = 0.0;
        for (int i = 0; i < precios.length; i++){
            precioTotal = precioTotal + Double.parseDouble(precios[i]);
        }
        Double nuevoSaldo;
        if(tipoPago == 1 && datosCuenta.length > 4 || tipoPago == 1 && datosCuenta.length == 4 || tipoPago == 2 && datosCuenta.length == 4){
            nuevoSaldo = Double.parseDouble(datosCuenta[2]) - precioTotal;
        }
        else if (tipoPago == 2 && datosCuenta.length > 4){
            nuevoSaldo = Double.parseDouble(datosCuenta[6]) - precioTotal;
        }
        else{
            nuevoSaldo = 0.0;
        }
        return Double.toString(nuevoSaldo);
    }


    /**
     * Realizar la compra de un producto editando el saldo del texto de cuentas.
     * @param nuevoSaldo Nuevo saldo esperado después de la compra.
     * @param datosCuenta en arreglo de String los datos de las cuentas del usuario.
     * @param tipoPago Tipo de pago del usuario relativo al tipo de cuenta que va a usar.
     * @throws IOException
     */
    public void comprarObjeto(String nuevoSaldo, String[] datosCuenta, int tipoPago)throws IOException{
        GestorArchivos gestor = new GestorArchivos();
        if(tipoPago == 1 && datosCuenta.length > 4 || tipoPago == 1 && datosCuenta.length == 4 || tipoPago == 2 && datosCuenta.length == 4){
            datosCuenta[2] = nuevoSaldo;
        }
        else if (tipoPago == 2 && datosCuenta.length > 4){
            datosCuenta[6] = nuevoSaldo;
        }
        String ubicacionTexto = "src\\main\\java\\archivos\\Cuentas.txt";
        String mensaje = gestor.leerArchivo(ubicacionTexto);
        gestor.escribirArchivo(ubicacionTexto,gestor.cambiarLinea(mensaje,ordenarCuentas(datosCuenta)));
    }

    /**
     * Ordena los datos de una cuenta en arreglo de String en una sola linea.
     * @param datosCuenta arreglo de String a ordenar.
     * @return Línea ya ordenada.
     */
    public String ordenarCuentas(String[] datosCuenta){
        String lineaFinal="";
        for (int i = 0; i < datosCuenta.length; i++){
            if(i < datosCuenta.length-1) {
                lineaFinal = lineaFinal + datosCuenta[i] + ";";
            }
            else{
                lineaFinal = lineaFinal + datosCuenta[i];
            }
        }
        return lineaFinal;
    }

    /**
     * Devuelve la clave correcta en una transacción según el tipo de pago y la cantidad de cuentas.
     * @param datosCuenta Los datos que representan la cantidad de cuentas.
     * @param tipoPago Tipo de pago a efectuar.
     * @return Clave correcta a pedir.
     */
    public String devolverPosicionClave(String[] datosCuenta, int tipoPago){
        if(tipoPago == 1 && datosCuenta.length > 4 || tipoPago == 1 && datosCuenta.length == 4 || tipoPago == 2 && datosCuenta.length == 4){
            return datosCuenta[3];
        }
        else if (tipoPago == 2 && datosCuenta.length > 4){
            return  datosCuenta[7];
        }
        else{
            return null;
        }
    }
}
