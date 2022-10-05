import java.util.Arrays;

public class Main {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

//        System.out.println(Arrays.toString(testSolution.solution(new int[][]{
//                {1, 1, 0, 0},
//                {1, 0, 0, 0},
//                {1, 0, 0, 1},
//                {1, 1, 1, 1}
//        })));

        System.out.println(Arrays.toString(testSolution.solution(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}
        })));
    }
}




