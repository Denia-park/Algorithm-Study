package Greedy;

// 곱하기 혹은 더하기 문제

public class Greedy2 {
    public static void main(String[] args) {
        System.out.println(solve("02984"));
        System.out.println(solve("567"));
    }

    private static long solve(String str){

        // 첫 번째 문자를 숫자로 변경한 값을 대입
        long result = str.charAt(0) - '0';

        for (int i = 1; i < str.length(); i++) {
            // 두 수 중에서 하나라도 '0' 혹은 '1'인 경우, 곱하기보다는 더하기 수행 ( 더하기를 수행하는게 더 큰 값을 만듬 )
            int num = str.charAt(i) - '0';
            if (num <= 1 || result <= 1) {
                result += num;
            }
            else {
                result *= num;
            }
        }

        return result;
    }
}
