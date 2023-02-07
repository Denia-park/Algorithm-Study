package CodingTest.Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//호텔 대실
//한 번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소를 하고
//다음 손님들이 사용할 수 있습니다.
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Room> useRooms = new PriorityQueue<>(Comparator.comparingInt(o -> o.endMinute));

        Room[] rooms = new Room[book_time.length];
        for (int i = 0; i < book_time.length; i++) {
            rooms[i] = new Room(book_time[i][0], book_time[i][1]);
        }

        Arrays.sort(rooms, Comparator.comparingInt(o -> o.startMinute));

        for (Room room : rooms) {
            if (!useRooms.isEmpty() && room.startMinute >= useRooms.peek().endMinute) {
                useRooms.poll();
            } else {
                answer++;
            }

            useRooms.offer(room);
        }

        return answer;
    }
}

class Room {
    int startMinute;
    int endMinute;

    public Room(String start, String end) {
        int minutesToClean = 10;

        this.startMinute = getMinutes(start);
        this.endMinute = getMinutes(end) + minutesToClean;
    }

    private int getMinutes(String time) {
        String[] timeArray = time.split(":");
        int hour = Integer.parseInt(timeArray[0]);
        int minute = Integer.parseInt(timeArray[1]);

        return hour * 60 + minute;
    }
}
