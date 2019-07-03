package interfaces;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
public class Perfil extends JFrame implements ActionListener{

    private JLabel imagenPerfil, nombrePersona, detalles, flecha_abajo, registro, salir, tipo_persona;
    private  JPanel panelSuperior, panelCentral, panelInferior;
    private JButton ver_registro, boton_salir, boton_inicio, boton_cuenta, boton_carrito;
    private Principal principalGuardada;
    private CarritoCompras carrito;

    public Perfil(Principal principalGuardada){
        super();
        this.principalGuardada = principalGuardada;
        configurarVentana();
        iniciarPanelSuperior();
        configurarPanelSuperior();
        iniciarPanelCentral();
        configurarPanelCentral();
        iniciarPanelInferior();
        configurarPanelInferior();
        iniciarComponentes();
        configurarComponentes();
    }

    private void configurarVentana() {
        this.setTitle("Registro");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarPanelSuperior(){
        panelSuperior = new JPanel();
        boton_inicio = new JButton();
        boton_cuenta = new JButton();
        boton_carrito = new JButton();
    }

    private void configurarPanelSuperior(){
        panelSuperior.setLayout(null);
        panelSuperior.setBackground(Color.DARK_GRAY);
        panelSuperior.setBounds(0, 0, this.getWidth(), 66);
        boton_inicio.setBounds(0, 0, 70, panelSuperior.getHeight());
        asignarImagenBoton(boton_inicio, "src\\main\\java\\archivos\\imagenesPrincipal\\boton_inicio.png");
        boton_inicio.setBorder(null);
        boton_inicio.addActionListener(this);
        panelSuperior.add(boton_inicio);
        boton_cuenta.setBounds(422, 0, 72, panelSuperior.getHeight());
        asignarImagenBoton(boton_cuenta, "src\\main\\java\\archivos\\imagenesPrincipal\\boton_cuenta.png");
        boton_cuenta.setBorder(null);
        boton_cuenta.addActionListener(this);
        panelSuperior.add(boton_cuenta);
        boton_carrito.setBounds(360, 0, 63, panelSuperior.getHeight());
        asignarImagenBoton(boton_carrito, "src\\main\\java\\archivos\\imagenesPrincipal\\boton_carrito.png");
        boton_carrito.setBorder(null);
        boton_carrito.addActionListener(this);
        panelSuperior.add(boton_carrito);
        this.add(panelSuperior);
    }

    private void iniciarPanelCentral(){
        panelCentral = new JPanel();
        nombrePersona = new JLabel(principalGuardada.getDatosPersona()[0]);
        imagenPerfil = new JLabel();
        boolean tipo = Boolean.valueOf(principalGuardada.getDatosPersona()[1]);
        tipo_persona = new JLabel(devolverTipo(tipo));
    }

    private void configurarPanelCentral(){
        panelCentral.setBounds(0,66,500,204);
        panelCentral.setBackground(Color.DARK_GRAY);
        panelCentral.setLayout(null);
        nombrePersona.setBounds(230,16,300,50);
        nombrePersona.setBackground(Color.DARK_GRAY);
        nombrePersona.setForeground(Color.WHITE);
        nombrePersona.setFont(new Font("Calibri", 3, 28));
        panelCentral.add(nombrePersona);
        imagenPerfil.setBounds(30,30,160,135);
        imagenPerfil.setBackground(Color.DARK_GRAY);
        asignarImagenEtiqueta(imagenPerfil, "src\\main\\java\\archivos\\imagenesPersonas\\"+principalGuardada.getDatosPersona()[0]+".png");
        panelCentral.add(imagenPerfil);
        tipo_persona.setBounds(230,100,250,50);
        tipo_persona.setBackground(Color.DARK_GRAY);
        tipo_persona.setForeground(Color.WHITE);
        tipo_persona.setFont(new Font("Calibri", 3, 28));
        panelCentral.add(tipo_persona);
        this.add(panelCentral);
    }

    private void iniciarPanelInferior (){
        panelInferior = new JPanel();
        detalles = new JLabel("Detalles");
        flecha_abajo = new JLabel();
    }

    private void configurarPanelInferior(){
        panelInferior.setBackground(Color.BLACK);
        panelInferior.setBounds(0,270,500,70);
        detalles.setBounds(30,290,100,50);
        detalles.setForeground(Color.WHITE);
        detalles.setBackground(Color.BLACK);
        detalles.setFont(new Font("Calibri",3,28));
        panelInferior.add(detalles);
        flecha_abajo.setBounds(300,315, 54, 50);
        asignarImagenEtiqueta(flecha_abajo,"src\\main\\java\\archivos\\imagenesPerfil\\imagen_flecha.png");
        panelInferior.add(flecha_abajo);
        this.add(panelInferior);
    }

    private void iniciarComponentes(){
        registro = new JLabel("Registro de Compras");
        salir = new JLabel("Salir");
        ver_registro = new JButton();
        boton_salir = new JButton();
    }

    private void configurarComponentes(){
        registro.setBounds(150,340,300,50);
        registro.setBackground(Color.WHITE);
        registro.setFont(new Font("Arial",3,24));
        this.add(registro);
        salir.setBounds(150,410,300,50);
        salir.setBackground(Color.WHITE);
        salir.setFont(new Font("Arial",3,24));
        this.add(salir);
        ver_registro.setBounds(50,340,52,46);
        asignarImagenBoton(ver_registro,"src\\main\\java\\archivos\\imagenesPerfil\\imagen_registro.png");
        ver_registro.setBorder(null);
        ver_registro.addActionListener(this);
        this.add(ver_registro);
        boton_salir.setBounds(50,410,52,46);
        asignarImagenBoton(boton_salir,"src\\main\\java\\archivos\\imagenesPerfil\\imagen_salida.png");
        boton_salir.setBorder(null);
        boton_salir.addActionListener(this);
        this.add(boton_salir);
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
     * Le asigna una imagen a un botón.
     * @param boton
     * @param ubicacionImagen
     */
    private void asignarImagenBoton(JButton boton, String ubicacionImagen){
        Image img = new ImageIcon(ubicacionImagen).getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH));
        boton.setIcon(img2);
    }

    /**
     * Devuelve un String que se elige según el valor booleano del parámetro.
     * @param tipo valor booleano.
     * @return
     */
    private String devolverTipo(boolean tipo){
        if (tipo){
            return "Estudiante";
        }
        else{
            return "Profesor";
        }
    }

    public Perfil getVentana(){
        return this;
    }

    public CarritoCompras getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoCompras carrito) {
        this.carrito = carrito;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == boton_inicio){
            principalGuardada.setVisible(true);
            principalGuardada.setCarrito(getCarrito());
            principalGuardada.setPerfil(getVentana());
            this.setVisible(false);
        }
        else if (actionEvent.getSource() == boton_carrito){
            if (principalGuardada.getCarritoGuardado() != null) {
                principalGuardada.getCarritoGuardado().setVisible(true);
                this.setVisible(false);
            }
            else {
                CarritoCompras carrito = new CarritoCompras(principalGuardada);
                carrito.setPerfil(getVentana());
                carrito.setVisible(true);
                this.setVisible(false);
            }
        }
        else if (actionEvent.getSource() == boton_cuenta){

        }
        else if (actionEvent.getSource() == boton_salir){
            this.dispose();
        }
        else if (actionEvent.getSource() == ver_registro){

        }
    }
}
