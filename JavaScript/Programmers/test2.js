function solution(S) {
    // Implement your solution here
    let arr = S.split('');

    let stackA = [];
    //A 앞에 B 터뜨리기
    let aCount = 0;
    for (const element of arr) {
        let str = element;

        if (stackA.length !== 0 && (str === 'A' && stackA[stackA.length - 1] === 'B')) {
            stackA.pop();
            aCount++;
        } else {
            stackA.push(str);
        }
    }

    let stackB = [];
    //B 뒤에 A 터뜨리기
    let bCount = 0;
    for (const element of arr) {
        let str = element;

        if (stackB.length !== 0 && (str === 'A' && stackB[stackB.length - 1] === 'B')) {
            bCount++;
        } else {
            stackB.push(str);
        }
    }

    return Math.min(aCount, bCount);
}

console.log(solution("BAAA") === 1)
console.log(solution("ABBB") === 0)
console.log(solution("BBAA") === 2)
console.log(solution("BBAAA") === 2)
console.log(solution("BBBAA") === 2)
console.log(solution("BABBBBBB") === 1)
console.log(solution("ABABBBBB") === 1)
