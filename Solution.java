import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String msg) {
        //인덱스를 저장할 answer 선언 및 초기화
        List<Integer> answer = new ArrayList<>();
        //영문 대문자 를 모두 저장 후 다음번에 저장하는 단어의 Index는 27부터 시작한다.
        int addIndex = 27;

        //단어와 색인을 가지고 있을 Map을 선언 및 초기화
        Map<String,Integer> map = new HashMap<>();
        //영문 대문자 를 map에 추가
        initializeMap(map);

        //msg에 대해서 for문을 돌면서 LZW압축을 실행
        for (int i = 0; i < msg.length();) {
            //처음에는 한글자씩 끊어서 map에 데이터를 비교해야 하므로
            //cuttingNum 을 선언하고 1로 초기화
            int cuttingNum = 1;
            //map에서 데이터의 색인 번호를 가져올 때 사용할 변수
            int tempIndex;

            //while문을 돌면서 글자를 한글자씩 늘려가며 map에 단어가 존재하는지 확인
            while (true) {
                //msg 에서 i ~ i + cuttingNum 만큼 글자를 자른다.
                String tempStr = msg.substring(i, i + cuttingNum);

                //tempStr 이 map에 존재하는지 확인
                tempIndex = map.getOrDefault(tempStr, -1);

                //존재하면 자르는 단어크기를 늘려서 다시 확인한다
                if(tempIndex != -1){
                    //i + cuttingNum 이 msg.length 를 넘게 되면 예외가 발생하므로
                    //사이즈가 작은 경우에만 cuttingNum을 늘린 후 다시 tempStr 를 구해서 map에 비교해본다.
                    if (i + cuttingNum < msg.length()) {
                        cuttingNum++;
                        continue;
                    }else {
                        //i + cuttingNum 이 msg.length 만큼 됐으므로 더 이상 글자를 늘려서 비교할수가 없다.
                        //for문이 정상 종료 될 수 있도록 i를 업데이트 하고 while을 종료한다.
                        i++;
                        break;
                    }
                }

                //없는 글자를 map에 추가해줘야 하므로 tempStr 과 addIndex 를 map에 추가한다.
                map.put(tempStr, addIndex);
                //addIndex 를 업데이트 해준다.
                addIndex++;

                //없는 글자의 Index를 추가할 수 없으므로 cuttingNum -1 된 글자의 Index를 가져온다.
                tempIndex = map.get(msg.substring(i, i + cuttingNum - 1));
                break;
            }

            //answer List에 tempIndex 를 추가
            answer.add(tempIndex);
            //늘어난 글자만큼 i를 추가 해준다.
            i += cuttingNum - 1;
        }

        //answer 가 Integer List 이므로 stream 으로 만들고 mapToInt 후 람다식을 적용하고 다시 int 배열로 만들어 리턴한다.
        return answer.stream().mapToInt((i) -> i).toArray();
    }

    //map에 영문 대문자를 Index와 같이 추가한다.
    private void initializeMap(Map<String, Integer> map) {
        //영문 대문자의 시작은 'A'
        char tempC = 'A';

        //Index의 시작은 1로 부터 시작한다.
        for (int i = 1; i <= 26; i++) {
            map.put(String.valueOf(tempC), i);
            tempC++;
        }
    }
}
