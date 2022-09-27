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

                numberString = Integer.toString(number, n);

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
