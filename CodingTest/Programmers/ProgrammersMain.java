package CodingTest.Programmers;

public class ProgrammersMain {
    static public void main(String[] args) {
        Solution ts = new Solution();

        System.out.println(ts.solution(8, 4, new int[]{2, 3, 6}));
        System.out.println(ts.solution(5, 4, new int[]{1, 3}));
        System.out.println(ts.solution(4, 1, new int[]{1, 2, 3, 4}));
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

