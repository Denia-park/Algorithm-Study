import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    List<Float[]> list;
    public String[] solution(int[][] lines) {
        list = new ArrayList<>();

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

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (Float[] floats : list) {
            int intFloatX = (int) Math.floor(floats[0]);
            int intFloatY = (int) Math.floor(floats[1]);

            if (floats[0] != intFloatX || floats[1] != intFloatY) {
                continue;
            }

            minX = Math.min(minX, intFloatX);
            minY = Math.min(minY, intFloatY);
            maxX = Math.max(maxX, intFloatX);
            maxY = Math.max(maxY, intFloatY);
        }

        list.sort(new Comparator<Float[]>() {
            @Override
            public int compare(Float[] o1, Float[] o2) {
                if(o1[0] < o2[0]){
                    return -1;
                }else if(o1[0] == o2[0]){
                    return o1[1].compareTo(o2[1]);
                }else{
                    return 1;
                }
            }
        });

        char[][] charArr = new char[maxY - minY + 1][maxX - minX + 1];

        for (char[] chars : charArr) {
            Arrays.fill(chars, '.');
        }

        boolean stanFlag = false;
        int stanX = 0;
        int stanY = 0;

        for (Float[] floats : list) {
            int intFloatX = (int) Math.floor(floats[0]);
            int intFloatY = (int) Math.floor(floats[1]);

            if (floats[0] != intFloatX || floats[1] != intFloatY) {
                continue;
            }

            if (!stanFlag) {
                stanFlag = true;
                charArr[0][0] = '*';
                stanX = intFloatX;
                stanY = intFloatY;
            } else {
                int absY = Math.abs(stanY - intFloatY);
                int absX = Math.abs(intFloatX - stanX);
                charArr[absY][absX] = '*';
            }
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

        list.add(tempVal);
    }

}
