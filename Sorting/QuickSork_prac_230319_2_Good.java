package Sorting;

import java.util.Arrays;

public class QuickSork_prac_230319_2_Good {
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
        최악의 경우, 개선 방법 -> 랜덤으로 섞기
        int randomIndex = left + (int) (Math.random() * (right - left + 1));
        swap(array, randomIndex, right);
         */

        int mid = (left + right) / 2;
        int pivot = arr[mid];

        while (left <= right) {
            while (less(arr[left], pivot)) {
                left++;
            }
            while (less(pivot, arr[right])) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean less(int i, int j) {
        return i < j;
    }
}
