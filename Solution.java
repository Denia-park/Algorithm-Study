import java.util.ArrayList;

public class Solution {
    static public void main(String[] args) {
        int nums1 = 12;
        int nums2 = 5;

        System.out.println(solution(nums1) == 28);
        System.out.println(solution(nums2) == 6);
    }

    static public int solution(int n) {
        int answer = 0;

        //약수들을 저장할 List를 생성
        ArrayList<Integer> divisorList = new ArrayList<>();
        
        //for문을 돌면서 약수를 구한다
        for (int i = 1; i <= n; i++) {
            //나머지가 0 이면 해당 i 는 약수
            if(n % i == 0){
                //약수는 List에 저장
                divisorList.add(i);
            }
        }
    
        // System.out.println(divisorList);

        //약수List 에 저장된 약수들을 for문을 돌면서 모두 더함.
        for (int divisor : divisorList) {
            answer += divisor;
        }
        
        return answer;
    }
}
