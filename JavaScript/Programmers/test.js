function solution(x) {
    let sum = getDigitSum(x);

    return Math.floor(x / sum) === x / sum;
}

function getDigitSum(number) {
    let sum = 0;

    let arr = number.toString().split('');

    for (let i = 0; i < arr.length; i++) {
        sum += Number(arr[i]);
    }

    return sum;
}
