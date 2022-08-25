package com.company;

class Solution {
    public int[] solution(String[][] places) {
        //answer 를 return 하기 위해서 배열 만듬
        int[] answer = new int[places.length];

        //places 를 하나씩 확인하기 위해서 index를 생성하고 , foreach 문을 사용
        //isKeepingDistanceInPlace 에서 주어진 place 가 거리두기를 제대로 하는지 확인
        int index = 0;
        for (String[] place : places){
            answer[index++] = isKeepingDistanceInPlace(place);
        }
        return answer;
    }

    private int isKeepingDistanceInPlace(String[] place) {
        //place 가 주어졌을 때 모든 자리를 확인하면서 거리두기를 제대로 하는지 확인
        //모든 자리를 확인하기 위해서 2중 for문 을 사용
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[0].length(); j++) {
                //사람이 있는 자리만 검사를 수행함
                // isKeepingDistanceAtSeat 은 해당 자리에 있는 사람 주위로 거리두기가 제대로 되는지 확인
                // 사람이 있는 자리인데 거리두기가 제대로 되지 않았으면 0을 return한다.
                // 사람이 앉지 않은 자리이면 확인할 필요가 없다
                if( place[i].charAt(j) == 'P' && !isKeepingDistanceAtSeat(i,j,place))
                    return 0;
            }
        }
        //거리두기가 모두 제대로 된 place 라면 1을 return한다
        return 1;
    }

    //해당 좌석 주위로 거리두기가 제대로 되었는지 확인
    private boolean isKeepingDistanceAtSeat(int row, int column, String[] place) {
        //1칸씩 상하좌우 계산
        int[][] dxy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상 우 하 좌
        //2칸씩 상하좌우 계산
        int[][] dxy2 = {{-2, 0}, {0, 2}, {2, 0}, {0, -2}}; // 상 우 하 좌
        //대각선 계산
        int[][] ddiagonal = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}}; // 1 5 7 11
        // 1.상 하 좌 우 에 사람이 있는지 확인하기. (1칸 ,2칸 모두 계산)
        for (int i = 0; i < dxy.length; i++) {
            //Row1 , Column1은 1칸 떨어져있는 좌표
            int tempRow1 = row + dxy[i][0];
            int tempColumn1 = column + dxy[i][1];

            //범위를 벗어나지 않는지 확인 , 벗어나면 continue
            if (isOutOfMatrix(tempRow1, tempColumn1, place))
                continue;

            //1칸씩 떨어진 자리에 사람이 있으면 false 를 반환
            if (place[tempRow1].charAt(tempColumn1) == 'P') {
                return false;
            }

            //Row2 , Column2은 2칸 떨어져있는 좌표
            int tempRow2 = row + dxy2[i][0];
            int tempColumn2 = column + dxy2[i][1];

            //범위를 벗어나지 않는지 확인 , 벗어나면 continue
            if (isOutOfMatrix(tempRow2, tempColumn2, place))
                continue;

            //2칸 떨어진 자리에 사람이 있는데 사이에 벽이 없으면 false 를 반환
            if (place[tempRow2].charAt(tempColumn2) == 'P' && place[tempRow1].charAt(tempColumn1) != 'X') {
                return false;
            }
        }

        // 2. 대각선을 확인
        for (int i = 0; i < ddiagonal.length; i++) {
            //RowD, ColumnD은 대각선에 위치한 좌표
            int tempRowD = row + ddiagonal[i][0];
            int tempColumnD = column + ddiagonal[i][1];

            //범위를 벗어나지 않는지 확인 , 벗어나면 continue
            if (isOutOfMatrix(tempRowD, tempColumnD, place))
                continue;

            //대각선에 사람이 존재할 경우
            //그 사람과 나 사이의 1의 거리만큼에 해당하는 좌표에는 벽이 존재해야함
            // 예를 들어 1시에 사람이 존재할 경우 12시 와 3시에는 벽이 존재해야한다.
                //그래서 대각선에 위치한 사람과 나 사이의 벽을 확인하기 위해서
                //for문을 사용하여 2개의 벽이 존재하는지 확인 - 이때 다시 dxy 배열을 사용함
                //2군데중에 한곳이라도 벽이 없으면 false를 return
            if (place[tempRowD].charAt(tempColumnD) == 'P') {
                for (int j = 0; j < 2; j++) {
                    int selectDxy = (i + j) % ddiagonal.length;
                    int tempRow1 = row + dxy[selectDxy][0];
                    int tempColumn1 = column + dxy[selectDxy][1];
                    if(place[tempRow1].charAt(tempColumn1) != 'X')
                        return false;
                }
            }
        }

        //거리를 다 잘 지키면 true;
        return true;
    }

    //거리가 벗어났는지 확인하기 위한 메서드
    private  boolean isOutOfMatrix(int rowIndex , int columnIndex , String[] matrix ){
        return rowIndex < 0 || columnIndex < 0 || rowIndex >= matrix.length || columnIndex >= matrix[0].length();
    }
}
