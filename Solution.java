import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];
        List<Integer> primeList = new ArrayList<Integer>();

        long myNum = begin;

        primeList.add(2);

        for (int val = 3; val <= begin; val += 2) {
            boolean addFlag = true;

            for (Integer integer : primeList) {
                if (val % integer == 0) {
                    addFlag = false;
                    break;
                }
            }

            if (addFlag) {
                primeList.add((int) val);
            }
        }

        for (int idx = 0; idx <= (end - begin); idx++) {
            if (myNum == 1) {
                answer[idx] = 0;
            } else {
                boolean addFlag = true;
                for (Integer integer : primeList) {
                    if (myNum % integer == 0) {
                        answer[idx] = (int) (myNum / integer);
                        addFlag = false;
                        break;
                    }
                }
                if (addFlag) {
                    answer[idx] = 1;
                    primeList.add((int) myNum);
                }
            }

            myNum++;
        }

        return answer;
    }
}
