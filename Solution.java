import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int limit, int[] tangerine) {
        int answer = 0;

        int count = 0;

        Map<Integer, Integer> counter = new HashMap<>();

        for (int tangerineNumber : tangerine) {
            int curTangerine = counter.getOrDefault(tangerineNumber, 0);
            curTangerine++;
            counter.put(tangerineNumber, curTangerine);
        }
        List<Integer> tangerines = new ArrayList<>(counter.keySet());

        tangerines.sort((a, b) -> counter.get(b) - counter.get(a));

        for (Integer keyIdx : tangerines) {
            count += counter.get(keyIdx);
            answer++;

            if (count >= limit) {
                break;
            }
        }

        return answer;
    }
}
