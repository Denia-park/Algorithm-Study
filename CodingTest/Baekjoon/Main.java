package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        sol.solution(input);
    }
}

class BjSolution {
    Set<WATER> set;
    int TotalA, TotalB, TotalC;

    public void solution(String[] input) {
        set = new TreeSet<>();

        TotalA = Integer.parseInt(input[0]);
        TotalB = Integer.parseInt(input[1]);
        TotalC = Integer.parseInt(input[2]);

        bfs(0, 0, TotalC);

        for (WATER water : set) {
            System.out.print(water.C + " ");
        }
    }

    private void bfs(int A, int B, int C) {
        Deque<WATER> dq = new ArrayDeque<>();
        Map<String, Integer> visited = new HashMap<>();

        WATER startWater = new WATER(A, B, C);
        dq.offerLast(startWater);
        isIncluded(visited, startWater);
        while (!dq.isEmpty()) {
            WATER curWater = dq.pollFirst();
            if (curWater.A == 0) {
                set.add(curWater);
            }

            //A->B
            int moveWater = Math.min(curWater.A, TotalB - curWater.B);
            if (moveWater != 0) {
                WATER newWater = new WATER(curWater.A - moveWater, curWater.B + moveWater, curWater.C);
                if (!isIncluded(visited, newWater)) {
                    dq.offerLast(newWater);
                }
            }
            //A->C
            moveWater = Math.min(curWater.A, TotalC - curWater.C);
            if (moveWater != 0) {
                WATER newWater = new WATER(curWater.A - moveWater, curWater.B, curWater.C + moveWater);
                if (!isIncluded(visited, newWater)) {
                    dq.offerLast(newWater);
                }
            }
            //B->A
            moveWater = Math.min(curWater.B, TotalA - curWater.A);
            if (moveWater != 0) {
                WATER newWater = new WATER(curWater.A + moveWater, curWater.B - moveWater, curWater.C);
                if (!isIncluded(visited, newWater)) {
                    dq.offerLast(newWater);
                }
            }
            //B->C
            moveWater = Math.min(curWater.B, TotalC - curWater.C);
            if (moveWater != 0) {
                WATER newWater = new WATER(curWater.A, curWater.B - moveWater, curWater.C + moveWater);
                if (!isIncluded(visited, newWater)) {
                    dq.offerLast(newWater);
                }
            }
            //C->A
            moveWater = Math.min(curWater.C, TotalA - curWater.A);
            if (moveWater != 0) {
                WATER newWater = new WATER(curWater.A + moveWater, curWater.B, curWater.C - moveWater);
                if (!isIncluded(visited, newWater)) {
                    dq.offerLast(newWater);
                }
            }
            //C->B
            moveWater = Math.min(curWater.C, TotalB - curWater.B);
            if (moveWater != 0) {
                WATER newWater = new WATER(curWater.A, curWater.B + moveWater, curWater.C - moveWater);
                if (!isIncluded(visited, newWater)) {
                    dq.offerLast(newWater);
                }
            }
        }
    }

    private boolean isIncluded(Map<String, Integer> visit, WATER water) {
        if (visit.containsKey(water.toString())) return true;

        visit.put(water.toString(), 1);
        return false;
    }
}

class WATER implements Comparable<WATER> {
    int A;
    int B;
    int C;

    public WATER(int A, int B, int C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public String toString() {
        return A + " " + B + " " + C;
    }

    @Override
    public int compareTo(WATER o) {
        return Integer.compare(this.C, o.C);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WATER water = (WATER) o;
        return A == water.A && B == water.B && C == water.C;
    }

    @Override
    public int hashCode() {
        return Objects.hash(A, B, C);
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
