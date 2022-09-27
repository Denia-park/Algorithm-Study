class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        int mySaveNumCount = 0;

        int number = 0;
        String numberString = "0";
        int numCount = 0;

        int turnCount = 1;

        while(mySaveNumCount != t){
            if(numCount == numberString.length()){
                number++;
                if(n == 2){
                    numberString = Integer.toBinaryString(number);
                } else if (n == 16) {
                    numberString = Integer.toHexString(number);
                } else if (n == 8) {
                    numberString = Integer.toOctalString(number);
                } else if (n == 10) {
                    numberString = Integer.toString(number);
                }

                numCount = 0;
            }

            if(turnCount == p){
                answer += numberString.charAt(numCount);
                mySaveNumCount++;
            }

            if(turnCount < m){
                turnCount++;
            }else{
                turnCount = 1;
            }

            numCount++;
        }

        return answer.toUpperCase();
    }
}
