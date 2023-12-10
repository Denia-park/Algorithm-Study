package CodingTest.Programmers;

class Solution {
    private int CASTING_TIME;
    private int HEAL_PER_SEC;
    private int CONTINUE_SUCCESS_HEAL;
    private int LAST_ATTACK_TIME;
    private int MY_MAX_HP;
    private int myCurrentHealth;

    public int solution(final int[] bandage, final int health, final int[][] attacks) {
        CASTING_TIME = bandage[0];
        HEAL_PER_SEC = bandage[1];
        CONTINUE_SUCCESS_HEAL = bandage[2];
        LAST_ATTACK_TIME = attacks[attacks.length - 1][0];
        MY_MAX_HP = health;

        myCurrentHealth = health;

        int attackIdx = 0;

        int curTime = 1;
        int continueSuccessTime = 0;

        while (curTime <= LAST_ATTACK_TIME) {
            //공격
            if (attackIdx < attacks.length && attacks[attackIdx][0] == curTime) {
                myCurrentHealth -= attacks[attackIdx][1];

                if (myCurrentHealth <= 0) {
                    return -1;
                }

                continueSuccessTime = 0;

                attackIdx++;
            } else {
                //회복
                heal(HEAL_PER_SEC);

                continueSuccessTime++;

                //연속시간 조건 만족하면
                if (continueSuccessTime == CASTING_TIME) {
                    //연속 성공 회복 올리고
                    heal(CONTINUE_SUCCESS_HEAL);

                    //연속 시간 초기화
                    continueSuccessTime = 0;
                }
            }

            curTime++;
        }

        return myCurrentHealth == 0 ? -1 : myCurrentHealth;
    }

    private void heal(final int healAmount) {
        myCurrentHealth += healAmount;

        if (myCurrentHealth > MY_MAX_HP) {
            myCurrentHealth = MY_MAX_HP;
        }
    }
}
