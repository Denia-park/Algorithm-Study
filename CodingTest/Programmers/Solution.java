package CodingTest.Programmers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(final String[] operations) {
        final DoublePriQue dq = new DoublePriQue();

        for (final String oper : operations) {
            final String[] split = oper.split(" " );
            final String command = split[0];
            final String number = split[1];

            if (command.equals("I" )) {
                dq.add(Integer.valueOf(number));
            } else {
                //최대 값 삭제
                if (number.equals("1" )) {
                    dq.delMax();
                }
                //최소 값 삭제
                else {
                    dq.delMin();
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
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    Map<Integer, Integer> map = new HashMap<>();

    public void add(final Integer number) {
        maxQueue.add(number);
        minQueue.add(number);

        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public int delMax() {
        int rtVal = -1;

        while (!maxQueue.isEmpty()) {
            rtVal = maxQueue.poll();
            final Integer numCount = map.get(rtVal);

            if (numCount > 0) {
                map.put(rtVal, numCount - 1);
                break;
            }
        }

        while (!minQueue.isEmpty()) {
            final int tempTop = minQueue.peek();

            final Integer numCount = map.get(tempTop);

            if (numCount > 0) {
                break;
            }

            minQueue.poll();
        }

        return rtVal;
    }

    public int delMin() {
        int rtVal = -1;

        while (!minQueue.isEmpty()) {
            rtVal = minQueue.poll();
            final Integer numCount = map.get(rtVal);

            if (numCount > 0) {
                map.put(rtVal, numCount - 1);
                break;
            }
        }

        while (!maxQueue.isEmpty()) {
            final int tempTop = maxQueue.peek();

            final Integer numCount = map.get(tempTop);

            if (numCount > 0) {
                break;
            }

            maxQueue.poll();
        }

        return rtVal;
    }

    public boolean isEmpty() {
        return maxQueue.isEmpty() && minQueue.isEmpty();
    }
}
