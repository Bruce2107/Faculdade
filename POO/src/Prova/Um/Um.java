package Prova.Um;

public class Um extends Thread {
    private final ArCondicionado arCondicionado;

    Um(ArCondicionado arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public void run() {
        if (this.arCondicionado.isLigado()) {
            this.arCondicionado.comprimir(this.arCondicionado.getTemp_ambiente() > this.arCondicionado.getTemp_usuario() ? "esfriar" : "esquentar");
            this.arCondicionado.ventilar();
        }
    }
}
