package CodingTest.LeetCode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.findDifferentBinaryString(new String[]{"01", "10"}));
        System.out.println(solution.findDifferentBinaryString(new String[]{"111", "011", "001"}));
    }
}

class Solution {

    private Set<String> stringSet;
    private int length;
    private String answer;

    public String findDifferentBinaryString(final String[] nums) {
        stringSet = Arrays.stream(nums)
                .collect(Collectors.toSet());

        length = nums.length;

        dfs("");

        return answer;
    }

    private void dfs(final String str) {
        if (answer != null) {
            return;
        }

        if (str.length() == length) {
            if (!stringSet.contains(str)) {
                answer = str;
                return;
            } else {
                return;
            }
        }

        dfs(str + "0");

        dfs(str + "1");
    }
}
