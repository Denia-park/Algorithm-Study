package com.company;


class Solution {
    int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}};
    int boardHeight;
    int boardWidth;
    public int solution(int height, int width, String[] board) {
        int answer = 0;

        boardHeight = height;
        boardWidth = width;

        while(true) {
            boolean[][] isDeletedBlock = checkBlockInBoard(board);

            //null 이 나오면 지울 게 없다는 것, while문 종료
            if (isDeletedBlock == null) break;

            //updateBoard , 여기서 answer 반환
            answer = updateBoard(board , isDeletedBlock);
        }

        return answer;
    }

    private int updateBoard(String[] board, boolean[][] isDeletedBlock) {
        int answer = 0;
        int height = board.length;;
        int width = board[0].length();

        for (int i = 0; i < height; i++) {
            String tempStr = "";
            for (int j = 0; j < width; j++) {
                char tempChar;
                if(isDeletedBlock[i][j]){
                    tempChar = ' ';
                    answer++;
                }else {
                    tempChar = board[i].charAt(j);
                }
                tempStr = tempStr + tempChar;
            }

            board[i] = tempStr;
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if(board[j].charAt(i) == ' '){
                    
                }
            }
        }


        return answer;
    }

    private boolean[][] checkBlockInBoard(String[] board) {
        int height = board.length;;
        int width = board[0].length();
        int deleteCount = 0;

        boolean[][] isDeletedBlock = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                deleteCount += checkFourBlockExist(board, i, j, isDeletedBlock);
            }
        }

        return deleteCount == 0 ? null : isDeletedBlock;
    }

    private int checkFourBlockExist(String[] board, int heightIndex, int widthIndex, boolean[][] isDeletedBlock) {
        int deleteCount = 0;

        char c = board[heightIndex].charAt(widthIndex);

        if(c == ' ') return 0;

        //4방향에 대해서 체크
            //1시, 5시, 7시, 11시 에 4개의 블럭들이 존재하는지 확인
        directionCheck : for (int i = 0; i < 4; i = i + 2) {
            //방향당 자기 주변 블럭 체크 , directions 변수 에 자기 주변 블럭 체크 용 dx, dy 기입해둠
            for (int j = i; j < i + 3; j++) {
                int moveHeight = heightIndex + directions[j][0];
                int moveWidth = widthIndex + directions[j][1];

                if (!isRightIndex(moveHeight, moveWidth) || board[moveHeight].charAt(moveWidth) != c) {
                    continue directionCheck;
                }
            }
            //4개의 블럭이 겹치므로 isDeletedBlock 에 체크를 해둔다.
            for (int j = i; j < i + 3; j++) {
                int moveHeight = heightIndex + directions[j][0];
                int moveWidth = widthIndex + directions[j][1];

                isDeletedBlock[moveHeight][moveWidth] = true;
                deleteCount++;
            }
        }
        return deleteCount;
    }

    private boolean isRightIndex(int heightIndex, int widthIndex){
        return 0 <= heightIndex && heightIndex < boardHeight && 0 <= widthIndex && widthIndex < boardWidth;
    }

}
