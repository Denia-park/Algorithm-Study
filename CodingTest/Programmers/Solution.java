package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    int[] gPicks;
    String[] gMinerals;
    private int answer;

    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        gPicks = picks;
        gMinerals = minerals;

        bfs();

        return answer;
    }

    private void bfs() {
        Deque<Miner> dq = new ArrayDeque<>();
        dq.add(new Miner(new int[]{gPicks[0], gPicks[1], gPicks[2]}, 0, 0));

        while (!dq.isEmpty()) {
            Miner miner = dq.poll();

            if ((miner.pickaxs[0] == 0 &&
                    miner.pickaxs[1] == 0 &&
                    miner.pickaxs[2] == 0) ||
                    miner.mineralIdx == gMinerals.length) {
                answer = Math.min(answer, miner.fatigue);
                continue;
            }

            if (miner.fatigue >= answer) {
                continue;
            }

            for (int pickaxIdx = 0; pickaxIdx < 3; pickaxIdx++) {
                int[] nextPickax = new int[]{miner.pickaxs[0], miner.pickaxs[1], miner.pickaxs[2]};
                int tempPickaxCount = nextPickax[pickaxIdx];
                if (tempPickaxCount == 0) continue;

                nextPickax[pickaxIdx] -= 1;

                int nextMineralIdx = miner.mineralIdx;
                int nextFatigue = miner.fatigue;

                int limit = nextMineralIdx + 5;

                for (; nextMineralIdx < limit; nextMineralIdx++) {
                    if (nextMineralIdx >= gMinerals.length) break;

                    if (gMinerals[nextMineralIdx].equals("diamond")) {
                        nextFatigue += Math.pow(5, pickaxIdx);
                    } else if (pickaxIdx == 2 && gMinerals[nextMineralIdx].equals("iron")) {
                        nextFatigue += 5;
                    } else {
                        nextFatigue += 1;
                    }
                }

                dq.add(new Miner(nextPickax, nextMineralIdx, nextFatigue));
            }
        }
    }

    class Miner {
        int[] pickaxs;
        int mineralIdx;
        int fatigue;

        public Miner(int[] pickaxs, int mineralIdx, int fatigue) {
            this.pickaxs = pickaxs;
            this.mineralIdx = mineralIdx;
            this.fatigue = fatigue;
        }
    }
}
