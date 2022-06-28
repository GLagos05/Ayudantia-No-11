package GUIs;

import model.Automotora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenuVentas extends Ventana {
    JLabel label;
    Automotora automotora;

    public VentanaMenuVentas(String nombre, int largoX, int largoY, Automotora automotora) {
        super(nombre, largoX, largoY);
        this.automotora = automotora;
        iniciarComponentes(largoX);
    }

    private void iniciarComponentes(int largoX){
        panelVentana();
        etiquetasVentana();
        botonesVentana(largoX);
    }

    private void panelVentana(){
        JPanel panel = new JPanel();
        this.add(panel);
    }

    private void etiquetasVentana() {
        generarJLabelEncabezado(label,"Sistema de Venta de Vehiculos",20,20,300,20);
    }

    private void botonesVentana(int largoX){
        JButton botonRegistrarClientes = generarBoton("Registrar Clientes",largoX/3,80,150,40);
        JButton botonRegistrarVehiculo = generarBoton("Registrar Vehiculo",largoX/3,150,150,40);
        JButton botonBuscarVehiculo = generarBoton("Buscar Vehiculo",largoX/3,220,150,40);
        JButton botonVenderVehiculo = generarBoton("Vender Vehiculo",largoX/3,290,150,40);
        JButton botonSalir = generarBoton("Salir",largoX/3,360,150,40);

        this.add(botonRegistrarClientes);
        this.add(botonRegistrarVehiculo);
        this.add(botonBuscarVehiculo);
        this.add(botonVenderVehiculo);
        this.add(botonSalir);

        botonRegistrarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRegistroCliente ventanaRegistroCliente = new VentanaRegistroCliente("Registro de Cliente",500,500,automotora);
            }
        });
        botonRegistrarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRegistroVehiculo ventanaRegistroVehiculo = new VentanaRegistroVehiculo("Registro de Vehículo",500,500,automotora);
            }
        });
        botonBuscarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaBusquedaVehiculo ventanaBusquedaVehiculo = new VentanaBusquedaVehiculo("Búsqueda de Vehículo",500,500,automotora);
            }
        });
        botonVenderVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(botonVenderVehiculo,"Próximamente","Mensaje Informativo",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
