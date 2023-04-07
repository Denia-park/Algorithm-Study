package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        while (true) {
            String val = (br.readLine());
            if (val == null || val.equals("")) break;

            list.add(Integer.parseInt(val));
        }

        sol.solution(list);
    }
}

class BjSolution {
    List<Integer> list;

    public void solution(List<Integer> inputs) {
        list = inputs;
        int len = inputs.size();

        postOrder(0, len - 1);
    }

    private void postOrder(int startIdx, int endIdx) {
        if (startIdx > endIdx) {
            return;
        }

        int root = list.get(startIdx);
        //midIdx는 startIdx 다음부터 시작
        int midIdx = startIdx + 1;

        // 어디까지가 root의 left인지 확인하기 위함 =>
        // midIdx를 하나씩 올리면서 확인한다.
        while (midIdx <= endIdx && root > list.get(midIdx)) {
            midIdx++;
        }

        postOrder(startIdx + 1, midIdx - 1);
        postOrder(midIdx, endIdx);
        System.out.println(root);
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
