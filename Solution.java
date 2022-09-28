class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for (int i = 0; i < land.length; i++) {
            int memoryIndex = 0;

            int max = -101;

            if(i + 1 < land.length) {
                int maxValueIndex = 0;
                for (int j = 0; j < land[0].length; j++){
                    if (j != memoryIndex && max < (land[i][j] - land[i + 1][j])) {
                        maxValueIndex = j;
                        memoryIndex = j;
                    }
                }
                answer = answer + land[i][maxValueIndex];
            }else{
                for (int j = 0; j < land[0].length; j++){
                    if (j != memoryIndex && max < (land[i][j])) {
                        max = land[i][j];
                    }
                }
                answer = answer + max;
            }
        }

        return answer;
    }
}
