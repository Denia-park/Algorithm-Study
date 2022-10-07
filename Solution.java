import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[] spell, String[] dic) {
        List<Character> words = Arrays.stream(spell).map(s -> s.charAt(0)).collect(Collectors.toList());

        for (String str : dic) {
            if(str.length() < spell.length) continue;

            Set<Character> spellSet = str.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

            if (spellSet.containsAll(words))
                return 1;
        }

        return 2;
    }
}

/*
class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;


        for(String dicS : dic) {

            boolean isRight = true;
            for(String spellS : spell) {
                if(dicS.indexOf(spellS) == -1) {
                    isRight = false;
                    break;
                }
            }

            if(isRight) {
                answer = 1;
                break;
            }
        }

        return answer;
    }
}
 */
