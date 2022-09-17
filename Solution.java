package com.company;

import java.util.HashMap;
import java.util.Map;

class Solution {
    //중복된 값이 나올 경우 또 다시 계산하는 것을 막기 위해서 map을 사용
    Map<Long,Long> map = new HashMap<>();
    public long[] solution(long[] numbers) {
        //return 용 Long 배열을 생성
        long[] answer = new long[numbers.length];

        //배열용으로 사용할 index
        int index = 0;

        //for문을 돌면서 모든 요소에 대해서 검사
        for (long number : numbers) {
            //이전에 저장한 값이 있으면 해당 값을 return , 아니면 -1을 리턴
            Long tempAnswer = map.getOrDefault(number, -1L);
            //-1이 나오면 값이 없으므로 계산을 해야함
            if(tempAnswer == -1L) {
                //값을 구하고 answer배열에 저장 후 map 에도 저장
                long saveValue = findNewNum(number);
                answer[index] = saveValue;
                map.put(number, tempAnswer);
            }else{
                //이미 저장된 값이 있으면 해당 값을 저장
                answer[index] = tempAnswer;
            }

            //index는 for을 돌때마다 업데이트
            index++;
        }

        return answer;
    }

    private long findNewNum(long number) {
        //number를 2진수로 변경
        String numberBinaryString = Long.toBinaryString(number);

        // 비트가 2개 이하로 작은 제일 작은 값을 찾아야 하므로 일반 indexOf 가 아니라 lastIndexOf 를 사용한다.
        int zeroIndex = numberBinaryString.lastIndexOf("0");

        //0을 찾지 못했으면 제일 큰 비트를 10 으로 바꿔준다.
        if(zeroIndex == -1){
            String newNumberBinaryString = "10" + numberBinaryString.substring(1);
            return Long.parseLong(newNumberBinaryString, 2);
        }
        //String의 마지막 자리에 0이 있으면 해당 자리만 1 올려주면 된다.
        else if (zeroIndex == numberBinaryString.length() - 1){
            String newNumberBinaryString = numberBinaryString.substring(0, zeroIndex) + "1" + numberBinaryString.substring(zeroIndex + 1);
            return Long.parseLong(newNumberBinaryString, 2);
        }
        //0이 없거나 , String의 마지막 자리에 0이 있는 경우가 아니면 lastIndexOf로 0을 찾고 01을 10으로 바꿔주면 된다.
        else {
            String newNumberBinaryString = numberBinaryString.substring(0, zeroIndex) + "10" + numberBinaryString.substring(zeroIndex + 2);
            return Long.parseLong(newNumberBinaryString, 2);
        }
    }
}
