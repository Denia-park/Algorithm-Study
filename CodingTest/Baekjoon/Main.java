package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//정답 참고
//https://sanghyu.tistory.com/36

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseNum; i++) {
            int peopleNum = Integer.parseInt(br.readLine());
            String[] inputs = new String[peopleNum];
            for (int j = 0; j < peopleNum; j++) {
                inputs[j] = br.readLine();
            }

            sol.solution(inputs);
        }
    }
}

class BjSolution {

    public void solution(String[] inputs) {
        List<Man> mans = new ArrayList<>();

        for (String input : inputs) {
            String[] temp = input.split(" ");
            mans.add(new Man(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }

        mans.sort(Comparator.comparingInt(o -> o.first));

        Man bestMan = mans.get(0);
        int maxSecond = bestMan.second;

        int count = 0;
        for (Man man : mans) {
            if (maxSecond >= man.second) {
                count++;
                maxSecond = man.second;
            }
        }

        System.out.println(count);
    }

    class Man {
        int first;
        int second;

        public Man(int first, int second) {
            this.first = first;
            this.second = second;
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
