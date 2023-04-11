package CodingTest.Programmers;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int[] newElements = new int[elements.length * 2];

        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
            newElements[i + elements.length] = elements[i];
        }

        Set<Integer> set = new HashSet<>();

        for (int length = 1; length <= elements.length; length++) {
            for (int idx = 0; idx < elements.length; idx++) {
                int tempVal = 0;
                for (int count = 0; count < length; count++) {
                    tempVal += newElements[idx + count];
                }
                set.add(tempVal);
            }
        }

        return set.size();
    }
}
