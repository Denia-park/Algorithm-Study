package com.company;

//DFS 이용하기
    //도착하면 길이값을 return, 그 중에서도 제일 낮은 값을 return 해야함
    //도착하지 못하면 -1 을 return

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] dRowCol = {{-1,0}, {0,1}, {1,0}, {0,-1}};//상우하좌
    int[][] graph ;
    int answer;
    public int solution(int[][] maps) {
        graph = maps;
        answer = Integer.MAX_VALUE;

        dfs();

        return answer;
    }

    private void dfs() {
        Queue<MyCharacter> queue = new LinkedList<>();

        //시작은 1,1 => 행렬의 index로 계산하면 0,0
        //시작할때 1칸을 먹고 시작하므로 처음부터 거리는 1칸부터 시작
        queue.add(new MyCharacter(0, 0,1));
        //visited
        graph[0][0] = 0;

        while (!queue.isEmpty()) {
            MyCharacter tempCharacter = queue.poll();
            int tempRow = tempCharacter.getRow();
            int tempCol = tempCharacter.getCol();
            int tempCount = tempCharacter.getPathCount();
            if(tempRow == (graph.length - 1) && tempCol == (graph[0].length - 1))
                answer = Math.min(answer, tempCount);

            for (int i = 0; i < dRowCol.length; i++) {
                int tempRow2 = tempRow + dRowCol[i][0];
                int tempCol2 = tempCol + dRowCol[i][1];
                if(!isOutOfMatrix(tempRow2, tempCol2) && graph[tempRow2][tempCol2] == 1) {
                    queue.add(new MyCharacter(tempRow2, tempCol2, tempCount + 1));
                    graph[tempRow2][tempCol2] = 0;
                }
            }
        }

        if(answer == Integer.MAX_VALUE)
            answer = -1;
    }

    private boolean isOutOfMatrix(int row, int col) {
        return row < 0 || col < 0 || row >= graph.length || col >= graph[0].length;
    }
}

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
