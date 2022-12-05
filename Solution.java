import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int limit, int[] tangerine) {
        int answer = 0;

        int count = 0;

        Map<Integer, Tangerine> counter = new HashMap<>();

        for (int tangerineNumber : tangerine) {
            Tangerine curTangerine = counter.getOrDefault(tangerineNumber, new Tangerine(tangerineNumber, 0));
            curTangerine.count++;
            counter.put(tangerineNumber, curTangerine);
        }

        List<Tangerine> tangerines = new ArrayList<>(counter.values());

        tangerines.sort(null);

        for (int i = 0; i < tangerines.size(); i++) {
            Tangerine curTangerine = tangerines.get(i);

            int tempCount = curTangerine.count;

            if (tempCount > limit) {
                continue;
            }

            count += tempCount;
            answer++;

            if (count == limit) {
                break;
            }
        }

        return answer;
    }
}

class Tangerine implements Comparable<Tangerine> {
    int number;
    int count;

    public Tangerine(int number, int count) {
        this.number = number;
        this.count = count;
    }

    @Override
    public int compareTo(Tangerine o) {
        return -Integer.compare(this.count, o.count);
    }
}
