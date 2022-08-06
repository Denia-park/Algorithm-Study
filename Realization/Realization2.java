package com.company.Realization;

public class Realization2 {
    public static void main(String[] args) {
        System.out.println(solve1("a1"));
    }

    static String rangeX = "abcdefgh";
    static String rangeY = "12345678";

    private static int solve1(String coordi) {
        int answer = 0;
        int intCoordiX = rangeX.indexOf(coordi.substring(0, 1));
        int intCoordiY = rangeY.indexOf(coordi.substring(1,2));

        //1시 부터 , 시계 방향
        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {-2, 1, -1, 2, 2, 1, -1, -2};

        int intAfterMoveX = 0;
        int intAfterMoveY = 0;

        for (int i = 0; i < dx.length; i++) {
            intAfterMoveX = intCoordiX + dx[i];
            intAfterMoveY = intCoordiY + dy[i];

            if(isNotMapOut(intAfterMoveY, intAfterMoveX))
                answer ++;
        }

        return answer;
    }

    static boolean isNotMapOut(int y, int x){
        return (y >= 0 && y < 8 && x >= 0 && x < 8);
    }

}
