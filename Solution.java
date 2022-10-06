class Solution{
    public int[] solution (int n, long left, long right){
        int arrNum = (int) (right - left + 1L);
        int[] answer = new int[arrNum];

        int startRow = (int) (left / n);
        int startCol = (int) (left %  n);

        int myCount = 0;

        boolean startFlag = true;

        out :
        for(int row = startRow; row < n; row++){
            for(int col = startFlag ? startCol : 0; col < n; col++){
                answer[myCount++] = Math.max(row+1,col+1);
                if(myCount == arrNum){
                    break out;
                }
            }

            startFlag = false;
        }

        return answer;
    }
    
    public int[][] makeNewArr (int size){
        int[][] rtArr = new int[size][size];

        for (int row = 0; row < size; row++){
            for (int col = 0; col < size; col++){
                rtArr[row][col] = Math.max(row+1,col+1);
            }
        }

        return rtArr;
    }
}
