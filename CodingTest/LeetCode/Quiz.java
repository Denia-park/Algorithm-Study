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
    PriorityQueue<Room> playRoom;
    PriorityQueue<Room> waitRoom;

    public int mostBooked(final int n, final int[][] meetings) {
        //현재 사용중인 방을 우선순위 큐로 다룬다
        //빨리 끝나는 순으로 정렬이 되도록 한다.
        playRoom = new PriorityQueue<>(Comparator.comparingLong(Room::getEndTime));
        waitRoom = new PriorityQueue<>(Comparator.comparingInt(Room::getIdx));

        final List<Room> list = new ArrayList<>();

        for (int idx = 0; idx < n; idx++) {
            final Room room = new Room(idx, 0, new long[2]);
            list.add(room);
            waitRoom.add(room);
        }

        Arrays.sort(meetings, Comparator.comparingInt(arr -> arr[0]));

        //모든 미팅이 끝날때까지 순환
        for (final int[] meeting : meetings) {
            //미팅 시작 시간
            long curTime = meeting[0];
            final int duration = meeting[1] - meeting[0];

            //현재 시작하는 미팅시간보다 빨리 끝나는 애들은 다 빼준다.
            while (!playRoom.isEmpty() && playRoom.peek().getEndTime() <= curTime) {
                waitRoom.add(playRoom.poll());
            }

            //빈 방이 있으면 할당한다.
            if (!waitRoom.isEmpty()) {
                //빈 방을 하나 꺼낸다 (idx 정렬)
                final Room room = waitRoom.poll();
                //빈 방이 끝나는 시간이랑 현재 시작 시간이랑 비교해서 늦은 시간을 사용한다.
                final long tempCurTime = Math.max(room.getEndTime(), curTime);

                occupyRoom(room, new long[]{tempCurTime, tempCurTime + duration});
                continue;
            }

            //빈 방이 없으면, 기다렸다가 들어가야함
            //제일 빨리 끝나는 방을 기다린다.
            curTime = playRoom.peek().getEndTime();
            //같이 끝나는 방들도 빈방으로 처리한다.
            while (!playRoom.isEmpty() && playRoom.peek().getEndTime() <= curTime) {
                waitRoom.add(playRoom.poll());
            }

            occupyRoom(waitRoom.poll(), new long[]{curTime, curTime + duration});
        }

        //많이 쓴 방 순으로 정렬, 값이 작은 순으로 정렬
        list.sort(
                Comparator
                        .comparingLong(Room::getCount).reversed()
                        .thenComparingInt(Room::getIdx)
        );

        return list.get(0).idx;
    }

    private void occupyRoom(final Room room, final long[] newMeetingTime) {
        room.count++;
        room.time = newMeetingTime;
        playRoom.add(room);
    }

    class Room {
        int idx;
        long count;
        long[] time;

        Room(final int idx, final int count, final long[] time) {
            this.idx = idx;
            this.count = count;
            this.time = time;
        }

        int getIdx() {
            return idx;
        }

        long getCount() {
            return count;
        }

        long getEndTime() {
            return time[1];
        }
    }
}
