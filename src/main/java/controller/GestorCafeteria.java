package controller;
import data.GestorDatos;
import model.Cafe;
import model.Cafeteria;

import javax.swing.*;
import java.util.ArrayList;

public class GestorCafeteria {

    public void agregarCafes(Cafe cafe) {
        ArrayList<Cafe> listaCafes = GestorDatos.leerArchivoCafes("cafes.txt");
        listaCafes.add(cafe);
        GestorDatos.registrarDatos(listaCafes,"cafes.txt");
        JOptionPane.showMessageDialog(null,"Se agrego el café exito");
    }

    public void descontinuarCafe(Cafe cafe) {
        ArrayList<Cafe> listaCafes = GestorDatos.leerArchivoCafes("cafes.txt");
        listaCafes.remove(cafe);
        GestorDatos.registrarDatos(listaCafes,"cafes.txt");
        JOptionPane.showMessageDialog(null,"Se descontinuo el café con exito");
    }

    public void modificarInfomarcionCafeteria(String nombre, String direccion, String redesSociales) {
        Cafeteria cafeteria = GestorDatos.leerArchivoCafeteria("cafetería.txt");
        cafeteria.setNombre(nombre);
        cafeteria.setDireccion(direccion);
        cafeteria.setRedesSociales(redesSociales);
        GestorDatos.registrarCafeteria(cafeteria,"cafetería.txt");
        JOptionPane.showMessageDialog(null,"Se modifico con exito la cafetería");
    }

    public JComboBox obtenerListaCafes(String tamaho) {
        ArrayList<Cafe> listaCafes = GestorDatos.leerArchivoCafes("cafes.txt");
        ArrayList<String> cafesTamanho = new ArrayList<>();
        for (Cafe cafe : listaCafes){
            if(cafe.getTamanho().equals(tamaho)){
                cafesTamanho.add(cafe.getTamanho());
            }
        }
        JComboBox listaDesplegable1 = new JComboBox((ComboBoxModel) cafesTamanho);
        listaDesplegable1.setBounds(20,20,100,30);
        return listaDesplegable1;
    }
}