/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Principal extends JFrame implements ActionListener{

    private JButton boton_atras;
    private JButton boton_siguiente;
    private JButton boton_agregar;
    private JButton boton_informacion;
    private JLabel nombreProducto;
    private JLabel precioProducto;
    private JLabel tipoProducto;
    private JLabel diaSemanal;
    private JLabel imagen;
    private JButton boton_inicio;
    private JButton boton_cuenta;
    private JButton boton_carrito;
    private JLabel imagenProducto;
    private JPanel panelSuperior;
    private JPanel panelCentral;
    private Font fuente;
    private int contadorCarrito;
    private int contadorPerfil;
    private CarritoCompras carritoGuardado;
    private Perfil perfilGuardado;
    private String[] datosPersona;
    private String  dia_semanal;
    String[] datosCuenta;
    private ArrayList<String[]> datosProductos;
    private ArrayList<String[]> informacionAlimentos;
    private int posicionActual;
    private ArrayList<String[]> productosComprados = new ArrayList<String[]>();
    private ArrayList<String[]> informacionProductosComprados = new ArrayList<String[]>();
    
    public Principal(String[] datosPersona, String[] datosCuenta, ArrayList<String[]> datosProductos, String dia_semanal,ArrayList<String[]> informacionAlimentos){
        super();
        iniciarVentana();
        this.datosPersona=datosPersona;
        this.datosCuenta = datosCuenta;
        this.datosProductos = datosProductos;
        this.dia_semanal = dia_semanal;
        this.informacionAlimentos = informacionAlimentos;
        iniciarPanelSuperior();
        iniciarPanelCentral();
        iniciarComponentes();
    }
    
    private void iniciarVentana() {
        this.setTitle("Selecciona tus productos");
        this.setSize(500, 470);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true);
        this.getContentPane().setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        posicionActual = 0;
    }

    private void iniciarPanelSuperior(){
        panelSuperior = new JPanel();
        panelSuperior.setLayout(null);
        panelSuperior.setBackground(Color.DARK_GRAY);
        panelSuperior.setBounds(0, 0, this.getWidth(), 66);
        boton_inicio = new JButton();
        boton_inicio.setBounds(0, 0, 70, panelSuperior.getHeight());
        asignarImagenBotones(boton_inicio, "src\\main\\java\\archivos\\imagenesPrincipal\\boton_inicio.png");
        boton_inicio.setBorder(null);
        boton_inicio.addActionListener(this);
        panelSuperior.add(boton_inicio);
        boton_cuenta = new JButton();
        boton_cuenta.setBounds(411, 0, 72, panelSuperior.getHeight());
        asignarImagenBotones(boton_cuenta, "src\\main\\java\\archivos\\imagenesPrincipal\\boton_cuenta.png");
        boton_cuenta.setBorder(null);
        boton_cuenta.addActionListener(this);
        panelSuperior.add(boton_cuenta);
        boton_carrito = new JButton();
        boton_carrito.setBounds(350, 0, 63, panelSuperior.getHeight());
        asignarImagenBotones(boton_carrito, "src\\main\\java\\archivos\\imagenesPrincipal\\boton_carrito.png");
        boton_carrito.setBorder(null);
        boton_carrito.addActionListener(this);
        panelSuperior.add(boton_carrito);
        this.add(panelSuperior);
        contadorCarrito = 0;
        contadorPerfil = 0;
    }

    private void iniciarPanelCentral(){
        fuente = new Font("Calibri", 3, 24);
        panelCentral = new JPanel();
        panelCentral.setLayout(null);
        panelCentral.setBackground(Color.LIGHT_GRAY);
        panelCentral.setBounds(0, 150, this.getWidth(), 180);
        imagenProducto = new JLabel();
        imagenProducto.setBounds(panelCentral.getX()+100, panelCentral.getY()-130, 193, panelCentral.getHeight()-40);
        asignarImagenEtiqueta(imagenProducto, "src\\main\\java\\archivos\\imagenesProductos\\"+datosProductos.get(posicionActual)[0]+".png");
        panelCentral.add(imagenProducto);
        this.add(panelCentral);
    }

    private void iniciarComponentes(){
        boton_atras = new JButton();
        boton_atras.setBounds(30, 68, 111, 41);
        asignarImagenBotones(boton_atras, "src\\main\\java\\archivos\\imagenesPrincipal\\flecha_atras.png");
        boton_atras.setBorder(null);
        boton_atras.addActionListener(this);
        this.add(boton_atras);
        boton_siguiente = new JButton();
        boton_siguiente.setBounds(350, 68, 117, 41);
        asignarImagenBotones(boton_siguiente, "src\\main\\java\\archivos\\imagenesPrincipal\\flecha_adelante.png");
        boton_siguiente.setBorder(null);
        boton_siguiente.addActionListener(this);
        this.add(boton_siguiente);
        tipoProducto = new JLabel(informacionAlimentos.get(posicionActual)[0]);
        tipoProducto.setFont(new Font("Calibri", 3, 15));
        tipoProducto.setBounds(100, 107, 150, 20);
        this.add(tipoProducto);
        precioProducto = new JLabel("$"+datosProductos.get(posicionActual)[1]);
        precioProducto.setFont(new Font("Calibri", 3, 25));
        precioProducto.setForeground(Color.LIGHT_GRAY);
        precioProducto.setBounds(100, 128, 100, 20);
        this.add(precioProducto);
        diaSemanal = new JLabel(dia_semanal);
        diaSemanal.setFont(new Font("Calibri", 3, 23));
        diaSemanal.setBounds(340, 100, 100, 50);
        this.add(diaSemanal);
        imagen = new JLabel();
        imagen.setBounds(0, 105, 74, 45);
        asignarImagenEtiqueta(imagen,"src\\main\\java\\archivos\\imagenesPrincipal\\servicios.png");
        this.add(imagen);
        nombreProducto = new JLabel(datosProductos.get(posicionActual)[0]);
        nombreProducto.setBounds(30, 335, 300, 40);
        nombreProducto.setFont(new Font("Calibri",3,30));
        this.add(nombreProducto);
        boton_agregar = new JButton("Agregar");
        boton_agregar.setBounds(30, 380, 150, 30);
        boton_agregar.setBackground(Color.GREEN);
        boton_agregar.setFont(new Font("Calibri",3,23));
        boton_agregar.addActionListener(this);
        this.add(boton_agregar);
        boton_informacion = new JButton("Información");
        boton_informacion.setBounds(200, 380, 150, 30);
        boton_informacion.setBackground(Color.GREEN);
        boton_informacion.setFont(new Font("Calibri",3,23));
        boton_informacion.addActionListener(this);
        this.add(boton_informacion);
    }

    /**
     * Le asigna una imagen a un botón.
     * @param boton
     * @param ubicacionImagen
     */
    private void asignarImagenBotones(JButton boton, String ubicacionImagen){
        Image img = new ImageIcon(ubicacionImagen).getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH));
        boton.setIcon(img2);
    }

    /**
     * Cambia el producto que se está mostrando
     * @param cambio valor de cambio que puede ser negativo o positivo.
     */
    private void cambiarProductoActual(int cambio){
        if(posicionActual == 0 && cambio == -1){
            posicionActual = datosProductos.size()-1;
        }
        else if (posicionActual == datosProductos.size()-1 && cambio == 1){
            posicionActual = 0;
        }
        else{
            posicionActual = posicionActual + cambio;
        }
        nombreProducto.setText(datosProductos.get(posicionActual)[0]);
        precioProducto.setText("$"+datosProductos.get(posicionActual)[1]);
        tipoProducto.setText(informacionAlimentos.get(posicionActual)[0]);
        asignarImagenEtiqueta(imagenProducto, "src\\main\\java\\archivos\\imagenesProductos\\"+datosProductos.get(posicionActual)[0]+".png");
    }

    /**
     * Le asigna una imagen a una etiqueta.
     * @param etiqueta
     * @param ubicacionImagen
     */
    private void asignarImagenEtiqueta(JLabel etiqueta, String ubicacionImagen){
        Image img = new ImageIcon(ubicacionImagen).getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(etiqueta.getWidth(), etiqueta.getHeight(), Image.SCALE_SMOOTH));
        etiqueta.setIcon(img2);
    }

    /**
     * Muestra la información del producto actual.
     */
    private void mostrarInformacion(){
        JOptionPane.showMessageDialog(this,"Características:\n"+informacionAlimentos.get(posicionActual)[1]+"\n"+informacionAlimentos.get(posicionActual)[2]+"\n"+informacionAlimentos.get(posicionActual)[3]);
    }

    /**
     * Agrega un producto para comprar desde el los productos disponibles.
     */
    public void agregarProducto(){
        productosComprados.add(datosProductos.get(posicionActual));
        informacionProductosComprados.add(informacionAlimentos.get(posicionActual));
        JOptionPane.showMessageDialog(this,"Producto "+datosProductos.get(posicionActual)[0]+" agregado");
    }

    public void setCarrito(CarritoCompras carritoGuardado){
        this.carritoGuardado = carritoGuardado;
    }

    public  void setPerfil(Perfil perfilGuardado){
        this.perfilGuardado = perfilGuardado;
    }

    public CarritoCompras getCarritoGuardado() {
        return carritoGuardado;
    }

    public Perfil getPerfilGuardado() {
        return perfilGuardado;
    }

    public Principal getVentana(){
        return this;
    }

    public ArrayList<String[]> getProductosComprados() {
        return productosComprados;
    }

    public ArrayList<String[]> getInformacionProductosComprados() {
        return informacionProductosComprados;
    }

    public String[] getDatosPersona() {
        return datosPersona;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == boton_carrito){
            if(contadorCarrito == 0){
                CarritoCompras carrito = new CarritoCompras(getVentana());
                carrito.setVisible(true);
            }
            else{
                carritoGuardado.setVisible(true);
                carritoGuardado.cambiarProductoActual(1);
                carritoGuardado.setInformacionProductosComprados(informacionProductosComprados);
                carritoGuardado.setProductosAgregados(productosComprados);
            }
            this.setVisible(false);
            contadorCarrito++;
        }
        else if (ae.getSource() == boton_cuenta){
            if(contadorPerfil == 0){
                Perfil perfil = new Perfil(getVentana());
                perfil.setVisible(true);
            }
            else{
                perfilGuardado.setVisible(true);
            }
            this.setVisible(false);
            contadorPerfil++;
        }
        else if (ae.getSource() == boton_inicio){

        }
        else if (ae.getSource() == boton_atras){
            cambiarProductoActual(-1);
        }
        else if (ae.getSource() == boton_siguiente){
            cambiarProductoActual(1);
        }
        else if (ae.getSource() == boton_informacion){
            mostrarInformacion();
        }
        else if (ae.getSource() == boton_agregar){
            agregarProducto();
        }
    }
}
