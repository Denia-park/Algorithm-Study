package CodingTest.Baekjoon;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static public void main(String[] args) {
        System.out.println("Hello World!");
    }
}

//        BjSolution sol = new BjSolution();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] arrSizes = br.readLine().split(" ");

//        sol.solution(arrSizes, arrA, arrB);

class BjSolution {
    public void solution(String[] arrSizes, String[] arrA, String[] arrB) {
        int ans = 0;
        List<Integer> list = new ArrayList<>();

        for (String s : arrA) {
            list.add(Integer.parseInt(s));
        }
        for (String s : arrB) {
            list.add(Integer.parseInt(s));
        }

        list.sort(null);

        StringBuilder sb = new StringBuilder();

        for (Integer i : list) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
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
