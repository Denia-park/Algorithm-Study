function solution(n) {

    return getDividers(n).reduce((a, b) => a + b, 0);
}

function getDividers(number) {
    let dividers = [];

    for (let i = 1; i <= number; i++) {
        if (number % i === 0) {
            dividers.push(i);
        }
    }

    return dividers
}
