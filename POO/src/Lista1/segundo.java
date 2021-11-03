import java.util.Arrays;

public class segundo {
    public static void main(String[] args) {
        int[] V = {1, 2, 3, 4};
        int[] U = {5, 6, 7, 8};
        Arrays.stream(newVetor(V, U)).sorted().forEach(System.out::println);
    }

    public static void Dois(int[] V, int[] U) {
        Arrays.stream(newVetor(V, U)).sorted().forEach(System.out::println);
    }

    private static int[] newVetor(int[] V, int[] U) {
        int[] T = new int[V.length];
        for (int i = 0; i < V.length; i++) {
            if (par(V[i]) && par(U[i])) {
                T[i] = V[i] + U[i];
                continue;
            }
            if (!par(V[i]) && !par(U[i])) {
                T[i] = V[i] - U[i];
                continue;
            }
            T[i] = V[i] * U[i];
        }
        return T;
    }

    private static boolean par(int n) {
        return n % 2 == 0;
    }
}
