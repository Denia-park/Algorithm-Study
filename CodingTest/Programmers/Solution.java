package CodingTest.Programmers;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        for (String player : players) {
            map.put(player, idx);
            idx++;
        }

        for (String calling : callings) {
            int callingIdx = map.get(calling);
            int frontIdx = callingIdx - 1;
            String callingName = calling;
            String frontName = players[frontIdx];

            exchange(players, frontIdx, callingIdx);
            map.put(callingName, callingIdx - 1);
            map.put(frontName, map.get(frontName) + 1);
        }

        return players;
    }

    private void exchange(String[] players, int frontIdx, int callingIdx) {
        String tempName = players[frontIdx];
        players[frontIdx] = players[callingIdx];
        players[callingIdx] = tempName;
    }
}
