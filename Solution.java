import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<int[]> list;
    int minX;
    int minY;
    int maxX;
    int maxY;
    public String[] solution(int[][] lines) {
        list = new ArrayList<>();

        minX = Integer.MAX_VALUE;
        minY = Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;
        maxY = Integer.MIN_VALUE;

        //교점 구하기
        getIntersections(lines);

        //교점 표시하기
        return showIntersection();
    }

    private void getIntersections(int[][] lines) {
        for (int i = 0; i < lines.length; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                calculateIntersection(lines[i], lines[j]);
            }
        }
    }

    private String[] showIntersection() {
        if(list.size() == 1) {
            return new String[]{"*"};
        }

        char[][] charArr = new char[maxY - minY + 1][maxX - minX + 1];

        for (char[] chars : charArr) {
            Arrays.fill(chars, '.');
        }

        for (int[] ints : list) {
            int absX = Math.abs(ints[0] - minX);
            int absY = Math.abs(maxY - ints[1]);
            charArr[absY][absX] = '*';
        }

        String[] answer = new String[maxY - minY + 1];
        for (int i = 0; i < maxY - minY + 1; i++) {
            answer[i] = String.valueOf(charArr[i]);
        }

        return answer;
    }

    private void calculateIntersection(int[] line1, int[] line2) {
        Float[] tempVal = new Float[2];
        float A = line1[0];
        float B = line1[1];
        float E = line1[2];
        float C = line2[0];
        float D = line2[1];
        float F = line2[2];

        if((A * D) - (B * C) == 0){
            return;
        }

        tempVal[0] = ((B * F) - (E * D)) / ((A * D) - (B * C));
        tempVal[1] = ((E * C) - (A * F)) / ((A * D) - (B * C));

        int intFloatX = (int) Math.floor(tempVal[0]);
        int intFloatY = (int) Math.floor(tempVal[1]);

        if (tempVal[0] != intFloatX || tempVal[1] != intFloatY) {
            return;
        }

        minX = Math.min(minX, intFloatX);
        minY = Math.min(minY, intFloatY);
        maxX = Math.max(maxX, intFloatX);
        maxY = Math.max(maxY, intFloatY);

        list.add(new int[]{intFloatX, intFloatY});
    }
}
