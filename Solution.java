package com.company;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        //answer 변수 선언
        int answer = 0;

        //모든 스킬 트리에 대해서 스킬이 올바르게 찍혔는지 테스트
        for (String skill_tree : skill_trees) {
            //모든 스킬의 찍힌 순서를 알아보기 위해서 skillIndexArr 를 선언
            int[] skillIndexArr = new int[skill.length()];
            //올바르게 찍힌 스킬인지 확인해줄 flag
            boolean rightSkillTreeFlag = true;

            //skill_tree에서 skill 이 어떤 순서로 찍혔는지 확인
            for (int i = 0; i < skill.length(); i++) {
                //처음으로 찍혀야 하는 스킬 선언
                char eachSkill = skill.charAt(i);
                //skill_tree 에서 몇번째로 찍혔는지 확인
                int eachSkillIndex = skill_tree.indexOf(eachSkill);

                //구해진 값을 skillIndexArr 에 저장
                skillIndexArr[i] = eachSkillIndex;
            }

            //skillIndexArr 에 찍혀진 값을 바탕으로 올바르게 찍힌 스킬인지 확인한다.
                //Index가 OutOfRangeError 를 발생하는 것을 막기 위해서 skill.length() -1 까지만 for문을 돌린다.
            for (int i = 0; i < skill.length() - 1; i++) {
                //선행스킬 중 현재 스킬
                int curSkillIdx = skillIndexArr[i];
                //선행스킬 중 다음 스킬
                int nextSkillIdx = skillIndexArr[i + 1];

                //올바른 스킬 트리가 아닌 경우 rightSkillTreeFlag 를 false 로 변환한 후 for문을 빠져나간다.
                if (isNotRightSkillTree(curSkillIdx, nextSkillIdx)) {
                    rightSkillTreeFlag = false;
                    break;
                }
            }

            //올바른 스킬 트리 인 경우만 answer를 업데이트
            if(rightSkillTreeFlag){
                answer++;
            }
        }

        return answer;
    }

    //현재 스킬이 skill_tree 에 존재하는지 확인
    private boolean isExistInSkillTree(int skillIndex){
        return skillIndex != -1;
    }

    //매개변수로 들어간 모든 스킬이 skill_tree 에 존재하는지 확인
    private boolean isAllExistInSkillTree(int skillIdx1 , int skillIdx2){
        return skillIdx1 != -1 && skillIdx2 != -1;
    }

    //잘못된 순서로 찍힌 스킬인지 확인
    private boolean isWrongOrderSkillTree(int curSkillIndex , int nextSkillIndex){
        //모든 스킬이 존재하는데 후행 스킬이 먼저 찍힌 경우 잘못된 순서로 찍힌 스킬
        return isAllExistInSkillTree(curSkillIndex, nextSkillIndex) &&
                curSkillIndex - nextSkillIndex > 0;
    }

    //올바른 스킬트리가 맞는지 확인
        //1. 선행스킬이 존재하지 않는데 후행스킬이 존재하는 경우 올바른 스킬트리가 아님
        //2. 순서가 잘못된 경우 올바른 스킬트리가 아님
    private boolean isNotRightSkillTree(int curSkillIndex , int nextSkillIndex){
        if(!isExistInSkillTree(curSkillIndex) && isExistInSkillTree(nextSkillIndex)){
            return true;
        }else if(isWrongOrderSkillTree(curSkillIndex, nextSkillIndex)){
            return true;
        }

        return false;
    }
}
