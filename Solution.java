import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        int max = sides[sides.length - 1];

        int restLength = sides[0] + sides[1];
        return restLength <= max ? 2 : 1;
    }
}
