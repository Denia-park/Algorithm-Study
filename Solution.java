package com.company;

// https://yummy0102.tistory.com/359 참고함
class Solution {
    public int solution(String name) {
        int answer = 0;
        int index;
        int move = name.length()-1;

        for(int i=0;i<name.length();i++) {
            answer += Math.min(name.charAt(i) - 'A', ('Z' + 1) - name.charAt(i));

            index = i+1;
            while(index<name.length() && name.charAt(index) == 'A') {
                index++;
            }
            move = Math.min(move, Math.min(i*2+name.length()-index,(name.length()-index)*2 + i));
        }
        return answer + move;
    }
}
