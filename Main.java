public class Main {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

//        String[] quizArr1_a = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int[] quizArr1_b = {2,3,4};
//        String[][] quizArr2_a = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

//        System.out.println(Arrays.toString(testSolution.solution(quizArr1_a, quizArr1_b)));

//        System.out.println(testSolution.solution(quizArr3_a));
//        System.out.println((testSolution.solution(3,3,new String[]{"ABC", "DEF", "GHI"})));
//        System.out.println((testSolution.solution(new int[]{70, 50, 80, 50}, 100)));
//        System.out.println((testSolution.solution(new int[]{70, 80, 50}, 100)));
//        System.out.println((testSolution.solution(new int[]{10, 30, 50,100,100,100, 90}, 100))); //5


//        System.out.println(testSolution.solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
//        System.out.println(testSolution.solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(testSolution.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(testSolution.solution("A#B#C#A#B#C#A#B#C#A#B#C#", new String[]{"00:00,00:00,HELLO,C#DEFGABC#DEFGAB", "12:58,14:03,WORLD,A#B#C#A#B#C#A#B#C#A#B#C#"}));
        System.out.println(testSolution.solution("AAAA", new String[]{"00:00,00:05,HEA,A", "12:58,14:03,WORLD,BBB"}));
    }
}




