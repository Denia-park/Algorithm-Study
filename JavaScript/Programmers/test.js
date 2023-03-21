function solution(x, n) {
    var answer = [];

    let curVal = x;
    answer.push(curVal);
    while (answer.length !== n) {
        curVal += x;
        answer.push(curVal);
    }
    return answer;
}
