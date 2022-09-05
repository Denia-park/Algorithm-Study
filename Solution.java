package com.company;
class Solution {
    //answer 설정 , dfs 내에서도 쓸 수 있게 전역변수로 설정
    int answer;
    //DFS 사용 전에 isVisited 설정
    boolean[] isVisited;
    //DFS 에서 사용할 던전 정보를 전역변수로 설정
    int[][] dungeonsInfo;
    public int solution(int k, int[][] dungeons) {
        //answer 초기화
        answer = 0;
        //isVisited 초기화
        isVisited = new boolean[dungeons.length];
        //dungeonsInfo 초기화
        dungeonsInfo = dungeons;

        //dfs 실행
        dfs(k,0);

        //answer return
        return answer;
    }

    private void dfs(int tiredness, int clearCount) {
        //해당 던전 문제는 모든 던전을 순열의 경우로 확인을 해야한다.
        //for문으로 모든 던전을 돌며, isVisited 를 true , false 를 반복하는 것으로 순열을 구함
        for (int i = 0; i <dungeonsInfo.length ; i++) {
            //방문하지 않은 곳만 방문
            if(!isVisited[i]){
                //피로도가 최소 필요 피로도 보다 낮을 경우 입장하지 못함 => continue
                if(tiredness < dungeonsInfo[i][0]) continue;

                //던전에 입장할 경우 clearCount를 1 올리고 기존의 answer 와 비교하여 answer를 업데이트
                answer = Math.max(answer, clearCount + 1);
                //현재 피로도를 소모 피로도 만큼 빼주고 다음 던전으로 입장해야 한다.
                int myTiredness = tiredness - dungeonsInfo[i][1];
                //순열을 구하기 위한 isVisited 의 true , false
                isVisited[i] = true;
                //업데이트 된 피로도 와 clearCount 를 dfs 의 매개변수로 넘겨준다.
                dfs(myTiredness, clearCount + 1);
                isVisited[i] = false;
            }
        }
    }
}
