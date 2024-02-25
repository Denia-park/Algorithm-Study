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
        final int length = nums.length;
        final int[] parents = new int[length];
        for (int i = 0; i < length; i++) {
            parents[i] = i;
        }

        //일단 가능한 조합에 대해서 묶기
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (gcd(nums[i], nums[j]) <= 1) {
                    continue;
                }

                final int parent1 = find(parents, i);
                final int parent2 = find(parents, j);

                parents[Math.max(parent1, parent2)] = Math.min(parent1, parent2);
            }
        }

        //모든 조합에 대해서 부모가 같은지 확인
        final int saveParent = find(parents, 0);

        for (int i = 1; i < length; i++) {
            if (saveParent != find(parents, i)) {
                return false;
            }
        }

        return true;
    }

    private int find(final int[] parents, int idx) {
        while (parents[idx] != idx) {
            idx = parents[idx];
        }

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
