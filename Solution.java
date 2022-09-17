package com.company;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        int index = 0;
        for (long number : numbers) {
            answer[index] = findNewNum(number);
            index++;
        }

        return answer;
    }

    private long findNewNum(long number) {
        long newNumber = number + 1;
        while (true) {
            long XorValue = number ^ newNumber;
            String newNumberBinaryString = Long.toBinaryString(XorValue);
            if(Long.bitCount(Long.parseLong(newNumberBinaryString,2)) <= 2)
                return newNumber;
            newNumber++;
        }
    }
}
