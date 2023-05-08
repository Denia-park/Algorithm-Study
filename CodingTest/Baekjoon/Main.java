package CodingTest.Baekjoon;

//텀 프로젝트 - 9466

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseNum; i++) {
            int peopleNum = Integer.parseInt(br.readLine());
            int[] people = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sol.solution(peopleNum, people);
        }
    }
}

/*
1. 아이디어
싸이클을 이루는지 확인 - 계속 돌면서 자기 자신한테로 돌아오는지 확인한다.

2. 시간 복잡도
O(N^2) 10^10 10억
dp를 써서 중간에 캐싱을 해야 함

3. 자료 구조
값을 저장할 dp int[]
*/

class BjSolution {
    //방문 확인
    boolean[] visited;
    //사이클 계산을 한적이 있는지 확인
    boolean[] done;
    //전역변수
    int[] gPeople;
    private int answer;

    public void solution(int peopleNum, int[] people) {
        answer = 0;

        gPeople = people;
        visited = new boolean[peopleNum + 1];
        done = new boolean[peopleNum + 1];

        //people 만큼 돌면서 확인
        for (int i = 0; i < people.length; i++) {
            int idx = i + 1;

            //이미 방문한적이 있으면 어떻게든 계산이 되었으므로 확인 X
            if (visited[idx]) continue;

            //방문한적이 없는 경우에만 dfs로 돈다.
            dfs(people[idx - 1]);
        }

        //조를 이루지 못한 사람만 출력
        System.out.println(peopleNum - answer);
    }

    private void dfs(int curIdx) {
        //방문 처리
        visited[curIdx] = true;
        //다음 방문할 idx 확인
        int nextIdx = gPeople[curIdx - 1];

        //방문한적이 없으면 계속해서 dfs
        if (!visited[nextIdx]) {
            dfs(nextIdx);
        }
        //방문한적이 있는데 계산한적이 없으면 사이클만큼 answer를 올린다.
        else if (!done[nextIdx]) {
            int cycleIdx = nextIdx;
            while (cycleIdx != curIdx) {
                answer++;
                cycleIdx = gPeople[cycleIdx - 1];
            }
            //curIdx를 count
            answer++;
        }

        done[curIdx] = true;
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
