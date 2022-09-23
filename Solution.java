import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        int addIndex = 27;

        Map<String,Integer> map = new HashMap<>();
        initializeMap(map);

        for (int i = 0; i < msg.length();) {
            int cuttingNum = 1;
            int tempVal;

            while (true) {
                String tempStr = msg.substring(i, i + cuttingNum);

                tempVal = map.getOrDefault(tempStr, -1);

                if(tempVal != -1){
                    if(i + cuttingNum < msg.length()){
                        cuttingNum++;
                        continue;
                    }
                    else{
                        i++;
                        break;
                    }
                }

                map.put(tempStr, addIndex);
                addIndex++;

                tempVal = map.get(msg.substring(i, i + cuttingNum - 1));
                break;
            }

            answer.add(tempVal);
            i += cuttingNum - 1;
        }

        return answer.stream().mapToInt((i) -> i).toArray();
    }

    private void initializeMap(Map<String, Integer> map) {
        char tempC = 'A';

        for (int i = 1; i <= 26; i++) {
            map.put(String.valueOf(tempC), i);
            tempC++;
        }
    }
}
