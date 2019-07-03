package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import dominioProblema.Tienda;


public class Login extends JFrame implements ActionListener, MouseListener{

      private JTextField cajaUsuario;
      private  JPasswordField cajaContrasena;
      private JLabel iconoUsuario, iconoContrasena, titulo, logo;
      private JButton ingresar,registrar;
      private JPanel panelSuperior, panelInferior;
      private int contadorClave;
      private int contadorRut;

      public Login() {
            super();
            configurarVentana();
            iniciarComponentes();
      }

      private void configurarVentana() {
            this.setTitle("Login Usuario");
            this.setSize(600, 500);
            this.setLocationRelativeTo(null);
            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

      private void iniciarComponentes() {
            cajaUsuario = new JTextField();
            cajaContrasena = new  JPasswordField();
            iconoUsuario = new JLabel();
            iconoContrasena = new JLabel();
            titulo = new JLabel();
            logo = new JLabel();
            ingresar = new JButton();
            registrar = new JButton();
            panelSuperior = new JPanel();
            panelInferior = new JPanel();
            panelSuperior();
            panelInferior();
            contadorClave = 0;
            contadorRut = 0;
      }

      private void panelSuperior() {
            titulo();
            anadirLogo();
            panelSuperior.setBackground(Color.WHITE);
            panelSuperior.setBounds(0, 0, 600, 140);
            panelSuperior.setLayout(null);
            this.add(titulo);
            this.add(logo);
            this.add(panelSuperior);

      }

      private void titulo() {
            titulo.setBounds(40, 0, 450, 180);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            titulo.setText("Casino Virtual Ufro");
            titulo.setForeground(Color.BLACK);
            titulo.setFont(new Font("Baskerville Old Face", Font.BOLD, 44));
            panelSuperior.add(titulo);
      }

      private void anadirLogo() {
            logo = new JLabel(new ImageIcon("src\\main\\java\\archivos\\imagenesLogin\\logo.jpg"));
            logo.setBounds(460, 21, 120, 120);
            logo.setOpaque(true);
            panelSuperior.add(logo);
      }

      private void panelInferior() {
            iconoUsuario();
            iconoContraseña();
            cajaUsuario();
            cajaContrasena();
            botonIngresar();
            botonRegistrar();
            panelInferior.setBackground(Color.WHITE);
            panelInferior.setBounds(0, 140, 600, 360);
            panelInferior.setLayout(null);
            this.add(registrar);
            this.add(iconoUsuario);
            this.add(iconoContrasena);
            this.add(cajaUsuario);
            this.add(cajaContrasena);
            this.add(ingresar);
            this.add(panelInferior);
      }

      private void iconoUsuario() {
            iconoUsuario = new JLabel(new ImageIcon("src\\main\\java\\archivos\\imagenesLogin\\iconoUsuario.png"));
            iconoUsuario.setBounds(90, 200, 40, 36);
            iconoUsuario.setOpaque(true);
            panelSuperior.add(iconoUsuario);

      }

      private void cajaUsuario() {
            cajaUsuario.setText("Ingrese rut sin puntos ni guión");
            cajaUsuario.setForeground(Color.LIGHT_GRAY);
            cajaUsuario.setFont(new Font("arial", Font.BOLD, 14));
            cajaUsuario.setBounds(130, 200, 250, 37);
            cajaUsuario.addMouseListener(this);
            panelInferior.add(cajaUsuario);
      }
      
      private void iconoContraseña() {
            iconoContrasena = new JLabel(new ImageIcon("src\\main\\java\\archivos\\imagenesLogin\\iconoContraseña.png"));
            iconoContrasena.setBounds(90, 240, 40, 36);
            iconoContrasena.setOpaque(true);
            panelInferior.add(iconoContrasena);

      }
      private void cajaContrasena() {
            cajaContrasena.setText("Contraseña");
            cajaContrasena.setForeground(Color.LIGHT_GRAY);
            cajaContrasena.setFont(new Font("arial", Font.BOLD, 14));
            cajaContrasena.setBounds(130, 240, 250, 37);
            cajaContrasena.addMouseListener(this);
            panelInferior.add(cajaContrasena);
      }
      
      private void botonIngresar() {
            ingresar.setText("Ingresar");
            ingresar.setForeground(Color.WHITE);
            ingresar.setBackground(Color.BLACK);
            ingresar.setFont(new Font("arial black", Font.BOLD, 14));
            ingresar.setBounds(200, 300, 120, 37);
            ingresar.addActionListener(this);
            panelInferior.add(ingresar);
      }
      
      private void botonRegistrar() {
            registrar.setText("Registrar");
            registrar.setForeground(Color.WHITE);
            registrar.setBackground(Color.BLACK);
            registrar.setFont(new Font("arial black", Font.BOLD, 14));
            registrar.setBounds(200, 350, 120, 37);
            registrar.addActionListener(this);
            panelInferior.add(registrar);
      }

      /**
       * Trata de acceder a la aplicación según la veracidad de sus credenciales.
       * @throws IOException
       */
      public void acceder() throws IOException{
            Tienda tienda = new Tienda();
          if (tienda.devolverDia().equals("Domingo")){
                JOptionPane.showMessageDialog(this,"EL casino no funciona los domingos gracias.");
          }
          else if  (tienda.autentificarIdentidad(cajaUsuario.getText(), cajaContrasena.getText())){
                tienda.iniciarProductos();
                tienda.iniciarPersona(cajaUsuario.getText());
                Principal met = new Principal(tienda.devolverPersona(), tienda.devolverCuentas(), tienda.devolverProductos(), tienda.devolverDia(),tienda.devolverInformacionAlimentos());
                met.setVisible(true);
              this.dispose();
          }
          else{
              JOptionPane.showMessageDialog(this, "No encontramos ninguna cuenta con ese rut");
          }
      }
      
      @Override
      public void actionPerformed(ActionEvent e) {
          if (e.getSource() == registrar){
              Formulario form = new Formulario();
              form.setVisible(true);
              this.dispose();
          }
          else if (e.getSource() == ingresar){
              try {
                  acceder();
              } catch (IOException ex) {
                  Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      }

      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
            if (mouseEvent.getSource() == cajaContrasena){
                  if (contadorClave == 0){
                        cajaContrasena.setText("");
                        contadorClave++;
                  }
            }
            else if (mouseEvent.getSource() == cajaUsuario){
                  if (contadorRut == 0){
                        cajaUsuario.setText("");
                        contadorRut++;
                  }
            }
      }

      @Override
      public void mousePressed(MouseEvent mouseEvent) {

      }

      @Override
      public void mouseReleased(MouseEvent mouseEvent) {

      }

      @Override
      public void mouseEntered(MouseEvent mouseEvent) {

      }

      @Override
      public void mouseExited(MouseEvent mouseEvent) {

      }
}
