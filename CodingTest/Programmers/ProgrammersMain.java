package CodingTest.Programmers;

import java.util.Arrays;

public class ProgrammersMain {
    public static void main(String[] args) {
        Solution ts = new Solution();

        System.out.println(Arrays.toString(ts.solution(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(ts.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
        System.out.println(Arrays.toString(ts.solution(new int[]{2, 2, 2, 2, 2}, 6)));
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

