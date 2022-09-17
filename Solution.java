package com.company;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Long,Long> map = new HashMap<Long,Long>();
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        int index = 0;
        for (long number : numbers) {
            Long tempAnswer = map.getOrDefault(number, -1L);
            if(tempAnswer == -1L) {
                long saveValue = findNewNum(number);
                answer[index] = saveValue;
                map.put(number, tempAnswer);
            }else{
                answer[index] = tempAnswer;
            }

            index++;
        }

        return answer;
    }

    private long findNewNum(long number) {
        String numberBinaryString = Long.toBinaryString(number);

        int zeroIndex = numberBinaryString.lastIndexOf("0");

        if(zeroIndex == -1){
            String newNumberBinaryString = "10" + numberBinaryString.substring(1);
            return Long.parseLong(newNumberBinaryString, 2);
        }else if (zeroIndex == numberBinaryString.length() - 1){
            String newNumberBinaryString = numberBinaryString.substring(0, zeroIndex) + "1" + numberBinaryString.substring(zeroIndex + 1);
            return Long.parseLong(newNumberBinaryString, 2);
        }else {
            String newNumberBinaryString = numberBinaryString.substring(0, zeroIndex) + "10" + numberBinaryString.substring(zeroIndex + 2);
            return Long.parseLong(newNumberBinaryString, 2);
        }
    }
}
