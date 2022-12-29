package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int listNum = Integer.parseInt(st[0]);
        int quizNum = Integer.parseInt(st[1]);
        String[] listTable = new String[listNum];
        String[] quizTable = new String[quizNum];

        for (int i = 0; i < listNum; i++) {
            listTable[i] = br.readLine();
        }
        for (int i = 0; i < quizNum; i++) {
            quizTable[i] = br.readLine();
        }
        sol.solution(listNum, quizNum, listTable, quizTable);
        br.close();
    }
}

class BjSolution {
    public void solution(int listNum, int quizNum, String[] list, String[] quiz) {
        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> numMap = new HashMap<>();

        for (int i = 0; i < listNum; i++) {
            nameMap.put(list[i], i + 1);
            numMap.put(i + 1, list[i]);
        }

        for (int i = 0; i < quizNum; i++) {
            try {
                int num = Integer.parseInt(quiz[i]);
                System.out.println(numMap.get(num));
            } catch (Exception e) {
                System.out.println(nameMap.get(quiz[i]));
            }
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

