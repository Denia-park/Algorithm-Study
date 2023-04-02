package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//23년 4월 2일 오후 7시 35분
//47분 걸림

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l1 = br.readLine();
        int caseNum = Integer.parseInt(l1);
        String[] iArr = new String[caseNum];
        for (int i = 0; i < caseNum; i++) {
            iArr[i] = br.readLine();
        }

        sol.solution(iArr);
    }
}

class BjSolution {
    private int ans;

    public void solution(String[] iArr) {
        ans = Integer.MAX_VALUE;

        List<List<Integer>> map = new ArrayList<>();

        for (String str : iArr) {
            String[] s = str.split(" ");
            List<Integer> l = new ArrayList<>();
            for (String s1 : s) {
                l.add(Integer.parseInt(s1));
            }
            map.add(l);
        }

        for (int i = 0; i < iArr.length; i++) {
            search(map, i);
        }

        System.out.println(ans);
    }

    private void search(List<List<Integer>> map, int startIdx) {
        boolean[] visited = new boolean[map.size()];
        int tempAns = 0;

        List<Integer> list = map.get(startIdx);
        visited[startIdx] = true;
        int nextIdx = startIdx;
        int loopCount = 0;

        for (int count = 0; count < map.size() - 1; count++) {
            int minDistance = Integer.MAX_VALUE;

            for (int i = 0; i < list.size(); i++) {
                int value = list.get(i);
                if (value == 0 || visited[i]) continue;

                if (list.get(i) < minDistance) {
                    minDistance = list.get(i);
                    nextIdx = i;
                }
            }

            if (minDistance == Integer.MAX_VALUE) {
                continue;
            }

            tempAns += minDistance;
            list = map.get(nextIdx);
            visited[nextIdx] = true;
            loopCount++;
        }

        if (loopCount != 3) {
            return;
        }

        tempAns += map.get(nextIdx).get(startIdx);

        ans = Math.min(ans, tempAns);
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
