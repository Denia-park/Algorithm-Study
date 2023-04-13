package CodingTest.Programmers;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        //옮길수 있었던 택배 양
        int deliSave = 0;
        //수거할수 있었던 박스 양
        int pickUpSave = 0;

        //끝집에서부터 검사하면서 모든 택배를 가져다주거나 빈 박스를 수거
        for (int idx = deliveries.length - 1; idx >= 0; idx--) {
            //deliveries[idx], pickups[idx] 이 0보다 크면 전달 및 수거할 택배이 있다는 의미
            deliSave = deliSave - deliveries[idx];

            //옮길 수 있었던 택배양보다 전달해야 하는 택배 양이 많은 경우
            if (deliSave < 0) {
                //해당 택배를 다 전달하기 전까지는 계속 해당 집을 가야함
                while (deliSave < 0) {
                    answer += ((idx + 1) * 2); // 거리는 idx + 1, 왕복 거리 이므로 * 2 (배달 및 수거를 같이 하므로)
                    deliSave += cap;
                    pickUpSave += cap;
                }
            } else {
                deliveries[idx] = 0;
            }

            pickUpSave = pickUpSave - pickups[idx];
            //수거할 수 있었던 박스양보다 다시 수거해야 하는 박스 양이 많은 경우
            if (pickUpSave < 0) {
                //해당 박스를 다 수거하기 전까지는 계속 해당 집을 가야함
                while (pickUpSave < 0) {
                    answer += ((idx + 1) * 2); // 거리는 idx + 1, 왕복 거리 이므로 * 2 (배달 및 수거를 같이 하므로)
                    deliSave += cap;
                    pickUpSave += cap;
                }
            } else {
                pickups[idx] = 0;
            }
        }

        return answer;
    }
}
