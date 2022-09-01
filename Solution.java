package com.company;

class Solution {
    public int[] solution(int brown, int yellow) {
        //정답 출력을 위한 int 배열 생성
        int[] answer = new int[2];

        //전체 타일의 수를 구함
        int totalTiles = brown + yellow;
        //전체 타일의 제곱근을 구한다.
        int sqrtValue = (int) Math.sqrt(totalTiles);
        //제곱근을 구해서 딱 떨어지며 정사각형 이므로 startIndex 를 제곱근 값을 하고 아닌 경우 + 1 을 한다.
        //가로 가 무조건 세로보다 길기 때문에 제곱근을 기준으로 가로의 시작 길이를 정했다.
        int startIndex = totalTiles / sqrtValue == sqrtValue ? sqrtValue : sqrtValue + 1;

        //가로 세로를 정함
        int width = 0;
        int height = 0;

        //위에서 정한 startIndex 를 기준으로 시작
        for (int i = startIndex; i < totalTiles; i++) {
            //나누어 떨어지지 않으면 continue
            if(totalTiles % i != 0) continue;
            //나누어 떨어지는 경우 계산을 통해 yellow 와 갯수가 같으면 해당 값이 올바른 가로, 세로의 값 이므로 break
            width = i;
            height = totalTiles / width;
            if((width - 2) * (height - 2) == yellow)
                break;
        }

        answer[0] = width;
        answer[1] = height;

        return answer;
    }
}
