package interfaces;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MetodoPago extends JFrame implements ActionListener {

    private JLabel titulo;
    private JLabel subtitulo;
    private JButton baes;
    private JButton rut;
    private JLabel etiqueta_baes;
    private JLabel etiqueta_rut;
    private JButton ok;
    private JButton cancelar;
    private JButton atras;
    private int indicador;
    private CarritoCompras carrito;

    public MetodoPago(CarritoCompras carrito){
        super();
        configurarVentana();
        this.carrito = carrito;
        iniciarEtiquetas();
        configurarEtiquetas();
        iniciarBotones();
        configurarBotones();
    }

    private void configurarVentana() {
        this.setTitle("Métodos de pago");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        indicador = 0;
    }

    private void iniciarEtiquetas(){
        titulo = new JLabel("Métodos de pago");
        subtitulo = new JLabel("Ingrese su método de pago");
        baes = new JButton();
        rut = new JButton();
        etiqueta_baes = new JLabel("Baes");
        etiqueta_rut = new JLabel("Cuenta Rut");
    }

    private void configurarEtiquetas(){
        titulo.setBounds(50,20,230,50);
        titulo.setFont(new Font("Calibri",3,30));
        this.add(titulo);
        subtitulo.setBounds(50,100,330,50);
        subtitulo.setFont(new Font("Calibri",1,26));
        this.add(subtitulo);
        etiqueta_baes.setBounds(120,150,150,40);
        etiqueta_baes.setFont(new Font("Calibri",1,26));
        this.add(etiqueta_baes);
        etiqueta_rut.setBounds(120,220,150,40);
        etiqueta_rut.setFont(new Font("Calibri",1,26));
        this.add(etiqueta_rut);
    }

    private void iniciarBotones(){
        baes = new JButton();
        rut = new JButton();
        ok = new JButton("OK");
        cancelar = new JButton("CANCELAR");
        atras = new JButton();
    }

    private void configurarBotones(){
        String direccionInicial = "src\\main\\java\\archivos\\imagenesPago\\noSeleccionada.png";
        baes.setBounds(40,150,44,40);
        asignarIcono(baes,direccionInicial);
        baes.setBorder(null);
        baes.addActionListener(this);
        this.add(baes);
        rut.setBounds(40,220,44,40);
        asignarIcono(rut,direccionInicial);
        rut.setBorder(null);
        rut.addActionListener(this);
        this.add(rut);
        ok.setBounds(400,360,80,40);
        ok.setFont(new Font("Arial",3,26));
        ok.setBackground(Color.BLACK);
        ok.setForeground(Color.WHITE);
        ok.setBorder(null);
        ok.addActionListener(this);
        this.add(ok);
        cancelar.setBounds(200,360,160,40);
        cancelar.setBackground(Color.WHITE);
        cancelar.setFont(new Font("Times New Roman",3,24));
        cancelar.setBorder(null);
        cancelar.addActionListener(this);
        this.add(cancelar);
        atras.setBounds(90,360,71,49);
        asignarIcono(atras,"src\\main\\java\\archivos\\imagenesPago\\flecha_atras.png");
        atras.setBorder(null);
        atras.addActionListener(this);
        this.add(atras);
    }

    /**
     * Le asigna una imagen a un botón.
     * @param boton
     * @param ubicacionImagen
     */
    private void asignarIcono(JButton boton, String ubicacionImagen){
        Image img = new ImageIcon(ubicacionImagen).getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH));
        boton.setIcon(img2);
    }

    /**
     * Cambia la apariencia de una serie de botones dejando uno distinto a otro.
     * @param boton
     */
    private void seleccionarOpcion(JButton boton){
        String direccionInicial = "src\\main\\java\\archivos\\imagenesPago\\noSeleccionada.png";
        asignarIcono(baes,direccionInicial);
        asignarIcono(rut,direccionInicial);
        asignarIcono(boton,"src\\main\\java\\archivos\\imagenesPago\\seleccionada.png");
    }

    /**
     * Trata de continuar con la transacción después de escoger un método de pago.
     */
    private void continuar() {
        if ((carrito.getPrincipalGuardada().datosCuenta.length > 4 && indicador == 1) || (carrito.getPrincipalGuardada().datosCuenta.length > 4 && indicador == 2 ||carrito.getPrincipalGuardada().datosCuenta[1].equals("baes") && indicador == 1) || (carrito.getPrincipalGuardada().datosCuenta[1].equals("rut") && indicador == 2)){
            Confirmacion conf = new Confirmacion(carrito,establecerPrecio(),indicador);
            conf.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(this, "Introduzca un medio de pago válido por favor");
        }
    }

    /**
     * Devuelve los precios de los productos seleccionados en un arreglo de String.
     * @return Arreglo de String con los precios.
     */
    private String[] establecerPrecio(){
        String[] datos = new String[carrito.getProductosAgregados().size()];
        for (int i = 0; i < datos.length; i++){
            datos[i] = carrito.getProductosAgregados().get(i)[1];
        }
        return datos;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == baes){
            indicador = 1;
            seleccionarOpcion(baes);
        }
        else if (actionEvent.getSource() == rut){
            indicador = 2;
            seleccionarOpcion(rut);
        }
        else if (actionEvent.getSource() == cancelar){
            this.dispose();
        }
        else if (actionEvent.getSource() == atras){
            carrito.setVisible(true);
            this.dispose();
        }
        else if (actionEvent.getSource() == ok){
            continuar();
        }
    }
}
