package CodingTest.Programmers;

import java.io.IOException;

public class ProgrammersMain {
    static public void main(String[] args) throws IOException {
        Solution ts = new Solution();

        System.out.println(ts.solution(new String[]{"aya", "yee", "u", "maa"}));
        System.out.println(ts.solution(new String[]{"ayayewooma"}));
        System.out.println(ts.solution(new String[]{"maayama"}));
        System.out.println(ts.solution(new String[]{"yemayemayemayemayemayemayemaye"}));
        System.out.println(ts.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
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

