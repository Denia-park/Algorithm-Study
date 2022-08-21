package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    //순열을 모아두기 위한 Set 생성
    Set<Integer> permuSet;
    //순열조합시 나올수있는 길이를 저장
    int length;
    //에라스토테네스의 채를 구할때 사용할 maxValue
    int maxValue;
    //받아온 numbers를 char[] 로 저장
    char[] numbersCharArr;
    //DFS 사용시에 방문처리르 확인
    boolean[] isVisited;
    public int solution(String numbers) {
        int answer = 0;
        //charArr 로 변환
        numbersCharArr = numbers.toCharArray();
        //set 생성
        permuSet = new HashSet<Integer>();
        //방문처리를 확인할 booleanArr 생성
        isVisited = new boolean[numbers.length()];

        //maxValue 이므로 0으로 초기화
        maxValue = 0;

        // 모든 순열 찾기
        for (int i = 1; i <= numbers.length(); i++) {
            //길이를 지정
            length = i;
            //DFS를 통해 모든 순열을 찾는다.
            findAllPermutationByDFS("");
        }

        //에라스토테네스의 채 이용해서 소수 배열 구하기.
        boolean[] primeNumArray = getPrimeNumCount(maxValue);

        //순열 Set을 돌면서 해당 숫자가 소수인지 판별
        for (Integer integer : permuSet) {
            //소수가 맞으면 answer 에 + 1
            if(primeNumArray[integer])
                answer++;
        }

        return answer;
    }

    private boolean[] getPrimeNumCount(int maxValue) {
        boolean[] tempPrimeNumArray = new boolean[maxValue + 1]; // maxValue 까지 포함해야 하므로 + 1
        Arrays.fill(tempPrimeNumArray, true);
        tempPrimeNumArray[0] = false;
        tempPrimeNumArray[1] = false;

        for (int i = 0; i < Math.sqrt(maxValue + 1); i++) {
            if(tempPrimeNumArray[i]){
                if(isPrimeNum(i)){
                    for (int j = i*2; j < maxValue + 1; j += i) {
                        tempPrimeNumArray[j] = false;
                    }
                }else{
                    tempPrimeNumArray[i] = false;
                }
            }
        }

        return tempPrimeNumArray;
    }

    //소수인지 판단
    private boolean isPrimeNum(int num) {
        // 0 1은 소수가 아님
        if(num == 0 || num == 1 ){
            return false;
        }

        //2부터 체크한다.
        for (int i = 2; i < num; i++) {
            if(num % i == 0)
                return false;
        }

        return true;
    }

    //DFS를 통해 모든 순열을 구한다.
    //savedStr 를 통해 재귀함수에서 현재까지 완성된 String 을 확인한다.
    private void findAllPermutationByDFS(String savedStr) {
        //전역변수 length 를 통해서 길이에 맞으면 set에 저장
        if(savedStr.length() == length){
            //set 저장시에 maxValue 를 구하기 위해서 tempValue 사용
            int tempValue = Integer.parseInt(savedStr);
            maxValue = Math.max(maxValue, tempValue);
            permuSet.add(tempValue);
        }

        //아직 방문처리 되지 않은 숫자들을 돌면서 순열을 생성 , 재귀함수 사용
        for (int i = 0; i < numbersCharArr.length; i++) {
            //방문처리 안되었으면 방문
            if(!isVisited[i]){
                //재귀함수 타기전 방문 처리
                isVisited[i] = true;
                //재귀함수 돌입
                findAllPermutationByDFS(savedStr + numbersCharArr[i]);
                //재귀함수에서 빠져 나왔으면 방문 처리 취소
                isVisited[i] = false;
            }
        }
    }
}
