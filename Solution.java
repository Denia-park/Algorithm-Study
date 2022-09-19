import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        //answer을 정의
        int answer = 0;

        //cacheSize 가 0일때는 예외로 처리
        if(cacheSize == 0)
            return cities.length * 5;

        //캐시 저장을 위해서 Deque 선언
        Deque<String> dq = new LinkedList<>();

        //모든 city에 대해서 캐시를 확인
        for (String city : cities) {
            //모든 city의 이름은 대문자로 처리한다. (※문제 조건에는 대소문자 구분하지 않는다고 나와있음)
            String upperCaseCityName = city.toUpperCase();
            //dq가 비어있지 않고 , 캐시에 해당 city가 들어있으면 오래된 캐시를 정리하고 새 캐시로 업데이트
            //캐시에 내용이 있으므로 1초를 추가
            //작업이 끝났으므로 continue
            if(!dq.isEmpty() && dq.contains(upperCaseCityName)) {
                dq.remove(upperCaseCityName);
                dq.add(upperCaseCityName);
                answer += 1;
                continue;
            }

            //cacheSize 가 0인 경우는 위에서 이미 처리했으므로 무조건 캐시 사이즈는 1 이상
            //캐시의 내용이 있는데 현재 city의 내용이 없으므로 LRU 캐시 교체 알고리즘에 의해 제일 오래된 캐시를 삭제
            if(dq.size() >= cacheSize)
                dq.poll();

            //신규 캐시 추가
            dq.add(upperCaseCityName);
            //캐시에 없는 경우 실행시간은 5초를 추가
            answer += 5;
        }

        return answer;
    }
}
