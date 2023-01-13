package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        List<String[]> quizArr = new ArrayList<>();
        for (int i = 0; i < testCase; i++) {
            String[] arr = br.readLine().split(" ");
            quizArr.add(arr);
        }

        sol.solution(testCase, quizArr);
    }
}

class BjSolution {
    public void solution(int testCase, List<String[]> quizArr) {
        int[] answer = new int[testCase + 1];
        int[] time = new int[testCase + 1];
        int[] indgree = new int[testCase + 1];
        List<List<Integer>> nextBuildList = new ArrayList<>();
        for (int i = 0; i < testCase + 1; i++) {
            nextBuildList.add(new ArrayList<>());
        }

        for (int i = 0; i < quizArr.size(); i++) {
            String[] arr = quizArr.get(i);
            int curBuildingNum = i + 1;
            time[curBuildingNum] = Integer.parseInt(arr[0]);
            for (int j = 1; j < arr.length; j++) {
                int preBuildingNum = Integer.parseInt(arr[j]);
                if (preBuildingNum == -1) {
                    break;
                }
                nextBuildList.get(preBuildingNum).add(curBuildingNum);
                indgree[curBuildingNum]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i < testCase + 1; i++) {
            if (indgree[i] == 0) {
                queue.addLast(i);
                answer[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int curBuilding = queue.removeFirst();

            for (int nextBuilding : nextBuildList.get(curBuilding)) {
                indgree[nextBuilding]--;

                answer[nextBuilding] = Math.max(answer[nextBuilding], (time[curBuilding] + time[nextBuilding]));

                if (indgree[nextBuilding] == 0) {
                    time[nextBuilding] = answer[nextBuilding];
                    queue.addLast(nextBuilding);
                }
            }
        }

        for (int i = 1; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
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
