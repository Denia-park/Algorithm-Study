package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//23년 4월 2일 오전 1시 2분
//16분 걸림

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l1 = br.readLine();
        String l2 = br.readLine();
        int tc = Integer.parseInt(l2);
        String[] iArr = new String[tc];
        for (int i = 0; i < tc; i++) {
            iArr[i] = br.readLine();
        }

        sol.solution(l1, iArr);
    }
}

class BjSolution {
    public void solution(String l1, String[] iArr) {
        String[] split = l1.split(" ");
        int width = Integer.parseInt(split[0]);
        int height = Integer.parseInt(split[1]);

        List<Integer> cutWidth = new ArrayList<>();
        List<Integer> cutHeight = new ArrayList<>();

        cutWidth.add(0);
        cutWidth.add(height);

        cutHeight.add(0);
        cutHeight.add(width);

        for (String str : iArr) {
            String[] tempArr = str.split(" ");
            if (tempArr[0].equals("0")) {
                cutWidth.add(Integer.valueOf(tempArr[1]));
            } else {
                cutHeight.add(Integer.valueOf(tempArr[1]));
            }
        }

        cutWidth.sort(null);
        cutHeight.sort(null);

        List<Integer> restWidth = new ArrayList<>();
        List<Integer> restHeight = new ArrayList<>();

        for (int i = 0; i < cutHeight.size() - 1; i++) {
            restWidth.add(cutHeight.get(i + 1) - cutHeight.get(i));
        }
        for (int i = 0; i < cutWidth.size() - 1; i++) {
            restHeight.add(cutWidth.get(i + 1) - cutWidth.get(i));
        }

        restWidth.sort(null);
        restHeight.sort(null);

        System.out.println(restWidth.get(restWidth.size() - 1) * restHeight.get(restHeight.size() - 1));
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
