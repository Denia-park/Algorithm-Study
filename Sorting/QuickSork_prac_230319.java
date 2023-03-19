package Sorting;

import java.util.Arrays;

public class QuickSork_prac_230319 {
    public static void main(String[] args) {
        int[] sortArr = new int[]{6, 3, 5, 1, 2, 4};
        quickSort(sortArr, 0, sortArr.length - 1);
        System.out.println(Arrays.toString(sortArr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        //분할 , 피봇 정하기
        int pivot = partition(arr, left, right);

        //피봇을 제외한 2개의 부분 배열을 대상으로 순환 호출
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        /*
        최악의 경우, 개선 방법
        int mid = (left + right) / 2;
        swap(arr, left, mid);
         */

        int pivot = arr[left]; // 가장 왼쪽 값을 피벗으로 설정
        int i = left;
        int j = right;


        while (i < j) {
            //right
            while (arr[j] > pivot) {
                j--;
            }

            //left
            while (i < j && arr[i] <= pivot) {
                i++;
            }

            swap(arr, i, j);
        }
        arr[left] = arr[i];
        arr[i] = pivot;

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
