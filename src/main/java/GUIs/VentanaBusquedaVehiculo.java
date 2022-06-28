package GUIs;

import model.Automotora;
import model.MarcaVehiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBusquedaVehiculo extends Ventana{
    JLabel label1;
    JLabel label2;
    JTextField textoModelo;
    MarcaVehiculo marcaVehiculo;
    Automotora automotora;

    public VentanaBusquedaVehiculo(String nombre, int largoX, int largoY, Automotora automotora) {
        super(nombre, largoX, largoY);
        this.automotora = automotora;
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        panelVentana();
        etiquetasVentana();
        camposTextoVentana();
        botonesVentana();
        listasDesplegables();
    }

    private void panelVentana() {
        JPanel panel = new JPanel();
        this.add(panel);
    }

    private void etiquetasVentana() {
        generarJLabel(label1,"Modelo Vehículo",20,60,150,20);
        generarJLabel(label2,"Marca Vehículo", 20,110,100,20);
    }

    private void camposTextoVentana() {
        textoModelo = generarJTextField(200,60,240,20);
        this.add(textoModelo);
    }

    private void listasDesplegables() {
        JComboBox listaMarcas = generarListaDesplegable(MarcaVehiculo.values(),120,110,100,20);
        this.add(listaMarcas);
    }

    private void botonesVentana() {
        JButton botonBuscarVehículo = generarBoton("Buscar Vehículo",70,350,150,20);
        this.add(botonBuscarVehículo);
        JButton botonRegresar = generarBoton("Regresar",260,350,150,20);
        this.add(botonRegresar);

        botonBuscarVehículo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaTabla ventanaTabla = new VentanaTabla(new String[2][], new String[]{"a", "b", "c"});
            }
        });
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


}
