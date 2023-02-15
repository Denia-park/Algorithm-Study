package CodingTest.Programmers;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        Set<Character> set = new HashSet<>();

        for (Character c : skip.toCharArray()) {
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();

        for (char i = 'a'; i <= 'z'; i++) {
            if (!set.contains(i)) {
                sb.append(i);
            }
        }

        String checkString = sb.toString().repeat(3);

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);

            answer.append(checkString.charAt(checkString.indexOf(curChar) + index));
        }


        return answer.toString();
    }
}
