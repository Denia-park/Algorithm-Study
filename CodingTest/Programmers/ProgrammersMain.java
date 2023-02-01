package CodingTest.Programmers;

import java.io.IOException;

public class ProgrammersMain {
    static public void main(String[] args) throws IOException {
        Solution ts = new Solution();

        System.out.println(ts.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(ts.solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
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

