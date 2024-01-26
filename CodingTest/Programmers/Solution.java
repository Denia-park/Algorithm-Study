package CodingTest.Programmers;

import java.util.HashMap;
import java.util.Map;

/*
아이디어
- union - find 에서 find 알고리즘만 따와서 사용

시간 복잡도
- O(N) ~ O(N^2) 사이

자료구조
- 재귀
 */
class Solution {
    public long[] solution(final long k, final long[] roomNumbers) {
        final long[] answer = new long[roomNumbers.length];

        //차지된 방에 대해서 Map으로 표시
        //Key : 차지된 방 번호, Value : 해당 방을 원할 경우 줘야하는 방 번호
        final Map<Long, Long> occupiedRoom = new HashMap<>();

        for (int i = 0; i < roomNumbers.length; i++) {
            answer[i] = getRoom(occupiedRoom, roomNumbers[i]);
        }

        return answer;
    }

    private long getRoom(final Map<Long, Long> occupiedRoom, final long room) {
        //방이 비어있으면 해당 방을 배정하고, 해당 방을 원할 경우 줘야하는 방을 기입
        if (!occupiedRoom.containsKey(room)) {
            final long nextRoom = room + 1;

            occupiedRoom.put(room, nextRoom);
            return room;
        }

        //방이 이미 차있으면, 해당 방 번호를 통해서 줘야하는 방에 대해서 알아낸다.
        final Long nextRoom = occupiedRoom.get(room);
        //줘야하는 방이 그새 뺏기지 않았는지 확인한다.
        final long returnRoom = getRoom(occupiedRoom, nextRoom);
        occupiedRoom.put(room, returnRoom);

        return returnRoom;
    }
}
