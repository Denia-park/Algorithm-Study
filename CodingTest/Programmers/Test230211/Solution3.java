package CodingTest.Programmers.Test230211;

import java.util.*;

public class Solution3 {
    public int[] solution(int[][] queries) {
        int[] answer = new int[queries.length];

        int idx = 0;
        for (int[] query : queries) {
            answer[idx] = bfs(query);
            idx++;
        }

        return answer;
    }


    private int bfs(int[] query) {
        Map<String, Boolean> isVisited = new HashMap<>();

        Deque<User> dq = new ArrayDeque<>();
        dq.addLast(new User(query, 0));
        isVisited.put(Arrays.toString(query), true);

        while (!dq.isEmpty()) {
            User curUser = dq.pollFirst();

            if (checkPalind(curUser.query)) {
                return curUser.turn;
            }

            for (int idx = 0; idx < curUser.query.length; idx++) {
                if (curUser.query[idx] == 0) continue;
                int[] tempQuery = Arrays.copyOf(curUser.query, curUser.query.length);

                tempQuery[idx] -= 1;

                String key = Arrays.toString(tempQuery);

                if (!isVisited.getOrDefault(key, false)) {
                    isVisited.put(key, true);
                    dq.addLast(new User(tempQuery, curUser.turn ^ 1));
                }
            }
        }

        return 0;
    }


    boolean checkPalind(int[] query) {
        boolean answer = true;
        int len = query.length;

        for (int start = 0, end = len - 1; start < (len / 2); start++, end--) {
            if (query[start] != query[end]) {
                return false;
            }
        }

        return answer;
    }
}

class User {
    int[] query;
    int turn;

    public User(int[] query, int turn) {
        this.query = query;
        this.turn = turn;
    }
}
