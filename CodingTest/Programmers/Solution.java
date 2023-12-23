package CodingTest.Programmers;

class Solution {
    public int[] solution(String s) {
        int zeroCount = 0;
        int convertCount = 0;

        while (!s.equals("1")) {
            final int beforeLength = s.length();
            final int afterLength = s.replace("0", "").length();

            zeroCount += beforeLength - afterLength;

            convertCount++;

            s = Integer.toBinaryString(afterLength);
        }

        return new int[]{convertCount, zeroCount};
    }
}
