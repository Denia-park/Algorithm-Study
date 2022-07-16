package com.company;

import java.util.Stack;

class Solution {
    static public void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));
    }

    static public int solution(int[][] board, int[] moves) {
        //초기값 지정
        int answer = 0;
        //인형을 넣을 스택을 만들어준다.
        Stack<Integer> stack = new Stack<Integer>();

        //moves 처리 , for문 돌면서 1개 1개 확인
        for (int move : moves) {
            //배열이기 때문에 index는 -1이 필요함
            int index = move - 1;

            //2차원 배열이므로 1차원 배열을 꺼내서 확인한다/
            for (int[] boardRow : board) {
                //Board 해당 Row에서 Index를 확인하면 인형을 확인가능
                int doll = boardRow[index];

                //인형이 존재하는 경우
                if(doll != 0){
                    //인형을 꺼내므로 해당 자리에 인형이 없다는 의미에 0을 넣음
                    boardRow[index] = 0;
                    //인형을 꺼내고 stack에 넣기전에 비교 , 맨 위의 인형이랑 동일한 인형이면 "터트리고" answer 를 +2 하자
                    if(!stack.empty() && stack.peek() == doll){
                        stack.pop(); // 기존 인형 터트리기 , 새로 뽑은 인형은 넣지도 않는다
                        answer += 2; // answer 값 +2 시키기
                    }
                    //인형이 동일하지 않으면 쌓기
                    else {
                        stack.push(doll);
                    }

                    //인형을 찾았으므로 break 문으로 빠져나온다.
                    break;
                }
            }
        }

        return answer;
    }
}

