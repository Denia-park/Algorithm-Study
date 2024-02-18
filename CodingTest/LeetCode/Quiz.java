package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(
                solution.mostBooked(
                        2,
                        BracketUtil.convertStrToIntArr(
                                "[[0,10],[1,5],[2,7],[3,4]]"
                        )
                )
        );
        System.out.println(
                solution.mostBooked(
                        3,
                        BracketUtil.convertStrToIntArr(
                                "[[1,20],[2,10],[3,5],[4,9],[6,8]]"
                        )
                )
        );
    }
}

class Solution {
    public int mostBooked(final int n, final int[][] meetings) {
        //현재 사용중인 방을 우선순위 큐로 다룬다
        //빨리 끝나는 순으로 정렬이 되도록 한다.
        final PriorityQueue<Room> pq = new PriorityQueue<>(
                Comparator.comparingInt(Room::getEndTime)
        );

        //모든 미팅이 끝날때까지 순환
        for (final int[] meeting : meetings) {
            if (pq.size() < n) { //방을 만든다.
                final int idx = pq.size();

                pq.add(new Room(idx, 1, meeting));
            } else { //방이 끝날때까지 기다렸다가 들어간다.
                //제일 빨리 끝난 방
                final Room room = pq.poll();
                final int idx = room.idx;
                final int count = room.count;

                final int duration = meeting[1] - meeting[0];
                final int newStartTime = room.getEndTime();
                final int[] newMeeting = new int[]{newStartTime, newStartTime + duration};

                pq.add(new Room(idx, count + 1, newMeeting));
            }
        }

        //많이 쓴 방 순으로 정렬, 값이 작은 순으로 정렬
        return pq.stream()
                .sorted(Comparator.comparingInt(Room::getCount).reversed().thenComparingInt(Room::getIdx))
                .collect(Collectors.toList()).get(0).idx;
    }

    class Room {
        int idx;
        int count;
        int[] time;

        Room(final int idx, final int count, final int[] time) {
            this.idx = idx;
            this.count = count;
            this.time = time;
        }

        int getIdx() {
            return idx;
        }

        int getCount() {
            return count;
        }

        int getEndTime() {
            return time[1];
        }
    }
}
