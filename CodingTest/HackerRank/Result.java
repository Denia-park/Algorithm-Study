package CodingTest.HackerRank;

public class Result {
    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        int rotateCount = k % 26;
        StringBuilder alphabet = new StringBuilder();
        for (int i = 'a'; i < 'z' + 1; i++) {
            alphabet.append((char) (i));
        }
        alphabet.append(alphabet);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean upperFlag = Character.isUpperCase(c);

            char c2 = Character.toLowerCase(c);

            int index = alphabet.indexOf(String.valueOf(c2));

            if (index == -1) {
                result.append(s.charAt(i));
            } else {
                char val = alphabet.charAt(index + rotateCount);
                result.append(upperFlag ? Character.toUpperCase(val) : val);
            }
        }

        return result.toString();
    }
}
