package CodingTest.Programmers;

class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();

        for (int idx = 0; idx < rsp.length(); idx++) {
            char c = rsp.charAt(idx);

            if (c == '2') {
                sb.append("0");
            } else if (c == '0') {
                sb.append("5");
            } else if (c == '5') {
                sb.append("2");
            }
        }

        return sb.toString();
    }
}
