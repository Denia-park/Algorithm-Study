package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

import java.util.*;

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

        Arrays.sort(meetings, Comparator.comparingInt(
                (int[] value) -> value[0]
        ));

        //모든 미팅이 끝날때까지 순환
        for (final int[] meeting : meetings) {
            //현재 시각 기준으로 방 빼야 함
            int curTime = meeting[0];

            //현재 시작하는 미팅시간보다 빨리 끝나는 애들은 다 빼준다.
            while (!playRoom.isEmpty() && playRoom.peek().getEndTime() <= curTime) {
                waitRoom.add(playRoom.poll());
            }

            //빈 방이 있으면 할당한다.
            if (!waitRoom.isEmpty()) {
                final Room room = waitRoom.poll();
                room.up();
                room.time = meeting;

                playRoom.add(room);
                continue;
            }

            //빈 방이 없으면, 기다렸다가 들어가야함
            //제일 빨리 끝나는 방을 기다린다.
            final Room firstEndRoom = playRoom.poll();
            curTime = firstEndRoom.time[1];

            final int duration = meeting[1] - meeting[0];
            final int[] newMeeting = new int[]{curTime, curTime + duration};

            firstEndRoom.up();
            firstEndRoom.time = newMeeting;

            playRoom.add(firstEndRoom);

        }

//        for (final Room room : list) {
//            System.out.println(room);
//        }

        //많이 쓴 방 순으로 정렬, 값이 작은 순으로 정렬
        list.sort(
                Comparator
                        .comparingInt(Room::getCount).reversed()
                        .thenComparingInt(Room::getIdx)
        );

        return list.get(0).idx;
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
