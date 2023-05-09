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
- 연결을 따라가다 보면 무조건 싸이클을 만나게 되어있다. (싸이클을 만나야 끝이 난다)
- 싸이클을 확인해야 함
- 싸이클을 만나면 해당 싸이클만큼 계산을 해야함
- 참여하지 못한 학생들의 수를 표시해야 하므로 전체 인원수에서 사이클 인원수를 빼야 한다.

2. 시간 복잡도
- 그냥 완탐 돌리면 O(N^2)으로 시간 초과가 난다. 10억 나옴
- O(N)으로 탐색을 해야함

3. 자료 구조
- 계속해서 들어가면서 값을 확인해야 하므로, 재귀 혹은 while을 쓴다. (dfs)
- 방문했는지 확인할 boolean[] visited
- 해당 싸이클이 이미 내가 검증한 싸이클인지 확인할 boolean[] done
*/

class BjSolution {
    //싸이클 판별을 위해 방문을 했는지 체크
    boolean[] visited;
    //이미 계산이 끝난 사람인지 확인을 위해 체크
    boolean[] done;
    int answer;

    public void solution(int peopleNum, int[] people) {
        answer = 0;
        //계산을 편리하게 하려고 1 큰 값을 사용
        visited = new boolean[peopleNum + 1];
        done = new boolean[peopleNum + 1];

        for (int i = 0; i < people.length; i++) {
            int curIdx = i + 1;

            //이미 계산이 끝난 사람이면 더 이상 확인할 필요가 없다.
            if (done[curIdx]) continue;

            dfs(people, curIdx);
        }

        System.out.println(peopleNum - answer);
    }

    //1 -> 3 -> 3 -> ...
    //1번에서 시작했지만 끝은 싸이클에서 끝나는 것을 알 수 있다.

    //4 -> 7 -> 6 -> 4 -> ...
    //현재 6번 상황이면 방문한 곳을 또 방문했는데, 아직 done이 안되어있으므로 싸이클을 계산한다.
    private void dfs(int[] people, int curIdx) {
        visited[curIdx] = true;

        int nextIdx = people[curIdx - 1];

        if (!visited[nextIdx]) {
            dfs(people, nextIdx);
            done[curIdx] = true;
            return;
        }

        //방문을 한번 한적이 있는데, 아직 계산을 안했으면 지금 딱 싸이클에 도달했다는 의미.
        if (visited[nextIdx] && !done[nextIdx]) {
            //계산 완료
            done[curIdx] = true;

            //싸이클 인원 수 만큼 계산을 해야함.
            int tempNextIdx = nextIdx;

            while (tempNextIdx != curIdx) {
                answer++;
                tempNextIdx = people[tempNextIdx - 1];
            }

            //나도 카운팅 해야함
            answer++;
        }
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
