import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[][] dots) {
        Set<Double> answerSet = new HashSet<>();

        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                double slope = getSlope(dots[i], dots[j]);
                if(answerSet.contains(slope)){
                    return 1;
                }else{
                    answerSet.add(slope);
                }
            }
        }

        return 0;
    }

    private Double getSlope(int[] dot, int[] dot1) {
        return Math.abs((double) (dot[1] - dot1[1]) / (dot[0] - dot1[0]));
    }
}
