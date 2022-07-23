package com.company;

class Solution {
    static public void main(String[] args) {
        System.out.println((solution(13, 17)) == 43);
        System.out.println((solution(24, 27)) == 52);
    }

    static public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int commonDivisor = getCommonDivisorNum(i);
            int tempVal = i;
            //짝수이면 더하기
            if( commonDivisor % 2 == 0){
            }else { //홀수이면 빼기
                tempVal = -1 * tempVal;
            }

            answer = answer + tempVal;
        }

        return answer;
    }

    private static int getCommonDivisorNum(int num) {
        int rtVal = 0;

        //num에 해당하는 값으로는 나누지 않고 밑에서 그냥 +1을 따로 해주자.
        for (int i = 1; i < num; i++) {
            if(num % i ==0 ){
                rtVal++;
            }
        }

        rtVal++; // num에 해당하는 값을 나누면 무조건 공약수가 되므로, +1 해준다. [위에서 num을 포함 안하고 for문을 돌리기 때문]

        return rtVal;
    }
}

