package CodingTest.Programmers;// you can also use imports, for example:

class Solution {
    public int solution(int N) {
        // Implement your solution here

        String binary = Integer.toBinaryString(N);

        int answer = 0;
        int idxStart = binary.indexOf("1");
        while (idxStart != -1) {
            int idxEnd = binary.indexOf("1", idxStart + 1);
            if (idxEnd == -1) {
                break;
            }

            answer = Math.max(answer, idxEnd - idxStart - 1);

            idxStart = idxEnd;
        }

        return answer;
    }
}
