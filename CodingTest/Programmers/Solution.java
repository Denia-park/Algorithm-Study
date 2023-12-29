package CodingTest.Programmers;

import java.util.*;

class Solution {
    public int solution(final String[] user_id, final String[] banned_id) {
        final Set<String> answerSet = new HashSet<>();

        //banId에 맞는 후보(Set<String>)를 구하기 위해서 Map 초기화
        final Map<Integer, Set<String>> digitCandidateMap = initMap(banned_id);

        //banId에 해당할 수 있는 모든 userId 목록 구하기
        findAllCandidateForBanId(user_id, banned_id, digitCandidateMap);


        //가능한 BanId 조합 구하기
        final ArrayDeque<String> permutationSaveDeque = new ArrayDeque<>();
        getIdPermutation(answerSet, digitCandidateMap, 0, permutationSaveDeque);

        return answerSet.size();
    }

    private Map<Integer, Set<String>> initMap(final String[] banned_id) {
        final Map<Integer, Set<String>> digitCandidateMap = new HashMap<>();
        for (int i = 0; i < banned_id.length; i++) {
            digitCandidateMap.put(i, new HashSet<>());
        }
        return digitCandidateMap;
    }

    private void findAllCandidateForBanId(final String[] user_id, final String[] banned_id, final Map<Integer, Set<String>> digitCandidateMap) {
        for (int banIdx = 0; banIdx < banned_id.length; banIdx++) {
            final String banId = banned_id[banIdx];

            final Set<String> digitCandidate = digitCandidateMap.get(banIdx);

            //모든 userId랑 비교하기
            for (final String userId : user_id) {
                //userId가 후보가 되는지 확인하기

                //길이가 다르면 후보가 될 수 없다.
                if (userId.length() != banId.length()) continue;

                //각 자리수를 비교해서 *이 아닌 경우에는 같아야 한다.
                boolean isCandidate = true;

                for (int digitIdx = 0; digitIdx < userId.length(); digitIdx++) {
                    final char banIdChar = banId.charAt(digitIdx);
                    final char userIdChar = userId.charAt(digitIdx);

                    // *인 경우는 무시
                    if (banIdChar == '*') continue;

                    // *이 아닌 경우에는 같아야 한다.
                    if (userIdChar != banIdChar) {
                        isCandidate = false;
                        break;
                    }
                }

                if (isCandidate) {
                    digitCandidate.add(userId);
                }
            }
        }
    }

    private void getIdPermutation(final Set<String> answerSet, final Map<Integer, Set<String>> banTargetIdMap, final int curIdx, final ArrayDeque<String> permutationSaveDeque) {
        //가능한 조합을 끝까지 찾은 경우
        if (curIdx == banTargetIdMap.size()) {
            final String combinationString = permutationSaveDeque.stream()
                    .sorted()
                    .reduce((a, b) -> a + b).get();

            answerSet.add(combinationString);

            return;
        }

        final Set<String> candidates = banTargetIdMap.get(curIdx);

        for (final String candidate : candidates) {
            if (permutationSaveDeque.contains(candidate)) continue;

            permutationSaveDeque.addLast(candidate);
            getIdPermutation(answerSet, banTargetIdMap, curIdx + 1, permutationSaveDeque);
            permutationSaveDeque.pollLast();
        }
    }
}
