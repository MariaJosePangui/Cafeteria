package view;
import controller.GestorCafeteria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaListaCafes extends JFrame{
    private JPanel panel;

    public VentanaListaCafes(){
        setTitle("Lista de Cafes");
        setBounds(50, 50, 400, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes() {
        generaPanel();
        mostrarListaCafes();
    }

    public void generaPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public JLabel crearEtiqueta(String texto, int x, int y, int ancho, int alto,String estiloTexto){
        JLabel etiqueta = new JLabel();
        etiqueta.setText(texto);
        etiqueta.setBounds(x,y,ancho,alto);
        etiqueta.setHorizontalAlignment(SwingConstants.LEFT);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font(estiloTexto,1,alto));
        return etiqueta;
    }

    public JTextField crearCajaTexto(int x, int y, int ancho, int alto){
        JTextField cajaTexto = new JTextField();
        cajaTexto.setBounds(x,y,ancho,alto);
        return cajaTexto;
    }

    public JButton crearBoton(String texto, int x, int y, int ancho, int alto, String estiloTexto){
        JButton boton = new JButton();
        boton.setText(texto);
        boton.setBounds(x,y,ancho,alto);
        boton.setForeground(Color.black);
        boton.setFont(new Font(estiloTexto,1,(alto)));
        return boton;
    }

    public void mostrarListaCafes() {
        JLabel etiqueta1 = crearEtiqueta("Mostrar cafes",120,10,200,20,"Calibri");
        panel.add(etiqueta1);

        JLabel etiqueta2 = crearEtiqueta("Tamaño : ",10,50,200,14,"Calibri");
        panel.add(etiqueta2);

        JTextField cajaTexto1 = crearCajaTexto(170,47,170,20);
        panel.add(cajaTexto1);

        JButton boton1 = crearBoton("Mostrar",40,220,150,18,"Calibri");
        panel.add(boton1);

        JButton boton2 = crearBoton("Volver a menu",200,220,150,18,"Calibri");
        panel.add(boton2);

        ActionListener eventoClick1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorCafeteria gestorCafeteria = new GestorCafeteria();
                String tamanho = cajaTexto1.getText();
                JComboBox listaDespegable = gestorCafeteria.obtenerListaCafes(tamanho);
                listaDespegable.setBounds(20,80,200,30);
                panel.add(listaDespegable);
            }
        };
        boton1.addActionListener(eventoClick1);

        ActionListener eventoClick2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaMenu ventanaMenu = new VentanaMenu();
                ventanaMenu.setVisible(true);
            }
        };
        boton2.addActionListener(eventoClick2);
    }
}
