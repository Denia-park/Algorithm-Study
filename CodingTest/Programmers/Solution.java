package CodingTest.Programmers;

import java.util.Arrays;

class Solution {
    public int[] solution(final int n) {
        //빈 배열 만들기
        final int[][] arr = new int[n][n];

        //시작 숫자 및 최대 값 지정하기
        int count = 1;
        final long maxCount = ((long) n * (n + 1)) / 2;

        //방향 지정하기
        Direction direction = Direction.DOWN;

        //시작 인덱스 정하기
        int rowIdx = 0;
        int colIdx = 0;

        //삼각형 사이즈를 조절할 변수 지정
        int height = n;
        int width = 1;

        //값 채우기
        while (count <= maxCount) {
            arr[rowIdx][colIdx] = count;

            switch (direction) {
                case DOWN:
                    if ((rowIdx + 1) == height) {
                        colIdx++;

                        //끝에 도달했으므로 방향을 바꿔야 한다.
                        direction = Direction.RIGHT;
                        break;
                    }

                    rowIdx++;

                    break;
                case UP:
                    //이미 채워진 값을 만났다 == 꼭대기에 도달했다.
                    if (arr[rowIdx - 1][colIdx - 1] != 0) {
                        rowIdx++;

                        //한번 삼각형을 완성했으므로, 삼각형의 사이즈를 줄여야 한다.
                        height--;
                        width--;

                        //끝에 도달했으므로 방향을 바꿔야 한다.
                        direction = Direction.DOWN;
                        break;
                    }

                    rowIdx--;
                    colIdx--;

                    break;
                case RIGHT:
                    if ((colIdx + 1) == rowIdx + width) {
                        colIdx--;
                        rowIdx--;

                        //끝에 도달했으므로 방향을 바꿔야 한다.
                        direction = Direction.UP;
                        break;
                    }

                    colIdx++;

                    break;
                default:
                    break;
            }

            count++;
        }

        //배열을 값으로 옮기기
        return Arrays.stream(arr)
                .flatMapToInt(Arrays::stream)
                .filter(value -> value != 0)
                .toArray();
    }

    enum Direction {
        UP,
        DOWN,
        RIGHT
    }
}
