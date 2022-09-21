import java.util.HashSet;
import java.util.Set;

class Solution {
    //사용하는 좌표계의 사이즈를 확인할때 사용
    int mapSizeLimit;
    //이동한 길을 기록해둘 Set
    Set<String> pathMemory;
    //현재 좌표의 위치
    int[] curPoint;
    public int solution(String dirs) {
        //좌표계 사이즈 초기화
        mapSizeLimit = 5;
        //Set 초기화
        pathMemory = new HashSet<>();
        //처음 좌표 시작은 0,0 에서 시작
        curPoint = new int[]{0, 0};

        //제공된 이동경로를 따라 curPoint 를 움직인다.
        for (int i = 0; i < dirs.length(); i++) {
            //움직여야 하는 이동경로
            char command = dirs.charAt(i);
            //주어진 이동경로에 대해서 curPoint 를 이동시키는 메서드
            movePoint(command);
        }

        //이동한 Path 를 가지고 있는 pathMemory 의 Size 절반이 움직인 경로
            //Size의 절반인 이유는 1,1 -> 0,0 간 것 과 0,0 -> 1,1 간 것은 똑같기 때문에 동일 경로에 대해서
            //2가지의 값이 존재한다.
        return pathMemory.size() / 2;
    }

    private void movePoint(char command) {
        //원래 좌표를 저장 : originX, originY
        int originX = curPoint[0];
        int originY = curPoint[1];
        //움직인 좌표를 관리 : moveX, moveY
        int moveX = curPoint[0];
        int moveY = curPoint[1];

        //command에 따라서 다르게 움직이므로 switch문 사용
            //mapSizeLimit 보다 작은 경우에만 좌표를 옮길 수 있음
            //mapSizeLimit 을 넘어가게 되면 더이상 움직이지 못함 => 경로 존재 X , 그러므로 바로 return
        switch (command) {
            case 'U':
                if (moveY + 1 <= mapSizeLimit){
                    moveY++;
                    break;
                }
                return;
            case 'D':
                if (moveY - 1 >= -mapSizeLimit) {
                    moveY--;
                    break;
                }
                return;
            case 'R':
                if (moveX + 1 <= mapSizeLimit) {
                    moveX++;
                    break;
                }
                return;
            case 'L':
                if (moveX - 1 >= -mapSizeLimit) {
                    moveX--;
                    break;
                }
                return;
        }
        
        //움직인 경로를 저장하기 위해서 StringBuilder 객체 생성
        //원래 좌표 , 이동 좌표 를 String 으로 만들어서 pathMemory 에 저장
        StringBuilder tempPathMemory = new StringBuilder();
        tempPathMemory.append(originX).append(originY);
        tempPathMemory.append(moveX).append(moveY);
        pathMemory.add(tempPathMemory.toString());

        //움직인 경로의 반대 버전을 저장하기 위해서 setLength 를 사용하여 StringBuilder 초기화
        //이동 좌표, 원래 좌표 를 String 으로 만들어서 pathMemory 에 저장
        tempPathMemory.setLength(0);
        tempPathMemory.append(moveX).append(moveY);
        tempPathMemory.append(originX).append(originY);
        pathMemory.add(tempPathMemory.toString());

        //현재의 좌표를 움직인 좌표로 수정
        curPoint[0] = moveX;
        curPoint[1] = moveY;
    }
}
