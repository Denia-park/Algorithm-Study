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
            if (students[stuIdx] == 2) {
                if (stuIdx != 1 & students[stuIdx - 1] == 0) {
                    students[stuIdx - 1]++;
                } else if (stuIdx != n & students[stuIdx + 1] == 0) {
                    students[stuIdx + 1]++;
                }
                students[stuIdx]--;
            }
        }

        answer = (int) Arrays.stream(students).filter(val -> val > 0).count();

        return answer;
    }
}
