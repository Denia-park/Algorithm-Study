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
    int[] waterMaxArr;

    public void solution(String[] input) {
        set = new TreeSet<>();
        visited = new boolean[WATER_MAX_SIZE + 1][WATER_MAX_SIZE + 1][WATER_MAX_SIZE + 1];

        TotalA = Integer.parseInt(input[0]);
        TotalB = Integer.parseInt(input[1]);
        TotalC = Integer.parseInt(input[2]);
        waterMaxArr = new int[]{TotalA, TotalB, TotalC};

        bfs(0, 0, TotalC);

        for (int val : set) {
            System.out.print(val + " ");
        }
    }

    private void bfs(int A, int B, int C) {
        Deque<WATER> dq = new ArrayDeque<>();

        WATER startWater = new WATER(A, B, C);

        visited[startWater.A][startWater.B][startWater.C] = true;
        dq.offerLast(startWater);

        while (!dq.isEmpty()) {
            WATER curWater = dq.pollFirst();

            if (curWater.A == 0) {
                set.add(curWater.C);
            }

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;

                    moveWater(dq, curWater, from, to);
                }
            }
        }
    }

    private void moveWater(Deque<WATER> dq, WATER curWater, int from, int to) {
        int[] waterArr = {curWater.A, curWater.B, curWater.C};
        int moveWater = Math.min(waterArr[from], waterMaxArr[to] - waterArr[to]);

        if (moveWater == 0) return;
        
        waterArr[from] -= moveWater;
        waterArr[to] += moveWater;

        WATER newWater = new WATER(waterArr[0], waterArr[1], waterArr[2]);

        if (visited[newWater.A][newWater.B][newWater.C]) return;

        visited[newWater.A][newWater.B][newWater.C] = true;
        dq.offerLast(newWater);
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
