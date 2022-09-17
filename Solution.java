package com.company;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];


        int index = 0;
        for (long number : numbers) {
            long saveValue = findNewNum(number);
            answer[index] = saveValue;

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
        }else{
            String newNumberBinaryString = numberBinaryString.substring(0, zeroIndex) + "1" + numberBinaryString.substring(zeroIndex + 1);
            return Long.parseLong(newNumberBinaryString, 2);
        }
    }
}
