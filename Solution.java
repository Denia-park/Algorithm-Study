package com.company;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Long,Long> map;
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        map = new HashMap<>();

        int index = 0;
        for (long number : numbers) {
            long existValue = map.getOrDefault(number, -1L);
            if (existValue == -1) {
                long saveValue = findNewNum(number);
                answer[index] = saveValue;
                map.put(number, saveValue);
            }else{
                answer[index] = existValue;
            }

            index++;
        }

        return answer;
    }

    private long findNewNum(long number) {
        long newNumber = number + 1;
        while (true) {
            long XorValue = number ^ newNumber;
            if(Long.bitCount(XorValue) <= 2)
                return newNumber;
            newNumber++;
        }
    }
}
