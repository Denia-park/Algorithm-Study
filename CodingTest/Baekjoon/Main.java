package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        sol.solution(start, end);
    }
}

class BjSolution {
    public void solution(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        long sum = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
                sum += i;
            }
        }

        if (primes.isEmpty()) {
            System.out.println(-1);
            return;
        }

        primes.sort(null);
        System.out.println(sum);
        System.out.println(primes.get(0));
    }

    private boolean isPrime(int i) {
        boolean flag = true;

        if (i == 1) {
            return false;
        }

        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                flag = false;
                break;
            }
        }

        return flag;
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
