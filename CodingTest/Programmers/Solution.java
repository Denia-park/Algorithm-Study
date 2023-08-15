package CodingTest.Programmers;

/*

처음 아이디어
- 내 왼쪽, 오른쪽 모두에 나보다 작은 숫자가 1개 이상 있으면 개는 지울 수 없는 숫자다

핵심 아이디어
-> 배열 최소값을 찾는다.
-> 배열 최소값을 기준으로 왼쪽 끝, 오른쪽 끝에서부터 값 비교를 시작한다.
-> 배열 최소값은 무조건 제일 작은 값이므로, 나보다 작은 값을 지우는 기회는 무조건 배열 최소값 지우는데에다가 써야한다.

-> 그렇다는건 배열 최소값 기준으로 비교를 하면 편한게 값을 구할 수 있다.
예시 1) 배열 최소값 기준 왼쪽 끝에서부터 비교를 시작하면, 비교하는 수는 오른쪽엔 무조건 배열 최소값이 존재하므로 내 왼쪽에 있는 숫자들만 신경 쓰면 된다.
        - 왼쪽에 있는 숫자를 편하게 비교하기 위해서는 왼쪽 끝부터 지금까지의 최소값을 갱신하면서 오른쪽으로 이동을 하면 편하게 계산이 가능하다.
        (왼쪽편의 최소값을 알고 있으니 현재 비교하는 수가 왼쪽편의 최소값보다 크다면 개는 양쪽에 자기보다 작은 값 (왼쪽 : 왼쪽편의 최소값, 오른쪽 : 배열 최소값)을 가지게 되므로 무조건 터짐)

예시 2) 최소값 기준 오른쪽 끝에서부터 비교를 시작하면, 비교하는 수는 왼쪽엔 무조건 최소값이 존재하므로 내 오른쪽에 있는 숫자들만 신경 쓰면 된다.
        - 오른쪽에 있는 숫자를 편하게 비교하기 위해서는 오른쪽 끝부터 최소값을 갱신하면서 왼쪽으로 이동을 하면 편하게 계산이 가능하다.
        (오른쪽 최소값을 알고 있으니 현재 비교하는 수가 최소값보다 크다면 개는 양쪽에 자기보다 작은 값 (왼쪽 : 배열 최소값, 오른쪽 : 오른편의 최소값)을 가지게 되므로 무조건 터짐)

시간복잡도
- O(n)

자료구조

 */

class Solution {
    public int solution(int[] a) {
        if (a.length < 3) {
            return a.length;
        }

        int answer = 1; //배열 최소값 -> 무조건 살아남음

        int minIdx = 0;
        int minVal = Integer.MAX_VALUE;

        //배열 최소값의 idx 찾기
        for (int idx = 0; idx < a.length; idx++) {
            int curVal = a[idx];

            if (curVal < minVal) {
                minIdx = idx;
                minVal = curVal;
            }
        }


        //왼쪽 끝에서부터 탐색, 오른쪽 끝에서부터 탐색
        int leftIdx = 0;
        int leftMinVal = a[leftIdx];
        int rightIdx = a.length - 1;
        int rightMinVal = a[rightIdx];

        while (leftIdx < minIdx || rightIdx > minIdx) {
            int leftVal = a[leftIdx];
            int rightVal = a[rightIdx];

            if (leftVal <= leftMinVal && leftIdx < minIdx) {
                answer++;
                leftMinVal = leftVal;
            }


            if (rightVal <= rightMinVal && rightIdx > minIdx) {
                answer++;
                rightMinVal = rightVal;
            }

            leftIdx++;
            rightIdx--;
        }

        return answer;
    }
}
