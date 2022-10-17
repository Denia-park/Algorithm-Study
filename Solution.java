class Solution {
    final int BONUS_NUM = 10;

    public int solution(int chicken) {
        int answer = 0;

        int restChick = chicken % BONUS_NUM;
        int couponNum = chicken / BONUS_NUM;
        answer += couponNum;

        while (couponNum != 0) {
            int newCouponNum = couponNum / BONUS_NUM;
            int newRestChick = couponNum % BONUS_NUM;
            answer += newCouponNum;
            couponNum = newCouponNum;

            restChick = restChick + newRestChick;
            if (restChick >= BONUS_NUM) {
                answer += restChick / BONUS_NUM;
                restChick = restChick % BONUS_NUM;
            }
        }

        return answer;
    }
}
