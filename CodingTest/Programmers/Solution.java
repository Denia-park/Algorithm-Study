package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<String, List<Integer>> conditionScoreMap;

    public int[] solution(final String[] infos, final String[] query) {
        conditionScoreMap = new HashMap<>();

        makeConditions(infos);

        for (final List<Integer> list : conditionScoreMap.values()) {
            list.sort(null);
        }

        final List<Integer> answer = new ArrayList<>();

        for (final String str : query) {
            final String editStr = str.replace(" and ", "");
            final int splitIndex = editStr.lastIndexOf(" ");
            final int targetScore = Integer.parseInt(editStr.substring(splitIndex + 1));
            final String targetStr = editStr.substring(0, splitIndex);

            final List<Integer> valueList = conditionScoreMap.getOrDefault(targetStr, new ArrayList<>());

            answer.add(valueList.size() - bisectLeft(valueList, targetScore));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private void makeConditions(final String[] infos) {
        for (final String info : infos) {
            final String[] splitInfo = info.split(" ");

            dfs(splitInfo, "", 0);
        }
    }

    private void dfs(final String[] splitInfo, final String str, final int curIndex) {
        //마지막 인덱스
        if (curIndex == splitInfo.length - 1) {
            final List<Integer> scoreList = conditionScoreMap.getOrDefault(str, new ArrayList<>());

            final String score = splitInfo[curIndex];
            scoreList.add(Integer.valueOf(score));

            conditionScoreMap.put(str, scoreList);
            return;
        }

        //일반 조합
        dfs(splitInfo, str + splitInfo[curIndex], curIndex + 1);
        // - 조합
        dfs(splitInfo, str + "-", curIndex + 1);
    }

    private int bisectLeft(final List<Integer> scoreList, final int targetScore) {
        int left = 0;
        int right = scoreList.size();

        while (left < right) {
            final int mid = (left + right) / 2;
            if (scoreList.get(mid) >= targetScore) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
