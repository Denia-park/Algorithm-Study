import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lostArr, int[] reserveArr) {
        int answer = 0;

        int[] students = new int[n + 2];

        Arrays.fill(students, 1);

        students[0] = 0;
        students[n + 1] = 0;

        for (int lostStuNum : lostArr) {
            students[lostStuNum]--;
        }

        for (int reserveStuNum : reserveArr) {
            students[reserveStuNum]++;
        }

        for (int stuIdx = 1; stuIdx < n + 1; stuIdx++) {
            if (students[stuIdx] == 0) {
                if (students[stuIdx - 1] == 2) {
                    students[stuIdx]++;
                    students[stuIdx - 1]--;
                } else if (students[stuIdx + 1] == 2) {
                    students[stuIdx]++;
                    students[stuIdx + 1]--;
                }
            }
        }

        answer = (int) Arrays.stream(students).filter(val -> val > 0).count();

        return answer;
    }
}
