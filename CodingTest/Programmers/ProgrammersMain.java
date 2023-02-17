package CodingTest.Programmers;

import java.io.IOException;
import java.util.Arrays;

public class ProgrammersMain {
    static public void main(String[] args) throws IOException {
        Solution ts = new Solution();

        System.out.println(Arrays.toString(ts.solution(new String[]{"left", "right", "up", "right", "right"}, new int[]{11, 11})));
    }
}

// 12345

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

