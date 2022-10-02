class Solution {
    public int solution(int n) {
        int answer = 0;

        int oldNBit1Count = Integer.bitCount(n);

        for (int i = n + 1; i <= 1_000_000; i++) {
            if(Integer.bitCount(i) == Integer.bitCount(n)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
