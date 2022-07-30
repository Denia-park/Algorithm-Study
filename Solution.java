package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static public void main(String[] args) {
        String[] quiz1 = new String[]{
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"};
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
        System.out.println(solution(quiz1));
//        System.out.println(solution(quiz1) == 1);
        System.out.println(solution(quiz2));
//        System.out.println(solution(quiz2) == 2);
        System.out.println(solution(quiz3));
//        System.out.println(solution(quiz3) == 7);
    }

    static public int solution(String[] lines) {
        if(lines.length == 1)
            return 1;

        int answer = 0;
        int nMF = 1_000_000; // nanoMultiplierFactor

        String[][] splitDateTimeArray = new String[lines.length][];
        String[][] splitTimeArray = new String[lines.length][];
        float[] processingTimeArray = new float[lines.length];
        long[][] timeToMillArray = new long[lines.length][2];
        long minTime = 0;

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

        // for문을 돌릴때 필요한 범위를 구하기 위해서 List를 만들고  timeToMillArray 의 모든 요소를 넣은 다음
        // 정렬을 한다.
        List<Long> timeToMillList = new ArrayList<Long>();
        for (long[] longs : timeToMillArray) {
            timeToMillList.add(longs[0]);
            timeToMillList.add(longs[1]);
        }

        timeToMillList.sort(null);

//        System.out.println(Arrays.deepToString(splitDateTimeArray));
//        System.out.println(Arrays.deepToString(splitTimeArray));
//        System.out.println(Arrays.toString(processingTimeArray));
//        System.out.println(Arrays.deepToString(timeToMillArray));
//        System.out.println(timeToMillList);

        for (long tempMillSecTime = timeToMillList.get(0); tempMillSecTime < timeToMillList.get(timeToMillList.size() - 1); tempMillSecTime++ ) {
            int tempVal = 0;

            for (int j = 0; j < timeToMillArray.length; j++) {
                //1초안에 해당하는 최대 처리량 이므로 시작하는 시간을 포함하므로 999를 더하는게 맞다.
                if ((tempMillSecTime <= timeToMillArray[j][0] && timeToMillArray[j][0] <= (tempMillSecTime + 999))
                        || (tempMillSecTime <= timeToMillArray[j][1] && timeToMillArray[j][1] <= (tempMillSecTime + 999))) {
                    tempVal++;
                }
            }

            if(answer < tempVal)
                answer = tempVal;
        }

        return answer;
    }

    //getMillSecTime 에 processingTime 이 매개변수로 들어가면 처리시간이 빠진 MilSecTime 이 나온다.
    //processingTime 이 빠졌으면 처리시간을 고려하지 않은 MilSecTime 이 나온다.
    //매개변수의 예상 데이터
        // dateStrings: [01:00:04, 001], [01:00:07, 000]
        // processingTime:  2.0, 2.0
    private static long getMillSecTime(String[] dateStrings, float processingTime) {
        long answer = 0;

        //1을 더해주는 이유 : 처리시간은 시작시간과 끝시간을 포함하기 때문에 마지막에 millSec 1초를 더해줘야함
        answer = convertStringToMillSecTime(dateStrings) - (long)(processingTime * 1000) + 1;

        if (answer < 0) {
            answer = 0;
        }

        return answer;
    }

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

        //Milsec -> hour * 3600000 + minute * 60000 + second*1000 + millisecond
        answer = (hour * 3600 + min * 60 + sec) * 1000 + millSec;

        return answer;
    }
}
