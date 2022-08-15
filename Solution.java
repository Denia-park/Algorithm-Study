package com.company;

public class Solution {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

        System.out.println(testSolution.solution(8,1,2));
        System.out.println(testSolution.solution(8,3,2));
        System.out.println(testSolution.solution(8,4,7));

    }

    public int solution(int n, int a, int b)
    {
        //처음에 바로 만나면 1라운드만에 만난 것
        int answer = 1;

        // while 문에서 조건을 비교하고 값을 변경할 변수, 처음에는 할당 받은 번호를 사용함
        int afterA = a;
        int afterB = b;

        //둘이서 승부를 하기 위해서는 바로 인접한 번호이여야 함 => Math.abs 를 사용하여 1 차이가 나는지 확인
        //그리고 두개가 1차이는 나지만 옆 조 인지 승부하는 번호인지 확인이 필요함
            //예를 들어) 2 , 3 번은 승부하는 번호가 아니고 서로 옆 조이다.
            // (1, 2) , (3, 4) 같은 케이스가 승부하는 번호
            // 승부하는 번호들로 확인해보면 두개가 2로 나눴을때 반드시 달라야 한다.
        while (!(Math.abs(afterA-afterB) == 1 && (afterA/2 != afterB/2))){
            // 승리하면 다음 라운드의 번호 지정 룰 => (현재 번호 + 1) / 2
                // 예를 들어 3번이 이기면 2번이 된다.
                // 그러므로 +1 하고 2로 정수 나누기를 하면 승리시 받을 번호가 됨.
            afterA = (afterA + 1) / 2;
            afterB = (afterB + 1) / 2;

            //다음 라운드 진출했으므로 결과에 +1를 해준다.
            answer++;
        }

        return answer;
    }
}
