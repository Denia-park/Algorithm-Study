class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        int number = 0;
        StringBuilder allNumberString = new StringBuilder();

        //우리가 필요한 길이만큼 String을 합친다.
        while (allNumberString.length() < t * m){
            allNumberString.append(Integer.toString(number, n));
            number++;
        }

        //내 차례에 맞는 char을 더하면서 answer를 만든다.
        for (int round = 0; round < t; round++) {
            answer.append(allNumberString.charAt(p - 1 + (round * m)));
        }

        return answer.toString().toUpperCase();
    }
}
