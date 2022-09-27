class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        int number = 0;
        StringBuilder allNumberString = new StringBuilder();

        while (allNumberString.length() < t * m){
            allNumberString.append(Integer.toString(number, n));
            number++;
        }

        for (int round = 0; round < t; round++) {
            answer.append(allNumberString.charAt(p - 1 + (round * m)));
        }

        return answer.toString().toUpperCase();
    }
}
