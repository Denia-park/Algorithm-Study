function solution(A) {
    let map = new Map();

    let newA = A.sort();
    let maxVal = newA[newA.length - 1];

    for (const key of newA) {
        let val = map.get(key);
        if (val === undefined) {
            map.set(key, 1);
        } else if (val === 1) {
            map.set(key, 2);
        }
    }
    map.set(maxVal, 1);

    let sum = 0;
    for (const ele of map.values()) {
        sum += ele;
    }

    return sum;
}

console.log(solution([2]) === 1);
console.log(solution([1, 2]) === 2);
console.log(solution([2, 5, 3, 2, 4, 1]) === 6);
console.log(solution([2, 3, 3, 2, 2, 2, 1]) === 4);
console.log(solution([4, 5, 7, 6, 3, 2]) === 6);
console.log(solution([1, 1, 1, 1, 1]) === 1);
console.log(solution([1, 2, 3, 3, 2]) === 4);
console.log(solution([1, 1, 2, 2, 3, 3, 7]) === 7);
console.log(solution([1, 1, 2, 2, 3, 3, 7, 7, 1]) === 7);
console.log(solution([1, 2, 3, 3, 2, 1]) === 5);
console.log(solution([1, 3, 3, 3, 2, 1]) === 4);
console.log(solution([1, 1, 1, 2, 2, 2, 3, 3, 3, 2, 1]) === 5);

//가능한 제일 긴 Spike를 구하시오.
