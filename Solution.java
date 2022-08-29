package com.company;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        //일단 정렬 - 오름차순
        Arrays.sort(citations);

        //이진탐색으로 필요한 답을 찾아보자.
        answer = binarySearch(citations);

        return answer;
    }

    private int binarySearch(int[] citations) {
        //return 할 변수
        int answer = -1;
        //이진탐색에 필요한 left , right
        int left = 0;
        int right = citations.length;
        //전체 길이
        int totalLength = citations.length;

        //left가 right 범위를 넘어서는 순간까지 while
        while(left <= right) {
            //mid를 구한다.
            int mid = (left + right) / 2;

            //mid에 해당하는 값 에 해당하는 index를 구한다.
            int firstIndex = getFirstNumIndex(citations, mid);

            //규칙에 해당하는 값을 찾으면 mid 값을 answer에 할당 , 아니면 right 를 mid - 1 로 변경하고 다시 이진탐색
            if((totalLength - firstIndex) >= mid && firstIndex <= mid) {
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return answer;
    }

    public int getFirstNumIndex(int[] arr, int num) {
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public int getNextNumIndex(int[] arr, int num, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
