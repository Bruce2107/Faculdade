public class oitavo {
    public static void main(String[] args) {
        var a = "Casa";
        var n = 2;
        System.out.println(caesar(a, n));
    }

    public static String caesar(String a, int salt) {
        if (salt < 0) return caesar(a, salt + 26);
        var r = "";
        var splited = a.split("");
        for (String s : splited) {
            if (s.matches("[A-z]")) {
                var code = (int) s.charAt(0);
                if (code >= 65 && code <= 90) {
                    r = r.concat(Character.toString(((code - 65 + salt) % 26) + 65));
                }
                else if (code >= 97 && code <= 122) {
                    r = r.concat(Character.toString(((code - 97 + salt) % 26) + 97));
                }
            }
        }
        return r;
    }
}
