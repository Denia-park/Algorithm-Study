package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//[JAVA] contains 함수의 재밌는 원리
//https://teambtd.tistory.com/12
//[java] hashcode()와 equals() 메서드는 언제 사용하고 왜 사용할까?
//https://jisooo.tistory.com/entry/java-hashcode%EC%99%80-equals-%EB%A9%94%EC%84%9C%EB%93%9C%EB%8A%94-%EC%96%B8%EC%A0%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B3%A0-%EC%99%9C-%EC%82%AC%EC%9A%A9%ED%95%A0%EA%B9%8C
//[Java] 자바 TreeMap 사용법 & 예제 총정리
//https://coding-factory.tistory.com/557
public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int boardSize = Integer.parseInt(br.readLine());
        int appleNum = Integer.parseInt(br.readLine());

        int[][] appleTable = new int[appleNum][2];

        for (int r = 0; r < appleNum; r++) {
            String[] row = br.readLine().split(" ");
            for (int i = 0; i < 2; i++) {
                appleTable[r][i] = Integer.parseInt(row[i]);
            }
        }

        int commandNum = Integer.parseInt(br.readLine());
        String[][] commandTable = new String[commandNum][2];

        for (int r = 0; r < commandNum; r++) {
            commandTable[r] = br.readLine().split(" ");
        }

        sol.solution(boardSize, appleTable, commandTable);
    }
}

class BjSolution {
    int answer;
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //북 동 남 서

    public void solution(int boardSize, int[][] appleTable, String[][] commandTable) {
        answer = 0;
        Deque<Coordi> snake = new ArrayDeque<>();

        Map<Coordi, Integer> appleMap = new HashMap<>();
        //1행 1열 기준으로 해서 좌표가 주어짐
        for (int[] apple : appleTable) {
            appleMap.put(new Coordi(apple[0] - 1, apple[1] - 1), 1);
        }

        Map<Integer, String> commandMap = new HashMap<>();
        for (String[] command : commandTable) {
            commandMap.put(Integer.parseInt(command[0]), command[1]);
        }

        //처음 뱀의 길이는 1 , (0,0) 좌표 추가
        snake.addLast(new Coordi(0, 0));
        //처음에는 오른쪽으로 이동
        int snakeDirection = 1;

        while (true) {
            answer++;

            Coordi snakeHead = snake.peekFirst();

            int newRow = snakeHead.r + directions[snakeDirection][0];
            int newCol = snakeHead.c + directions[snakeDirection][1];

            Coordi newCoordi = new Coordi(newRow, newCol);

            //벽에 부딪히지 않는지
            if (newCoordi.r < 0 || newCoordi.r >= boardSize
                    || newCoordi.c < 0 || newCoordi.c >= boardSize) break;
            //내 몸이랑 부딪히지 않는지 확인
            if (snake.contains(newCoordi)) break;

            snake.addFirst(newCoordi);
            //사과 있는지 확인 , 존재할 경우 remove 하면 value를 반환
            //없으면 null
            if (appleMap.remove(newCoordi) == null) {
                snake.pollLast();
            }

            String newDirection = commandMap.get(answer);
            if (newDirection == null) {

            } else if (newDirection.equals("L")) {
                snakeDirection = (snakeDirection + directions.length - 1) % directions.length;
            } else if (newDirection.equals("D")) {
                snakeDirection = (snakeDirection + directions.length + 1) % directions.length;
            }
        }

        System.out.println(answer);
    }
}

class Coordi {
    int r, c;

    public Coordi(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordi coordi = (Coordi) o;
        return r == coordi.r && c == coordi.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, c);
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
