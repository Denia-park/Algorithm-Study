import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    int gStart;
    int gEnd;
    int answer;
    boolean[] primeTable;
    boolean[] visited;

    public void solution(int size, int[][] table) {
        primeTable = new boolean[10000];
        Arrays.fill(primeTable, true);

        eratosthenes(primeTable);

        for (int i = 0; i < size; i++) {
            int[] quiz = table[i];
            gStart = quiz[0];
            gEnd = quiz[1];
            answer = Integer.MAX_VALUE;
            visited = new boolean[10000];

            bfs(gStart);

            if (answer == Integer.MAX_VALUE) {
                System.out.println("Impossible");
            } else {
                System.out.println(answer);
            }
        }
    }

    void bfs(int curValue) {
        Deque<Number> dq = new ArrayDeque<>();
        dq.add(new Number(curValue, 0));
        visited[curValue] = true;

        while (!dq.isEmpty()) {
            Number n = dq.poll();
            if (gEnd == n.number) {
                answer = Math.min(answer, n.count);
                return;
            }

            for (int digitIdx = 0; digitIdx < 4; digitIdx++) {
                char[] str = String.valueOf(n.number).toCharArray();
                for (int i = 0; i < 10; i++) {
                    str[digitIdx] = (char) ('0' + i);
                    int newNum = Integer.parseInt(String.valueOf(str));
                    if (primeTable[newNum] && newNum > 1000 && !visited[newNum]) {
                        visited[newNum] = true;
                        dq.add(new Number(newNum, n.count + 1));
                    }
                }
            }
        }
    }

    private void eratosthenes(boolean[] primeTable) {
        for (int i = 2; i < 10000; i++) {
            if (!primeTable[i]) {
                continue;
            }
            for (int j = i + i; j < 10000; j += i) {
                primeTable[j] = false;
            }
        }
    }
}

class Number {
    int count;
    int number;

    public Number(int number, int count) {
        this.number = number;
        this.count = count;
    }
}
