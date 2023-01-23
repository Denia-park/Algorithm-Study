package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        sol.solution(input);
    }
}

class BjSolution {
    final int WATER_MAX_SIZE = 200;
    int TotalA, TotalB, TotalC;
    Set<Integer> set;
    boolean[][][] visited;

    public void solution(String[] input) {
        set = new TreeSet<>();
        visited = new boolean[WATER_MAX_SIZE + 1][WATER_MAX_SIZE + 1][WATER_MAX_SIZE + 1];

        TotalA = Integer.parseInt(input[0]);
        TotalB = Integer.parseInt(input[1]);
        TotalC = Integer.parseInt(input[2]);

        bfs(0, 0, TotalC);

        for (int val : set) {
            System.out.print(val + " ");
        }
    }

    private void bfs(int A, int B, int C) {
        Deque<WATER> dq = new ArrayDeque<>();

        WATER startWater = new WATER(A, B, C);

        isIncluded(startWater);
        dq.offerLast(startWater);

        while (!dq.isEmpty()) {
            WATER curWater = dq.pollFirst();
            
            if (curWater.A == 0) {
                set.add(curWater.C);
            }

            //A->B
            int moveWater = Math.min(curWater.A, TotalB - curWater.B);
            if (moveWater != 0) {
                WATER newWater = new WATER(curWater.A - moveWater, curWater.B + moveWater, curWater.C);
                if (!isIncluded(newWater)) {
                    dq.offerLast(newWater);
                }
            }
            //A->C
            moveWater = Math.min(curWater.A, TotalC - curWater.C);
            if (moveWater != 0) {
                WATER newWater = new WATER(curWater.A - moveWater, curWater.B, curWater.C + moveWater);
                if (!isIncluded(newWater)) {
                    dq.offerLast(newWater);
                }
            }
            //B->A
            moveWater = Math.min(curWater.B, TotalA - curWater.A);
            if (moveWater != 0) {
                WATER newWater = new WATER(curWater.A + moveWater, curWater.B - moveWater, curWater.C);
                if (!isIncluded(newWater)) {
                    dq.offerLast(newWater);
                }
            }
            //B->C
            moveWater = Math.min(curWater.B, TotalC - curWater.C);
            if (moveWater != 0) {
                WATER newWater = new WATER(curWater.A, curWater.B - moveWater, curWater.C + moveWater);
                if (!isIncluded(newWater)) {
                    dq.offerLast(newWater);
                }
            }
            //C->A
            moveWater = Math.min(curWater.C, TotalA - curWater.A);
            if (moveWater != 0) {
                WATER newWater = new WATER(curWater.A + moveWater, curWater.B, curWater.C - moveWater);
                if (!isIncluded(newWater)) {
                    dq.offerLast(newWater);
                }
            }
            //C->B
            moveWater = Math.min(curWater.C, TotalB - curWater.B);
            if (moveWater != 0) {
                WATER newWater = new WATER(curWater.A, curWater.B + moveWater, curWater.C - moveWater);
                if (!isIncluded(newWater)) {
                    dq.offerLast(newWater);
                }
            }
        }
    }

    private boolean isIncluded(WATER water) {
        if (visited[water.A][water.B][water.C]) return true;

        visited[water.A][water.B][water.C] = true;
        return false;
    }
}

class WATER {
    int A, B, C;

    public WATER(int A, int B, int C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }
}

//        *StringTokenizer*
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        int stNum = Integer.parseInt(st.nextToken());
//        int testValue = Integer.parseInt(br.readLine());

//        *BufferedReader*
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int testCaseNum = Integer.parseInt(br.readLine());
//        String[] testCase = new String[testCaseNum];
//        for (int i = 0; i < testCaseNum; i++) {
//            testCase[i] = br.readLine();
//        }
