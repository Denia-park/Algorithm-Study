package CodingTest.Programers;

//마법의 엘리베이터

//절댓값이 10 ^ c ( c >= 0 인 정수)
//더한 값으로 이동
//0보다 작으면 엘리베이터는 움직이지 않습니다.
//0층이 가장 아래층 -> 엘리베이터 와 민수 모두 0층


//절반보다 크면 더해서 큰 값을 만드는게 이득
//절반보다 작으면 빼서 작은 값을 만드는게 이득
class Solution {
    public int solution(int storey) {
        int answer = 0;

        String stVal = String.valueOf(storey);
        char[] chars = stVal.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            char aChar = chars[i];

            int diff = aChar - '0';
            if (diff > 5) {
                answer += (10 - diff) + 1;
            } else {
                answer += diff;
            }
        }

        return answer;
    }
}
