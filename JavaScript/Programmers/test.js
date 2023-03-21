function solution(n) {
    let arr = Array.from(String(n));
    arr = arr.sort().reverse();

    let str = arr.reduce((a, b) => a + b, "");

    return parseInt(str);
}
