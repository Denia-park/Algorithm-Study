// 백준 - 3613 - Java vs C++

// 정답 참고
// https://codejin.tistory.com/127

class Solution {
    public String solution(String quizString) {
        String answer = quizString;

        if (isError(quizString)) {
            return "Error!";
        } else if (isJava(quizString)) {
            answer = makeJavaToCpp(quizString);
        } else if (isCpp(quizString)) {
            answer = makeCppToJava(quizString);
        }

        return answer;
    }

    String makeJavaToCpp(String quizString) {
        StringBuilder sb = new StringBuilder(quizString);

        for (int i = 0; i < sb.length(); i++) {
            if (Character.isUpperCase(sb.charAt(i))) {
                sb.replace(i, i + 1, "_" + Character.toLowerCase(sb.charAt(i)));
            }
        }

        return sb.toString();
    }

    String makeCppToJava(String quizString) {
        StringBuilder sb = new StringBuilder(quizString);
        boolean changeFlag = false;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '_') {
                changeFlag = true;
            } else {
                if (changeFlag) {
                    sb.replace(i - 1, i + 1, String.valueOf(Character.toUpperCase(sb.charAt(i))));
                    changeFlag = false;
                }
            }
        }

        return sb.toString();
    }

    boolean isJava(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    boolean isCpp(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '_') {
                return true;
            }
        }

        return false;
    }

    boolean isError(String str) {
        boolean hasUnderBar = false;
        boolean hasUpper = false;

        for (int i = 0; i < str.length(); i++) {
            char curCh = str.charAt(i);
            if (curCh == '_') {
                hasUnderBar = true;
            } else if (Character.isUpperCase(curCh)) {
                hasUpper = true;
            }
        }

        if (hasUnderBar && hasUpper) {
            return true;
        }

        char startCh = str.charAt(0);
        if (startCh == '_' || Character.isUpperCase(startCh)) {
            return true;
        }

        char finalCh = str.charAt(str.length() - 1);
        if (finalCh == '_') {
            return true;
        }

        // '_'이 연속해서 나오는지 판단한다.
        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i) == '_' && str.charAt(i + 1) == '_') {
                return true;
            }
        }

        return false;
    }
}
