import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
    public String solution(String my_string) {
        Set<Character> set = new LinkedHashSet<>();

        for (int i = 0; i < my_string.length(); i++) {
            set.add(my_string.charAt(i));
        }

        Character[] tempCharacterArr = set.toArray(new Character[0]);

        StringBuilder sb = new StringBuilder();
        for (Character character : tempCharacterArr) {
            sb.append(character);
        }
        return sb.toString();
    }
}
