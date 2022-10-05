class Solution {
    //checkAllElements 메서드를 돌면서 0 과 1의 개수를 체크
    int zeroCount;
    int oneCount;
    public int[] solution(int[][] arr) {
        //답을 정의할 answer 초기화
        int[] answer = new int[2];

        //0의 개수 초기화
        zeroCount = 0;
        //1의 개수 초기화
        oneCount = 0;

        //arr을 돌면서 맨 처음에 주어진 0 과 1의 개수를 센다.
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if(anInt == 0)
                    zeroCount++;
                else
                    oneCount++;
            }
        }

        //분할 정복을 진행할 메서드
        checkAllElements(arr, new int[]{0, 0}, arr.length);

        //최종적으로 구한 zeroCount 및 oneCount 를 answer 배열에 할당 후 return
        answer[0] += zeroCount;
        answer[1] += oneCount;

        return answer;
    }

    //arr는 확인을 진행할 arr
    //start 는 시작점의 좌표를 int[] 형태로 받는다.
    //length는 start 좌표로 부터 확인할 좌표의 row 와 col 수
    private void checkAllElements(int[][] arr, int[] start ,int length) {
        //길이가 1 이면 더이상 메서드를 진행할 필요 X
        if (length == 1)
            return;

        //쿼드트리 진행 플래그
        boolean flag = true;

        //쿼드 트리를 확인할 startValue
        int startValue = arr[start[0]][start[1]];

        //2중 for문을 돌면서 쿼드트리 조건 확인
        out:
        for (int row = start[0]; row < start[0] + length; row++) {
            for (int col = start[1]; col < start[1] + length; col++) {
                if (startValue != arr[row][col]) {
                    flag = false;
                    break out;
                }
            }
        }

        //플래그가 true 이면 쿼드 트리 진행이 된 것 이므로,
        //처음에 개수를 센 0 과 1의 개수를 조정한다.
        //쿼드 트리를 진행한 요소의 수 만큼 빼준다.
        if (flag) {
            int tempValue = (int) Math.pow(length, 2) - 1;

            if (startValue == 0)
                zeroCount -= tempValue;
            else
                oneCount -= tempValue;

            return;
        }


        //정사각형을 4개로 쪼개서 분할정복을 시작해야 하므로 각각 조건에 맞춰서 메서드를 진행
        checkAllElements(arr, start, length / 2);
        checkAllElements(arr, new int[]{start[0], start[1] + length / 2}, length / 2);
        checkAllElements(arr, new int[]{start[0] + length / 2, start[1]}, length / 2);
        checkAllElements(arr, new int[]{start[0] + length / 2, start[1] + length / 2}, length / 2);
    }
}
