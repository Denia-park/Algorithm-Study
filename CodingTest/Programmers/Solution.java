package CodingTest.Programmers;

import java.util.*;

class Solution {
    public int[] solution(final String[] operations) {
        final DoublePriQue dq = new DoublePriQue();

        for (final String oper : operations) {
            final String[] split = oper.split(" " );
            final String command = split[0];
            final String number = split[1];

            if (command.equals("I" )) {
                dq.add(Integer.valueOf(number)); // 삽입
            } else {
                if (number.equals("1" )) {
                    dq.delMax(); //최대 값 삭제
                } else {
                    dq.delMin(); //최소 값 삭제
                }
            }
        }

        if (dq.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{
                dq.delMax(),
                dq.delMin(),
        };
    }
}

class DoublePriQue {
    Queue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
    Queue<Integer> minQueue = new PriorityQueue<>();
    Map<Integer, Integer> map = new HashMap<>();

    public void add(final Integer number) {
        maxQueue.add(number);
        minQueue.add(number);

        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public int delMax() {
        //maxQueue의 최대 값을 가져오고, minQueue를 refresh
        final int rtVal = getTopValueFromQueue(maxQueue);
        refreshQueue(minQueue);

        return rtVal;
    }

    public int delMin() {
        //minQueue의 최소 값을 가져오고, maxQueue를 refresh
        final int rtVal = getTopValueFromQueue(minQueue);
        refreshQueue(maxQueue);

        return rtVal;
    }

    private void refreshQueue(final Queue<Integer> queue) {
        //맨위에 존재하는 숫자가 존재하는 숫자 인지 확인
        //존재 하지 않는 숫자면 빼주고, 존재하는 숫자면 refresh 종료
        while (!queue.isEmpty()) {
            final int numCount = map.get(queue.peek());

            if (numCount > 0) {
                break;
            }

            queue.poll();
        }
    }

    private int getTopValueFromQueue(final Queue<Integer> queue) {
        int rtVal = 0;

        //맨위의 값이 존재하는 숫자면, 카운트 1개 빼고 해당 값을 반환
        //맨위의 값이 존재하지 않는 값이면, 존재하는 값이 나올때까지 순환
        while (!queue.isEmpty()) {
            rtVal = queue.poll();
            final int numCount = map.get(rtVal);

            if (numCount > 0) {
                map.put(rtVal, numCount - 1);
                break;
            }
        }

        return rtVal;
    }

    public boolean isEmpty() {
        //모든 값이 존재하지 않으면 empty
        return maxQueue.isEmpty() && minQueue.isEmpty();
    }
}
