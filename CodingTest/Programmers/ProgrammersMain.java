package CodingTest.Programmers;

import java.io.IOException;

public class ProgrammersMain {
    static public void main(String[] args) throws IOException {
        Solution ts = new Solution();
        String[][] bookTime1 = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        String[][] bookTime2 = {{"09:10", "10:10"}, {"10:20", "12:20"}};

        System.out.println(ts.solution(bookTime1));
        System.out.println(ts.solution(bookTime2));
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

