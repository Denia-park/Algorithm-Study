package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.minCost("abaac", new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.minCost("abc", new int[]{1, 2, 3}));
        System.out.println(solution.minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
        System.out.println(solution.minCost("cddcdcae", new int[]{4, 8, 8, 4, 4, 5, 4, 2}));
    }
}

class Solution {
    private final char EMPTY = 'E';

    public int minCost(final String colors, final int[] neededTime) {
        //연속적인 풍선을 쳐내야 하므로 -> 투포인터로 풀면 될 듯
        //투 포인터 중에서 시간이 더 짧은 쪽을 쳐내자.
        int answer = 0;

        final char[] chars = colors.toCharArray();
        final int length = chars.length;

        int left = 0;
        int right = 1;
        while (right < length && left < right) {
            //풍선 색이 다르면 넘어간다
            if (chars[left] != chars[right]) {
                left++;

                while (chars[left] == EMPTY) {
                    left++;
                }

                right = left + 1;
                continue;
            }

            //풍선 색이 같으면 자르는 시간을 비교한다.
            if (neededTime[left] < neededTime[right]) {
                //더 짧은 시간을 answer에 더한다.
                answer += neededTime[left];
                //자르고 나서는 해당 char에 'E'을 넣어준다.
                chars[left] = EMPTY;

                //left가 터졌으니까 left를 옮겨준다.
                left++;

                while (chars[left] == EMPTY) {
                    left++;
                }

                //연속된 풍선을 비교해야 하니까 right도 같이 옮긴다.
                right = left + 1;
            } else {
                //더 짧은 시간을 answer에 더한다.
                answer += neededTime[right];
                //자르고 나서는 해당 char에 'E'을 넣어준다.
                chars[right] = EMPTY;

                //right가 터졌으니까 right를 옮겨준다.
                right++;
            }
        }

        return answer;
    }
}
