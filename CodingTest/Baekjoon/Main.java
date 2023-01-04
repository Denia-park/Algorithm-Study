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
    int answer, gClickNum, gBufferCount;
    boolean gCopyFlag;
    boolean gSelectFlag;

    public void solution(int clickNum) {
        answer = 0;
        gClickNum = clickNum;
        gBufferCount = 0;
        gSelectFlag = false;
        gCopyFlag = false;

        while (gClickNum != 0) {
            if (answer < 3) {
                comPrintA();
                continue;
            } else {
                if (!gSelectFlag) {
                    comSelectAll();
                } else {
                    if (!gCopyFlag) {
                        comCopyData();
                    } else {
                        comPaste();
                    }
                }
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
        gSelectFlag = true;
    }

    //화면 버퍼에 복사
    void comCopyData() {
        gClickNum--;
        gCopyFlag = true;
        gBufferCount = answer;
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
