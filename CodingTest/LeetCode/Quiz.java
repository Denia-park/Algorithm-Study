package CodingTest.LeetCode;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.countAndSay(1)); //1
        System.out.println(solution.countAndSay(2)); //11
        System.out.println(solution.countAndSay(3)); //21
        System.out.println(solution.countAndSay(4)); //1211
    }
}

class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        final String sayString = countAndSay(n - 1);

        StringBuilder result = new StringBuilder();
        //sayString을 조작한다.
        //  -subString으로 숫자를 확인하고, 개수를 센다.
        int start = 0;
        int count = 0;
        for (int end = 0; end < sayString.length(); end++) {
            if (sayString.charAt(start) == sayString.charAt(end)) {
                //같은 문자이므로 기존 문자에 개수를 더한다.
                count++;
            } else {
                //다른 문자로 바꾸기 전에 기존 문자를 활용하여 계산
                result.append(makeString(sayString, start, count));

                //새로운 문자이므로 초기화
                start = end;
                count = 1;
            }
        }
        //마지막에 계산이 안된 문자열을 고려하여 추가한다.
        result.append(makeString(sayString, start, count));

        return result.toString();
    }

    private String makeString(final String sayString, final int start, final int count) {
        return "" + count + sayString.charAt(start);
    }
}
