import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int[] line : lines) {
            int tempMin = Math.min(line[0], line[1]);
            int tempMax = Math.max(line[0], line[1]);
            min = Math.min(min, tempMin);
            max = Math.max(max, tempMax);

            for (int i = tempMin; i < tempMax + 1; i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }

        for (int i = min + 1; i < max + 1; i++) {
            if (!map.containsKey(i) || !map.containsKey(i - 1)) continue;

            if (map.get(i - 1) >= 2 && map.get(i) >= 2) {
                answer++;
            }
        }


        return answer;
    }
}
