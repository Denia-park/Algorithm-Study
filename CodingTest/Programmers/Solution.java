package CodingTest.Programmers;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            String curName = name[i];
            int curScore = yearning[i];

            map.put(curName, curScore);
        }

        int idx = 0;
        for (String[] charecters : photo) {
            int tempScore = 0;
            for (String charName : charecters) {
                tempScore += map.getOrDefault(charName, 0);
            }
            answer[idx++] = tempScore;
        }

        return answer;
    }
}
