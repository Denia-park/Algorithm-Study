package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static public void main(String[] args) {
        int n1 = 3;
        int m1 = 12;
        int n2 = 2;
        int m2 = 5;

        System.out.println(Arrays.toString(solution(n1, m1)));
        System.out.println(Arrays.toString(solution(n2, m2)));
        System.out.println(Arrays.toString(solution(4, 8)));
        System.out.println(Arrays.toString(solution(5, 10)));
        System.out.println(Arrays.toString(solution(9, 15)));
        System.out.println(Arrays.toString(solution(18, 30)));
        
    }

    static public int[] solution(int n, int m){
        //사이즈가 2인 배열로 Return 해야함
        int[] answer = {0,0};

        //n의 공약수를 담는 배열
        List<Integer> nArray = new ArrayList<Integer>();
        //m의 공약수를 담는 배열
        List<Integer> mArray = new ArrayList<Integer>();
        //공통된 공약수를 담는 배열
        List<Integer> divisorsList = new ArrayList<Integer>();

        //nArray 구하는 과정
        for (int i = 1; i <= n; i++) {
            if(n % i == 0) {
                nArray.add(i);
            }
        }

        //mArray 구하는 과정
        for (int i = 1; i <= m; i++) {
            if(m % i == 0) {
                mArray.add(i);
            }
        }

        //공통된 약수 배열 구하는 과정
        for (int divisor : nArray) {
            if(mArray.contains(divisor)){
                divisorsList.add(divisor);
            }
        }

        //최대 공약수 (오름차순으로 배열에 들어가므로 마지막 Index에 있는 원소값이 최대 공약수)
        answer[0] = divisorsList.get(divisorsList.size() - 1);

        //최소 공배수 구하기
        int shareOfN = n / answer[0];
        int shareOfM = m / answer[0];
        answer[1] = answer[0] * shareOfN * shareOfM;

        return answer;
    }

    //내가 구한 로직보다 더 짧게 잘 구한 코드가 있어서 가져옴
    
//    public long[] solution(int n, int m) {
//        long[] answer = new long [2];
//
//        if(m%n==0){
//            answer[0] = n;
//            answer[1] = m;
//        }else{
//            for(int i = 1; i <= m; i++){
//                if(n%i==0 && m%i==0){
//                    answer[0] = i;
//                }
//            }
//            answer[1] = n*m/answer[0];
//        }
//        //System.out.println(Arrays.toString(answer));
//        return answer;
//    }
}
