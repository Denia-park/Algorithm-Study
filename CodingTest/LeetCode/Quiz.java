package CodingTest.LeetCode;

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

class Solution {
    public boolean canTraverseAllPairs(final int[] nums) {
        //서로 연결되어 있는가 ? -> 유니온-파인드
        final int[] parents = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            parents[i] = i;
        }

        //일단 가능한 조합에 대해서 묶기
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (gcd(nums[i], nums[j]) <= 1) {
                    continue;
                }

                final int parent1 = find(parents, i);
                final int parent2 = find(parents, j);

                parents[Math.max(parent1, parent2)] = Math.min(parent1, parent2);
            }
        }

        //모든 조합에 대해서 부모가 같은지 확인
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                final int parent1 = find(parents, i);
                final int parent2 = find(parents, j);

                if (parent1 != parent2) {
                    return false;
                }
            }
        }

        return true;
    }

    private int find(final int[] parents, final int idx) {
        if (parents[idx] == idx) {
            return idx;
        }

        parents[idx] = find(parents, parents[idx]);

        return parents[idx];
    }

    private int gcd(final int first, final int second) {
        if (first % second == 0) {
            return second;
        } else {
            return gcd(second % first, first);
        }
    }
}
