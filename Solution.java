package com.company;

import java.util.Arrays;

public class Solution {
    static public void main(String[] args) {

        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0},{1, 2, 2, 0},{1, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 3},{0, 0, 0, 3} };

        System.out.println(Arrays.toString(solution(m, n, picture)));
    }

    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int pictureHeight;
    static int pictureWidth;
    static int[][] pictureGraph;
    static int standardValue;
    static int tempWidthValue;

    static public int[] solution(int height, int width, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        pictureGraph = new int[picture.length][picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            System.arraycopy(picture[i], 0, pictureGraph[i], 0, picture[i].length);
        }
        System.out.println(Arrays.deepToString(pictureGraph));
        pictureHeight = height;
        pictureWidth = width;
        tempWidthValue = 0; // 이름 변경하기 임시로 너비의 값을 가지고 있다는 것으로
        int[] answer = new int[2];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if(pictureGraph[y][x] != 0 ){
                    numberOfArea++; // 해당 if문에 들어올때마다 영역의 수 ++ , 연결된 영역은 한번에 다 visited 처리를 할 것이므로 또 방문하지 않기 때문에
                    tempWidthValue = 0; // 해당 영역의 너비를 구할때 사용할 임시 변수
                    standardValue = pictureGraph[y][x]; // 같은 영역인지 판단을 해줄 변수 , 내가 처음에 진입하는 그 좌표의 값을 할당한다. , 좌표의 값과 같은 부분들만 영역으로 인정한다.
                    dfs(y, x);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tempWidthValue); //위에서 정의했던 checkValue를 사용하여 지금까지 최대 영역을 구해서 대입
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static void dfs(int y, int x) {
        if (y < 0 || x < 0 || x >= pictureWidth || y >= pictureHeight || pictureGraph[y][x] == 0) {
            return;
        }

        if(pictureGraph[y][x] == standardValue){
            tempWidthValue++;
        }else{
            return;
        }

        //Visited 처리
        pictureGraph[y][x] = 0;

        dfs(y-1, x);
        dfs(y, x+1);
        dfs(y+1, x);
        dfs(y, x-1);
    }
}

