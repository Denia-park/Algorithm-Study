package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//23년 4월 1일 오후 10시 53분
//23분 걸림

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int val = Integer.parseInt(br.readLine());
            sol.solution(val);
        }
    }
}


class BjSolution {
    static boolean[] eratos;

    public void solution(int input) {
        if (eratos == null) {
            eratos = getEratos();
        }

        int[] answer = new int[2];

        int min = Integer.MAX_VALUE;
        for (int i = 2; i < input; i++) {
            if (eratos[i] && eratos[input - i] && (min > Math.abs(input - (2 * i)))) {
                min = Math.abs(input - (2 * i));
                answer = new int[]{Math.min(i, input - i), Math.max(i, input - i)};
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }

    private boolean[] getEratos() {
        boolean[] result = new boolean[10001];
        Arrays.fill(result, true);
        result[0] = false;
        result[1] = false;

        for (int i = 2; i <= Math.sqrt(10000); i++) {
            if (!result[i]) continue;

            for (int j = i * 2; j <= 10000; j += i) {
                result[j] = false;
            }
        }

        return result;
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
