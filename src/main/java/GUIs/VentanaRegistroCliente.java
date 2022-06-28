package GUIs;

import data.GestorDatos;
import model.Automotora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistroCliente extends Ventana{
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JTextField textoNombre;
    JTextField textoRut;
    JTextField textoDireccion;
    JTextField textoCorreo;
    JTextField textoNumero;
    Automotora automotora;

    public VentanaRegistroCliente(String nombre, int largoX, int largoY, Automotora automotora) {
        super(nombre, largoX, largoY);
        this.automotora = automotora;
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        panelVentana();
        etiquetasVentana();
        camposTextoVentana();
        botonesVentana();
    }

    private void panelVentana() {
        JPanel panel = new JPanel();
        this.add(panel);
    }

    private void etiquetasVentana() {
        generarJLabelEncabezado(label1,"Registro de Cliente",150,20,250,20);
        generarJLabel(label2,"Nombre: ",20,60,150,20);
        generarJLabel(label3,"Rut: ",20,110,150,20);
        generarJLabel(label4,"Dirección: ",20,160,100,20);
        generarJLabel(label5,"Correo electrónico: ",20,210,150,20);
        generarJLabel(label6,"Número telefónico: ",20,260,150,20);
    }

    private void camposTextoVentana() {
        textoNombre = generarJTextField(200,60,240,20);
        this.add(textoNombre);
        textoRut = generarJTextField(200,110,240,20);
        this.add(textoRut);
        textoDireccion = generarJTextField(200,160,240,20);
        this.add(textoDireccion);
        textoCorreo = generarJTextField(200,210,240,20);
        this.add(textoCorreo);
        textoNumero = generarJTextField(200,260,240,20);
        this.add(textoNumero);
    }

    private void botonesVentana() {
        JButton botonRegistrarCliente = generarBoton("Registrar Cliente",70,350,150,20);
        this.add(botonRegistrarCliente);
        JButton botonCancelar = generarBoton("Cancelar",260,350,150,20);
        this.add(botonCancelar);

        botonRegistrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    automotora.añadirClientes(textoNombre.getText(),textoRut.getText(),textoDireccion.getText(),textoCorreo.getText(),textoNumero.getText());
                    GestorDatos.registrarDatos(automotora.getClientes(),"target/"+"clientes.txt");
                    JOptionPane.showMessageDialog(botonRegistrarCliente,"Cliente registrado correctamente","Message",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(botonRegistrarCliente,"Ingrese datos válidos","Message",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
