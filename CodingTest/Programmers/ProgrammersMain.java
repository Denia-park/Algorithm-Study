package CodingTest.Programmers;

import java.io.IOException;

public class ProgrammersMain {
    static public void main(String[] args) throws IOException {
        Solution ts = new Solution();

        System.out.println(ts.solution(new int[]{1, 3, 4, 6}).equals("1223330333221"));
        System.out.println(ts.solution(new int[]{1, 7, 1, 2}).equals("111303111"));
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

