class Solution {
    String[] banList = {"ayaaya", "yeye", "woowoo", "mama"};
    String[] speakingList = {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        int answer = 0;

        for (String str : babbling) {
            String tempStr = str;
            for (String ban : banList) {
                tempStr = tempStr.replace(ban, "z");
            }
            for (String speak : speakingList) {
                tempStr = tempStr.replace(speak, "");
            }
            if (tempStr.length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}
