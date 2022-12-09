class Solution {
    public int solution(int mySoldierNum, int superPass, int[] enemys) {
        int roundCheck = 0;

        for (int enemy : enemys) {
            if (mySoldierNum < enemy && superPass == 0) {
                break;
            }

            if (mySoldierNum - enemy > enemy) {
                mySoldierNum -= enemy;
            } else if (superPass > 0) {
                superPass--;
            } else if (mySoldierNum >= enemy) {
                mySoldierNum -= enemy;
            } else {
                break;
            }

            roundCheck++;
        }

        return roundCheck;
    }
}
