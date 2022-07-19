package com.company;

import java.util.HashMap;

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

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        //해시맵 사용
        //폰켓몬의 종류를 알기위해서 HashMap을 사용함
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], 1);
        }

        //Hash에 들어간 Key의 수 확인 : Size 메서드
        //=> 폰켓몬의 종류가 몇개인지 확인하는 과정
        answer = hashMap.size();

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

