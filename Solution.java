class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String radixString = Integer.toString(n, k);
        String[] strArr = radixString.split("0");

        for (String str : strArr) {
            if (str.equals("") || str.equals("1")) continue;

            if (isPrime(str)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isPrime(String str) {
        int intVal = Integer.parseInt(str);
        for (int i = 2; i <= (int) Math.pow(intVal, 0.5); i++) {
            if (intVal % i == 0) {
                return false;
            }

        }
        return true;
    }
}
