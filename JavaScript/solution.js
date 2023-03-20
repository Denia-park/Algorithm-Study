function solution(N) {
    // Implement your solution here
    let binaryString = dec2bin(N);

    let answer = 0;
    let zeroCount = 0;
    for (let i = 0; i < binaryString.length; i++) {
        if (binaryString.charAt(i) === "1") {
            answer = Math.max(answer, zeroCount);
            zeroCount = 0;
        } else {
            zeroCount++;
        }
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
console.log(solution(328));
