package CodingTest.Programmers;

import java.util.Arrays;

/*
아이디어
- 이분탐색을 사용한다.

시간복잡도
- O(N * lnN)

자료형
- int
 */
class Solution {
    public int solution(final int destinationDistance, final int[] rocksPosition, final int maxDeleteCount) {
        int answer = 0;

        //계산을 편리하게 하기 위해서 정렬을 한다.
        Arrays.sort(rocksPosition);

        // 모든 바위 사이의 거리를 저장할 배열
        final int[] distance = new int[rocksPosition.length + 1];
        distance[0] = rocksPosition[0]; // 0에서 첫번째 바위와의 거리
        distance[rocksPosition.length] = destinationDistance - rocksPosition[rocksPosition.length - 1]; // 마지막 바위에서 도착지점과의 거리

        // 모든 바위 사이의 거리를 구함
        for (int i = 1; i < rocksPosition.length; i++) {
            distance[i] = rocksPosition[i] - rocksPosition[i - 1];
        }

        //바위들 사이의 거리를 이분탐색으로 조절을 해가면서,
        //바위들 사이의 거리가 최소 값 중에서 최대가 되도록 한다.
        int left = 0;
        int right = destinationDistance;
        while (left <= right) {
            //바위들 사이의 거리의 최소값
            final int minDistance = left + (right - left) / 2;

            //제거한 바위의 수
            final int removeCount = getRemoveCount(distance, minDistance);

            //제거한 바위의 수가 제거할 수 있는 바위의 수보다 많다면,
            //거리를 너무 좁게한 것 -> 최소 거리를 늘린다.
            if (removeCount > maxDeleteCount) {
                right = minDistance - 1;
            }
            //최소한의 거리 중에 최대값을 찾아야 하므로, 바위를 제대로 지웠어도
            //최소 거리를 늘려서 다시 시도해본다.
            else {
                left = minDistance + 1;
                answer = Math.max(answer, minDistance);
            }
        }

        return answer;
    }

    private int getRemoveCount(final int[] distance, final int minDistance) {
        int removeCount = 0; //제거한 바위의 개수
        int removedDistance = 0; //제거한 바위들 사이의 거리

        //내가 정한 바위 사이의 최소 거리를 기준으로
        //없애야 하는 바위의 수를 카운트한다.
        for (final int betweenDistance : distance) {
            //바위들 사이의 거리가 최소값보다 작다면, 바위를 제거한다.
            //내가 정한 최소 값의 거리만큼 바위들이 떨어져있을 수 있도록 한다.
            removedDistance += betweenDistance;

            if (removedDistance < minDistance) {
                removeCount++;
            }
            //바위를 제거한 후, 바위들 사이의 거리를 다시 계산한다.
            else {
                removedDistance = 0;
            }
        }

        return removeCount;
    }
}
