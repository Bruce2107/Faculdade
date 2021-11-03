public class primeiro {
    public static void main(String[] args) {
        int a = 10, b = 15;
        for (int i = a; i <= b; i++) {
            if (isPrime(i, 2)) {
                System.out.println(i);
            }
        }
    }
    public static void Um(int a, int b) {
        for (int i = a; i <= b; i++) {
            if (isPrime(i, 2)) {
                System.out.println(i);
            }
        }
    }

    static boolean isPrime(int n, int i) {
        if (n <= 2)
            return n == 2;
        if (n % i == 0)
            return false;
        if (i * i > n)
            return true;
        return isPrime(n, i + 1);
    }
}
