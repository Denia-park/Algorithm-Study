function solution(n) {
    var answer = 0;

    let newN = n - 1;

    return getDividers(newN)[1];
}

function getDividers(number) {
    let arr = [];
    for (let i = 1; i <= number; i++) {
        if (number % i === 0) {
            arr.push(i);
        }
    }
    return arr
}
