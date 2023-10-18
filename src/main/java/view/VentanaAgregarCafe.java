package view;
import controller.GestorCafeteria;
import model.Cafe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaAgregarCafe extends JFrame {
    private JPanel panel;

    public VentanaAgregarCafe(){
        setTitle("Agregar Café");
        setBounds(50, 50, 400, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes() {
        generarPanel();
        agregarCafe();
    }

    public void generarPanel() {
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

    public void agregarCafe() {
        JLabel etiqueta1 = crearEtiqueta("Agregar Café",120,10,200,20,"Calibri");
        panel.add(etiqueta1);

        JLabel etiqueta2 = crearEtiqueta("Cantidad de gramos : ",10,50,200,14,"Calibri");
        panel.add(etiqueta2);

        JLabel etiqueta3 = crearEtiqueta("Mililitros de agua : ",10,90,200,14,"Calibri");
        panel.add(etiqueta3);

        JLabel etiqueta4 = crearEtiqueta("Tamaño : ",10,130,200,14,"Calibri");
        panel.add(etiqueta4);

        JLabel etiqueta5 = crearEtiqueta("Ingredientes opcionales : ",10,170,170,14,"Calibri");
        panel.add(etiqueta5);

        JTextField cajaTexto1 = crearCajaTexto(170,47,170,20);
        panel.add(cajaTexto1);

        JTextField cajaTexto2 = crearCajaTexto(170,87,170,20);
        panel.add(cajaTexto2);

        JTextField cajaTexto3 = crearCajaTexto(170,127,170,20);
        panel.add(cajaTexto3);

        JTextField cajatexto4 = crearCajaTexto(170,167,170,20);
        panel.add(cajatexto4);

        JButton boton1 = crearBoton("Agregar",40,270,150,18,"Calibri");
        panel.add(boton1);

        JButton boton2 = crearBoton("Volver a menu",200,270,150,18,"Calibri");
        panel.add(boton2);

        ActionListener eventoClick1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorCafeteria gestorCafeteria = new GestorCafeteria();
                int cantidadGramos = Integer.parseInt(cajaTexto1.getText());
                int mililitrosAgua = Integer.parseInt(cajaTexto2.getText());
                String tamanho = cajaTexto3.getText();
                String ingredientesOpcionales = cajatexto4.getText();
                Cafe cafe = new Cafe(cantidadGramos,mililitrosAgua,tamanho,ingredientesOpcionales);
                gestorCafeteria.agregarCafes(cafe);
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
