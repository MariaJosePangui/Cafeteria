package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaMenu extends JFrame{
    private JPanel panel;

    public VentanaMenu(){
        setTitle("Menu");
        setBounds(50, 50, 400, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes() {
        generarPanel();
        menu();
    }

    public void generarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public JButton crearBoton(String texto, int x, int y, int ancho, int alto, String estiloTexto) {
        JButton boton = new JButton();
        boton.setText(texto);
        boton.setBounds(x,y,ancho,alto);
        boton.setForeground(Color.black);
        boton.setFont(new Font(estiloTexto,1,(alto)));
        return boton;
    }

    public void menu() {
        JButton boton1 = crearBoton("Agregar Café",45,20,300,20,"Calibri");
        panel.add(boton1);

        JButton boton2 = crearBoton("Descontinuar Café",45,70,300,20,"Calibri");
        panel.add(boton2);

        JButton boton3 = crearBoton("Modificar Información",45,120,300,20,"Calibri");
        panel.add(boton3);

        JButton boton4 = crearBoton("Mostrar Cafes",45,170,300,20,"Calibri");
        panel.add(boton4);

        ActionListener eventoClick1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaAgregarCafe ventanaAgregarCafe = new VentanaAgregarCafe();
                ventanaAgregarCafe.setVisible(true);
            }
        };
        boton1.addActionListener(eventoClick1);

        ActionListener eventoClick2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaDescontinuarCafe ventanaDescontinuarCafe = new VentanaDescontinuarCafe();
                ventanaDescontinuarCafe.setVisible(true);
            }
        };
        boton2.addActionListener(eventoClick2);

        ActionListener eventoClick3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaModificarInformacion ventanaModificarInformacion = new VentanaModificarInformacion();
                ventanaModificarInformacion.setVisible(true);
            }
        };
        boton3.addActionListener(eventoClick3);

        ActionListener eventoClick4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaListaCafes ventanaListaCafes = new VentanaListaCafes();
                ventanaListaCafes.setVisible(true);
            }
        };
        boton4.addActionListener(eventoClick4);
    }
}
