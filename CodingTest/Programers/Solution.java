package CodingTest.Programers;

import java.util.HashMap;
import java.util.Map;

//3분 -> 21분 = 18분 걸림
//처음에 set을 이용하여 풀이하려고 했으나 set은 이전의 값들을 기억하지 못하므로 효율적이지 못함

//그래서 토핑의 가지수가 다르다 => hash의 key가 다르다에서 착안하여 map을 사용함
class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        if (topping.length == 1) {
            return 0;
        }

        Map<Integer, Integer> leftSet = new HashMap<>();
        Map<Integer, Integer> rightSet = new HashMap<>();

        for (int topp : topping) {
            rightSet.put(topp, rightSet.getOrDefault(topp, 0) + 1);
        }

        for (int topp : topping) {
            leftSet.put(topp, leftSet.getOrDefault(topp, 0) + 1);

            int moveVal = rightSet.getOrDefault(topp, 0);
            if (moveVal - 1 == 0) {
                //이번에 삭제
                rightSet.remove(topp);
            } else {
                //수정값 적용
                rightSet.put(topp, moveVal - 1);
            }

            if (leftSet.size() == rightSet.size()) {
                answer++;
            }
        }

        return answer;
    }
}
