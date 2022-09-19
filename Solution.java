package com.company;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0)
            return cities.length * 5;

        Deque<String> dq = new LinkedList<>();

        for (String city : cities) {
            String upperCaseCityName = city.toUpperCase();
            if(!dq.isEmpty() && dq.contains(upperCaseCityName)) {
                dq.remove(upperCaseCityName);
                dq.add(upperCaseCityName);
                answer += 1;
                continue;
            }

            if(dq.size() >= cacheSize)
                dq.poll();

            dq.add(upperCaseCityName);
            answer += 5;
        }

        return answer;
    }
}
