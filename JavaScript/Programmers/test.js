function solution(n, k) {
    var answer = 0;
    const sheepFood = 12000;
    const drink = 2000;
    const service = parseInt(String(n / 10));
    answer = 12000 * n + 2000 * (k - service);
    return answer;
}
