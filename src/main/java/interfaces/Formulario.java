package interfaces;

import dominioProblema.Tienda;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;


public class Formulario extends JFrame implements ActionListener, MouseListener {

      private JPanel panelSuperior, panelInferior;
      private JLabel titulo, textoNombreUsuario, textoRut;
      private  JLabel textoContraseña;
      private  JLabel textoConfirmacion;
      private JTextField cajaNombre, cajaRut;
      private JPasswordField cajaContraseña;
      private JPasswordField cajaConfirmacion;
      private JButton ok, cancelar, volver;
      private int contador1, contador2, contador3, contador4;

      public Formulario() {
            super();
            contador1 = 0;
            contador2 = 0;
            contador3 = 0;
            contador4 = 0;
            configurarVentana();
            iniciarComponentes();
      }

      private void configurarVentana() {
            this.setTitle("Registro");
            this.setSize(600, 500);
            this.setLocationRelativeTo(null);
            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

      private void iniciarComponentes() {
            panelSuperior = new JPanel();
            panelInferior = new JPanel();
            titulo = new JLabel();
            textoNombreUsuario = new JLabel();
            textoRut = new JLabel();
            textoContraseña = new JLabel();
            textoConfirmacion = new JLabel();
            cajaNombre = new JTextField();
            cajaRut = new JTextField();
            cajaContraseña = new JPasswordField();
            cajaConfirmacion = new JPasswordField();
            ok = new JButton();
            cancelar = new JButton();
            volver = new JButton();
            panelSuperior();
            panelInferior();
      }
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      // configuraciones panel superior

      private void panelSuperior() {
            titulo();
            panelSuperior.setBackground(Color.WHITE);
            panelSuperior.setBounds(0, 0, 600, 50);
            panelSuperior.setLayout(null);
            this.add(titulo);
            this.add(panelSuperior);
      }

      private void titulo() {
            titulo.setBounds(20, 0, 200, 50);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            titulo.setText("REGISTRO");
            titulo.setForeground(Color.BLACK);
            titulo.setFont(new Font("Baskerville Old Face", Font.BOLD, 24));
            panelSuperior.add(titulo);
      }

      private void panelInferior() {
            textoRut();
            textoNombreUsuario();
            textoContraseña();
            textoConfirmacion();
            cajaNombre();
            cajaRut();
            cajaContraseña();
            cajaConfirmacion();
            botonOk();
            botonCancelar();
            botonVolver();
            panelInferior.setBackground(Color.WHITE);
            panelInferior.setBounds(0, 50, 600, 450);
            panelInferior.setLayout(null);
            this.add(textoNombreUsuario);
            this.add(textoRut);
            this.add(textoContraseña);
            this.add(textoConfirmacion);
            this.add(cajaNombre);
            this.add(cajaRut);
            this.add(cajaContraseña);
            this.add(cajaConfirmacion);
            this.add(ok);
            this.add(cancelar);
            this.add(volver);
            this.add(panelInferior);
      }

      private void textoNombreUsuario() {
            textoNombreUsuario.setBounds(60, 60, 400, 50);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            textoNombreUsuario.setText("Ingrese nombre de Usuario");
            textoNombreUsuario.setForeground(Color.BLACK);
            textoNombreUsuario.setFont(new Font("Arial", Font.BOLD, 14));
            panelInferior.add(textoNombreUsuario);
      }

      private void textoRut() {
            textoRut.setBounds(60, 125, 400, 50);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            textoRut.setText("Ingrese su Rut");
            textoRut.setForeground(Color.BLACK);
            textoRut.setFont(new Font("Arial", Font.BOLD, 14));
            panelInferior.add(textoRut);
      }

      private void textoContraseña() {
            textoContraseña.setBounds(60, 190, 400, 50);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            textoContraseña.setText("Ingrese una Contraseña");
            textoContraseña.setForeground(Color.BLACK);
            textoContraseña.setFont(new Font("Arial", Font.BOLD, 14));
            panelInferior.add(textoContraseña);
      }

      private void textoConfirmacion() {
            textoConfirmacion.setBounds(60, 250, 400, 50);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            textoConfirmacion.setText("Confirmar Contraseña");
            textoConfirmacion.setForeground(Color.BLACK);
            textoConfirmacion.setFont(new Font("Arial", Font.BOLD, 14));
            panelInferior.add(textoConfirmacion);
      }

      private void cajaNombre() {
            cajaNombre.setText("Nombre");
            cajaNombre.setForeground(Color.LIGHT_GRAY);
            cajaNombre.setFont(new Font("arial", Font.BOLD, 14));
            cajaNombre.setBounds(60, 100, 250, 37);
            cajaNombre.addMouseListener(this);
            panelInferior.add(cajaNombre);
      }

      private void cajaRut() {
            cajaRut.setText("Rut");
            cajaRut.setForeground(Color.LIGHT_GRAY);
            cajaRut.setFont(new Font("arial", Font.BOLD, 14));
            cajaRut.setBounds(60, 165, 250, 37);
            cajaRut.addMouseListener(this);
            panelInferior.add(cajaRut);
      }

      private void cajaContraseña() {
            cajaContraseña.setText("Contraseña");
            cajaContraseña.setForeground(Color.LIGHT_GRAY);
            cajaContraseña.setFont(new Font("arial", Font.BOLD, 14));
            cajaContraseña.setBounds(60, 227, 250, 37);
            cajaContraseña.addMouseListener(this);
            panelInferior.add(cajaContraseña);
      }

      private void cajaConfirmacion() {
            cajaConfirmacion.setText("Contraseña");
            cajaConfirmacion.setForeground(Color.LIGHT_GRAY);
            cajaConfirmacion.setFont(new Font("arial", Font.BOLD, 14));
            cajaConfirmacion.setBounds(60, 290, 250, 37);
            cajaConfirmacion.addMouseListener(this);
            panelInferior.add(cajaConfirmacion);
      }
      
      private void botonOk() {
            ok.setText("OK");
            ok.setForeground(Color.WHITE);
            ok.setBackground(Color.BLACK);
            ok.setFont(new Font("arial black", Font.BOLD, 14));
            ok.setBounds(450, 370, 70, 37);
            ok.addActionListener(this);
            panelInferior.add(ok);
      }
      
      private void botonCancelar() {
            cancelar.setText("CANCELAR");
            cancelar.setForeground(Color.BLACK);
            cancelar.setBackground(Color.WHITE);
            cancelar.setFont(new Font("arial", Font.BOLD, 14));
            cancelar.setBounds(280, 370, 150, 37);
            cancelar.addActionListener(this);
            panelInferior.add(cancelar);
      }
       private void botonVolver() {
            volver.setBounds(60, 370, 70, 40);
            ImageIcon volv = new ImageIcon("src\\main\\java\\archivos\\imagenesLogin\\flecha.png");
            volver.setIcon(new ImageIcon(volv.getImage().getScaledInstance(volver.getWidth(),volver.getHeight(), Image.SCALE_SMOOTH)));
            volver.addActionListener(this);
            volver.setBorderPainted(true);
            volver.setBorder(null);
            panelInferior.add(volver);
      }

      /**
       * Efectúa el registro de la persona siempre y cuando cumpla las condiciones.
       * @throws IOException
       */
      private void registrarse()throws IOException {
             if ((contador1 + contador2 + contador3 + contador4 >= 4) && (cajaContraseña.getText().equals(cajaConfirmacion.getText()))) {
                  Tienda tienda = new Tienda();
                  if(tienda.vereficarRegistro(cajaRut.getText())){
                        JOptionPane.showMessageDialog(this,"Ya existe una cuenta asociada a ese rut.");
                  }
                  else {
                        tienda.agregarPersona(cajaRut.getText(), cajaContraseña.getText(), cajaNombre.getText());
                        JOptionPane.showMessageDialog(this, "Te has registrado correctamente");
                  }
            }
            else {
                  JOptionPane.showMessageDialog(this,"Introduzca bien sus datos por favor");
            }
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            if (e.getSource() == volver){
                Login login = new Login();
                login.setVisible(true);
                this.dispose();
            }
            else if (e.getSource() == cancelar){
                this.dispose();
            }
            else if (e.getSource() == ok){
                  try {
                        registrarse();
                  } catch (IOException ex) {
                        ex.printStackTrace();
                  }
            }
      }

      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
            if (mouseEvent.getSource() == cajaNombre){
                  if(contador1 == 0){
                        cajaNombre.setText("");
                  }
                  contador1++;
            }
            else if(mouseEvent.getSource() == cajaRut){
                  if(contador2 == 0){
                        cajaRut.setText("");
                  }
                  contador2++;
            }
            else if (mouseEvent.getSource() == cajaContraseña){
                  if(contador3 == 0){
                        cajaContraseña.setText("");
                  }
                  contador3++;
            }
            else if (mouseEvent.getSource() == cajaConfirmacion){
                  if(contador4 == 0){
                        cajaConfirmacion.setText("");
                  }
                  contador4++;
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
