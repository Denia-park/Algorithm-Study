class Solution {
    public int solution(int target) {
        int answer = 0;

        MyNumber myNumber = new MyNumber(1, 1);

        while (myNumber.start <= target) {
            if (myNumber.sum < target) {
                myNumber.updateSumWithEnd();
            } else if (myNumber.sum > target) {
                myNumber.updateSumWithStart();
            } else {
                answer++;

                myNumber.updateSumWithEnd();
                myNumber.updateSumWithStart();
            }
        }

        return answer;
    }
}

class MyNumber {
    int start;
    int end;
    int sum;

    public MyNumber(int start, int end) {
        this.start = start;
        this.end = end;
        this.sum = end;
    }

    public void updateSumWithEnd() {
        end++;
        sum += end;
    }

    public void updateSumWithStart() {
        sum -= start;
        start++;
    }
}
