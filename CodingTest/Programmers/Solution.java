package CodingTest.Programmers;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        int idx = 0;
        
        for(String str : quiz){
            String[] split = str.split(" ");
            int startInt = Integer.parseInt(split[0]);
            String oper = split[1];
            int endInt = Integer.parseInt(split[2]);
            int result = Integer.parseInt(split[4]);
        
            
            if(oper.equals("+")){
                if(startInt + endInt == result){
                    answer[idx] = "O";
                }else{
                    answer[idx] = "X";
                }
            }else{
                if(startInt - endInt == result){
                    answer[idx] = "O";
                }else{
                    answer[idx] = "X";
                }
            }
            
            idx++;
        }
        
        return answer;
    }
    
    void sout(Object o){
        System.out.println(o);
    }        
}