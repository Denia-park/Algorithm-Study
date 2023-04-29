package CodingTest.Programmers;

//이모티콘 할인행사

//아이디어
//완탐 돌리기

//시간복잡도
//이모티콘 별로 할인율을 모두 적용 후 유저별로 계산
//4^이모티콘의 수 (7) * user의 수 (100)

//자료구조
//우선순위큐
//완탐 돌리기 - 백트래킹 [dfs 사용 - 재귀]

class Solution {
    final int MEMBERSHIP = 0;
    final int PRICE = 1;

    int[][] gUsers;
    int[] gEmoticons;
    int[] gEmoticonsPercent;
    int[] answer;
    int[] percents = new int[]{40, 30, 20, 10};

    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[]{0, 0};
        gUsers = users;
        gEmoticons = emoticons;
        gEmoticonsPercent = new int[gEmoticons.length];

        //백트래킹 - 모든 경우의 수 조사 - 재귀
        dfs(0);

        return answer;
    }

    public void dfs(int curDepth) {
        if (curDepth == gEmoticons.length) {
            int[] result = calculate();
            
            //해당 하는 상황일때 가격 및 가입자 수 저장하기.
            if (answer[MEMBERSHIP] < result[MEMBERSHIP] ||
                    answer[MEMBERSHIP] == result[MEMBERSHIP] && (answer[PRICE] < result[PRICE])) {
                answer = result;
            }

            return;
        }

        for (int idx = curDepth; idx < gEmoticons.length; idx++) {
            for (int percent : percents) {
                gEmoticonsPercent[idx] = percent;
                dfs(curDepth + 1);
            }
        }
    }

    private int[] calculate() {
        int[] result = new int[2];

        int totalUserPriceSum = 0;
        int totalMembershipCount = 0;

        for (int[] tempUser : gUsers) {
            int userStanPercent = tempUser[0];
            int userStanPrice = tempUser[1];

            double userPriceSum = 0;

            for (int i = 0; i < gEmoticons.length; i++) {
                double emoticonPercent = gEmoticonsPercent[i];
                int emoticonPrice = gEmoticons[i];

                if (emoticonPercent >= userStanPercent) {
                    userPriceSum += emoticonPrice * (1 - (emoticonPercent / 100));
                }

                if (userPriceSum >= userStanPrice) {
                    break;
                }
            }

            if (userPriceSum >= userStanPrice) {
                totalMembershipCount++;
            } else {
                totalUserPriceSum += userPriceSum;
            }
        }

        result[MEMBERSHIP] = totalMembershipCount;
        result[PRICE] = totalUserPriceSum;

        return result;
    }
}
