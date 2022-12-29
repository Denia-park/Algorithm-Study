package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

// 정답 참고
// https://m.blog.naver.com/occidere/221095055060

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] table = new String[testCase];

        for (int i = 0; i < testCase; i++) {
            table[i] = br.readLine();
        }
        System.out.println(sol.solution(testCase, table));
        br.close();
    }
}

class BjSolution {
    int gSize;
    String[] gTable;
    int answer;

    public int solution(int size, String[] table) {
        gSize = size;
        gTable = table;
        answer = 0;

        Map<Character, Integer> standardMap = new TreeMap<>();
        char[] defaultStr = table[0].toCharArray();
        for (char c : defaultStr) {
            standardMap.put(c, standardMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 1; i < size; i++) {
            if (Math.abs(table[0].length() - table[i].length()) > 1) continue;

            Map<Character, Integer> tempMap = new TreeMap<>();
            int diff = 0;

            char[] chars = gTable[i].toCharArray();
            for (char c : chars) {
                tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
            }

            for (char c = 'A'; c <= 'Z'; c++) {
                diff += Math.abs(standardMap.getOrDefault(c, 0) - tempMap.getOrDefault(c, 0));
            }

            if (diff <= 2) {
                answer++;
            }
        }

        return answer;
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

