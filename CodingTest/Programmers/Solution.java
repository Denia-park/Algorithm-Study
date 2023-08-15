package CodingTest.Programmers;

/*

아이디어
- 내 왼쪽, 오른쪽 모두에 나보다 작은 숫자가 있으면 개는 불가능

시간복잡도
- n번 돌면서
- 왼쪽 정렬, 오른쪽 정렬 후 나보다 작은 애가 있는지 탐색

자료구조

 */

class Solution {
    public int solution(int[] nums) {
        //3개보다 작으면 무조건 가능함
        if (nums.length < 3) {
            return nums.length;
        }

        //3개 이상이면 비교를 해줘야함
        int answer = 2;

        //맨 왼쪽과 , 오른쪽은 무조건 가능하다.
        for (int i = 1; i < nums.length - 1; i++) {
            int smallNumCount = 0;

            //왼쪽 체크
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    smallNumCount++;
                    break;
                }
            }

            //오른쪽 체크
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    smallNumCount++;
                    break;
                }
            }

            if (smallNumCount < 2) {
                answer++;
            }
        }

        return answer;
    }
}
