package com.company;

public class Solution {
    static public void main(String[] args) {
        String[] quiz1 = new String[]{
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"};
        String[] quiz11 = new String[]{
                "2016-09-15 00:00:00.000 2.3s", "2016-09-15 23:59:59.999 0.1s"};
        String[] quiz2 = new String[]{
                "2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"};
        String[] quiz3 = new String[]{
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
        System.out.println(solution(quiz1) == 1);
        System.out.println(solution(quiz2) == 2);
        System.out.println(solution(quiz3) == 7);
    }

    static public int solution(String[] lines) {
        if(lines.length == 1)
            return 1;

        int answer = 0;

        String[][] splitDateTimeArray = new String[lines.length][];
        String[][] splitTimeArray = new String[lines.length][];
        float[] processingTimeArray = new float[lines.length];
        long[][] timeToMillArray = new long[lines.length][2];

        //년월일 , 시간 , 처리시간 나누기
        int index = 0;
        for (String line : lines){
            splitDateTimeArray[index] = line.split(" ");
            index++;
        }

        //시간은 splitTimeArray 에 저장 [splitDateTimeArray[i] 에서 1번째 요소]
        //처리 시간은 processingTimeArray 에 저장 (float으로 저장한다) [splitDateTimeArray[i] 에서 2번째 요소]
            // s 로 끝나기 때문에 s로 split 하고 0번째 요소를 사용한다.
        for (int i = 0; i < lines.length; i++) {
            splitTimeArray[i] = splitDateTimeArray[i][1].split("\\.");
            processingTimeArray[i] = Float.parseFloat(splitDateTimeArray[i][2].split("s")[0]);
        }

        //splitTimeArray[i]를 이용하여 Milsec 시간으로 변경하여 timeToMillArray 에 저장한다.
        //저장하는 이유 : 시간 비교를 편리하게 하기 위하여
        for (int i = 0; i < lines.length; i++) {
            timeToMillArray[i][0] = getMillSecTime(splitTimeArray[i],processingTimeArray[i]);
            timeToMillArray[i][1] = getMillSecTime(splitTimeArray[i]);
        }

        // 1초 구간을 비교할때 로그의 끝이 들어가있는 경우가 가장 최대 처리값이 될 것이므로
        // 로그의 끝시간들을 기준으로 1초만큼 플러스 시켜서 비교를 함
        for (long[] timeRange : timeToMillArray) {
            //로그의 끝 시간을 기준으로 비교를 한다.
            long referTime = timeRange[1];
            //몇개가 겹치는지 비교할때 쓸 변수
            int tempVal = 0;

            //기준 시간이 정해졌으면 모든 로그 시간을 비교해서 answer를 구한다.
            for (int j = 0; j < timeToMillArray.length; j++) {
                //1초안에 해당하는 최대 처리량 이므로 시작하는 시간을 포함하므로 999를 더하는게 맞다.
                    //1.시작시간이 내가 정한 1초 사이에 있는 경우
                    //2.끝시간이 내가 정한 1초 사이에 있는 경우
                    //3.해당 로그 간격이 1초보다 커서 1초가 해당 로그 안에 포함되는 경우(시작시간이 1초보다 작고 , 끝시간이 1초보다 크다)
                if ((referTime <= timeToMillArray[j][0] && timeToMillArray[j][0] <= (referTime + 999)) ||
                (referTime <= timeToMillArray[j][1] && timeToMillArray[j][1] <= (referTime + 999)) ||
                (timeToMillArray[j][0] <= referTime && (referTime + 999) <= timeToMillArray[j][1]) ) {
                    tempVal++;
                }
            }

            //answer보다 tempVal이 크면 answer을 변경한다.
            if(answer < tempVal)
                answer = tempVal;
        }

        return answer;
    }

    //getMillSecTime 에 processingTime 이 매개변수로 들어가면 처리시간이 마이너스 된 MilSecTime 이 나온다.
    //매개변수의 예상 데이터
        // dateStrings: [01:00:04, 001], [01:00:07, 000]
        // processingTime:  2.0, 2.0
    private static long getMillSecTime(String[] dateStrings, float processingTime) {
        long answer = 0;

        //1을 더해주는 이유 : 처리시간은 시작시간과 끝시간을 포함하기 때문에 마지막에 millSec 1초를 더해줘야함
        answer = convertStringToMillSecTime(dateStrings) - (long)(processingTime * 1000) + 1;

        return answer;
    }

    //getMillSecTime 에 processingTime 이 들어가지 않으면 처리시간을 고려하지 않은 MilSecTime 이 나온다.
    private static long getMillSecTime(String[] dateStrings) {

        return convertStringToMillSecTime(dateStrings);
    }

    //  문자열을 MillSecTime 으로 변경한다.
    // [01:00:04, 001] 에서 0번째 즉 01:00:04 를 가져와서 ":" 로 쪼갠 다음에
    // hour , min , sec 을 가져온다.
    // millSec 은 1번째 즉 001을 가져오면 된다.
    private static long convertStringToMillSecTime(String[] dateStrings) {
        long answer = 0;
        String[] tempTimeStringArray = dateStrings[0].split(":");
        long hour = Long.parseLong(tempTimeStringArray[0]);
        long min = Long.parseLong(tempTimeStringArray[1]);
        long sec = Long.parseLong(tempTimeStringArray[2]);
        long millSec = Long.parseLong(dateStrings[1]);

        //Millsec -> hour * 3600000 + minute * 60000 + second*1000 + millisecond
        answer = (hour * 3600 + min * 60 + sec) * 1000 + millSec;

        return answer;
    }
}
