package Lista2;

class Ponto2D {
    private double x, y;

    public Ponto2D(double _x, double _y) {
        x = _x;
        y = _y;
    }
}

class Ponto3D extends Ponto2D {
    private double z;

    Ponto3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }
}