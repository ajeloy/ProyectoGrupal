package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class CarritoCompras extends JFrame implements ActionListener {

      private JPanel panelSuperior, panelCentral1, panelCentral2, panelInferior;
      private JButton principal, carro, usuario, comprar, eliminar;
      private JLabel carrito, textoCarrito, textoProducto, textoValor, imagenServicio;
      private Principal principalGuardada;
      private Perfil perfil;
      private ArrayList<String[]> productosAgregados;
      private int posicionActual;
      private JButton siguiente;
      private JButton atras;
      private JButton imagen;
      private ArrayList<String[]> informacionProductosComprados;

      private void configurarVentana() {
            this.setTitle("Carrito de Compras");
            this.setSize(600, 500);
            this.setLocationRelativeTo(null);
            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

      public CarritoCompras(Principal principalGuardada) {
            super();
            configurarVentana();
            this.principalGuardada = principalGuardada;
            this.productosAgregados = principalGuardada.getProductosComprados();
            this.informacionProductosComprados = principalGuardada.getInformacionProductosComprados();
            posicionActual = 0;
            iniciarPanelSuperior();
            configurarPanelSuperior();
            iniciarPanelCentral1();
            configurarPanelCentral1();
            iniciarPanelCentral2();
            configurarPanelCentral2();
            iniciarPanelInferior();
            configurarPanelInferior();
      }

      private void iniciarPanelSuperior(){
            panelSuperior = new JPanel();
            principal = new JButton();
            carro = new JButton();
            usuario = new JButton();
      }

      private void configurarPanelSuperior(){
            panelSuperior.setBounds(0,0,600,75);
            panelSuperior.setLayout(null);
            panelSuperior.setBackground(Color.DARK_GRAY);
            principal.setBounds(0, -5, 70, 75);
            asignarImagenBotones(principal,"src\\main\\java\\archivos\\imagenesPrincipal\\boton_inicio.png");
            principal.addActionListener(this);
            principal.setBorder(null);
            panelSuperior.add(principal);
            carro.setBounds(455, -5, 70, 75);
            asignarImagenBotones(carro,"src\\main\\java\\archivos\\imagenesPrincipal\\boton_carrito.png");
            carro.addActionListener(this);
            carro.setBorder(null);
            panelSuperior.add(carro);
            usuario.setBounds(525, -5, 70, 76);
            asignarImagenBotones(usuario,"src\\main\\java\\archivos\\imagenesPrincipal\\boton_cuenta.png");
            usuario.addActionListener(this);
            usuario.setBorder(null);
            panelSuperior.add(usuario);
            this.add(panelSuperior);
      }

      private void iniciarPanelCentral1(){
            panelCentral1 = new JPanel();
            textoCarrito = new JLabel();
            carrito = new JLabel();
      }

      private void configurarPanelCentral1(){
            panelCentral1.setBounds(0,75,600,75);
            panelCentral1.setLayout(null);
            panelCentral1.setBackground(Color.WHITE);
            textoCarrito.setBounds(70, 10, 200, 40);
            textoCarrito.setText("Carrito de compras");
            textoCarrito.setForeground(Color.BLACK);
            textoCarrito.setFont(new Font("Arial", Font.BOLD, 18));
            panelCentral1.add(textoCarrito);
            carrito.setBounds(10, 10, 44, 44);
            asignarImagenEtiqueta(carrito,"src\\main\\java\\archivos\\imagenesCarritoCompra\\carrito.jpg");
            carrito.setBorder(null);
            panelCentral1.add(carrito);
            this.add(panelCentral1);
      }

      private void iniciarPanelCentral2(){
            panelCentral2 = new JPanel();
            imagenServicio = new JLabel();
            imagen = new JButton();
            textoProducto = new JLabel();
            textoValor = new JLabel();
            eliminar = new JButton();
            siguiente = new JButton("Siguiente");
            atras = new JButton("Atrás");
      }

      private void configurarPanelCentral2(){
            panelCentral2.setBounds(0,150,600,250);
            panelCentral2.setBackground(Color.lightGray);
            panelCentral2.setLayout(null);
            imagenServicio.setBounds(10, 10, 60, 60);
            asignarImagenEtiqueta(imagenServicio,"src\\main\\java\\archivos\\imagenesCarritoCompra\\servicio.jpg");
            imagenServicio.setBorder(null);
            panelCentral2.add(imagenServicio);
            imagen.setBounds(430, 20, 30, 30);
            asignarImagenBotones(imagen,"src\\main\\java\\archivos\\imagenesCarritoCompra\\circulo.jpg");
            imagen.setBorder(null);
            imagen.addActionListener(this);
            panelCentral2.add(imagen);
            textoProducto.setBounds(120, 15, 200, 40);
            textoProducto.setForeground(Color.BLACK);
            textoProducto.setFont(new Font("Arial", Font.PLAIN, 18));
            textoValor.setBounds(120, 40, 100, 40);
            textoValor.setForeground(Color.WHITE);
            textoValor.setFont(new Font("Arial", Font.PLAIN, 18));
            eliminar.setBounds(500, 20, 30, 30);
            asignarImagenBotones(eliminar,"src\\main\\java\\archivos\\imagenesCarritoCompra\\x.jpeg");
            eliminar.addActionListener(this);
            eliminar.setBorder(null);
            siguiente.setBounds(350,150,150,50);
            siguiente.setFont(new Font("Arial",3,24));
            siguiente.setBackground(Color.WHITE);
            siguiente.addActionListener(this);
            atras.setBounds(100,150,150,50);
            atras.setFont(new Font("Arial",3,24));
            atras.setBackground(Color.WHITE);
            atras.addActionListener(this);
            iniciarProductoActual(textoProducto, textoValor, 0);
            panelCentral2.add(eliminar);
            panelCentral2.add(siguiente);
            panelCentral2.add(textoProducto);
            panelCentral2.add(textoValor);
            panelCentral2.add(atras);
            this.add(panelCentral2);
      }

      private void iniciarPanelInferior(){
            panelInferior = new JPanel();
            comprar = new JButton("Comprar");
      }

      private void configurarPanelInferior(){
            panelInferior.setBounds(0,400,600,100);
            panelInferior.setLayout(null);
            panelInferior.setBackground(Color.WHITE);
            comprar.setBounds(210, 5, 152, 56);
            comprar.setFont(new Font("Arial",3,27));
            comprar.setBackground(Color.WHITE);
            comprar.addActionListener(this);
            panelInferior.add(comprar);
            this.add(panelInferior);
      }

      public Perfil getPerfil() {
            return perfil;
      }

      public void setPerfil(Perfil perfil) {
            this.perfil = perfil;
      }

      public void setProductosAgregados(ArrayList<String[]> productosAgregados) {
            this.productosAgregados = productosAgregados;
      }

      public void setInformacionProductosComprados(ArrayList<String[]> informacionProductosComprados) {
            this.informacionProductosComprados = informacionProductosComprados;
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
       * Se asegura que ciertos elementos tengas valores predeterminados al iniciar el programa.
       * @param etiqueta Etiqueta a cambiar.
       * @param etiqueta2 Etiqueta a cambiar.
       * @param posicion Posición de valor externo que se usará para asignarle valores a las etiquetas.
       */
      private void iniciarProductoActual(JLabel etiqueta,JLabel etiqueta2, int posicion){
            if (!productosAgregados.isEmpty()){
                  etiqueta.setText(productosAgregados.get(posicionActual)[posicion]);
                  etiqueta2.setText("$"+productosAgregados.get(posicionActual)[posicion+1]);
            }
      }

      /**
       * Cambia el producto que se está mostrando
       * @param cambio valor de cambio que puede ser negativo o positivo.
       */
      public void cambiarProductoActual(int cambio){
            if (!productosAgregados.isEmpty()) {
                  if (posicionActual == 0 && cambio == -1) {
                        posicionActual = productosAgregados.size() - 1;
                  } else if (posicionActual == productosAgregados.size() - 1 && cambio == 1) {
                        posicionActual = 0;
                  } else {
                        posicionActual = posicionActual + cambio;
                  }
                  textoValor.setText("$" + productosAgregados.get(posicionActual)[1]);
                  textoProducto.setText(productosAgregados.get(posicionActual)[0]);
            }
      }

      /**
       * Muestra la información del producto actual.
       */
      private void mostrarInformacion(){
            if(!informacionProductosComprados.isEmpty()) {
                  JOptionPane.showMessageDialog(this, "Carácterísticas\n" + informacionProductosComprados.get(posicionActual)[1] + "\n" + informacionProductosComprados.get(posicionActual)[2] + "\n" + informacionProductosComprados.get(posicionActual)[3]);
            }
            else{
                  JOptionPane.showMessageDialog(this,"No has agregado ningún producto en tu carrito");
            }
      }

      /**
       * Elimina el producto en la posición actual.
       */
      public void eliminarProducto(){
            if(!productosAgregados.isEmpty()){
                  JOptionPane.showMessageDialog(this,"Producto "+productosAgregados.get(posicionActual)[0]+" eliminado correctamente");
                  productosAgregados.remove(posicionActual);
                  cambiarProductoActual(1);
            }
            else{
                  JOptionPane.showMessageDialog(this,"No has agregado ningún producto en tu carrito");
            }
      }

      public CarritoCompras getVentana(){
            return this;
      }

      public ArrayList<String[]> getProductosAgregados() {
            return productosAgregados;
      }

      public Principal getPrincipalGuardada() {
            return principalGuardada;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            if (e.getSource() == principal){
                  principalGuardada.setVisible(true);
                  principalGuardada.setPerfil(getPerfil());
                  principalGuardada.setCarrito(getVentana());
                  this.setVisible(false);
            }
            else if(e.getSource() == carro){

            }
            else if (e.getSource() == usuario){
                  if (principalGuardada.getPerfilGuardado() != null) {
                        principalGuardada.getPerfilGuardado().setVisible(true);
                        this.setVisible(false);
                  }
                  else {
                        Perfil perfil = new Perfil(principalGuardada);
                        perfil.setCarrito(getVentana());
                        perfil.setVisible(true);
                        this.setVisible(false);
                  }
            }
            else if (e.getSource() == comprar){
                  MetodoPago met = new MetodoPago(getVentana());
                  met.setVisible(true);
                  this.setVisible(false);
            }
            else if (e.getSource() == eliminar){
                  eliminarProducto();
            }
            else if (e.getSource() == siguiente){
                  cambiarProductoActual(1);
            }
            else if (e.getSource() == atras){
                  cambiarProductoActual(-1);
            }
            else if (e.getSource() == imagen){
                  mostrarInformacion();
            }
      }

}
