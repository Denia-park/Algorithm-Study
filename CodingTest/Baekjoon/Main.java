package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//23년 4월 5일 오전 12시 30분
//1시간 걸림
//정답 참고 -> 자꾸 시간초과 남

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        sol.solution(inputs);
    }
}

class BjSolution {
    private long base;
    private long mod;

    public void solution(String[] inputs) {
        base = Long.parseLong(inputs[0]);
        long count = Long.parseLong(inputs[1]);
        mod = Long.parseLong(inputs[2]);

        System.out.println(multiply(count));
    }

    private long multiply(long count) {
        if (count == 1) {
            return (base % mod);
        }

        long divideVal = multiply(count / 2) % mod;

        if (count % 2 == 0) {
            return (divideVal * divideVal) % mod;
        } else {
            return (divideVal * divideVal * (base % mod)) % mod;
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
