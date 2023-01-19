package CodingTest.Programers;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] left = new int[10001], right = new int[10001];
        int ls = 0, rs = 0;
        for (int i : topping) {
            if (right[i] == 0) rs++;
            right[i]++;
        }
        for (int i : topping) {
            right[i]--;
            if (right[i] == 0) rs--;
            if (left[i] == 0) ls++;
            left[i]++;
            if (rs == ls) answer++;
        }
        return answer;
    }
}
