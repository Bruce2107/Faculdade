package Prova.Um;

import java.util.Locale;

public class Compressor {
    private final String modo;
    Compressor(String modo) {
        this.modo = modo;
    }
    public void execute() {
        if(this.modo.toLowerCase(Locale.ROOT).equals("esfriar")) {
            System.out.println("compressao para esfriar");
        }
        if(this.modo.toLowerCase(Locale.ROOT).equals("esquentar")){
            System.out.println("compressão para esquentar");
        }
    }
}
