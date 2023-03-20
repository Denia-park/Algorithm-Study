function solution(babbling) {
    var answer = 0;

    let sayYes = ["aya", "ye", "woo", "ma"];

    for (let element of babbling) {
        for (const word of sayYes) {
            element = element.replace(word, " ");
        }

        if (element.trim() === "") {
            answer++;
        }
    }

    return answer;
}

console.log(solution(["aya", "yee", "u", "maa", "wyeoo"]));
console.log(solution(["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]));
