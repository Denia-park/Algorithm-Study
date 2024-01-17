package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(final int bridgeLength, final int bridgeMaxWeight, final int[] truck_weights) {
        final Deque<Truck> waitQueue = new ArrayDeque<>();
        final Deque<Truck> moveQueue = new ArrayDeque<>();

        for (final int truckWeight : truck_weights) {
            waitQueue.offerLast(new Truck(truckWeight));
        }

        int time = 0;
        int bridgeCurWeight = 0;

        //트럭이 다 지나갈때 까지 반복 (while)
        while (!waitQueue.isEmpty() || !moveQueue.isEmpty()) {
            //시간 흐른다.
            time++;

            //다리가 비었으면, 바로 트럭을 올린다.
            if (moveQueue.isEmpty()) {
                final Truck enterTruck = waitQueue.pollFirst();
                enterTruck.move();

                moveQueue.offerLast(enterTruck);
                bridgeCurWeight += enterTruck.weight;

                continue;
            }

            //모든 트럭들이 이동한다.
            for (final Truck truck : moveQueue) {
                truck.move();
            }

            //다리를 지난 트럭이 있는지 검사
            if (moveQueue.peek().time > bridgeLength) {
                final Truck exitTruck = moveQueue.pollFirst();
                bridgeCurWeight -= exitTruck.weight;
            }

            //다리에 진입할 트럭이 있는지 검사
            final int allowableWeight = bridgeMaxWeight - bridgeCurWeight;
            if (!waitQueue.isEmpty() && waitQueue.peekFirst().weight <= allowableWeight) {
                final Truck enterTruck = waitQueue.pollFirst();
                enterTruck.move();

                moveQueue.offerLast(enterTruck);
                bridgeCurWeight += enterTruck.weight;
            }
        }

        return time;
    }

    private class Truck {
        int weight;
        int time;

        public Truck(final int weight) {
            this.weight = weight;
            this.time = 0;
        }

        void move() {
            time++;
        }
    }
}
