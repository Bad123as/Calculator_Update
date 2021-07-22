class ArabToRoman {
    public static String arabToRoman(int input) {
        StringBuilder stringBuilder = new StringBuilder();
        int a = 0;
        String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L",
                "XC", "C"};
        int[] ints = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100};
        for (int i = ints.length - 1; i >= 0; i--) {
            a = input / ints[i];
            input %= ints[i];
            while (a > 0) {
                stringBuilder.append(romans[i]);
                a--;
            }
        }
        return stringBuilder.toString();
    }
}