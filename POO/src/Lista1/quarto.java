public class quarto {
    public static void main(String[] args) {
        String a = "GefsdA";
        boolean vogal = false;
        a = a.replaceAll(vogal ? "[aeiouAEIOU]" : "[a-zA-Z&&[^aeiouAEIOU]]", "");
        System.out.println(a);
    }
    public static void Quarto(String a,boolean vowel) {
        a = a.replaceAll(vowel ? "[aeiouAEIOU]" : "[a-zA-Z&&[^aeiouAEIOU]]", "");
        System.out.println(a);
    }
}
