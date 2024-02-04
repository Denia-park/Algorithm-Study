package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println((solution.minWindow("ADOBECODEBANC", "ABC")));
        System.out.println((solution.minWindow("a", "a")));
        System.out.println((solution.minWindow("a", "aa")));
        System.out.println((solution.minWindow("ab", "a")));
        System.out.println((solution.minWindow("cabefgecdaecf", "cae")));
        System.out.println((solution.minWindow("cab", "ab")));
    }
}

class Solution {
    public String minWindow(final String s, final String t) {
        // ASCII 문자를 위한 해시맵 역할을 하는 정수 배열을 초기화합니다.
        final int[] map = new int[128];

        // 문자열 t에 포함된 문자의 수를 세기 위한 변수입니다.
        int count = t.length();

        // 슬라이딩 윈도우의 시작점과 끝점, 최소 길이, 그리고 최소 길이를 가지는 시작 인덱스를 초기화합니다.
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;

        // 문자열 t에 포함된 각 문자에 대해 map 배열의 해당 문자 위치의 값을 증가시킵니다.
        for (final char c : t.toCharArray()) {
            map[c] += 1;
        }

        // 문자열 s를 char 배열로 변환합니다.
        final char[] chS = s.toCharArray();

        // 문자열 s를 끝까지 탐색합니다.
        while (end < chS.length) {
            // 현재 end 위치의 문자가 t에 포함되어 있다면 count를 감소시킵니다.
            if (map[chS[end]] > 0) {
                count -= 1;
            }
            map[chS[end]] -= 1;
            end += 1;

            // 필요한 모든 문자가 윈도우에 포함된 경우
            while (count == 0) {
                // 현재 윈도우의 길이가 이전에 찾은 최소 길이보다 작다면, 최소 길이와 시작 인덱스를 업데이트합니다.
                if ((end - start) < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                // start 위치의 문자를 다시 윈도우 밖으로 이동시키면서 해당 문자의 map 값을 증가시킵니다.
                if (map[chS[start]] == 0) {
                    count += 1;
                }
                map[chS[start]] += 1;
                start += 1;
            }
        }

        // 최소 길이가 갱신되지 않았다면, t의 모든 문자를 포함하는 부분 문자열을 찾지 못한 것이므로 빈 문자열을 반환합니다.
        // 그렇지 않다면, 최소 길이의 부분 문자열을 반환합니다.
        return minLen == Integer.MAX_VALUE ? "" :
                new String(chS, startIndex, minLen);
    }
}
