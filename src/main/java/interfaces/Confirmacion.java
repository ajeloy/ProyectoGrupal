package interfaces;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import dominioProblema.Tienda;
public class Confirmacion extends JFrame implements ActionListener{

    private JLabel mensaje;
    private JPasswordField caja;
    private JButton confirmar;
    private  String[] precio;
    private CarritoCompras carro;
    private int indicador;

    public Confirmacion(CarritoCompras carro, String[] precio, int indicador){
        super();
        this.carro = carro;
        this.precio = precio;
        this.indicador = indicador;
        configurarVentana();
        iniciarComponentes();
        configurarComponentes();
    }

    private void configurarVentana() {
        this.setTitle("Métodos de pago");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
    }

    private  void iniciarComponentes(){
        mensaje = new JLabel("Introduce la clave:");
        caja = new JPasswordField();
        confirmar = new JButton("Confirmar compra");
    }

    private void configurarComponentes(){
        mensaje.setBounds(20,50,260,50);
        mensaje.setBackground(Color.WHITE);
        mensaje.setFont(new Font("Arial",3,23));
        this.add(mensaje);
        caja.setBounds(80,130,100,40);
        caja.setFont(new Font("Arial",3,23));
        this.add(caja);
        confirmar.setBounds(20,180,260,50);
        confirmar.setBackground(Color.WHITE);
        confirmar.setFont(new Font("Arial",3,23));
        confirmar.addActionListener(this);
        this.add(confirmar);
    }

    /**
     * Su función es realizar la compra de los productos seleccionados si es que la contraseña es válida.
     * @throws IOException
     */
    public void comprar()throws IOException{
        Tienda tienda = new Tienda();
        String clave = tienda.devolverPosicionClave(carro.getPrincipalGuardada().datosCuenta,indicador);
        if(caja.getText().equals(clave)) {
            JOptionPane.showMessageDialog(this, "Usted ha realizado su compra con éxito");
            String precioTotal = tienda.calcularTotal(precio, carro.getPrincipalGuardada().datosCuenta, indicador);
            tienda.comprarObjeto(precioTotal, carro.getPrincipalGuardada().datosCuenta, indicador);
            carro.eliminarProducto();
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(this, "Contraseña incorrecta");
            this.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == confirmar){
            try {
                comprar();
            }
             catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
