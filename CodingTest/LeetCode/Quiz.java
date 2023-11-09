package CodingTest.LeetCode;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.countHomogenous("abbcccaa") == 13);
        System.out.println(solution.countHomogenous("xy") == 2);
        System.out.println(solution.countHomogenous("zzzzz") == 15);
        System.out.println(solution.countHomogenous("oooorppppppppooooobbbjjjjcccccccccccceeeee") == 171);
    }
}

class Solution {
    int powVal = (int) (Math.pow(10, 9) + 7);

    public int countHomogenous(String quizStr) {
        int sum = 0;

        char[] array = quizStr.toCharArray();

        int start = 0;
        for (int end = 0; end < array.length; end++) {
            if (array[start] == array[end]) {
                sum = ((sum % powVal) + ((end - start + 1) % powVal)) % powVal;
            } else {
                start = end;
                sum++;
            }
        }

        return sum;
    }
}
