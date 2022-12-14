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
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < quizString.length(); i++) {
            char curCh = quizString.charAt(i);
            
            if (Character.isUpperCase(curCh)) {
                sb.append('_').append(Character.toLowerCase(curCh));
            } else {
                sb.append(curCh);
            }
        }

        return sb.toString();
    }

    String makeCppToJava(String quizString) {
        StringBuilder sb = new StringBuilder();
        boolean changeFlag = false;

        for (int i = 0; i < quizString.length(); i++) {
            char curCh = quizString.charAt(i);

            if (curCh == '_') {
                changeFlag = true;
            } else {
                if (changeFlag) {
                    sb.append(Character.toUpperCase(curCh));
                    changeFlag = false;
                } else {
                    sb.append(curCh);
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
