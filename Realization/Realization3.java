package Realization;

import java.util.ArrayList;
import java.util.List;

public class Realization3 {
    public static void main(String[] args) {
        System.out.println(solve1("K1KA5CB7"));
        System.out.println(solve1("AJKDLSI412K4JSJ9D"));
    }

    private static String solve1(String str) {
        String answer = "";
        int numValue = 0;
        List<Character> answerList = new ArrayList<Character>();

        //Character.isLetter() 이라는 메서드가 있음
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9' ){
                numValue += (str.charAt(i) - '0');
            }else{
                answerList.add(str.charAt(i));
            }
        }

        answerList.sort(null);

        for (Character c : answerList){
            answer +=  c;
        }

        if(numValue != 0) {
            answer += numValue;
        }

        return answer;
    }
}
