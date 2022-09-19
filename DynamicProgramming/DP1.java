package DynamicProgramming;

import java.util.Scanner;

// 개미 전사
// 점화식 f(i) =  max(f(i-1) , f(i-2) + Ki)
// 한 칸 이상 떨어진 식량창고는 항상 털 수 있으므로 i-3 번째 이하는 고려할 필요가 없다
public class DP1 {
    public static int[] d = new int[100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 N을 입력받기
        int n = sc.nextInt();

        // 모든 식량 정보 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }
        //다이나믹 프로그래밍 진행 (바텀 업)
        d[0] = arr[0];
        d[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + arr[i]);
        }

        //계산된 결과 return
        System.out.println(d[n - 1]);
    }
}
