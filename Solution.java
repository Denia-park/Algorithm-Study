package com.company;

import java.util.Arrays;

class Solution {
    static public void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1S10D*10T"));
        System.out.println(solution("1D2S#10S"));
        System.out.println(solution("1D2S0T"));
        System.out.println(solution("1S*2T*3S"));
        System.out.println(solution("1D#2S*3S"));
        System.out.println(solution("1T2D3D#"));
        System.out.println(solution("1D2S3T*"));
    }

    static public int solution(String dartResult) {
        //정답을 return할 변수
        int answer = 0;

        //점수를 3개 보관할 Array
        int[] eachScoreArray = new int[3];
        int eachScoreArrayIndex = 0; // eachScoreArray의 Index 기록용 변수

        //점수의 인덱스를 3개 보관할 Array
        int[] eachScoreIndexArray = new int[3];
        int eachScoreIndexArrayIndex = 0; // eachScoreIndexArray의 Index 기록용 변수

        //Round마다 발생한 총 점수를 기록할 배열
        int[] roundTotalScoreArray = new int[3];

        // 각 라운드 별로 다트에 맞춘 숫자 찾기
        // dartResult를 for문으로 돌면서 eachScoreArray 에 들어갈 요소 찾기
        for (int i = 0; i < dartResult.length(); i++) {
            // 1글자씩 Read
            char oneChar = dartResult.charAt(i);
            //숫자 0~9만 가져오기
            if('0'<= oneChar && oneChar <= '9'){
                //숫자는 0~10점까지 가능 하므로
                // 1이 나오면 해당 숫자가 10인지 아닌지 확인 해야함
                if(oneChar == '1'){
                    //1인 경우 와 10인 경우를 찾아야함
                    if(dartResult.charAt(i+1) == '0'){ //10인 경우
                        eachScoreArray[eachScoreArrayIndex] = 10; // eachScoreArray에 10 저장
                        i++; // 10이 나온경우 숫자의 마지막은 0이 있는 곳이므로 i ++를 적용한다.
                    }else{ //1인 경우
                        eachScoreArray[eachScoreArrayIndex] = 1; // eachScoreArray에 1 저장
                    }
                }
                // 1이 아닌 경우에는 해당하는 숫자를 저장해야 하는데 '0'을 빼면 char를 숫자로 바꿧을때 해당하는 값이 나온다.
                else {
                    eachScoreArray[eachScoreArrayIndex] = oneChar - '0';
                }
                // eachScoreArray에 숫자를 넣을때 Index도 기록하면 편하므로 index 도 저장한다.
                eachScoreIndexArray[eachScoreIndexArrayIndex] = i;
                // Array에 Index를 저장했으므로 Index 변수들은 ++ 해준다.
                eachScoreIndexArrayIndex++;
                eachScoreArrayIndex++;
            }
        }

        //중간 확인용 print문
//        System.out.println((Arrays.toString(eachScoreArray)));
//        System.out.println((Arrays.toString(eachScoreIndexArray)));

        //저장된 점수를 바탕으로 각 라운드마다 적용될 Round 별 점수를 구한다.
        //3라운드에 해당하는 점수들을 구하고 roundTotalScoreArray에 저장해둔다
        //그리고 마지막에 roundTotalScoreArray의 원소들을다 읽어서 더 해준다. => answer
        for (int i = 0; i < eachScoreArray.length; i++) {
            //각 라운드에 다트로 맞춘 점수를 가져온다
            int tempScore = eachScoreArray[i];
            //점수에 해당하는 Index에서 +1을 해서 점수 다음의 보너스 및 옵션을 체크하기 위함
            int calForStart = eachScoreIndexArray[i] + 1;
            //보너스 옵션을 체크할 Index의 끝을 계산하기 위함
            int calForFinal = 0;
            // i가 2가 아닐 때는 i +1 해서 Index를 구해도 OutOfRange 에러가 발생하지 않음
            if(i != 2){
                calForFinal = eachScoreIndexArray[i + 1];
            }
            // i가 2 일때 i+1 하면 OutOfRange 에러가 발생하므로 dartResult의 길이를 calForFinal로 넣는다.
            else {
                calForFinal = dartResult.length();
            }

            //실제로 제일 중요한 점수를 계산하는 로직
            for (int j = calForStart; j < calForFinal; j++) {
                //S는 Single 점수의 1제곱 , pow 제곱해주는 메서드 이용
                if (dartResult.charAt(j) == 'S'){
                    tempScore = (int) Math.pow(tempScore, 1);
                }
                //D는 Double  점수의 2제곱 , pow 제곱해주는 메서드 이용
                else if(dartResult.charAt(j) == 'D'){
                    tempScore = (int) Math.pow(tempScore, 2);
                }
                //T는 Triple 점수의 3제곱 , pow 제곱해주는 메서드 이용
                else if(dartResult.charAt(j) == 'T'){
                    tempScore = (int) Math.pow(tempScore, 3);
                }
                //*는 스타상 전에 얻은 점수 2배 , 당첨시에 해당 점수 2배
                else if(dartResult.charAt(j) == '*'){
                    //처음에 걸리면 이전 점수가 없어서 2배를 못한다.
                    //처음에 걸리지 않았다면 이전 점수를 2배 한다.
                    if(i != 0){
                        roundTotalScoreArray[i - 1] = roundTotalScoreArray[i - 1] * 2;
                    }
                    //당첨시에 해당 점수 2배
                    tempScore = tempScore * 2;
                }
                //#는 아차상 해당 점수를 마이너스 한다.
                else if(dartResult.charAt(j) == '#'){
                    tempScore = tempScore * -1;
                }
            }
            //For문을 돌아서 계산된 점수를 Array에 저장한다.
            roundTotalScoreArray[i] = tempScore;
        }

        //3라운드에 해당하는 점수를 모두 구했으므로 roundTotalScoreArray의 원소들을다 읽어서 더 해준다. => answer
        for (int roundScore : roundTotalScoreArray ) {
            answer += roundScore;
        }

        return answer;
    }
}

