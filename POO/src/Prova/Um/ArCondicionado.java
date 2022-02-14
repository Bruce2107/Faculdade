package Prova.Um;

public class ArCondicionado {
    private boolean ligado, desligado, esquentando,resfriando;
    protected double temp_ambiente, temp_usuario;

    ArCondicionado(boolean l,boolean d,boolean e,boolean r,double ta,double tu) {
        this.desligado = d;
        this.esquentando = e;
        this.ligado = l;
        this.resfriando = r;
        this.temp_ambiente = ta;
        this.temp_usuario = tu;
    }

    public void ventilar() {
        var ventilador = new Ventilador();
        ventilador.execute();
    }

    public void comprimir(String modo) {
        var compressor = new Compressor(modo);
        compressor.execute();
    }

    public double getTemp_ambiente() {
        return temp_ambiente;
    }

    public double getTemp_usuario() {
        return temp_usuario;
    }

    public boolean isDesligado() {
        return desligado;
    }

    public boolean isLigado() {
        return ligado;
    }

    public boolean isEsquentando() {
        return esquentando;
    }

    public boolean isResfriando() {
        return resfriando;
    }

    public void setDesligado(boolean desligado) {
        this.desligado = desligado;
    }

    public void setEsquentando(boolean esquentando) {
        this.esquentando = esquentando;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public void setResfriando(boolean resfriando) {
        this.resfriando = resfriando;
    }

    public void setTemp_ambiente(double temp_ambiente) {
        this.temp_ambiente = temp_ambiente;
    }

    public void setTemp_usuario(double temp_usuario) {
        this.temp_usuario = temp_usuario;
    }
}
