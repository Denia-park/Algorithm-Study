package CodingTest.Programmers;

import java.util.*;

//정답 참고
//https://velog.io/@fufru/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%8B%9C%EC%86%8C-%EC%A7%9D%EA%B6%81

class Solution {

    public long solution(int[] weights) {
        long answer = 0;

        Map<Integer, List<Integer>> hm = new HashMap<>();

        Set<Integer> mySet = new HashSet<>();

        int leng = weights.length;

        for (int i = 0; i < leng; i++) {
            if (!hm.containsKey(weights[i])) {
                List<Integer> myList = new ArrayList<>();
                myList.add(i);
                hm.put(weights[i], myList);
            } else {
                hm.get(weights[i]).add(i);
            }
            mySet.add(weights[i]);
        }

        for (int key : mySet) {

            int dupli = hm.get(key).size();

            int wX2 = key * 2;
            if (wX2 % 3 == 0) {
                if (hm.containsKey(wX2 / 3)) {
                    answer += (long) hm.get(wX2 / 3).size() * dupli;
                }
            }

            if (wX2 % 4 == 0) {
                if (hm.containsKey(wX2 / 4)) {
                    answer += (long) hm.get(wX2 / 4).size() * dupli;
                }
            }

            int wX3 = key * 3;
            if (wX3 % 2 == 0) {
                if (hm.containsKey(wX3 / 2)) {
                    answer += (long) hm.get(wX3 / 2).size() * dupli;
                }
            }

            if (wX3 % 4 == 0) {
                if (hm.containsKey(wX3 / 4)) {
                    answer += (long) hm.get(wX3 / 4).size() * dupli;
                }
            }

            int wX4 = key * 4;
            if (wX4 % 2 == 0) {
                if (hm.containsKey(wX4 / 2)) {
                    answer += (long) hm.get(wX4 / 2).size() * dupli;
                }
            }

            if (wX4 % 3 == 0) {
                if (hm.containsKey(wX4 / 3)) {
                    answer += (long) hm.get(wX4 / 3).size() * dupli;
                }
            }

            if (dupli > 1) {
                answer += (long) dupli * (long) (dupli - 1) / 2;
            }

            hm.remove(key);

        }
        return answer;
    }
}
