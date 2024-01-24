package CodingTest.Programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/*
아이디어
- 투포인터
- 동일한 보석이 포함되지 않은 길이가 가장 긴 포인터를 반환

시간 복잡도
- N

자료구조
- Set 사용
 */
class Solution {
    public int[] solution(final String[] gems) {
        final int[] answer = new int[2];
        int answerLength = Integer.MAX_VALUE;

        final int gemTypeCount = new HashSet<>(List.of(gems)).size();

        final int gemLength = gems.length;

        final Map<String, Integer> gemMap = new HashMap<>();

        int startIdx = 0;
        int endIdx = -1;

        while (startIdx < gemLength) {
            if (gemMap.size() == gemTypeCount) {
                //모든 보석을 다 구했으니까 answer 계산
                final int tempGemCount = endIdx - startIdx + 1;

                if (tempGemCount < answerLength) {
                    answerLength = tempGemCount;

                    answer[0] = startIdx + 1;
                    answer[1] = endIdx + 1;
                }

                if (startIdx == endIdx && endIdx < gemLength - 1) {
                    endIdx++;

                    final String endGemName = gems[endIdx];

                    gemMap.put(endGemName, gemMap.getOrDefault(endGemName, 0) + 1);
                } else {
                    final String startGemName = gems[startIdx];

                    final int startGemCount = gemMap.getOrDefault(startGemName, 0) - 1;

                    if (startGemCount == 0) {
                        gemMap.remove(startGemName);
                    } else {
                        gemMap.put(startGemName, startGemCount);
                    }

                    startIdx++;
                }
            } else {
                if (endIdx < gemLength - 1) {
                    endIdx++;

                    final String endGemName = gems[endIdx];

                    gemMap.put(endGemName, gemMap.getOrDefault(endGemName, 0) + 1);
                } else {
                    final String startGemName = gems[startIdx];

                    final int startGemCount = gemMap.getOrDefault(startGemName, 0) - 1;

                    if (startGemCount == 0) {
                        gemMap.remove(startGemName);
                    } else {
                        gemMap.put(startGemName, startGemCount);
                    }

                    startIdx++;
                }
            }
        }

        return answer;
    }
}
