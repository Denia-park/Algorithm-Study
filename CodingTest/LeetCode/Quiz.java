package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
        System.out.println(
                solution.mostBooked(
                        3,
                        BracketUtil.convertStrToIntArr(
                                "[[0,10],[1,9],[2,8],[3,7],[4,6]]"
                        )
                )
        );
    }
}

class Solution {
    public int mostBooked(final int n, final int[][] meetings) {
        //현재 사용중인 방을 우선순위 큐로 다룬다
        //빨리 끝나는 순으로 정렬이 되도록 한다.
        final PriorityQueue<Room> playRoom = new PriorityQueue<>(
                Comparator.comparingInt(Room::getEndTime)
        );
        final PriorityQueue<Room> waitRoom = new PriorityQueue<>(
                Comparator.comparingInt(Room::getIdx)
        );

        final List<Room> list = new ArrayList<>();

        for (int idx = 0; idx < n; idx++) {
            final Room room = new Room(idx, 0, null);
            list.add(room);
            waitRoom.add(room);
        }

        //모든 미팅이 끝날때까지 순환
        for (final int[] meeting : meetings) {
            if (playRoom.size() < n) { //방을 만든다.
                final Room addRoom = waitRoom.poll();
                addRoom.up();
                addRoom.time = meeting;

                playRoom.add(addRoom);
            } else { //방이 끝날때까지 기다렸다가 들어간다.
                //현재 시간을 구한다 (미팅이 끝난 시간이랑 현재 미팅 시작시간을 비교)
                //애초에 현재 미팅이 늦게 시작하면 현재 미팅은 방이 다 비고 시작함
                final int curTime = Math.max(playRoom.peek().time[1], meeting[0]);
                //현재 시작하는 미팅시간보다 빨리 끝나는 애들은 다 빼준다.
                while (!playRoom.isEmpty() && playRoom.peek().getEndTime() <= curTime) {
                    waitRoom.add(playRoom.poll());
                }

                final int duration = meeting[1] - meeting[0];
                final int newStartTime = curTime;
                final int[] newMeeting = new int[]{newStartTime, newStartTime + duration};

                final Room addRoom = waitRoom.poll();
                addRoom.up();
                addRoom.time = newMeeting;

                playRoom.add(addRoom);
            }
        }

//        for (Room room : list) {
//            System.out.println(room);
//        }

        //많이 쓴 방 순으로 정렬, 값이 작은 순으로 정렬
        return playRoom.stream()
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

        void up() {
            count++;
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

        @Override
        public String toString() {
            return "[" + idx + " : " + count + "]";
        }
    }
}
