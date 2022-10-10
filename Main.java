public class Main {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

        for (int i = 1; i <= 1000000; i++) {
            for (int j = 3; j <= 10; j++) {
                System.out.println("" + i + " : " + j);
                System.out.println(testSolution.solution(i, j));

                System.out.println();
            }
        }

        System.out.println(testSolution.solution(1_000_000, 10));
//        System.out.println(testSolution.solution(437674, 3));
//        System.out.println(testSolution.solution(110011, 10));
    }
}




