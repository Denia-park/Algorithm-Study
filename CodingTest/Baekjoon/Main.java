package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

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
    final int NORTH = 0;
    final int EAST = 1;
    final int SOUTH = 2;
    final int WEST = 3;
    int answer;
    //북 동 남 서
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void solution(int boardSize, int[][] appleTable, String[][] commandTable) {
        answer = 0;
        Deque<Coordi> snake = new ArrayDeque<>();

        Map<Coordi, Integer> appleMap = new HashMap<>();
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
        int snakeDirection = EAST;

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
            boolean isCrashExist = false;
            for (Coordi snakeCoordi : snake) {
                if (snakeCoordi.r == newCoordi.r && snakeCoordi.c == newCoordi.c) {
                    isCrashExist = true;
                    break;
                }
            }
            if (isCrashExist) {
                break;
            }

            snake.addFirst(newCoordi);
            //사과 있는지 확인 , 존재할 경우 remove 하면 value를 반환
            //없으면 null
            boolean isAppleExist = false;
            for (Coordi appCoordi : appleMap.keySet()) {
                if (appCoordi.r == newCoordi.r && appCoordi.c == newCoordi.c) {
                    appleMap.remove(appCoordi);
                    isAppleExist = true;
                    break;
                }
            }
            if (!isAppleExist) {
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
