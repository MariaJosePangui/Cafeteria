package data;
import model.Cafe;
import model.Cafeteria;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {

    public static boolean registrarDatos(List objetos, String direccionArchivo) {
        try {
            File file = new File(direccionArchivo);
            Files.deleteIfExists(Paths.get(direccionArchivo));
            File fichero = new File(direccionArchivo);
            fichero.createNewFile();
            FileWriter fw = new FileWriter(fichero, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Object objeto : objetos) {
                bw.write(objeto.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static ArrayList<Cafe> leerArchivoCafes(String direccionArchivo) {
        ArrayList<Cafe> listaCafes = new ArrayList<>();
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(",");
                listaCafes.add(new Cafe(Integer.parseInt(data[0]),Integer.parseInt(data[1]),data[2],data[3]));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Documento no disponible, favor contactar con administrador");
        }
        return listaCafes;
    }

    public static boolean registrarCafeteria(Cafeteria cafeteria, String direccionArchivo){
        try {
            File file = new File(direccionArchivo);
            Files.deleteIfExists(Paths.get(direccionArchivo));
            File fichero = new File(direccionArchivo);
            fichero.createNewFile();
            FileWriter fw = new FileWriter(fichero, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(cafeteria.toString());
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Cafeteria leerArchivoCafeteria(String direccionArchivo) {
        String textoArchivo = "";
        Cafeteria cafeteria = null;
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String[] data = textoArchivo.split(",");
            cafeteria = new Cafeteria(data[0],data[1],data[2]);
            br.close();
            fr.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Documento no disponible, favor contactar con administrador");
        }
        return cafeteria;
    }
}