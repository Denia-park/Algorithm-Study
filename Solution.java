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
        String numberBinaryString = Long.toBinaryString(number);
        long newNumber = number + 1;
        while (true) {
            long XorValue = number ^ newNumber;
            String newNumberBinaryString = Long.toBinaryString(XorValue).replace("0", "");
            if(newNumberBinaryString.length() <= 2)
                return newNumber;
            newNumber++;
        }
    }
}
