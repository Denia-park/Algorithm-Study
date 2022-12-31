package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int lectureNum = Integer.parseInt(line[0]);
        int splitNum = Integer.parseInt(line[1]);
        int[] lectures = new int[lectureNum];
        long totalTime = 0;
        int maxValue = -1;
        String[] lecturesLine = br.readLine().split(" ");
        for (int i = 0; i < lectureNum; i++) {
            int curTime = Integer.parseInt(lecturesLine[i]);
            lectures[i] = curTime;
            totalTime += curTime;
            maxValue = Math.max(maxValue, curTime);
        }

        sol.solution(lectureNum, splitNum, lectures, totalTime, maxValue);
    }
}

class BjSolution {
    long answer;
    int gLectureNum;
    int gSplitNum;
    long gTotalTime;
    int[] gLectures;

    public void solution(int lectureNum, int splitNum, int[] lectures, long totalTime, int maxValue) {
        answer = Long.MAX_VALUE;
        gLectureNum = lectureNum;
        gSplitNum = splitNum;
        gLectures = lectures;
        gTotalTime = totalTime;

        long start = 1;
        long end = totalTime;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (maxValue <= mid && checkLength(mid)) {
                end = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private boolean checkLength(long mid) {
        long tempSum = 0;
        int tempCount = 1;
        for (int i = 0; i < gLectureNum; i++) {
            int curTime = gLectures[i];
            if (tempSum + curTime <= mid) {
                tempSum += curTime;
            } else {
                tempSum = curTime;
                tempCount++;
            }
        }
        return tempCount <= gSplitNum;
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
