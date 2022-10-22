class Solution {
    public int solution(int submitNum, int receiveNum, int initCokeNum) {
        int answer = 0;

        while (initCokeNum >= submitNum) {
            int tempReceive = (initCokeNum / submitNum) * receiveNum;
            initCokeNum = initCokeNum % submitNum + tempReceive;

            answer += tempReceive;
        }

        return answer;
    }
}
