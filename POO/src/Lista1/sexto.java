import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class sexto {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 2, 3, 5, 6); // 17
        List<Integer> B = Arrays.asList(1, 2, 4, 5, 7); // 19

        var I = Intersection(A, B);
        var U = Union(A, B);
        var S = Sum(A, B);
        var sub = Sub(A,B);

        System.out.println("Intersection");
        I.forEach(System.out::println);
        System.out.println("Union");
        U.forEach(System.out::println);
        System.out.println("Soma");
        System.out.println(S);
        System.out.println("Sub");
        System.out.println("A - B: "+sub.get(0)+"\nB - A: "+sub.get(1));
    }

    public static void Seis(List<Integer> A, List<Integer> B) {
        var I = Intersection(A, B);
        var U = Union(A, B);
        var S = Sum(A, B);
        var sub = Sub(A,B);

        System.out.println("Intersection");
        I.forEach(System.out::println);
        System.out.println("Union");
        U.forEach(System.out::println);
        System.out.println("Soma");
        System.out.println(S);
        System.out.println("Sub");
        System.out.println("A - B: "+sub.get(0)+"\nB - A: "+sub.get(1));
    }

    private static List<Integer> Intersection(List<Integer> A, List<Integer> B) {
        return A.stream().filter(B::contains).collect(Collectors.toList());
    }

    private static List<Integer> Union(List<Integer> A, List<Integer> B) {
        List<Integer> U = new java.util.ArrayList<>(List.of());
        U.addAll(A);
        B.forEach(b -> {
            if (!U.contains(b)) U.add(b);
        });
        return U;
    }

    private static Integer Sum(List<Integer> A, List<Integer> B) {
        Integer a = A.stream()
                .mapToInt(Integer::intValue)
                .sum();
        Integer b = B.stream()
                .mapToInt(Integer::intValue)
                .sum();
        return (a + b);
    }

    private static List<Integer> Sub(List<Integer> A, List<Integer> B) {
        Integer a = A.stream()
                .mapToInt(Integer::intValue)
                .sum();
        Integer b = B.stream()
                .mapToInt(Integer::intValue)
                .sum();
        return Arrays.asList((a - b), (b - a));
    }

}
