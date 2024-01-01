package CodingTest.Programmers;

import java.util.Arrays;
import java.util.Comparator;

//자리수가 다르면, 짧은 놈의 길이를 기준으로 모든 자리수 비교
//자리수가 같으면, 그냥 값 비교
class Solution {
    public String solution(final int[] numbers) {
        final Comparator<String> comp = (o1, o2) -> {
            //길이가 같으면, 내림차순
            if (o1.length() == o2.length()) {
                return o2.compareTo(o1);
            }

            //길이가 다르면, 짧은 놈의 길이를 기준으로 모든 자리수 비교
            final int minLength = Math.min(o1.length(), o2.length());

            for (int i = 0; i < minLength; i++) {
                final int v1 = o1.charAt(i) - '0';
                final int v2 = o2.charAt(i) - '0';

                if (v1 == v2) continue;

                //내림차순 비교
                return Integer.compare(v2, v1);
            }

            return Integer.compare(o1.length(), o2.length());
        };

        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted(comp)
                .reduce((s1, s2) -> s1 + s2).get();
    }
}
