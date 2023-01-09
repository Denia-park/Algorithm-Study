package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//정답 참고 - 센서 [2212]

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sensorNum = Integer.parseInt(br.readLine());
        int companyNum = Integer.parseInt(br.readLine());
        String[] sensorDistances = br.readLine().split(" ");
        int[] sensors = new int[sensorNum];
        for (int i = 0; i < sensorNum; i++) {
            sensors[i] = Integer.parseInt(sensorDistances[i]);
        }
        sol.solution(sensorNum, companyNum, sensors);
    }
}

class BjSolution {
    public void solution(int sensorNum, int companyNum, int[] sensors) {
        if (companyNum >= sensorNum) {
            System.out.println(0);
            return;
        }

        //sensor X 거리 기준으로 정렬
        Arrays.sort(sensors);

        int[] sensorDistanceDiffs = new int[sensorNum - 1];

        for (int i = 0; i < sensorNum - 1; i++) {
            sensorDistanceDiffs[i] = sensors[i + 1] - sensors[i];
        }

        int jump = companyNum - 1;

        //정렬
        Arrays.sort(sensorDistanceDiffs);

        int answer = 0;
        for (int i = sensorDistanceDiffs.length - 1; i >= 0; i--) {
            if (jump > 0) {
                jump--;
                continue;
            }

            answer += sensorDistanceDiffs[i];
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
