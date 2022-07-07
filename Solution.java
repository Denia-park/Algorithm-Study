package com.company;

class Solution {
    static public void main(String[] args){
//        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//        String hand = "right";
//        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
//        String hand = "left";
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";


        System.out.println(solution(numbers, hand).equals("LRLLLRLLRRL"));
        System.out.println(solution(numbers, hand).equals("LRLLRRLLLRR"));
        System.out.println(solution(numbers, hand).equals("LLRLLRLLRL"));
    }

    static public String solution(int[] numbers, String hand) {
        //answer 출력을 위해서 StringBuilder 생성
        StringBuilder answer = new StringBuilder();
        
        //양손에 맞는 초기 좌표값 생성
        Cordinate leftHand = new Cordinate(0, 0);
        Cordinate rightHand = new Cordinate(2, 0);

        //향상된 for문을 돌면서 answer에 String 값을 넣고 완료되면 toString 메서드를 써서 출력
        for (int number : numbers) {
            //1,4,7 면 왼쪽 손 사용
            if(number == 1 || number == 4 || number == 7 ){
                leftHand.move(number, true); //실제로 왼손의 좌표를 옮겨야 하므로 saveFlag를 true
                answer.append("L"); //왼쪽 사용했으므로 L을 append
            }
            //3,6,9 면 왼쪽 손 사용
            else if(number == 3 || number == 6 || number == 9 ){
                rightHand.move(number, true); //실제로 오른손의 좌표를 옮겨야 하므로 saveFlag를 true
                answer.append("R"); //오른쪽 사용했으므로 R을 append
            }
            //2 5 8 0 이면 양손 거리를 계산 해야함
            else{
                //왼손의 거리가 더 가까우면 왼손을 사용한다. , saveFlag가 false인 이유 : 여기서는 비교만 하고 실제로 옮기면 안되므로 if문 안에서는 testFalg를 false로 한다.
                if(leftHand.move(number,false) < rightHand.move(number,false)){
                    leftHand.move(number, true); //실제로 왼손의 좌표를 옮겨야 하므로 saveFlag를 true
                    answer.append("L"); //왼쪽 사용했으므로 L을 append
                }
                //오른손의 거리가 더 가까우면 오른손을 사용한다. , saveFlag가 false인 이유 : 여기서는 비교만 하고 실제로 옮기면 안되므로 if문 안에서는 testFalg를 false로 한다.
                else if (leftHand.move(number,false) > rightHand.move(number,false)) {
                    rightHand.move(number, true); //실제로 오른손의 좌표를 옮겨야 하므로 saveFlag를 true
                    answer.append("R"); //오른쪽 사용했으므로 R을 append
                }
                //거리가 동일할 경우 오른손잡이 or 왼손잡이 비교를 시작한다.
                else{
                    //오른손잡이 일 경우
                    if(hand.equals("right")){
                        rightHand.move(number, true); //실제로 오른손의 좌표를 옮겨야 하므로 saveFlag를 true
                        answer.append("R"); //오른쪽 사용했으므로 R을 append
                    }
                    //왼손잡이 일 경우
                    else if(hand.equals("left")){
                        leftHand.move(number, true); //실제로 왼손의 좌표를 옮겨야 하므로 saveFlag를 true
                        answer.append("L"); //왼쪽 사용했으므로 L을 append
                    }
                }
            }
        }

        //StringBuilder의 내부 데이터를 실제 String으로 변환
        return answer.toString() ;
    }
}


// 좌표화
// 1 2 3    ==>    {0,3}  {1,3}  {2,3}
// 4 5 6    ==>    {0,2}  {1,2}  {2,2}
// 7 8 9    ==>    {0,1}  {1,1}  {2,1}
// * 0 #    ==>    {0,0}  {1,0}  {2,0}

//왼손 , 오른손의 좌표를 저장하기 위한 클래스
class Cordinate {
    int x; //x 좌표
    int y; //y 좌표

    //생성자를 통해 인스턴스를 만들때 좌표를 지정함
    Cordinate(int defaultX , int defaultY){
        this.x = defaultX;
        this.y = defaultY;
    }

    //해당 숫자를 누를때 사용하는 메서드 , saveFlag는 실제로 손을 옮길 것인지? 아니면 값만 불러올지 확인한다.
    int move(int moveNum , boolean saveFlag){
        int moveX , moveY; //옮기게 될 번호의 좌표

        if(moveNum == 0){ //0번일때
            moveX = 1; moveY = 0;
        }
        else if(moveNum == 1){ //1번일때
            moveX = 0; moveY = 3;
        }
        else if(moveNum == 2){ //2번일때
            moveX = 1; moveY = 3;
        }
        else if(moveNum == 3){ //3번일때
            moveX = 2; moveY = 3;
        }
        else if(moveNum == 4){ //4번일때
            moveX = 0; moveY = 2;
        }
        else if(moveNum == 5){ //5번일때
            moveX = 1; moveY = 2;
        }
        else if(moveNum == 6){ //6번일때
            moveX = 2; moveY = 2;
        }
        else if(moveNum == 7){ //7번일때
            moveX = 0; moveY = 1;
        }
        else if(moveNum == 8){ //8번일때
            moveX = 1; moveY = 1;
        }
        else if(moveNum == 9){ //9번일때
            moveX = 2; moveY = 1;
        }else{ //일어날 수 없는 상황이지만 만들어둠
            moveX = 0; moveY = 0;
        }

        //거리계산은 상하좌우로만 이동이 가능하며 , 키패드 이동 한 칸은 거리로 1에 해당함
        int rtVal = Math.abs(moveX - this.x) + Math.abs(moveY - this.y);

        //saveFlag가 true면 옮긴 좌표를 저장
        if(saveFlag){
            this.x = moveX;
            this.y = moveY;
        }

        return rtVal;
    }
}