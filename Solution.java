package com.company;

public class Solution {
    static public void main(String[] args) {

        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));

    }

    static public int solution(String initialString) {
        // 제대로 압축이 되었다면  initialString의 length 보다는 무조건 작아져야 하니까,
        // 처음에 그냥 initialString.length() 를 넣는다. , 압축되지 않았다면 해당 길이를 그대로 반환할 예정
        int answer = initialString.length();
        //압축한 String을 담아둘 변수 , StringBuilder를 사용
        StringBuilder compressString= new StringBuilder();
        //동일 글자를 판단하고 몇번 중복됐는지 담아둘 변수, 해당 글자로 잘랐다는 것은 해당 글자가 1번은 있다는 소리 => 초기값 : 1
        int repeatCharNumber = 1;
        //몇 글자씩 쪼갤지 값을 가지고 있을 변수 , 처음에는 1글자씩 쪼개는 것으로 시작
        int divideNumber = 1;

        //그리디 방식으로 진행을 해야할 것 같다. (while Loop - for Loop - for Loop 의 형태가 될 예정)
        //1. 쪼갤 글자수를 1에서 조금씩 올려가면서 최고의 해를 구해야함 (while 문)
        //2. 쪼갤 글자수가 정해졌으면 압축을 할때 필요한 기준 글자를 정해야함
        // [initialString 의 모든 글자를 돌면서 압축을 해야함] => (for 문)
        //3. 기준 글자를 가지고 initialString 에서 해당 글자가 얼마나 중복되는지 확인이 필요함 => (for 문)

        // 쪼갤 글자수를 1에서 조금씩 올려가면서 최고의 해를 구해야함
        while (divideNumber < initialString.length()) {

            // 쪼갤 글자수가 정해졌으면 압축을 할때 필요한 기준 글자를 계산해야 한다.
            // 기준 글자를 변경해가며 압축을 해야하므로 for 문이 필요함
            // forIndex 변수 => for 문을 돌때 압축용 기준 글자가 현재 initialString 에서 어디를 기준으로 기준 글자를 가져왔는지 확인용
            // forIndex는 for문 내부에서 계산이 계속해서 되므로 for문 조건에서는 따로 가감식을 넣지 않음.
            for (int forIndex = 0; forIndex < initialString.length();) {
                // 현재 forIndex 에 쪼갤 글자수를 더했을 떄, 기존 문자열보다 길다면 더 이상 쪼개는 의미가 없으므로
                // 남아있는 나머지 글자를 지금까지 압축해둔 StringBuilder 에 그냥 마저 붙인다.
                if (forIndex + divideNumber > initialString.length()) {
                    compressString.append(initialString.substring(forIndex, initialString.length()));
                    break;
                }

                //압축을 진행할떄 필요한 기준 글자를 정한다.
                String tempString = initialString.substring(forIndex, forIndex + divideNumber);

                //정한 글자를 for문 돌면서 얼마나 압축할 수 있는지 확인하는 Loop
                //tempString 으로 기준 글자를 정했으므로 해당 글자를 제외한 다음에 존재하는 글자를 확인해서 압축을 해야하므로
                //for 문을 시작할 때 forIndex에 dividorNumber을 더한 값으로 할당하고 시작
                //압축을 할때도 forIndex 가 initialString.length() 를 넘길수 없으므로 조건식으로 사용
                //쪼개는 글자수만큼 Index를 옮겨야 하므로 forIndex += divideNumber 가감식을 사용함
                for (forIndex += divideNumber; forIndex < initialString.length(); forIndex += divideNumber) {
                    //기준으로 정한 tempString 과 divideNumber 만큼 다음에 존재하는 문자열이 동일하면 압축이 가능하다.
                    //repeatCharNumber을 증가시켜 반복량(압축량)을 확인한다.
                    //equals 가 되지 않으면 압축 Loop에서 빠져나온다.
                    // forIndex + divideNumber 가 initialString.length() 크면 OutOfRange 예외가 발생하므로 예외 처리용 조건
                    if(forIndex + divideNumber > initialString.length())
                        break;
                    else if (tempString.equals(initialString.substring(forIndex, forIndex + divideNumber)))
                        repeatCharNumber++;
                    else
                        break;
                }

                //반복량이 1일 경우 => 문자가 반복되지 않으므로 한번만 나타난 경우 1은 생략
                //1이 아닌 경우에만 repeatCharNumber를 붙여서 압축 문자열을 새로 만들어줌
                if (repeatCharNumber != 1)
                    compressString.append(repeatCharNumber).append(tempString);
                else
                    compressString.append(tempString);

                //기준 글자가 달라지므로 반복량은 초기화
                repeatCharNumber = 1;
            }

            //압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 해야 하므로 기존 answer와 비교하여 짧아졌으면 Update한다.
            if (answer > compressString.length()) {
                answer = compressString.length();
            }
            //쪼개는 수를 증가시킨다.
            divideNumber++;
            //StringBuilder 의 내부 버퍼를 Clear
            compressString.setLength(0);
        }

        return answer;
    }
}
