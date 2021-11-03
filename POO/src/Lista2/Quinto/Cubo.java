package Lista2.Quinto;

public class Cubo extends Quadrado {
    public Cubo(double ml) {
        super(ml);
    }

    @Override
    public double getArea() {
        return 6 * Math.pow(this.getMedidaLados(), 2);
    }
}
