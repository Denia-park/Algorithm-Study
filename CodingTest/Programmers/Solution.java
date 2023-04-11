package CodingTest.Programmers;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for (int length = 1; length <= elements.length; length++) {
            for (int idx = 0; idx < elements.length; idx++) {
                int tempVal = 0;
                for (int count = 0; count < length; count++) {
                    tempVal += elements[(idx + count) % elements.length];
                }
                set.add(tempVal);
            }
        }

        return set.size();
    }
}
