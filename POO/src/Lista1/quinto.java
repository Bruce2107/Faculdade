public class quinto {
    public static void main() {
        int col = 3, row = 4;
        double[][] A = gerarMatriz(col, row);
        double[][] B = gerarMatriz(col, row);
        double[][] C = sum(col, row, A, B);
        double[][] T = transpose(row,col,C);

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(T[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double[][] gerarMatriz(int col, int row) {
        double[][] T = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                T[i][j] = Math.random();
            }
        }
        return T;
    }

    private static double[][] sum(int col, int row, double[][] m1, double[][] m2) {
        double[][] soma = new double[row][];
        for (int i = 0; i < row; i++) {
            soma[i] = new double[col];
            for (int j = 0; j < col; j++) {
                soma[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return soma;
    }

    private static double[][] transpose(int col, int row, double[][] m) {
        double[][] T = new double[row][col];
        for (int i = 0; i < col; i = i + 1) {
            for (int j = 0; j < row; j = j + 1)
                T[j][i] = m[i][j];
        }
        return T;
    }

}
