import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    final String EMPTY = "0";
    final String HOUSE = "1";
    final String CHICK = "2";

    List<House> houses;

    int minValue;

    int gChickLimit;

    public int solution(int tableSize, int chickLimit, String[][] tables) {
        houses = new ArrayList<>();
        minValue = Integer.MAX_VALUE;
        gChickLimit = chickLimit;

        List<Chick> chicks = new ArrayList<>();

        for (int r = 0; r < tableSize; r++) {
            for (int c = 0; c < tableSize; c++) {
                if (tables[r][c].equals(EMPTY)) {
                    continue;
                }

                if (tables[r][c].equals(HOUSE)) {
                    houses.add(new House(r, c));
                } else if (tables[r][c].equals(CHICK)) {
                    chicks.add(new Chick(r, c));
                }
            }
        }

        Deque<Chick> deque = new LinkedList<>();
        combination(chicks, deque, 0);

        return minValue;
    }

    private void combination(List<Chick> chicks, Deque<Chick> aliceChicks, int startIdx) {
        if (aliceChicks.size() >= gChickLimit) {
            minValue = Math.min(minValue, calculateCityChickDistance(aliceChicks));
            return;
        }

        for (int curIdx = startIdx; curIdx < chicks.size(); curIdx++) {
            aliceChicks.addLast(chicks.get(curIdx));
            combination(chicks, aliceChicks, curIdx + 1);
            aliceChicks.pollLast();
        }
        if (summary <= k) return -1;

<<<<<<< HEAD
        // 시간이 작은 음식부터 빼야 하므로 우선순위 큐를 이용
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            // (음식 시간, 음식 번호) 형태로 우선순위 큐에 삽입
            pq.offer(new Food(food_times[i], i + 1));
        }

        summary = 0; // 먹기 위해 사용한 시간
        long previous = 0; // 직전에 다 먹은 음식 시간
        long length = food_times.length; // 남은 음식의 개수

        // summary + (현재의 음식 시간 - 이전 음식 시간) * 현재 음식 개수와 k 비교
        while (summary + ((pq.peek().getTime() - previous) * length) <= k) {
            int now = pq.poll().getTime();
            summary += (now - previous) * length;
            length -= 1; // 다 먹은 음식 제외
            previous = now; // 이전 음식 시간 재설정
        }

        // 남은 음식 중에서 몇 번째 음식인지 확인하여 출력
        ArrayList<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        // 음식의 번호 기준으로 정렬
        Collections.sort(result, new Comparator<Food>() {
            @Override
            public int compare(Food a, Food b) {
                return Integer.compare(a.getIndex(), b.getIndex());
            }
        });
        return result.get((int) ((k - summary) % length)).getIndex();
=======
    private int calculateCityChickDistance(Deque<Chick> aliceChicks) {
        int totalDistance = 0;
        for (House house : houses) {
            int minDistance = Integer.MAX_VALUE;

            for (Chick chick : aliceChicks) {
                minDistance = Math.min(minDistance, calculateDistance(chick, house));
            }
            totalDistance += minDistance;
        }

        return totalDistance;
    }

    int calculateDistance(Chick chick, House house) {
        return Math.abs(chick.r - house.r) + Math.abs(chick.c - house.c);
    }
}

class House {
    int r;
    int c;

    public House(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Chick {
    int r;
    int c;

    public Chick(int r, int c) {
        this.r = r;
        this.c = c;
>>>>>>> 백준
    }
}
