package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.canTraverseAllPairs(
                new int[]{2, 3, 6}
        ));
        System.out.println(solution.canTraverseAllPairs(
                new int[]{3, 9, 5}
        ));
        System.out.println(solution.canTraverseAllPairs(
                new int[]{4, 3, 12, 8}
        ));
    }
}

//https://leetcode.com/problems/greatest-common-divisor-traversal/solutions/3569177/java-prime-factors-and-disjoint-set-union-code-with-comments/?envType=daily-question&envId=2024-02-25
class Solution {
    public boolean canTraverseAllPairs(final int[] nums) {
        if (nums.length == 1) return true;

        final Map<Integer, Integer> dsu = new HashMap<>();

        for (final int num : nums) {
            // if num is 1 GCD with any other number will be 1 so return false.
            if (num == 1) return false;

            // Get all unique [pri]
            final Set<Integer> factors = findFactors(num);

            // First time visiting this node, it will be a separate component itself.
            if (!dsu.containsKey(num)) dsu.put(num, num);

            // For all prime factors merge factor and num.
            for (final int factor : factors) {
                // If first time visiting this factor, it will be a separate component itself.
                if (!dsu.containsKey(factor)) dsu.put(factor, factor);

                // merge num and factor in one component.
                union(dsu, num, factor);
            }
        }

        // collect parent of all the components.
        final Set<Integer> components = new HashSet<>();
        for (final int num : nums) {
            components.add(find(dsu, num));
        }

        // if all nodes are part of same component components count will be 1.
        return components.size() == 1;
    }

    // Union operation to merge two components.
    private void union(final Map<Integer, Integer> dsu, final int num1, final int num2) {
        final int p1 = find(dsu, num1);
        final int p2 = find(dsu, num2);

        dsu.put(p1, p2);
    }

    // Find operation to get the parent of DSU node.
    private int find(final Map<Integer, Integer> dsu, final int num) {
        if (dsu.getOrDefault(num, num) != num) {
            dsu.put(num, find(dsu, dsu.get(num)));
        }

        return dsu.getOrDefault(num, num);
    }

    // Method to get all the unique factors of the number.
    private HashSet<Integer> findFactors(int number) {
        final HashSet<Integer> primeFactors = new HashSet<>();

        while (number % 2 == 0) {
            primeFactors.add(2);
            number /= 2;
        }

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                primeFactors.add(i);
                number /= i;
            }
        }

        if (number > 2) {
            primeFactors.add(number);
        }

        return primeFactors;
    }
}
