package com.company;

import java.util.HashSet;
import java.util.Set;

public class Quiz2 {

    static public void main(String[] args) {
        int[] topping1 = {1, 2, 1, 3, 1, 4, 1, 2};
        int[] topping2 = {1, 2, 3, 1, 4};

        System.out.println(solution(topping1) == 2);
        System.out.println(solution(topping2) == 0);
    }

//
//    static public int solution(int[] topping) {
//        int answer = 0;
//        Set<Integer> answerSet1 = new HashSet<Integer>();
//        Set<Integer> answerSet2 = new HashSet<Integer>();
//
//        for (int i = 1; i < topping.length; i++) {
//            answerSet1.clear();
//            answerSet2.clear();
//
//            for (int j = 0; j < i; j++) {
//                answerSet1.add(topping[j]);
//            }
//            for (int j = i; j < topping.length; j++) {
//                answerSet2.add(topping[j]);
//            }
//            if(answerSet1.size() == answerSet2.size()){
//                answer++;
//            }
//        }
//        return answer;
//    }

    static public int solution(int[] topping) {
        int answer = 0;

        for (int i = 1; i < topping.length; i++) {
            int[] answerArray1 = new int[10001];
            int typeCount1 = 0;
            int[] answerArray2 = new int[10001];
            int typeCount2 = 0;

            for (int j = 0; j < i; j++) {
                if(answerArray1[topping[j]] == 0){
                    typeCount1++;

                    answerArray1[topping[j]]++;
                }
            }

            for (int j = i; j < topping.length; j++) {
                if(answerArray2[topping[j]] == 0){
                    typeCount2++;
                    answerArray2[topping[j]]++;

                    if(typeCount1 < typeCount2){
                        break;
                    }
                }
            }

            if(typeCount1 == typeCount2){
                answer++;
            }
        }
        return answer;
    }
}


