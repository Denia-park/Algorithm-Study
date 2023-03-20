function solution(N) {
    // Implement your solution here
    let binaryString = dec2bin(N);
    let arr = binaryString.split("1");

    console.log(arr)

    if (arr.length === 2) {
        return 0;
    }

    let answer = 0;

    for (const element of arr) {
        answer = Math.max(answer, element.length);
    }

    return answer;
}

function dec2bin(dec) {
    return (dec >>> 0).toString(2);
}

console.log(solution(5));
console.log(solution(9));
console.log(solution(32));
console.log(solution(1041));
