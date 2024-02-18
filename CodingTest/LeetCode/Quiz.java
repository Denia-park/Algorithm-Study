package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

import java.util.*;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
//
//        System.out.println(
//                solution.mostBooked(
//                        2,
//                        BracketUtil.convertStrToIntArr(
//                                "[[0,10],[1,5],[2,7],[3,4]]"
//                        )
//                )
//        );
//        System.out.println(
//                solution.mostBooked(
//                        3,
//                        BracketUtil.convertStrToIntArr(
//                                "[[1,20],[2,10],[3,5],[4,9],[6,8]]"
//                        )
//                )
//        );
//        System.out.println(
//                solution.mostBooked(
//                        3,
//                        BracketUtil.convertStrToIntArr(
//                                "[[0,10],[1,9],[2,8],[3,7],[4,6]]"
//                        )
//                )
//        );
        System.out.println(
                solution.mostBooked(
                        4,
                        BracketUtil.convertStrToIntArr(
                                "[[18,19],[3,12],[17,19],[2,13],[7,10]]"
                        )
                )
        );
        System.out.println(
                solution.mostBooked(
                        2,
                        BracketUtil.convertStrToIntArr(
                                "[[10,11],[2,10],[1,17],[9,13],[18,20]]"
                        )
                )
        );
        System.out.println(
                solution.mostBooked(
                        4,
                        BracketUtil.convertStrToIntArr(
                                "[[19,20],[14,15],[13,14],[11,20]]"
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
            //play 방이 없으면 바로 waiting 방에 진입
            if (playRoom.isEmpty()) {
                final Room room = waitRoom.poll();
                room.up();
                room.time = meeting;

                playRoom.add(room);
                continue;
            }

            final int firstEndTime = playRoom.peek().time[1];
            int curTime = 0;
            //빈 방이 남아있으면, 현재 시간은 현재 미팅 시작 시간
            if (!waitRoom.isEmpty()) {
                curTime = Math.min(firstEndTime, meeting[0]);
            }
            //빈 방이 없으면, 제일 빨리 미팅이 끝나는 시간이 현재 미팅 시작 시간
            else {
                curTime = Math.max(firstEndTime, meeting[0]);
            }

            //play 방이 있으면 현재 시간을 비교해서 현재 방이 끝났는지 확인한다.
            //현재 시간을 구한다 (미팅이 끝난 시간이랑 현재 미팅 시작시간을 비교)
            //애초에 현재 미팅이 늦게 시작하면 현재 미팅은 방이 다 비고 시작함

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

        for (final Room room : list) {
            System.out.println(room);
        }

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
