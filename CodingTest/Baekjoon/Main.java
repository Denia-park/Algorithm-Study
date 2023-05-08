package CodingTest.Baekjoon;

//플로이드 - 11404

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseNum; i++) {
            int peopleNum = Integer.parseInt(br.readLine());
            int[] people = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sol.solution(peopleNum, people);
        }
    }
}

/*
1. 아이디어
싸이클을 이루는지 확인 - 계속 돌면서 자기 자신한테로 돌아오는지 확인한다.

2. 시간 복잡도
O(N^2) 10^10 10억
dp를 써서 중간에 캐싱을 해야 함

3. 자료 구조
값을 저장할 dp int[]
*/

class BjSolution {
    final int UNCHECKED = 0;
    final int SUCCESS = 1;
    final int FAIL = 2;

    public void solution(int peopleNum, int[] people) {
        int answer = 0;

        int[] success = new int[peopleNum + 1];

        for (int idx = 0; idx < peopleNum; idx++) {
            int myNum = idx + 1;
            if (success[myNum] == SUCCESS) {
                answer++;
                continue;
            }

            int wantIdx = people[myNum - 1];
            if (success[wantIdx] != UNCHECKED) {
                success[myNum] = FAIL;
                continue;
            }
            List<Integer> list = new ArrayList<>();

            list.add(wantIdx);

            while (true) {
                int nextWantIdx = people[wantIdx - 1];

                if (success[nextWantIdx] != UNCHECKED) {
                    for (Integer intVal : list) {
                        success[intVal] = FAIL;
                    }
                    success[myNum] = FAIL;
                    break;
                }

                if (nextWantIdx == myNum) {
                    for (Integer intVal : list) {
                        success[intVal] = SUCCESS;
                    }

                    answer++;
                    success[myNum] = SUCCESS;
                    break;
                } else if (nextWantIdx == wantIdx) {
                    for (Integer intVal : list) {
                        success[intVal] = FAIL;
                    }
                    success[list.get(list.size() - 1)] = SUCCESS;
                    success[myNum] = FAIL;
                    break;
                }

                list.add(nextWantIdx);
                wantIdx = nextWantIdx;
            }
        }

//        System.out.println(Arrays.toString(success));

        System.out.println(peopleNum - answer);
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
