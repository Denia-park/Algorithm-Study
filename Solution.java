package com.company;

//BFS 이용하기
    //도착하면 길이값을 return, 그 중에서도 제일 낮은 값을 return 해야함
    //도착하지 못하면 -1 을 return

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 4방향으로 움직일때 필요한 좌표를 생성
    int[][] dRowCol = {{-1,0}, {0,1}, {1,0}, {0,-1}};//상우하좌
    // maps를 받아서 저장해둘 2차원 int 배열 생성
    int[][] graph ;
    // dfs 메서드 안에서도 answer에 접근하기 위해서 answer 를 전역변수로 설정
    int answer;
    public int solution(int[][] maps) {
        //graph 에 maps를 지정
        graph = maps;
        //최단 거리를 구해야 하므로 answer의 맨 처음에는 int의 최대값을 지정
        answer = Integer.MAX_VALUE;

        //dfs 메서드 실행
        dfs();

        //answer를 return
        return answer;
    }

    private void dfs() {
        //dfs에서 Queue를 이용하므로 생성
        Queue<MyCharacter> queue = new LinkedList<>();

        //시작은 1,1 => 행렬의 index로 계산하면 0,0
        //시작할때 1칸을 먹고 시작하므로 처음부터 거리는 1칸부터 시작
        queue.add(new MyCharacter(0, 0,1));
        //visited 처리
        graph[0][0] = 0;

        //Queue가 빌때까지 while문을 실행
        while (!queue.isEmpty()) {
            //Queue 안에 들어있던 원소를 하나 꺼냄
            MyCharacter tempCharacter = queue.poll();
            //원소의 멤버 모두 꺼내서 임시변수로 저장
            int tempRow = tempCharacter.getRow();
            int tempCol = tempCharacter.getCol();
            int tempCount = tempCharacter.getPathCount();

            //원소의 좌표가 목적지에 도달하면 answer를 업데이트.
            //최단 거리를 구해야하므로 Math.min 을 사용
            if(tempRow == (graph.length - 1) && tempCol == (graph[0].length - 1))
                answer = Math.min(answer, tempCount);

            //4방향으로 돌면서 Queue에 넣어줄 원소를 찾는다.
            for (int i = 0; i < dRowCol.length; i++) {
                //아까 꺼낸 원소의 좌표에다가 4방향 이동하면 변하게될 좌표를 더해서 이동시의 좌표를 구한다.
                int tempRow2 = tempRow + dRowCol[i][0];
                int tempCol2 = tempCol + dRowCol[i][1];
                //옮겨지는 좌표가 Matrix의 범위를 벗어나지 않고 , 방문처리가 되어있지 않으면
                // Queue 의 원소로 집어넣고 , 방문처리를 한다.
                if(!isOutOfMatrix(tempRow2, tempCol2) && graph[tempRow2][tempCol2] == 1) {
                    //Queue에 데이터를 집어넣기
                    queue.add(new MyCharacter(tempRow2, tempCol2, tempCount + 1));
                    //visited 처리
                    graph[tempRow2][tempCol2] = 0;
                }
            }
        }

        //목적지에 도달하지 못해서 단 한번도 업데이트가 되지 못한경우 -1을 return 해야한다.
        if(answer == Integer.MAX_VALUE)
            answer = -1;
    }

    //Matrix 밖으로 벗어났는지 확인하기 위해서 메서드 생성
    private boolean isOutOfMatrix(int row, int col) {
        return row < 0 || col < 0 || row >= graph.length || col >= graph[0].length;
    }
}

//Queue에 넣을 클래스 생성
class MyCharacter {
    int row;
    int col;
    int pathCount;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getPathCount() {
        return pathCount;
    }

    public MyCharacter(int row, int col , int pathCount) {
        this.row = row;
        this.col = col;
        this.pathCount = pathCount;
    }
}
