package Greedy;

// 거스름돈 문제
//- 정당성 분석
//    - 가능하면 최대한 많이 나누는 작업이 최적의 해를 항상 보장 가능 ?
//        - N이 아무리 큰 수여도, K로 계속 나눈다면 기하급수적으로 빠르게 줄일 수 있다.
//        - 다시 말해 K가 2 이상이기만 하면, K로 나누는 것이 1을 빼는 것보다 항상 빠르게 N을 줄일 수 있습니다.
//            - 또한 N은 항상 1에 도달하게 된다. (최적의 해 성립)

public class Greedy1 {
    public static void main(String[] args) {
        System.out.println(solve(25, 5));
        System.out.println(solve(25, 3));
    }

    private static int solve(int n, int k) {
        int answer = 0;
        while (n != 1){
            if(n % k == 0){
                n = n / k;
                answer++;
            }else{
                n -= 1;
                answer++;
            }
        }
        return answer;
    }
}
