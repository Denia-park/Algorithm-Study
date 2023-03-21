function solution(n) {
    const arr = Array.from(String(n));

    let sum = 0;
    for (const arrElement of arr) {
        sum += parseInt(arrElement);
    }

    return sum;
}

console.log(solution(123));
