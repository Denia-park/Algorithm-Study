package CodingTest.Programmers.HackerRank;

public class Result {
    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
    static final String FIZZ = "Fizz";
    static final String BUZZ = "Buzz";
    static final String FIZZBUZZ = FIZZ + BUZZ;

    public static void fizzBuzz(int n) {
        //3으로 나누면 Fizz
        //5로 나뉘면 Buzz
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            boolean converted = false;

            if (i % 3 == 0) {
                sb.append(FIZZ);
                converted = true;
            }
            if (i % 5 == 0) {
                sb.append(BUZZ);
                converted = true;
            }

            if (!converted) {
                sb.append(i);
            }

            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }
}
