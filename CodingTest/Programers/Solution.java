package CodingTest.Programers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] todayWords = today.split("\\.");
        int y = Integer.parseInt(todayWords[0]);
        int m = Integer.parseInt(todayWords[1]);
        int d = Integer.parseInt(todayWords[2]);
        LocalDate tdy = LocalDate.of(y, m, d);

        Map<String, String> termMap = new HashMap<>();
        for (String term : terms) {
            String[] words = term.split(" ");
            String alpha = words[0];
            String month = words[1];

            termMap.put(alpha, month);
        }

        List<Integer> tempList = new ArrayList<>();
        int idx = 1;
        for (String privacy : privacies) {
            String[] words = privacy.split(" ");
            String date = words[0];
            String alpha = words[1];
            if (isDestroied(tdy, date, termMap.get(alpha))) {
                tempList.add(idx);
            }
            idx++;
        }

        int[] answer = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            answer[i] = tempList.get(i);
        }

        return answer;
    }

    private boolean isDestroied(LocalDate tdy, String date, String period) {
        String[] words = date.split("\\.");
        int y = Integer.parseInt(words[0]);
        int m = Integer.parseInt(words[1]);
        int d = Integer.parseInt(words[2]);

        LocalDate getDate = LocalDate.of(y, m, d);
        LocalDate afterDate = getDate.plusMonths(Integer.parseInt(period));
//        System.out.println(afterDate + " " + tdy);

        return afterDate.isBefore(tdy) || afterDate.isEqual(tdy);
    }
}
