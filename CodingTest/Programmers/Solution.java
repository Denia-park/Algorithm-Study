package CodingTest.Programmers;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;

        int[] diceNumbers = new int[7];
        diceNumbers[a]++;
        diceNumbers[b]++;
        diceNumbers[c]++;
        diceNumbers[d]++;

        if (diceNumbers[a] == 4) {
            return 1111 * a;
        } else if (diceNumbers[a] == 1 && diceNumbers[b] == 1 && diceNumbers[c] == 1 && diceNumbers[d] == 1) {
            int tempMin1 = Math.min(a, b);
            int tempMin2 = Math.min(c, d);

            return Math.min(tempMin1, tempMin2);
        } else {
            //case2
            int case2Big = 0;
            int case2Small = 0;
            for (int i = 1; i < 7; i++) {
                if (diceNumbers[i] == 3) {
                    case2Big = i;
                } else if (diceNumbers[i] == 1) {
                    case2Small = i;
                }
            }
            if (case2Big != 0 && case2Small != 0) {
                return (int) Math.pow(10 * case2Big + case2Small, 2);
            }

            //case3
            int case3Big = 0;
            int case3Small = 0;
            for (int i = 1; i < 7; i++) {
                if (case3Big == 0 && diceNumbers[i] == 2) {
                    case3Big = i;
                } else if (diceNumbers[i] == 2) {
                    case3Small = i;
                }
            }
            if (case3Big != 0 && case3Small != 0) {
                return (case3Big + case3Small) * Math.abs(case3Big - case3Small);
            } else if (case3Big != 0) {
                int temp = 1;
                if (a != case3Big) {
                    temp *= a;
                }
                if (b != case3Big) {
                    temp *= b;
                }
                if (c != case3Big) {
                    temp *= c;
                }
                if (d != case3Big) {
                    temp *= d;
                }
                return temp;
            }
        }
        return answer;
    }

}
