public class setimo {
    public static void main() {
        var A = quinto.gerarMatriz(4,4);
        var B = quinto.gerarMatriz(4,4);
        var C = combine(A,B,4);
        System.out.println("A");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("B");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(B[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Combinada");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(C[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static double[][] combine(double[][] A, double[][] B, int n) {
        double[][] T = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i<=j) {
                    T[i][j] = A[i][j];
                }else T[i][j]=B[i][j];
            }
        }
        return T;
    }
}
