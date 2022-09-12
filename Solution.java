package com.company;

// 참고 : https://school.programmers.co.kr/questions/19184

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        //총 이동 수를 저장할 변수 선언
        int moveCount = 0;

        //people 배열을 정렬
        Arrays.sort(people);

        // 정렬한 최소값을 기준으로 하여 limit 에서 해당 값을 뺀 값보다 큰 값들은 어떻게 해도 혼자 배를 타야 하므로
        // 미리 정렬에서 빼준다. 그리고 구한 Index 를 이용하여 이동 수도 미리 구한다.
        //bisectRight ,bisectLeft 는 파이썬에서 사용하는 라이브러리를 참고하여 직접 구현하였다.
        int limitValIndex = bisectRight(people, limit - people[0]);

        //limitValIndex 를 이용하여 moveCount 를 구함
        moveCount += people.length - limitValIndex;

        //최소값 과 최대값을 구하고 빼줘야 하므로 Deque 를 이용한다.
        Deque<Integer> deque = new LinkedList<>();

        //아까 구한 limitValIndex 이용하여 확인해야하는 people 배열만을 구한다.
        int[] newPeople = Arrays.copyOfRange(people, 0, limitValIndex);

        //deque 에 필요한 값들을 추가한다.
        for (int newPerson : newPeople) {
            deque.add(newPerson);
        }

        //deque 가 빌 때까지 해당 로직을 수행한다.
        while(!deque.isEmpty()){
            //마지막 값 = 제일 무거운 사람
            int lastVal = deque.pollLast();

            //제일 무거운 사람 과 제일 가벼운 사람을 더했을때 limit 보다 작으면 가벼운 사람도 같이 보트를 태워 보낸다.
            //제일 가벼운 사람이 보트를 타지 못하는 경우에는 제일 무거운 사람만 태워 보낸다.
            //이렇게 로직이 가능한 이유는 보트가 작아서 최대 2명씩만 탈 수 있기 때문이다.
            if(!deque.isEmpty() && lastVal + deque.peekFirst() <= limit){
                deque.pollFirst();
            }

            moveCount++;
        }

        return moveCount;
    }

    public int bisectLeft(int[] people, int targetValue) {
        int start = 0;
        int end = people.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if(targetValue <= people[mid]) {
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return end;
    }

    public int bisectRight(int[] people, int targetValue) {
        int start = 0;
        int end = people.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if(targetValue < people[mid]) {
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return end;
    }
}

