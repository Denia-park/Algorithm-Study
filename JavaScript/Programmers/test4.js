function solution(S) {
    let map = new Map();
    let maxVal = -1;

    // Implement your solution here
    for (let i = 0; i < S.length - 1; i++) {
        let digram = S.slice(i, i + 2);

        if (map.get(digram) === undefined) {
            map.set(digram, i);
        } else {
            maxVal = Math.max(maxVal, i - map.get(digram));
        }
    }

    return maxVal;
}

console.log(solution("aakmaakmakda") === 7);
console.log(solution("aaa") === 1);
console.log(solution("codility") === -1);
