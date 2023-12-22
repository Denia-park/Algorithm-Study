package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(final String original) {
        int answer = Integer.MAX_VALUE;

        //stack을 사용해서 같은 단어면 Count 하도록 하면 어떨까 ?
        for (int count = 1; count < original.length(); count++) {
            final Deque<Word> stack = new ArrayDeque<>();
            //처음부터 탐색
            int searchIdx = 0;
            for (; searchIdx <= original.length() - count; searchIdx += count) {
                final String str = original.substring(searchIdx, searchIdx + count);

//                System.out.println("count = " + count + ", searchIdx = " + searchIdx + ", str = " + str);

                if (stack.isEmpty()) {
                    stack.addLast(new Word(str, 1));
                    continue;
                }

                final Word peek = stack.peekLast();

                if (peek.getStr().equals(str)) {
                    peek.increaseCount();
                } else {
                    stack.addLast(new Word(str, 1));
                }
            }

            //마지막 단어 처리
            final String str = original.substring(searchIdx);
            stack.addLast(new Word(str, 1));

            final StringBuilder stringBuilder = new StringBuilder();
            while (!stack.isEmpty()) {
                final Word word = stack.pollFirst();

                if (word.getCount() == 1) {
                    stringBuilder.append(word.getStr());
                } else {
                    stringBuilder.append(word.getCount()).append(word.getStr());
                }
            }

//            System.out.println(stringBuilder);

            answer = Math.min(answer, stringBuilder.toString().length());
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
