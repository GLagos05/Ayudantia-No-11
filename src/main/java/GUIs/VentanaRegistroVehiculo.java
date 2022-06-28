package GUIs;

import data.GestorDatos;
import model.Automotora;
import model.ColorVehiculo;
import model.MarcaVehiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistroVehiculo extends Ventana{
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JTextField textoModelo;
    JTextField textoAño;
    JTextField textoPrecio;
    JTextField textoKm;
    JComboBox listaMarcas;
    JComboBox listaColores;
    MarcaVehiculo marcaVehiculo;
    ColorVehiculo colorVehiculo;
    Automotora automotora;

    public VentanaRegistroVehiculo(String nombre, int largoX, int largoY, Automotora automotora) {
        super(nombre, largoX, largoY);
        this.automotora = automotora;
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        panelVentana();
        etiquetasVentana();
        camposTextoVentana();
        listasDesplegables();
        botonesVentana();
    }

    private void panelVentana() {
        JPanel panel = new JPanel();
        this.add(panel);
    }

    private void etiquetasVentana() {
        generarJLabelEncabezado(label1,"Registro de Vehiculo",150,20,250,20);
        generarJLabel(label2,"Modelo Vehículo: ",20,60,150,20);
        generarJLabel(label3,"Marca Vehículo: ",20,110,100,20);
        generarJLabel(label4,"Color Vehículo: ",250,110,100,20);
        generarJLabel(label5,"Año: ",20,160,100,20);
        generarJLabel(label6,"Precio: ",20,210,150,20);
        generarJLabel(label7,"Kilómetros recorridos: ",20,260,150,20);
    }

    private void camposTextoVentana() {
        textoModelo = generarJTextField(200,60,240,20);
        this.add(textoModelo);
        textoAño = generarJTextField(200,160,240,20);
        this.add(textoAño);
        textoPrecio = generarJTextField(200,210,240,20);
        this.add(textoPrecio);
        textoKm = generarJTextField(200,260,240,20);
        this.add(textoKm);
    }

    private void listasDesplegables() {
        listaMarcas = generarListaDesplegable(MarcaVehiculo.values(),120,110,100,20);
        this.add(listaMarcas);
        listaColores = generarListaDesplegable(ColorVehiculo.values(),350,110,100,20);
        this.add(listaColores);
    }

    private void botonesVentana() {
        JButton botonRegistrarVehículo = generarBoton("Registrar Vehículo",70,350,150,20);
        this.add(botonRegistrarVehículo);
        JButton botonCancelar = generarBoton("Cancelar",260,350,150,20);
        this.add(botonCancelar);

        botonRegistrarVehículo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    automotora.añadirVehiculo(textoModelo.getText(),ColorVehiculo.valueOf(listaColores.getSelectedItem().toString()),MarcaVehiculo.valueOf(listaMarcas.getSelectedItem().toString()) ,Integer.parseInt(textoAño.getText()),Integer.parseInt(textoPrecio.getText()),Integer.parseInt(textoKm.getText()));
                    GestorDatos.registrarDatos(automotora.getVehiculosAVenta(),"target/"+"vehiculos.txt");
                    JOptionPane.showMessageDialog(botonRegistrarVehículo,"Vehículo registrado correctamente","Mensaje Informativo",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(botonRegistrarVehículo,"Ingrese datos Válidos","Mensaje Informativo",JOptionPane.ERROR_MESSAGE);
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
