package com.company;

class Solution {
    //확인해야 하는 direction 의 dx , dy를 정의 , 계산을 쉽게 하기 위해 마지막에 {-1,0} 을 또 추가함
    int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}};
    //다른 메서드에서 boardHeight 사용하기 위해서 변수 설정
    int boardHeight;
    //다른 메서드에서 boardWidth 사용하기 위해서 변수 설정
    int boardWidth;
    //String 배열 대신에 board 값을 쉽게 컨트롤 하기 위해서 char 2차원 배열로 설정
    char[][] boardCharArr;
    public int solution(int height, int width, String[] board) {
        //정답을 저장할 변수
        int answer = 0;

        //boardHeight, boardWidth 를 board 에 해당하는 값으로 초기화
        boardHeight = height;
        boardWidth = width;

        //boardCharArr 초기화
        boardCharArr = new char[height][width];

        //String 배열인 board 를 char 2차원 배열로 변환하는 과정
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boardCharArr[i][j] = board[i].charAt(j);
            }
        }

        //boardCharArr 을 무한 루프 돌면서 블럭을 처리
        while(true) {
            //블럭의 모든 요소들을 돌면서 삭제 해야하는 블럭을 확인 후 isDeletedBlock 으로 반환
            boolean[][] isDeletedBlock = checkBlockInBoard();

            //null 이 나오면 지울 게 없다는 것, while문 종료
            if (isDeletedBlock == null) break;

            //isDeletedBlock 의 값에 맞춰서 블럭을 삭제하고, 공중에 떠있는 블럭을 아래로 내린다.
            // 그리고 여기서 나온 반환값으로 answer 를 업데이트
            answer += updateBoard(isDeletedBlock);
        }

        return answer;
    }

    private boolean[][] checkBlockInBoard() {
        //몇개의 블럭을 지워야 하는지 저장할 변수
        int deleteCount = 0;

        //return 해줄 2차원 boolean 배열을 저장
        boolean[][] isDeletedBlock = new boolean[boardHeight][boardWidth];

        //boardCharArr 의 모든 요소를 돌면서 인접한 블럭 중에 지워야 하는 블럭이 있는지 확인
        //지워야 하는 블럭의 수가 있으면 deleteCount 에 합해준다.
        for (int heightIndex = 0; heightIndex < boardHeight; heightIndex++) {
            for (int widthIndex = 0; widthIndex < boardWidth; widthIndex++) {
                deleteCount += checkNearBlockToDelete(heightIndex, widthIndex, isDeletedBlock);
            }
        }

        //지워야 하는 블럭이 있으면 2차원 boolean 배열을 반환 , 지워야 하는 블럭이 없으면 null 을 반환
        return deleteCount == 0 ? null : isDeletedBlock;
    }

    //해당 좌표의 근처를 모둗 확인하여 지워야 하는 블럭이 있는지 확인한다.
    private int checkNearBlockToDelete(int heightIndex, int widthIndex, boolean[][] isDeletedBlock) {
        //몇개의 블럭을 지워야 하는지 저장할 변수
        int deleteCount = 0;

        //처음에 받아온 좌표에 어떤 글자가 들어있는지 저장
        char c = boardCharArr[heightIndex][widthIndex];

        //해당 칸이 공백일 경우 확인하지 않고 해당 메서드를 종료
        if(c == ' ') return 0;

        //4방향에 대해서 체크
            //1시, 5시, 7시, 11시 에 4개의 블럭들이 존재하는지 확인
        for (int i = 0; i < 4; i = i + 2) {
            boolean isExistDeleteBlockInThisDirection = true;
            //방향당 자기 주변 블럭 체크 , directions 변수 에 자기 주변 블럭 체크 용 dx, dy 기입해둠
            for (int j = i; j < i + 3; j++) {
                //moveHeight , moveWidth 에 가상으로 옮긴 좌표를 대입
                int moveHeight = heightIndex + directions[j][0];
                int moveWidth = widthIndex + directions[j][1];

                //moveHeight , moveWidth 가 올바른 index를 가지고 있지 않거나,
                //확인해야 하는 글자와 동일한 글자를 가지고 있지 않으면
                //해당 방향은 지워야 하는 블럭들이 존재하지 않으므로 isExistDeleteBlockInThisDirection 를 false로 변경 후 break
                if (!isRightIndex(moveHeight, moveWidth) || boardCharArr[moveHeight][moveWidth] != c) {
                    isExistDeleteBlockInThisDirection = false;
                    break;
                }
            }

            // isExistDeleteBlockInThisDirection 가 false 면 해당 방향은 지워야 하는 블럭이 존재하지 않으므로 다음 방향을 살펴본다.
            if(!isExistDeleteBlockInThisDirection) continue;

            //지워야 하는 블럭이 존재하므로 좌표값에 맞게 isDeletedBlock 에 체크를 해둔다.
            //그리고 지워야 하는 블럭의 개수를 deleteCount 에 업데이트
            for (int j = i; j < i + 3; j++) {
                int moveHeight = heightIndex + directions[j][0];
                int moveWidth = widthIndex + directions[j][1];

                isDeletedBlock[moveHeight][moveWidth] = true;
                deleteCount++;
            }
        }

        return deleteCount;
    }

    //올바른 Index를 가지고 있는지 확인하는 메서드
    private boolean isRightIndex(int heightIndex, int widthIndex){
        return 0 <= heightIndex && heightIndex < boardHeight && 0 <= widthIndex && widthIndex < boardWidth;
    }


    //boardCharArr 의 내용을 업데이트 하는 메서드
    private int updateBoard(boolean[][] isDeletedBlock) {
        //지운 블럭의 수를 return
        int deleteCount = 0;

        //isDeletedBlock 을 확인하여 지워야 하는 블럭을 확인하고
        // 지운 블럭들은 boardCharArr에 ' ' 로 변경 
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                if(isDeletedBlock[i][j]){
                    boardCharArr[i][j] = ' ';
                    deleteCount++;
                }
            }
        }

        //먼저 열을 기준으로 하여 행을 돌면서 ' '이 있는지 확인
        //' '인 행 위로 ' '이 아닌 글자가 있으면 아래로 가져온다.
        for (int i = 0; i < boardWidth; i++) {
            for (int j = boardHeight - 1; j >= 0; j--) {
                //해당 칸이 ' '이면
                if(boardCharArr[j][i] == ' '){
                    //바로 윗 행부터 첫 행까지 돌면서 글자가 있는 칸을 찾고 그 칸을 현재의 ' '칸에 대입
                    for (int k = j - 1; k >= 0; k--) {
                        char tempChar = boardCharArr[k][i];
                        if(tempChar != ' '){
                            boardCharArr[j][i] = tempChar;
                            boardCharArr[k][i] = ' ';
                            break;
                        }
                    }
                }
            }
        }

        //지운 deleteCount 반환
        return deleteCount;
    }
}
