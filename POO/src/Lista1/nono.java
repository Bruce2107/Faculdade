public class nono {
    public static void main(String[] args) {
        System.out.println(toBin(6));
        System.out.println(toHex(16));
    }
    public static void nove(int n, boolean bin) {
        System.out.println(bin ? toBin(n) : toHex(n));
    }
    private static String toBin(int n) {
        var binario = "";

        if (n == 1)
            binario = binario.concat("1");
        else {
            while (true) {
                if (n % 2 == 0) binario = binario.concat("0");
                else binario = binario.concat("1");
                n /= 2;
                if (n == 1) {
                    binario = binario.concat("1");
                    break;
                }
            }
        }
        var invertido = "";
        var b = binario.split("");
        for (int i = 0; i < b.length; i++) {
            invertido = invertido.concat(b[b.length - 1 - i]);
        }
        return invertido;

    }

    private static final int sizeOfIntInHalfBytes = 8;
    private static final int numberOfBitsInAHalfByte = 4;
    private static final int halfByte = 0x0F;
    private static final char[] hexDigits = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    public static String toHex(int dec) {
        StringBuilder hexBuilder = new StringBuilder(sizeOfIntInHalfBytes);
        hexBuilder.setLength(sizeOfIntInHalfBytes);
        for (int i = sizeOfIntInHalfBytes - 1; i >= 0; --i)
        {
            int j = dec & halfByte;
            hexBuilder.setCharAt(i, hexDigits[j]);
            dec >>= numberOfBitsInAHalfByte;
        }
        return hexBuilder.toString();
    }
}
