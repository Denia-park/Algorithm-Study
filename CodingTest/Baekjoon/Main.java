package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int clickNum = Integer.parseInt(br.readLine());

        sol.solution(clickNum);
    }
}

class BjSolution {
    int answer, gClickNum, gBufferCount, gStandardCount;
    boolean gCopyFlag;
    boolean gSelectFlag;

    public void solution(int clickNum) {
        if (clickNum <= 6) {
            System.out.println(clickNum);
            return;
        }

        answer = 6;
        gBufferCount = 3;
        gSelectFlag = false;
        gCopyFlag = true;
        gStandardCount = 3; // con v 한번에 나오는 값
        gClickNum = (clickNum - 6);

        //남아있는 N을 기준으로 계산을 해야함.
        //남아있는 N 과 answer의 상태 , 버퍼의 값

        while (gClickNum != 0) {
            if (gClickNum >= 3 && (answer + gStandardCount * 3 <= answer * 2)) {
                comSelectAll();
                comCopyData();
                comPaste();
            } else {
                comPaste();
            }
        }

        System.out.println(answer);
    }

    //화면에 A 출력 -> answer + 1
    void comPrintA() {
        answer++;

        gClickNum--;
    }

    //화면 전체 선택
    void comSelectAll() {
        gClickNum--;
    }

    //화면 버퍼에 복사
    void comCopyData() {
        gClickNum--;
        gBufferCount = answer;
        gStandardCount = gBufferCount;
    }

    //화면에 복사한거 붙이기
    void comPaste() {
        gClickNum--;
        answer += gBufferCount;
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
