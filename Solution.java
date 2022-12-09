class Solution {
    int answer;
    int[] gEnemy;

    public int solution(int mySoldierNum, int superPass, int[] enemy) {
        answer = Integer.MIN_VALUE;
        gEnemy = enemy;

        int round = 0;

        defeatEnemy(mySoldierNum, superPass, round);


        return answer;
    }

    private void defeatEnemy(int mySoldierNum, int superPass, int round) {
        if (round >= gEnemy.length) {
            answer = round;
            return;
        } else if (mySoldierNum < gEnemy[round] && superPass == 0) {
            answer = Math.max(answer, round);
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                if (mySoldierNum >= gEnemy[round]) {
                    defeatEnemy(mySoldierNum - gEnemy[round], superPass, round + 1);
                }
            } else {
                if (superPass > 0) {
                    defeatEnemy(mySoldierNum, superPass - 1, round + 1);
                }
            }
        }
    }
}
