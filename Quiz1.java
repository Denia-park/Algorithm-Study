//package com.company;
//
//public class Quiz1 {
//    static public void main(String[] args) {
//        String X1 = "100";
//        String Y1 = "2345";
//        String X2 = "100";
//        String Y2 = "203045";
//        String X3 = "100";
//        String Y3 = "123450";
//        String X4 = "12321";
//        String Y4 = "42531";
//        String X5 = "5525";
//        String Y5 = "1255";
//        String X6 = "55251232131231231231231231";
//        String Y6 = "1255123123123123123123123123123123123";
//
//        System.out.println(solution(X1, Y1).equals("-1"));
//        System.out.println(solution(X2, Y2).equals("0"));
//        System.out.println(solution(X3, Y3).equals("10"));
//        System.out.println(solution(X4, Y4).equals("321"));
//        System.out.println(solution(X5, Y5).equals("552"));
//        System.out.println(solution(X6, Y6));
//    }
//
//    static public String solution(String X, String Y) {
//        // StringBuilder 를 사용하면 속도가 빠르다. 그냥 문자열 붙이기를 사용할 경우 시간초과가 된다.
//        StringBuilder answer = new StringBuilder();
//        // x와 y 문자열의 숫자들을 보관할 Array 그리고 공통의 짝을 보관할 Array
//        int[] xNumberArray = new int[10];
//        int[] yNumberArray = new int[10];
//        int[] commonNumberArray = new int[10];
//        // 공통되는 숫자가 몇개인지 셀 변수
//        int commonNumberCount = 0;
//
//        //String X를 분해해서 xNumberArray에 채우기 , 해당 문자열의 숫자를 Index 로 바꿔서 Array 의 값을 ++
//        for (int i = 0; i < X.length(); i++) {
//            xNumberArray[(X.charAt(i) - '0')]++;
//        }
//        //String Y를 분해해서 xNumberArray에 채우기 , 해당 문자열의 숫자를 Index 로 바꿔서 Array 의 값을 ++
//        for (int i = 0; i < Y.length(); i++) {
//            yNumberArray[(Y.charAt(i) - '0')]++;
//        }
//        //중복되는 요소들 확인하기
//        for (int i = 0; i < 10; i++) {
//            while (xNumberArray[i] != 0 && yNumberArray[i] != 0){
//                commonNumberCount++; // 공통되는 수가 있을 때마다 ++
//                commonNumberArray[i]++;
//                xNumberArray[i]--;
//                yNumberArray[i]--;
//            }
//        }
//
//        // 공통되는 짝이 없는 경우에는 -1 을 리턴
//        if(commonNumberCount == 0) {
//            return "-1";
//        }
//
//        //배열 끝에서부터 값이 있는지 확인해서 큰 자리수 만들기
//        while (commonNumberCount > 0) {
//            for (int i = 9; i >= 0; i--) {
//                //배열의 값이 있는 경우 해당 숫자를 써야하므로 StringBuilder를 사용하여 answer 문자열에 붙인다.
//                if(commonNumberArray[i] != 0){
//                    answer.append(String.valueOf(i));
//                    commonNumberArray[i] --; // 해당 숫자를 사용했으므로 해당 배열의 값을 1만큼 줄인다.
//                    break;
//                }
//            }
//            // 공통되는 숫자의 카운트 -1 시킨다.
//            commonNumberCount--;
//        }
//
//        //문자열이 0으로만 구성되어 있는 경우 "0"으로 split을 하면 공백 Array가 나온다. => 사이즈가 0이라면 "0"을 리턴
//        if(answer.toString().split("0").length == 0){
//            return "0";
//        }
//
//        return answer.toString();
//    }
//}
