// 1x1 이 M
// 2x2 이 N

//가장 큰 정사각형을 만들어야 한다.
//겹치면 안됨
//비어있으면 안됨

//가장 큰 정사각형의 한변을 return 해라
//정사각형이 안만들어 지면 0을 return 해라

function solution(M, N) {
    let tileSum = M + (4 * N);

    let maxValue = parseInt(Math.sqrt(tileSum));
    let startValue = maxValue;

    let addTileNum = (4 - (N % 4));

    if (M >= (4 * addTileNum)) {
        N = N + addTileNum;
        M = M - (addTileNum * 4);
    }

    while (true) {
        //홀수 인지, 짝수인지 구분하기
        if (startValue % 2 === 0) {
            //짝수
            return startValue;
        } else {
            //홀수
            if (N % 4 !== 0 && startValue - (2 * N) < 0) {
                startValue--;
                continue
            }

            return startValue;
        }
    }
}

// console.log(solution(0, 0) === 0);
// console.log(solution(1, 0) === 1);
// console.log(solution(2, 0) === 1);
// console.log(solution(3, 0) === 1);
// console.log(solution(3, 3) === 2);
// console.log(solution(4, 0) === 2);
// console.log(solution(4, 1) === 2);
// console.log(solution(4, 2) === 2);
// console.log(solution(4, 3) === 4);
// console.log(solution(0, 1) === 2);
// console.log(solution(8, 0) === 2);
// console.log(solution(0, 18) === 8);
// console.log(solution(1, 1) === 2);
// console.log(solution(1, 2) === 2);
// console.log(solution(1, 3) === 2);
// console.log(solution(0, 4) === 4);
// console.log(solution(13, 3) === 5);
console.log("------------");
console.log(solution(3, 1) === 2);
console.log(solution(3, 3) === 2);
console.log(solution(4, 3) === 4);
console.log(solution(12, 5) === 5);
