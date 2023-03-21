function solution(n) {
    let arr = Array.from(String(n));

    let answer = [];
    for (let i = arr.length - 1; i >= 0; i--) {
        answer.push(parseInt(arr[i]));
    }

    return answer;
}
