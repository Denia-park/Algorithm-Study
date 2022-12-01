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
    }

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
    }
}
