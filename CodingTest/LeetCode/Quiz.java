package CodingTest.LeetCode;

import java.util.*;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(
                solution.findLeastNumOfUniqueInts(
                        new int[]{5, 5, 4}, 1
                )
        );
        System.out.println(
                solution.findLeastNumOfUniqueInts(
                        new int[]{4, 3, 1, 1, 3, 3, 2}, 3
                )
        );
    }
}

class Solution {
    public int findLeastNumOfUniqueInts(final int[] arr, int k) {
        final Map<Integer, Num> countMap = new HashMap<>();
        for (final int val : arr) {
            final Num num = countMap.getOrDefault(val, new Num(val));
            num.up();

            countMap.put(val, num);
        }

        final List<Num> list = new ArrayList<>(countMap.values());
        list.sort(Comparator.comparingInt((Num n) -> n.count));

        int answer = 0;
        for (final Num num : list) {
            final int count = num.count;

            if (count <= k) {
                k -= count;
            } else {
                answer++;
            }
        }

        return answer;
    }

    static class Num {
        int val;
        int count;

        Num(final int val) {
            this.val = val;
            this.count = 0;
        }

        void up() {
            this.count++;
        }
    }
}
