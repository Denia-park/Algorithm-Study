import java.util.PriorityQueue;

class Solution {
    //두 부모 노드를 합치는 함수
    private static void unionParent(int[] parents, int element1, int element2) {
        int parentOfElem1 = getParent(parents, element1);
        int parentOfElem2 = getParent(parents, element2);

        if (parentOfElem1 == parentOfElem2) return;

        if (parentOfElem1 < parentOfElem2) parents[parentOfElem2] = parentOfElem1;
        else parents[parentOfElem1] = parentOfElem2;
    }

    //부모 노드를 찾는 함수
    private static int getParent(int[] parents, int element) {
        int myParent = parents[element];

        if (myParent == element) return element;

        return parents[element] = getParent(parents, myParent);
    }

    //같은 부모를 가지는지 확인
    private static boolean findParent(int[] parents, int element1, int element2) {
        int parentOfElem1 = getParent(parents, element1);
        int parentOfElem2 = getParent(parents, element2);

        return parentOfElem1 == parentOfElem2;
    }

    public long solution(int tableLength, int[][] tables) {
        long answer = 0;

        int[] parents = new int[tableLength];
        for (int i = 0; i < tableLength; i++) {
            parents[i] = i;
        }

        PriorityQueue<PlanetDistance> pq = new PriorityQueue<PlanetDistance>();

        for (int i = 0; i < tableLength; i++) {
            for (int j = i + 1; j < tableLength; j++) {
                pq.add(new PlanetDistance(getDistance(tables[i], tables[j]), i, j));
            }
        }

        while (!pq.isEmpty()) {
            PlanetDistance planetDistance = pq.poll();
            int planetNum1 = planetDistance.planetNum1;
            int planetNum2 = planetDistance.planetNum2;

            if (!findParent(parents, planetNum1, planetNum2)) {
                unionParent(parents, planetNum1, planetNum2);
                answer += planetDistance.distance;
            }
        }


        return answer;
    }

    int getDistance(int[] coordi1, int[] coordi2) {
        return Math.min(Math.abs(coordi1[0] - coordi2[0]),
                Math.min(Math.abs(coordi1[1] - coordi2[1]),
                        Math.abs(coordi1[2] - coordi2[2])));
    }
}

class PlanetDistance implements Comparable<PlanetDistance> {
    int distance;
    int planetNum1;
    int planetNum2;

    public PlanetDistance(int distance, int planetNum1, int planetNum2) {
        this.distance = distance;
        this.planetNum1 = planetNum1;
        this.planetNum2 = planetNum2;
    }

    @Override
    public int compareTo(PlanetDistance o) {
        return Integer.compare(this.distance, o.distance);
    }
}


