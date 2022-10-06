class Solution{
    //따로 makeNewArr 를 써서 배열을 만들게 되면 메모리 초과가 남
    //구현 문제로 이해하고 그냥 바로 return할 arr를 만들어야 함
    public int[] solution (int n, long left, long right){
        //구해야하는 개수 초기화
        int arrNum = (int) (right - left + 1L);
        //answer 초기화
        int[] answer = new int[arrNum];

        //필요한 row, col 초기화
        int startRow = (int) (left / n);
        int startCol = (int) (left %  n);

        //지금까지 arr에 저장한 원소 개수를 셀 변수
        int myCount = 0;

        //처음에 내가 원하는 startRow , startCol 로 시작을 하고 startFlag를 초기화 시켜서
        //다음 row 부터는 col을 0부터 시작하게 설정
        boolean startFlag = true;

        out :
        for(int row = startRow; row < n; row++){
            for(int col = startFlag ? startCol : 0; col < n; col++){
                answer[myCount++] = Math.max(row+1,col+1);
                
                //arrNum이 myCount 와 같으면 return할 배열을 제대로 채웠으므로 for문을 종료
                if(myCount == arrNum){
                    break out;
                }
            }

            startFlag = false;
        }

        return answer;
    }
    
    //처음에 만들어서 사용을 했는데 필요없어서 사용하지 않음
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
