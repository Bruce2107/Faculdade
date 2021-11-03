import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Numero do exercicio");
        var op = Integer.parseInt(in.nextLine());
        do {
            switch (op) {
                case 1 -> um();
                case 2 -> dois();
                case 3 -> tres();
                case 4 -> quatro();
                case 5 -> cinco();
                case 6 -> seis();
                case 7 -> sete();
                case 8 -> oito();
                case 9 -> nove();
                default -> {
                }
            }
            System.out.println("Numero do exercicio");
            op = Integer.parseInt(in.nextLine());
        } while (op != 0);
    }

    private static void um() {
        Scanner in = new Scanner(System.in);
        System.out.println("A");
        var a = Integer.parseInt(in.nextLine());
        System.out.println("B");
        var b = Integer.parseInt(in.nextLine());
        primeiro.Um(a, b);
    }

    private static void dois() {
        Scanner in = new Scanner(System.in);
        System.out.println("Tamanho");
        var n = Integer.parseInt(in.nextLine());
        int[] a = new int[n];
        System.out.println("valores de A");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(in.nextLine());
        }
        int[] b = new int[n];
        System.out.println("valores de B");
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(in.nextLine());
        }
        segundo.Dois(a, b);
    }

    private static void tres() {
        Scanner in = new Scanner(System.in);
        System.out.println("numero");
        var a = Integer.parseInt(in.nextLine());

        terceiro.Tres(a);
    }

    private static void quatro() {
        Scanner in = new Scanner(System.in);
        System.out.println("Frase");
        var a = (in.nextLine());
        System.out.println("1 - remover vogais\n0 - remover consoantes");
        var b = Boolean.parseBoolean(in.nextLine());
        quarto.Quarto(a, b);
    }

    private static void cinco() {
        quinto.main();
    }

    private static void seis() {
        Scanner in = new Scanner(System.in);
        System.out.println("Tamanho");
        var n = Integer.parseInt(in.nextLine());
        List<Integer> a = new ArrayList<>(List.of());
        System.out.println("valores de A");
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(in.nextLine()));
        }
        List<Integer> b = new ArrayList<>(List.of());
        System.out.println("valores de B");
        for (int i = 0; i < n; i++) {
            b.add(Integer.parseInt(in.nextLine()));
        }
        sexto.Seis(a, b);
    }

    private static void sete() {
        setimo.main();
    }

    private static void oito() {
        Scanner in = new Scanner(System.in);
        System.out.println("Frase");
        var a = (in.nextLine());
        System.out.println("Salt");
        var b = Integer.parseInt(in.nextLine());
        System.out.println(oitavo.caesar(a, b));
    }

    private static void nove() {
        Scanner in = new Scanner(System.in);
        System.out.println("Numero");
        var a = Integer.parseInt(in.nextLine());
        System.out.println("1 - binario\n0 - hex");
        var b = Boolean.parseBoolean(in.nextLine());
        nono.nove(a, b);
    }
}
