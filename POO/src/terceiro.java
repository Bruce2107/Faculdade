public class terceiro {
    public static void main(String args[])
    {
        int N = 10,sum=0;

        for (int i = 0; i < N; i++) {
            int f = fib(i);
            sum +=f;
            System.out.print(f + " ");
        }
        System.out.println("\nTotal "+sum);
    }
    public static void Tres(int N) {
       int sum=0;

        for (int i = 0; i < N; i++) {
            int f = fib(i);
            sum +=f;
            System.out.print(f + " ");
        }
        System.out.println("\nTotal "+sum);
    }

    private static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
}
