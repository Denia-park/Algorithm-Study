import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];

        List<StudentScore> list = new ArrayList<StudentScore>();

        for (int i = 0; i < score.length; i++) {
            int[] ints = score[i];
            list.add(new StudentScore(ints[0], ints[1], i));
        }

        list.sort(null);

        double tempScore = list.get(0).getAvg();
        int tempRank = 1;
        int tempCount = 1;

        for (StudentScore studentScore : list) {
            if (tempScore > studentScore.getAvg()) {
                tempScore = studentScore.getAvg();
                tempRank = tempCount;
            }

            int tempIndex = studentScore.getIndex();
            answer[tempIndex] = tempRank;

            tempCount++;
        }

        return answer;
    }
}

class StudentScore implements Comparable<StudentScore> {
    private final int engScore, mathScore, index;
    private final double avg;

    public StudentScore(int engScore, int mathScore, int index) {
        this.engScore = engScore;
        this.mathScore = mathScore;
        this.index = index;

        this.avg = (engScore + mathScore) / 2.0;
    }

    public int getIndex() {
        return index;
    }

    public double getAvg() {
        return avg;
    }

    @Override
    public int compareTo(StudentScore o1) {
        double avg1 = this.getAvg();
        double avg2 = o1.getAvg();

        if (avg1 > avg2) return -1;
        else if (avg1 < avg2) return 1;

        return 0;
    }
}
