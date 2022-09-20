import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    //교점을 저장할 List 선언
    List<long[]> list;
    //*을 표현하기 위한 배열을 만들기 위해서 필요한 값들을 선언
    long minX, minY, maxX, maxY;
    public String[] solution(int[][] lines) {
        //교점을 저장할 List를 초기화
        list = new ArrayList<>();

        //*을 표현하기 위한 배열을 만들기 위해서 필요한 값들을 초기화
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
        //2중 for문을 돌면서 모든 선들끼리의 교점을 구한다. => 조합을 이용
        for (int i = 0; i < lines.length; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                calculateIntersection(lines[i], lines[j]);
            }
        }
    }

    private void calculateIntersection(int[] line1, int[] line2) {
        //교점은 실수가 나올수도 있으므로 Double 로 선언
        Double[] tempVal = new Double[2];
        //A ~ F 까지는 모두 정수이지만 곱 , 나누기 연산시에는 실수가 나올 수 있으므로 처음부터 double로 선언
        double A = line1[0];
        double B = line1[1];
        double E = line1[2];
        double C = line2[0];
        double D = line2[1];
        double F = line2[2];

        //두 선이 평행하는 경우 이므로 교점이 없음
            //두선이 겹치는 경우는 존재하지 않는다고 문제에 나와있다.
        if((A * D) - (B * C) == 0){
            return;
        }

        //X 교점 구하기
        tempVal[0] = ((B * F) - (E * D)) / ((A * D) - (B * C));
        //Y 교점 구하기
        tempVal[1] = ((E * C) - (A * F)) / ((A * D) - (B * C));

        //소수점을 버리기
        long intFloatX = (long) Math.floor(tempVal[0]);
        long intFloatY = (long) Math.floor(tempVal[1]);

        //기존 값과 소수점을 버린 값을 비교하는데 X ,Y 둘중에 한개라도 다르다면,
        // 실수가 포함되어 있으므로 교점을 구하지 않음
        if (tempVal[0] != intFloatX || tempVal[1] != intFloatY) {
            return;
        }

        //X , Y 의 최대값 최소값을 업데이트한다.
        minX = Math.min(minX, intFloatX);
        minY = Math.min(minY, intFloatY);
        maxX = Math.max(maxX, intFloatX);
        maxY = Math.max(maxY, intFloatY);

        //교점이 정수인 경우 list에 추가한다.
        list.add(new long[]{intFloatX, intFloatY});
    }

    private String[] showIntersection() {
        //교점의 사이즈가 1인 경우 바로 return 한다.
        if(list.size() == 1) {
            return new String[]{"*"};
        }

        //*을 찍기 위해서 char 2차원 배열을 선언한다.
        char[][] charArr = new char[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];

        //처음에는 모두 '.' 로 채운다.
        for (char[] chars : charArr) {
            Arrays.fill(chars, '.');
        }

        //*을 교점에다가 채운다
        for (long[] ints : list) {
            int absX = (int) Math.abs(ints[0] - minX);
            int absY = (int) Math.abs(maxY - ints[1]);
            charArr[absY][absX] = '*';
        }

        //char의 2차원 배열을 String 1차원 배열로 변환
        String[] answer = new String[(int) (maxY - minY + 1)];
        for (int i = 0; i < maxY - minY + 1; i++) {
            answer[i] = String.valueOf(charArr[i]);
        }

        //answer를 return
        return answer;
    }
}
