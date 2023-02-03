package CodingTest.Programmers;

//푸드 파이트 대회
//1. 왼쪽 -> 오른쪽
//2. 왼쪽 <- 오른쪽
//물 먼저 먹으면 끝남 , 음식의 종류 와 양이 같다

//칼로리가 낮은 음식부터 배치
class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbReverse = new StringBuilder();

        for (int idx = 1; idx < food.length; idx++) {
            int foodNum = food[idx];

            for (int repeat = 1; repeat <= foodNum / 2; repeat++) {
                sb.append(idx);
                sbReverse.append(idx);
            }
        }
        sb.append(0);
        sb.append(sbReverse.reverse());
        
        return sb.toString();
    }
}
