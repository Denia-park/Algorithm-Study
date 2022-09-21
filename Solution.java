import java.util.HashSet;
import java.util.Set;

class Solution {
    int mapSizeLimit;
    Set<String> pathMemory;
    int[] startPoint;
    public int solution(String dirs) {
        mapSizeLimit = 5;
        pathMemory = new HashSet<>();
        startPoint = new int[]{0, 0};

        for (int i = 0; i < dirs.length(); i++) {
            char command = dirs.charAt(i);
            movePath(command);
        }

        return pathMemory.size();
    }

    private void movePath(char command) {
        int originX = startPoint[0];
        int originY = startPoint[1];

        StringBuilder tempPathMemory = new StringBuilder();
        tempPathMemory.append(originX).append(originY);

        switch (command) {
            case 'U':
                if (originY + 1 <= 5){
                    originY++;
                    break;
                }
                return;
            case 'D':
                if (originY - 1 >= -5) {
                    originY--;
                    break;
                }
                return;
            case 'R':
                if (originX + 1 <= 5) {
                    originX++;
                    break;
                }
                return;
            case 'L':
                if (originX - 1 >= -5) {
                    originX--;
                    break;
                }
                return;
        }

        tempPathMemory.append(originX).append(originY);

        startPoint[0] = originX;
        startPoint[1] = originY;

        pathMemory.add(tempPathMemory.toString());
    }
}
