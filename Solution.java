package com.company;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //초를 계산할 answer
        int answer = 0;
        //총 몇대의 트럭이 지나가야하는지 변수 설정
        int truckTotalNum = truck_weights.length;
        //다리 위에 얼마만큼의 무게가 실려있는지 변수 설정
        int weightOnBridge = 0;
        // 대기 트럭 , 다리를 건너는 트럭 , 다리를 지난 트럭 모두 Queue를 구현한 LinkedList를 사용하여 변수 설정
        Queue<Truck> waitQueue = new LinkedList<>();
        Queue<Truck> bridgeQueue = new LinkedList<>();
        Queue<Truck> completeQueue = new LinkedList<>();

        //truck_weights 의 원소들을 waitQueue에 모두 삽입
        for (int truckWeight : truck_weights) {
            waitQueue.add(new Truck(truckWeight));
        }

        //completeQueue 가 truckTotalNum 의 수에 도달하면 모든 트럭이 지나갔으므로 while문 종료
        while (completeQueue.size() < truckTotalNum) {
            //1. 도로에서 빠져나가기
                //bridgeQueue에 원소가 존재하고 , bridgeQueue의 맨 앞의 원소가 다리를 건넌 시점일때 [맨 앞의 차부터 차례차례 건너야 하므로 peek()를 사용]
                //bridgeQueue에서 completeQueue 로 이동
                //다리 위의 무게에서도 트럭의 무게 만큼 빼준다.
            if(!bridgeQueue.isEmpty() && bridgeQueue.peek().getDistance() >= bridge_length){
                //bridgeQueue 에서 completeQueue 로 원소를 이동
                Truck completedTruck = bridgeQueue.poll();
                completeQueue.add(completedTruck);
                //다리 위의 무게에서도 트럭의 무게 만큼 빼준다.
                weightOnBridge -= completedTruck.getWeight();
            }

            //2. 도로에 진입하기
                //한번에 한대씩만 들어갈 수 있으므로 bridgeQueue.size() + 1 <= bridgelength 로 계산을 했다.
                //waitQueue가 비어있지 않고 weightOnBridge에 이번에 들어올 원소의 무게를 더했을때 weight를 넘지 않는 경우에만
                //트럭을 waitQueue 에서 bridgeQueue 로 이동
            if ((bridgeQueue.size() + 1 <= bridge_length) && !waitQueue.isEmpty() && (weightOnBridge + waitQueue.peek().getWeight() <= weight)) {
                //waitQueue 에서 bridgeQueue 로 원소를 이동
                Truck completedTruck = waitQueue.poll();
                bridgeQueue.add(completedTruck);
                //다리 위의 무게에 트럭의 무게 만큼 더한다.
                weightOnBridge += completedTruck.getWeight();
            }

            //3. 도로에 존재하는 트럭들 모두 1칸씩 이동하기.
            if(!bridgeQueue.isEmpty()){
                for (Truck truck : bridgeQueue) {
                    truck.moving();
                }
            }

            //while문이 1번 돌때마다 answer를 증가시켜 1초가 지났음을 표시
            answer++;
        }

        //모든 트럭이 길을 지났으므로 answer를 return
        return answer;
    }
}

class Truck {
    int weight; // 트럭 무게
    int distance; // 트럭 거리

    // 트럭이 이동함을 표시
    public void moving() {
        this.distance++;
    }

    //트럭 생성자
    public Truck(int weight) {
        this.weight = weight;
        this.distance = 0;
    }

    public int getWeight() {
        return weight;
    }

    public int getDistance() {
        return distance;
    }
}
