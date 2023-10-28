package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    int answer;
    private List<Computer> computerList;

    public int solution(int n, int[][] computers) {
        answer = 0;
        computerList = new ArrayList<>();

        for (int i = 0; i < computers.length; i++) {
            final int[] network = computers[i];

            List<Integer> tempNetwork = new ArrayList<>();

            for (int j = 0; j < network.length; j++) {
                if (i == j) continue;

                if (network[j] == 1) {
                    tempNetwork.add(j);
                }
            }

            computerList.add(new Computer(i, tempNetwork));
        }

        for (Computer computer : computerList) {
            if (computer.isVisited) continue;

            answer++;

            bfs(computer);
        }

        return answer;
    }

    private void bfs(final Computer computer) {
        Deque<Computer> dq = new ArrayDeque<>();

        computer.isVisited = true;
        dq.add(computer);

        while (!dq.isEmpty()) {
            Computer currentComputer = dq.poll();
            final List<Integer> networkComputerNums = currentComputer.networkComputerNums;

            for (int i = 0; i < networkComputerNums.size(); i++) {
                int nextIdx = networkComputerNums.get(i);
                Computer nextComputer = computerList.get(nextIdx);

                if (nextComputer.isVisited) continue;

                nextComputer.isVisited = true;
                dq.add(nextComputer);
            }
        }
    }

    class Computer {
        int idx;
        List<Integer> networkComputerNums;
        boolean isVisited;

        Computer(int idx, List<Integer> networkComputerNums) {
            this.idx = idx;
            this.networkComputerNums = networkComputerNums;
            this.isVisited = false;
        }
    }
}
