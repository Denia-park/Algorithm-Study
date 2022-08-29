package com.company;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        answer = binarySearch(citations);

        return answer;
    }

    private int binarySearch(int[] citations) {
        int answer = -1;
        int left = 0;
        int right = citations.length - 1;
        int totalLength = citations.length;

        while(left <= right) {
            int mid = (left + right) / 2;
            int quoteNum = citations[mid];

            int firstIndex = getFirstNumIndex(citations, quoteNum, left, right);

            if((totalLength - firstIndex) >= quoteNum) {
                answer = quoteNum;
                left = getNextNumIndex(citations, quoteNum, left, right);
            }else{
                if(answer != -1)
                    break;
                else{
                    right = mid - 1;
                }
            }
        }

        return answer;
    }

    public int getFirstNumIndex(int[] arr, int num, int left, int right) {
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
        if(left == right){
            return right + 1;
        }

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
