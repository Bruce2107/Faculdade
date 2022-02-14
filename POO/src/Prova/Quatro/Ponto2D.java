package Prova.Quatro;

class Ponto2D {
    private double x, y;

    /** Codigo da imagem da prova
     * Ponto 2D(double _x, double _y){ // Pela imagem eu vejo um espaço entre `Ponto` e `2D`
     *     x=_x;y=_y;
     * }
     */
    Ponto2D(double _x, double _y) {
        x = _x;
        y = _y;
    }
}

class Ponto3D extends Ponto2D {
    private double z;
    /** Codigo da imagem da prova
     * Ponto3D(double x, double y,double z){
     *     x=_x; // variavel `_x` não existe
     *     y=_y; // variavel `_y` não existe
     *     z=_z; // variavel `_z` não existe
     *     // `x` e `y` deveriam ser passados para o metodo `super()`
     * }
     */
    Ponto3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }
}
