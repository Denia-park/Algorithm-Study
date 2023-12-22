package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(final String original) {
        int answer = Integer.MAX_VALUE;

        //길이가 1이면 바로 1을 리턴하자.
        if (original.length() == 1) {
            return 1;
        }

        //Deque를 사용해서 방금 추가한 단어가 같은 단어면 Count 하자.
        for (int count = 1; count < original.length(); count++) {
            final Deque<Word> deque = new ArrayDeque<>();

            //처음부터 탐색
            int searchIdx = 0;
            for (; searchIdx <= original.length() - count; searchIdx += count) {
                //단어로 자르기
                final String str = original.substring(searchIdx, searchIdx + count);

                //deque가 비어있으면 추가
                if (deque.isEmpty()) {
                    deque.addLast(new Word(str, 1));
                    continue;
                }

                final Word peek = deque.peekLast();

                //마지막에 추가한 단어랑 같으면 count를 증가시키자.
                //다르면 새로운 단어로 추가하자.
                if (peek.getStr().equals(str)) {
                    peek.increaseCount();
                } else {
                    deque.addLast(new Word(str, 1));
                }
            }

            //마지막 단어 처리
            final String str = original.substring(searchIdx);
            deque.addLast(new Word(str, 1));

            //문자열 길이를 구해준다.
            final StringBuilder stringBuilder = new StringBuilder();
            for (final Word word : deque) {
                if (word.getCount() == 1) {
                    stringBuilder.append(word.getStr());
                } else {
                    stringBuilder.append(word.getCount()).append(word.getStr());
                }
            }

            //문자열 길이를 기존의 값과 비교한다.
            answer = Math.min(answer, stringBuilder.length());
        }

        return answer;
    }

    class Word {
        private final String str;
        private int count;

        public Word(final String str, final int count) {
            this.str = str;
            this.count = count;
        }

        public void increaseCount() {
            this.count++;
        }

        public String getStr() {
            return str;
        }

        public int getCount() {
            return count;
        }
    }
}
