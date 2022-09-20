import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<long[]> list;
    long minX;
    long minY;
    long maxX;
    long maxY;
    public String[] solution(int[][] lines) {
        list = new ArrayList<>();

        minX = Long.MAX_VALUE;
        minY = Long.MAX_VALUE;
        maxX = Long.MIN_VALUE;
        maxY = Long.MIN_VALUE;

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

    private void calculateIntersection(int[] line1, int[] line2) {
        Double[] tempVal = new Double[2];
        double A = line1[0];
        double B = line1[1];
        double E = line1[2];
        double C = line2[0];
        double D = line2[1];
        double F = line2[2];

        if((A * D) - (B * C) == 0){
            return;
        }

        tempVal[0] = ((B * F) - (E * D)) / ((A * D) - (B * C));
        tempVal[1] = ((E * C) - (A * F)) / ((A * D) - (B * C));

        long intFloatX = (long) Math.floor(tempVal[0]);
        long intFloatY = (long) Math.floor(tempVal[1]);

        if (tempVal[0] != intFloatX || tempVal[1] != intFloatY) {
            return;
        }

        minX = Math.min(minX, intFloatX);
        minY = Math.min(minY, intFloatY);
        maxX = Math.max(maxX, intFloatX);
        maxY = Math.max(maxY, intFloatY);

        list.add(new long[]{intFloatX, intFloatY});
    }

    private String[] showIntersection() {
        if(list.size() == 1) {
            return new String[]{"*"};
        }

        char[][] charArr = new char[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];

        for (char[] chars : charArr) {
            Arrays.fill(chars, '.');
        }

        for (long[] ints : list) {
            int absX = (int) Math.abs(ints[0] - minX);
            int absY = (int) Math.abs(maxY - ints[1]);
            charArr[absY][absX] = '*';
        }

        String[] answer = new String[(int) (maxY - minY + 1)];
        for (int i = 0; i < maxY - minY + 1; i++) {
            answer[i] = String.valueOf(charArr[i]);
        }

        return answer;
    }
}
