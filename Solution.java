import java.util.ArrayList;
import java.util.List;

// https://deok2kim.tistory.com/123 정답 코드 참고
// 블럭의 한계가 있다는 것을 확인하지 못했음
class Solution {
    final int BLOCK_LIMIT = 10_000_000;

    public Integer[] solution(long begin, long end) {
        List<Integer> answerList = new ArrayList<Integer>(10000);

        for (int value = (int) begin; value <= end; value++) {
            if (value == 1) {
                answerList.add(0);
            } else {
                boolean isPrime = true;
                for (int i = 2; i <= Math.sqrt(value); i++) {
                    int mok = value / i;

                    if (mok > BLOCK_LIMIT) {
                        continue;
                    }

                    if (value % i == 0) {
                        answerList.add(mok);
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    answerList.add(1);
                }
            }
        }

        return answerList.toArray(new Integer[0]);
    }
}
