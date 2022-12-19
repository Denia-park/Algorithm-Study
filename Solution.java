class Solution {
    public int solution(String[] inputLine) {
        int answer = 0;

        int addFatiguePerOneHour = Integer.parseInt(inputLine[0]);
        int workAmount = Integer.parseInt(inputLine[1]);
        int healing = Integer.parseInt(inputLine[2]);
        int maxFatigue = Integer.parseInt(inputLine[3]);

        int curFatigue = 0;

        for (int i = 0; i < 24; i++) {
            if (curFatigue + addFatiguePerOneHour <= maxFatigue) {
                curFatigue += addFatiguePerOneHour;
                answer += workAmount;
            } else {
                curFatigue -= healing;
                if (curFatigue <= 0) {
                    curFatigue = 0;
                }
            }
        }

        return answer;
    }
}
