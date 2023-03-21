function solution(arr) {
    let length = arr.length;
    return arr.reduce((a, b) => a + b, 0) / length;
}
