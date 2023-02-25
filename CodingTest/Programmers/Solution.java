package CodingTest.Programmers;

import java.util.HashMap;
import java.util.Map;

//키의 개수 1~100개
//자판을 이용해 특정 문자열을 작성할 때, 키를 최소한으로 몇번 눌러야 하는지 ?
class Solution {
    final int NOT_VALID = 1000;
    final int IMPOSSIBLE = -1;

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> dict = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char curChar = key.charAt(i);
                int curPushNum = i + 1;
                int findPushNum = dict.getOrDefault(curChar, NOT_VALID);

                if (curPushNum < findPushNum) {
                    dict.put(curChar, curPushNum);
                }
            }
        }

        int idx = 0;
        for (String target : targets) {
            int tempVal = 0;

            for (int i = 0; i < target.length(); i++) {
                char curChar = target.charAt(i);
                int findPushNum = dict.getOrDefault(curChar, NOT_VALID);

                if (findPushNum == NOT_VALID) {
                    return new int[]{IMPOSSIBLE};
                }

                tempVal += findPushNum;
            }
            answer[idx] = tempVal;

            idx++;
        }

        return answer;
    }
}
