package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(final int bridgeLength, final int bridgeMaxWeight, final int[] truck_weights) {
        final int truckTotalCount = truck_weights.length;

        int time = 0;
        int truckCount = 0;
        int bridgeCurWeight = 0;
        int enterTruckIdx = 0;

        final Deque<Truck> bridge = new ArrayDeque<>();

        //트럭이 다 지나갈때 까지 반복 (while)
        while (truckCount != truckTotalCount) {
            //다리를 지난 트럭이 있는지 검사
            while (!bridge.isEmpty()) {
                final Truck frontTruck = bridge.peek();
                frontTruck.move();

                if (frontTruck.time < bridgeLength) {
                    break;
                }

                bridge.pollFirst();
                bridgeCurWeight -= frontTruck.weight;
                truckCount++;
            }

            //다리에 진입할 트럭이 있는지 검사
            if (bridge.size() != bridgeLength && enterTruckIdx < truckTotalCount) {
                final Truck enterTruck = new Truck(truck_weights[enterTruckIdx], 0);

                if (enterTruck.weight <= (bridgeMaxWeight - bridgeCurWeight)) {
                    bridge.offerLast(enterTruck);

                    bridgeCurWeight += enterTruck.weight;
                    enterTruckIdx++;
                }
            }

            //시간 흐른다.
            time++;
        }

        //  매 초 마다 다리 위의 트럭이 다 지나갔는지 체크 (Queue 사용)
        return time;
    }

    private class Truck {
        int weight;
        int time;

        public Truck(final int weight, final int time) {
            this.weight = weight;
            this.time = time;
        }

        void move() {
            time++;
        }
    }
}
