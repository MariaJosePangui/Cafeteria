package model;

public class Cafe {
    private int cantidadGramos;
    private int mililitrosAgua;
    private String tamanho;
    private String ingredientesOpcionales;

    public Cafe(int cantidadGramos, int mililitrosAgua, String tamanho, String ingredientesOpcionales) {
        this.cantidadGramos = cantidadGramos;
        this.mililitrosAgua = mililitrosAgua;
        this.tamanho = tamanho;
        this.ingredientesOpcionales = ingredientesOpcionales;
    }

    public int getCantidadGramos() {
        return this.cantidadGramos;
    }

    public void setCantidadGramos(int cantidadGramos) {
        this.cantidadGramos = cantidadGramos;
    }

    public int getMililitrosAgua() {
        return this.mililitrosAgua;
    }

    public void setMililitrosAgua(int mililitrosAgua) {
        this.mililitrosAgua = mililitrosAgua;
    }

    public String getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getIngredientesOpcionales() {
        return this.ingredientesOpcionales;
    }

    public void setIngredientesOpcionales(String ingredientesOpcionales) {
        this.ingredientesOpcionales = ingredientesOpcionales;
    }

    public String toString(){
        return cantidadGramos+","+mililitrosAgua+","+tamanho+","+ingredientesOpcionales;
    }
}