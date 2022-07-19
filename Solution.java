package com.company;

import java.util.Stack;

class Solution {
    static public void main(String[] args) {
        int[] nums1 = {3,1,2,3};
        int[] nums2 = {3,3,3,2,2,4};
        int[] nums3 = {3,3,3,2,2,2};

        System.out.println(solution(nums1)==2);
        System.out.println(solution(nums2)==3);
        System.out.println(solution(nums3)==2);
    }

    //nums : 폰켓몬 종류 번호가 담긴 1차원 배열 , 1~10_000까지 항상 짝수
    static public int solution(int[] nums) {
        int answer = 0;


        //폰켓몬 종류는 1~20만 이하의 자연수
        int[] countingArray = new int[200_001];

        //계수정렬 사용
        for (int i = 0; i < nums.length; i++) {
            countingArray[nums[i]]++;
        }

        //0이 아닌 값을 센다  => 폰켓몬의 종류를 세는 것
        for (int i = 0; i < countingArray.length; i++) {
            if(countingArray[i] != 0){
                answer++;
            }
        }

        //1차원 배열의 반 만큼만 폰켓몬을 선택할 수 있다.
        int poketmonSelectNumber = nums.length / 2;

        //선택할수있는 폰켓몬의 종류(answer 값)가 poketmonSelectNumber 보다 작으면 폰켓몬의 종류를 return
        //poketmonSelectNumber가 선택할 수 있는 폰켓몬의 종류(answer 값) 보다 작으면 poketmonSelectNumber을 return
        if(answer<poketmonSelectNumber){
            return  answer;
        }else{
            return poketmonSelectNumber;
        }
    }
}

