function solution(n) {
    var answer = 0;
    let sqrt = Math.floor(Math.sqrt(n));
    if (Math.pow(sqrt, 2) === n) {
        answer = (sqrt + 1) ** 2;
    } else {
        answer = -1;
    }

    return answer;
}

console.log(solution(1))
console.log(solution(25))
console.log(solution(121))
