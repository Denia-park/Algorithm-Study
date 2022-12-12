import java.util.ArrayList;
import java.util.List;

class Solution {
    public void solution(int[][] tables) {
        int[] answer = new int[4];

        List<List<GameResult>> example = new ArrayList<>();

        for (int i = 0; i < tables.length; i++) {
            example.add(makeGameResults(tables[i]));
        }

        for (int i = 0; i < example.size(); i++) {
            List<GameResult> curExample = example.get(i);

            if (isRightResultByWinLose(curExample) && isRightResultByDraw(curExample)) {
                answer[i] = 1;
            }
        }

        String[] answerString = new String[4];

        for (int i = 0; i < answer.length; i++) {
            answerString[i] = String.valueOf(answer[i]);
        }

        System.out.println(String.join(" ", answerString));
    }

    private boolean isRightResultByDraw(List<GameResult> curExample) {
        int totalDraw = 0;
        int totalCountry = 0;

        for (GameResult gameResult : curExample) {
            int curDraw = gameResult.draw;
            if (curDraw != 0) {
                totalCountry++;
            }
            totalDraw += curDraw;
        }

        if (totalDraw == 0 && totalCountry == 0) {
            return true;
        } else {
            return (totalDraw % 2 != 1) && (totalCountry % 2 != 1);
        }
    }

    private boolean isRightResultByWinLose(List<GameResult> curExample) {
        int totalWin = 0;
        int totalLose = 0;

        for (GameResult gameResult : curExample) {
            int curWin = gameResult.win;
            int curLose = gameResult.lose;
            totalWin += curWin;
            totalLose += curLose;
        }

        return totalWin == totalLose;
    }

    private List<GameResult> makeGameResults(int[] table) {
        String[] nameList = {"A", "B", "C", "D", "E", "F"};
        List<GameResult> gameResults = new ArrayList<>();
        int nameIdx = 0;
        for (int i = 0; i < table.length; i += 3) {
            int win = table[i];
            int draw = table[i + 1];
            int lose = table[i + 2];
            gameResults.add(new GameResult(nameList[nameIdx], win, draw, lose));
            nameIdx++;
        }

        return gameResults;
    }
}

class GameResult {
    String name;
    int win;
    int draw;
    int lose;

    GameResult(String name, int win, int draw, int lose) {
        this.name = name;
        this.win = win;
        this.draw = draw;
        this.lose = lose;
    }
}
