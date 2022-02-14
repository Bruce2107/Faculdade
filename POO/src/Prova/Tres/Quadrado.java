package Prova.Tres;

public class Quadrado {
    private double medidaLados;

    public Quadrado(double ml) {
        this.medidaLados = ml;
    }

    public void setMedidaLados(double medidaLados) {
        this.medidaLados = medidaLados;
    }

    public double getMedidaLados() {
        return medidaLados;
    }

    public double getArea() {
        return Math.pow(this.medidaLados, 2);
    }
}
