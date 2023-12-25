package CodingTest.Programmers;

import java.util.List;

class Solution {
    List<Character> specialCharacters = List.of('-', '_', '.');

    public String solution(String new_id) {
        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            final char c = new_id.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        new_id = sb.toString();

        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            final char c = new_id.charAt(i);
            if (!Character.isLowerCase(c)
                    && !Character.isDigit(c)
                    && !specialCharacters.contains(c)) {
                continue;
            }

            sb.append(c);
        }
        new_id = sb.toString();

        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            final char c = new_id.charAt(i);
            if (c == '.') {
                sb.append('.');

                while (i + 1 < new_id.length() && new_id.charAt(i + 1) == '.') {
                    i++;
                }
            } else {
                sb.append(c);
            }
        }
        new_id = sb.toString();

        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (!new_id.isEmpty() && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        if (!new_id.isEmpty() && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }

        //        만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if (new_id.length() <= 2) {
            final char lastChar = new_id.charAt(new_id.length() - 1);

            while (new_id.length() < 3) {
                new_id += lastChar;
            }
        }

        return new_id;
    }
}
