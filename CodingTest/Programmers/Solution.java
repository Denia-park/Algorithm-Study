package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private final String[] group = new String[]{"A", "E", "I", "O", "U"};
    List<String> answerList;
    private int answer;
    private String target;

    public int solution(final String word) {
        answerList = new ArrayList<>();
        answer = -1;
        target = word;

        search("");

        return answer;
    }

    private void search(final String curString) {
        if (curString.length() > 5 || answer != -1) {
            return;
        }

        if (!curString.isEmpty()) {
            answerList.add(curString);
        }

        if (curString.equals(target)) {
            answer = answerList.size();
            return;
        }

        for (final String str : group) {
            search(curString + str);
        }
    }
}
