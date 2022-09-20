package Sorting;

import java.util.Arrays;
import java.util.Collections;

public class Sorting1 {
    public static void main(String[] args) {
        int N = 5;
        int K = 3;
        int[] A = {1, 2, 5, 4, 3};
        int[] B = {5, 5, 6, 6, 5};
        System.out.println(solve(N,K,A,B));
    }

    private static int solve(int n, int k, int[] a, int[] b) {
        int answer = 0;

        //정렬
        Arrays.sort(a);
        Arrays.sort(b);

        // K 개를 바꿔치기 해야하므로 제일 작은 것부터 K개를 제외하고 나머지를 다 더함
        for(int i = k; i<n; i++) {
            answer += a[i];
        }
        // K 개를 바꿔치기 해야 하므로 제일 큰값부터 K개를 다 더함
        for(int i = n-k; i<n; i++) {
            answer += b[i];
        }

        return answer;
    }
}

// 나동빈님의 코드
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // N과 K를 입력받기
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//
//        // 배열 A의 모든 원소를 입력받기
//        Integer[] a = new Integer[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//        // 배열 B의 모든 원소를 입력받기
//        Integer[] b = new Integer[n];
//        for (int i = 0; i < n; i++) {
//            b[i] = sc.nextInt();
//        }
//
//        // 배열 A는 오름차순 정렬 수행
//        Arrays.sort(a);
//        // 배열 B는 내림차순 정렬 수행
//        Arrays.sort(b, Collections.reverseOrder());
//
//        // 첫 번째 인덱스부터 확인하며, 두 배열의 원소를 최대 K번 비교
//        for (int i = 0; i < k; i++) {
//            // A의 원소가 B의 원소보다 작은 경우
//            if (a[i] < b[i]) {
//                // 두 원소를 교체
//                int temp = a[i];
//                a[i] = b[i];
//                b[i] = temp;
//            }
//            // A의 원소가 B의 원소보다 크거나 같을 때, 반복문을 탈출
//            else break;
//        }
//
//        // 배열 A의 모든 원소의 합을 출력
//        long result = 0;
//        for (int i = 0; i < n; i++) {
//            result += a[i];
//        }
//        System.out.println(result);
//    }
