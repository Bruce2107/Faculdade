package Prova.Dois;

public class Dois {
    public static void main(String[] args) {
        um();
//        dois();
        tres();
    }

    private static void um() {
        System.out.println("Caso um");
        System.out.println(Inversor.inverterString("eduardo"));
    }
    private static void dois() {
        System.out.println("Caso dois");
        String temp = null;
        temp = Inversor.inverterString(temp);
        // Sem o tratamento necessario é estourada uma `NullPointerException`
        System.out.println(temp);
    }
    private static void tres() {
        System.out.println("Caso tres");
        String temp = "professor";
        temp = Inversor.inverterString(temp);
        // temp vai possuir o valor `rosseforp`
        System.out.println(temp);
    }
}
