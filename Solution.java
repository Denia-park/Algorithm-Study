package com.company;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    static public void main(String[] args) {
        String[] quiz = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] quizAnswer = new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};
        System.out.println(Arrays.equals(solution(quiz),quizAnswer));
    }

    static public String[] solution(String[] record) {
        String[] answer = {};
        // record를 받아서 공백을 기준으로 쪼갠 후에 저장할 배열
        String[][] splitRecodeArray = new String[record.length][];
        // ID 와 닉네임을 저장할 HashMap
        HashMap<String, String> hashMap = new HashMap<>();
        // splitRecodeArray 에서 명령을 저장해둘 String 변수
        String command = null;
        //answer 에 넣을 데이터를 저장해둔 List
        List<String> answerList = new ArrayList<>();

        //index 확인용 변수
        int index = 0;

        // record 를 쪼개서 저장하는 Loop
        for (String string : record) {
            //공백을 기준으로 나눠지므로 공백으로 나눈다.
            splitRecodeArray[index] = string.split(" ");
            index++;
        }

        // Id 와 닉네임을 저장하는 Loop
        for (int i = 0; i < record.length; i++) {
            //[i][0] 은 command를 담고있다.
            command = splitRecodeArray[i][0];
            //Leave 를 할 때는 닉네임이 나오지 않으므로 NPE을 없애기 위해 조건을 추가함
            if(!command.equals("Leave"))
                //ID 를 Key , 닉네임을 Value로 저장함
                hashMap.put(splitRecodeArray[i][1], splitRecodeArray[i][2]);
        }

        // 저장된 데이터를 출력하는 Loop
        for (int i = 0; i < record.length; i++) {
            //[i][0] 은 command를 담고있다.
            command = splitRecodeArray[i][0];
            //코드를 효과적으로 짜기위해 tailString 변수를 만들어, 최소한의 코드가 중복되게 짠다.
            String tailString = "";

            if(command.equals("Enter")){
                tailString = "님이 들어왔습니다.";
            }
            else if(command.equals("Leave")){
                tailString = "님이 나갔습니다.";
            }
            else{
                //Change인 경우 아무런 메시지가 출력되지 않으므로 continue로 처리한다.
                continue;
            }

            //hashMap에서 닉네임을 가져오고 거기에 tailString을 붙여서 채팅방 메세지를 만들고 answerList에 해당 문자열을 저장
            answerList.add(hashMap.get(splitRecodeArray[i][1]) + tailString);
        }

        //List를 Array로 만들어서 Return
        return answerList.toArray(answer);
    }
}
