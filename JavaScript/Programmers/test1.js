// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

//몇번 나타는지랑 숫자가 몇인지 맞아야 한다.
function solution(A) {
    let map = new Map();

    for (const element of A) {
        if (map.get(element) === undefined) {
            map.set(element, 1);
        } else {
            map.set(element, map.get(element) + 1);
        }
    }

    let answer = [];
    for (const mapElement of map.keys()) {
        if (mapElement === map.get(mapElement)) {
            answer.push(mapElement);
        }
    }

    let rtVal = answer.sort().reverse()[0];

    return rtVal ? rtVal : 0;
}

console.log(solution([3, 8, 2, 3, 3, 2]) === 3)
console.log(solution([7, 1, 2, 8, 2]) === 2)
console.log(solution([3, 1, 4, 1, 5]) === 0)
console.log(solution([5, 5, 5, 5, 5]) === 5)
console.log(solution([1, 2, 2, 3, 3, 3]) === 3)
console.log(solution([7, 7, 7, 7, 7, 7, 2, 2, 3, 3, 3]) === 3)
console.log(solution([7, 7, 7, 7, 7, 7, 7, 2, 2, 3, 3, 3]) === 7)
console.log(solution([1, 1, 7, 7, 7, 7, 7, 2, 2, 3, , 3]) === 2)
console.log(solution([1, 1, 7, 7, 7, 7, 7, 2, 3, , 3]) === 0)
console.log(solution([1]) === 1)
console.log(solution([2, 2]) === 2)
console.log(solution([2, 2, 1]) === 2)
