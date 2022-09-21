import java.util.HashSet;
import java.util.Set;

class Solution {
    int mapSizeLimit;
    Set<String> pathMemory;
    public int solution(String dirs) {
        mapSizeLimit = 5;
        pathMemory = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {
            movePath(dirs.substring(i));
        }

        return pathMemory.size();
    }

    private void movePath(String substring) {

    }
}
