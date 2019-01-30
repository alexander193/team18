public class Comcom {
    public static void main(String[] args) {
        System.out.println("Test");
        double q = 0.1;
        double[] x0 = new double[11];
        double[] x1 = new double[11];
        double[] Px0 = new double[11];
        double[] Px1 = new double[11];
        double[] HY = new double[11];
        double[] IXY = new double[11];
        double[][] A = {{1 - q, q}, {q, 1 - q}};
        double[][] B = new double[2][11];
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        for (int i = 0; i <= 10; i++) {
            x0[i] = i;
            str1 += x0[i] + "  ";
            x1[i] = 10 - i;
            str2 += x1[i] + "  ";
            Px0[i] = x0[i] / 10;
            str3 += Px0[i] + "  ";
            Px1[i] = x1[i] / 10;
            str4 += Px1[i] + "  ";
            B[0][i] = Px0[i];
            B[1][i] = Px1[i];
        }
        printResult(str1, str2, str3, str4);
        double[][] result = multiplicar(A, B);
        for (int i = 0; i < 2; i++) {
            System.out.println(i == 0 ? "P(X = 0)" : "P(Y = 0)");
            for (int j = 0; j < 11; j++) {
                System.out.printf("%.2f ", result[i][j]);

            }
            System.out.println();
        }
        System.out.println("H(Y|X)");
        double hyx = -((1 - q) * (Math.log(1 - q) / Math.log(2))) - (q * (Math.log(q) / Math.log(2)));
        System.out.println(hyx);
        System.out.println("H(Y)");
        System.out.println(result[0][0]);
        System.out.println(result[1][0]);
        for (int i = 0; i < 11; i++) {
            HY[i] = -(result[0][i] * (Math.log(result[0][i]) / Math.log(2))) -
                    (result[1][i] * (Math.log(result[1][i]) / Math.log(2)));
            System.out.printf("%.4f  ", HY[i]);
        }
        System.out.println("\nI(X|Y)");
        for (int i = 0; i < 11; i++) {
            System.out.printf("%.4f  ", HY[i] - hyx);
        }
    }

    public static double[][] multiplicar(double[][] A, double[][] B) {

        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        double[][] C = new double[aRows][bColumns];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0.00000;
            }
        }

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    public static void printResult(String s1, String s2, String s3, String s4) {
        System.out.println("X = 0");
        System.out.println(s1);
        System.out.println("X = 1");
        System.out.println(s2);
        System.out.println("P(X = 0)");
        System.out.println(s3);
        System.out.println("P(X = 1)");
        System.out.println(s4);
    }
}
