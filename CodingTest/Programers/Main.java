package CodingTest.Programers;

import java.io.IOException;

public class Main {
    static public void main(String[] args) throws IOException {
        Solution ts = new Solution();

//        System.out.println(ts.solution(16));
//        System.out.println(ts.solution(2554));
//        System.out.println(ts.solution(12345));
//        System.out.println(ts.solution(199));
//        System.out.println(ts.solution(1));
        System.out.println(ts.solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
        System.out.println(ts.solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));

        //앞자리 보고 계산해줘야함.
        //65 [1,3,5] , 45 [4,5]
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

