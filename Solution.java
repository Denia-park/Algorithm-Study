class Solution {
    public int solution(int[][] lines) {
        int answer = 0;

        int[] lineArr = new int[200];

        for (int[] line : lines) {
            int tempMin = Math.min(line[0], line[1]);
            int tempMax = Math.max(line[0], line[1]);
            for (int i = tempMin; i < tempMax; i++) {
                lineArr[i + 100]++;
            }
        }

        for (int i = 1; i < lineArr.length; i++) {
            if (lineArr[i] > 1) {
                answer++;
            }
        }

        return answer;
    }
}
