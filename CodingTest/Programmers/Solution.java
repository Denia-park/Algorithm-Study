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

        final Map<String, Integer> gemMap = new HashMap<>();

        int startIdx = 0;
        int endIdx = -1;

        while (startIdx < gemLength) {
            if (gemMap.size() == gemTypeCount) {
                //모든 보석을 다 구했으니까 answer 계산
                calculateAnswer(startIdx, endIdx);

                if (isNotLastIdx(endIdx, gemLength) && startIdx == endIdx) {
                    endIdx++;

                    addEndGem(gemMap, gems[endIdx]);
                } else {
                    removeStartGem(gemMap, gems[startIdx]);

                    startIdx++;
                }
            } else {
                if (isNotLastIdx(endIdx, gemLength)) {
                    endIdx++;

                    addEndGem(gemMap, gems[endIdx]);
                } else {
                    removeStartGem(gemMap, gems[startIdx]);

                    startIdx++;
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

    private boolean isNotLastIdx(final int endIdx, final int gemLength) {
        return endIdx < gemLength - 1;
    }

    private void addEndGem(final Map<String, Integer> gemMap, final String endGemName) {
        gemMap.put(endGemName, gemMap.getOrDefault(endGemName, 0) + 1);
    }

    private void removeStartGem(final Map<String, Integer> gemMap, final String startGemName) {
        final int startGemCount = gemMap.getOrDefault(startGemName, 0) - 1;

        if (startGemCount == 0) {
            gemMap.remove(startGemName);
        } else {
            gemMap.put(startGemName, startGemCount);
        }
    }
}
