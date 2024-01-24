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
    int[] answer;
    int answerLength;

    public int[] solution(final String[] gems) {
        answer = new int[2];
        answerLength = Integer.MAX_VALUE;

        final int gemTypeCount = new HashSet<>(List.of(gems)).size();
        final int gemLength = gems.length;

        final Map<String, Integer> gemCountMap = new HashMap<>();

        int startIdx = 0;
        int endIdx = -1;

        while (endIdx < gemLength) {
            //모든 보석이 다 포함됨
            if (gemCountMap.size() == gemTypeCount) {
                //answer 계산
                calculateAnswer(startIdx, endIdx);

                //보석을 빼면서 더 짧은 길이를 구한다.
                removeStartGem(gemCountMap, gems[startIdx]);
                startIdx++;
            } else {
                //보석을 추가하면서 모든 보석이 다 포함되는 경우를 구한다.
                endIdx++;
                if (endIdx < gemLength) {
                    addEndGem(gemCountMap, gems[endIdx]);
                }
            }
        }

        return answer;
    }

    private void calculateAnswer(final int startIdx, final int endIdx) {
        final int tempGemCount = endIdx - startIdx + 1;

        if (tempGemCount < answerLength) {
            answerLength = tempGemCount;

            answer[0] = startIdx + 1;
            answer[1] = endIdx + 1;
        }
    }

    private void addEndGem(final Map<String, Integer> gemMap, final String endGemName) {
        gemMap.put(endGemName, gemMap.getOrDefault(endGemName, 0) + 1);
    }

    private void removeStartGem(final Map<String, Integer> gemMap, final String startGemName) {
        final int startGemCount = gemMap.getOrDefault(startGemName, 0) - 1;

        if (startGemCount == 0) {
            gemMap.remove(startGemName);
            return;
        }

        gemMap.put(startGemName, startGemCount);
    }
}
