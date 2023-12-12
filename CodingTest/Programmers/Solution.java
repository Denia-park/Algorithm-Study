package CodingTest.Programmers;

import java.util.*;

class Solution {
    private Set<String> wordSet;
    private Map<Integer, Set<String>> digitCharMap;
    private String gTarget;
    private int answer;

    public int solution(final String begin, final String target, final String[] words) {
        answer = 1_000_000_000;

        gTarget = target;
        //words를 set으로 저장
        wordSet = new HashSet<>();
        digitCharMap = new HashMap<>();
        for (final String word : words) {
            for (int i = 0; i < word.length(); i++) {
                final Set<String> characterSet = digitCharMap.getOrDefault(i, new HashSet<>());
                characterSet.add(String.valueOf(word.charAt(i)));
                digitCharMap.put(i, characterSet);
            }

            wordSet.add(word);
        }

        //words에 target이 없으면 0 반환
        if (!wordSet.contains(target)) {
            return 0;
        }

        //확인한 단어들도 set으로 관리 -> 그래야 2중 변환을 하지 않음.
        bfs(new Word(begin, 0));

        return answer;
    }

    private void bfs(final Word startWord) {
        final Deque<Word> dq = new ArrayDeque<>();
        dq.add(startWord);
        final Set<String> convertedWordSet = new HashSet<>();
        convertedWordSet.add(startWord.word);

        while (!dq.isEmpty()) {
            final Word tempWord = dq.pollFirst();
            final String checkWord = tempWord.word;
            final int count = tempWord.count;

            if (checkWord.equals(gTarget)) {
                answer = Math.min(answer, count);
                return;
            }

            for (int idx = 0; idx < checkWord.length(); idx++) {
                final Set<String> characters = digitCharMap.get(idx);

                for (final String st : characters) {
                    final StringBuilder sb = new StringBuilder(checkWord);
                    //new String 만들기
                    final String newString = sb.replace(idx, idx + 1, st).toString();

                    if (convertedWordSet.contains(newString)) {
                        continue;
                    }

                    //new String이 wordSet에 잇는지 확인, 없으면 넘어감
                    if (!wordSet.contains(newString)) {
                        continue;
                    }

                    //변환 목록에 추가
                    convertedWordSet.add(newString);

                    dq.add(new Word(newString, count + 1));
                }
            }
        }
    }

    private class Word {
        private final String word;
        private final int count;

        public Word(final String word, final int count) {
            this.word = word;
            this.count = count;
        }
    }
}
