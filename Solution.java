package com.company;

import java.util.*;

class Solution {
    // 각 노드들의 거리 정보를 저장한 2중 List
    List<List<DeliverNode>> graph;
    //시작 노드를 기준으로 거리를 저장할 int 배열
    int[] roadLengthArrFromStartNode;
    public int solution(int villageNum, int[][] roadInfoArr, int targetTime) {
        //배달 가능한 거리를 셀 때 필요한 answer
        int answer = 0;
        //graph 초기화
        graph = new ArrayList<>();
        //배열 초기화 , 값을 쉽게 확인하기 위해 기존 사이즈보다 + 1 처리
        roadLengthArrFromStartNode = new int[villageNum + 1];
        //처음에 거리는 무조건 INF 로 설정하기 , INF 는 int의 최대값
        final int INF = Integer.MAX_VALUE;
        //기본 거리를 최대로 설정
        Arrays.fill(roadLengthArrFromStartNode, INF);

        //일부러 사이즈 1개 크게 제작
        //graph 내부 에 들어갈 List들을 초기화 후 할당
        for (int i = 0; i < villageNum + 1; i++) {
            graph.add(new ArrayList<>());
        }

        //노드끼리의 거리 데이터를 저장할 for문
        for (int[] roadInfo : roadInfoArr) {
            int start = roadInfo[0];
            int dest = roadInfo[1];
            int roadLength = roadInfo[2];
            //양쪽에 모두 넣기.
            graph.get(start).add(new DeliverNode(dest, roadLength));
            graph.get(dest).add(new DeliverNode(start, roadLength));
        }
        
        //다익스트라 알고리즘 수행 , 시작 노드는 1번 노드
        dijkstra(1);

        //다익스트라 알고리즘 수행 후 업데이트가 완료된 거리 정보 Arr를 사용해서 answer 구하기.
        for (int deliverTime : roadLengthArrFromStartNode) {
            if (deliverTime <= targetTime)
                answer++;
        }

        return answer;
    }

    //시작할 startNodeNum 을 받고 거기서 시작할때를 경우로 잡고 Node를 추가하자
    private void dijkstra(int startNodeNum) {
        //다익스트라에서 PriorityQueue 를 사용
        PriorityQueue<DeliverNode> pq = new PriorityQueue<>();
        //PriorityQueue에 시작점의 노드를 추가, 그리고 시작점에서 시작점까지의 거리는 0
        pq.add(new DeliverNode(startNodeNum, 0));
        //거리 정보를 global Array 에 업데이트
        roadLengthArrFromStartNode[startNodeNum] = 0;

        //while 문으로 pq가 빌때까지 거리 정보를 global Array 에 업데이트
        while (!pq.isEmpty()) {
            //pq에 들어있는 Node 하나를 꺼냄
            DeliverNode tempNode= pq.poll();
            //Node가 가지고 있는 목적지 정보
            int nodeDestination = tempNode.getDestination();
            //Node가 가지고 있는 목적지까지의 거리
            int existDistance = tempNode.getDistance();

            //기존에 있는 거리가 이번 Node의 거리보다 더 빠르다면, 선발대가 이미 훑고 지나갔으므로 확인할 필요가 X => continue
            if(existDistance > roadLengthArrFromStartNode[nodeDestination]) continue;

            //nodeDestination 을 기준으로 해당 Node랑 연결되어 있는 Node들을 확인 후,
            //해당 Node까지와의 거리 정보가 업데이트 된다면 pq에 해당 Node를 넣자.
            for (int i = 0; i < graph.get(nodeDestination).size(); i++){
                //현재 노드와 nodeDestination 까지의 거리
                int distanceFromCurToNextDestination = graph.get(nodeDestination).get(i).getDistance();
                //다음 목적지 노드
                int nextDestination = graph.get(nodeDestination).get(i).getDestination();
                //기존 거리 정보 보다 지금까지의 거리 + nodeDestination 까지의 거리가 더 짧다면 업데이트를 실행
                if(existDistance + distanceFromCurToNextDestination < roadLengthArrFromStartNode[nextDestination]){
                    //거리 정보 업데이트
                    roadLengthArrFromStartNode[nextDestination] = existDistance + distanceFromCurToNextDestination;
                    //PriorityQueue 에 Node 추가
                    pq.add(new DeliverNode(nextDestination, existDistance + distanceFromCurToNextDestination));
                }
            }
        }
    }
}

class DeliverNode implements Comparable<DeliverNode>{
    int destination;//다음 목적지 Node
    int distance;//해당 목적지까지의 거리

    public DeliverNode(int destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }

    public int getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    //PriorityQueue 에 넣기 위해서는 Comparable를 구현해야함.
    //거리가 짧을 수록 우선순위가 높게 설정
    @Override
    public int compareTo(DeliverNode o) {
        return this.getDistance() - o.getDistance();
    }
}
