package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//23년 4월 5일 오전 12시 00분
//29분 걸림

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int houseNum = Integer.parseInt(input[0]);
        int wifiNum = Integer.parseInt(input[1]);

        int[] inputs = new int[houseNum];
        for (int i = 0; i < houseNum; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        sol.solution(wifiNum, inputs);
    }
}

class BjSolution {
    public void solution(int wifiNum, int[] houses) {
        Arrays.sort(houses);

        int answer = 0;

        int distance = houses[houses.length - 1] - houses[0];

        int left = 0;
        int right = distance;
        while (left <= right) {
            int mid = (right + left) / 2;

            int wifiCount = 1;
            int prevWifiDistance = houses[0];
            for (int i = 1; i < houses.length; i++) {
                if (houses[i] - prevWifiDistance >= mid) {
                    wifiCount++;
                    prevWifiDistance = houses[i];
                }
            }

            if (wifiCount >= wifiNum) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
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
