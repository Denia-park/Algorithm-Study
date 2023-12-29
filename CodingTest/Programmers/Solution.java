package CodingTest.Programmers;

import java.util.*;

class Solution {
    public int solution(final String[] user_id, final String[] banned_id) {
        final Set<String> answerSet = new HashSet<>();
        final List<String> userIdList = Arrays.asList(user_id);

        //각 자리수에 들어갈 수 있는 알파벳 및 숫자 추가
        final Map<Integer, Set<String>> digitCharMap = new HashMap<>();

        for (final String id : user_id) {
            for (int i = 0; i < id.length(); i++) {
                final char ch = id.charAt(i);

                final Set<String> set = digitCharMap.getOrDefault(i, new HashSet<>());
                set.add(String.valueOf(ch));
                digitCharMap.put(i, set);
            }
        }

        //ban에 각 요소에 맞는 Id를 찾아서 저장
        final Map<Integer, List<String>> banTargetIdMap = new HashMap<>();
        for (int i = 0; i < banned_id.length; i++) {
            banTargetIdMap.put(i, new ArrayList<>());
        }

        for (int banIdIdx = 0; banIdIdx < banned_id.length; banIdIdx++) {
            final String badId = banned_id[banIdIdx];
            //banId 길이만큼 문자열이 만들어 지면, 존재하는지 확인하고 List에 저장
            final Deque<String> queue = new ArrayDeque<>();
            queue.addLast("");

            while (!queue.isEmpty()) {
                String currentId = queue.pollFirst();
                final int curIdLength = currentId.length();

                if (curIdLength == badId.length()) {
                    //해당 아이디가 실제로 존재하는 아이디 인지 확인
                    if (userIdList.contains(currentId)) {
                        banTargetIdMap.get(banIdIdx).add(currentId);
                    }

                    continue;
                }

                final char curChar = badId.charAt(curIdLength);

                if (curChar != '*') {
                    currentId += curChar;
                    queue.addLast(currentId);
                    continue;
                }

                for (final String ch : digitCharMap.get(curIdLength)) {
                    queue.addLast(currentId + ch);
                }
            }
        }

        //아이디는 중복될 수 없다.
        getIdPermutation(answerSet, banTargetIdMap, 0, "");

        return answerSet.size();
    }

    private void getIdPermutation(final Set<String> answerSet, final Map<Integer, List<String>> banTargetIdMap, final int curIdx, final String curStr) {
        if (curIdx == banTargetIdMap.size()) {
            final char[] charArray = curStr.toCharArray();
            Arrays.sort(charArray);

            answerSet.add(String.valueOf(charArray));

            return;
        }

        final List<String> ithStrings = banTargetIdMap.get(curIdx);

        for (final String ithStr : ithStrings) {
            if (Arrays.asList(curStr.split(",")).contains(ithStr)) continue; //이미 선택된 아이디인 경우 (중복 불가)

            getIdPermutation(answerSet, banTargetIdMap, curIdx + 1, curStr + ',' + ithStr);
        }
    }
}
