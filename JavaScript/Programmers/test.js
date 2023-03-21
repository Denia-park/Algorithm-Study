function solution(id_list, report, k) {
    var answer = [];

    let totalRepoList = {};
    let repoHistory = {};

    for (const eachElement of report) {
        let [from, to] = eachElement.split(" ");

        if (repoHistory[from] === undefined) {
            repoHistory[from] = [];
            repoHistory[from].push(to);
        } else {
            if (repoHistory[from].includes(to)) {
                continue;
            }
            
            repoHistory[from].push(to);
        }

        if (totalRepoList[to] === undefined) {
            totalRepoList[to] = 1;
        } else {
            totalRepoList[to]++;
        }
    }

    let stoppedIdList = id_list.filter(id => totalRepoList[id] >= k);

    for (const id of id_list) {
        let tempCount = 0;
        if (repoHistory[id] !== undefined) {

            for (const repoId of repoHistory[id]) {
                if (stoppedIdList.includes(repoId)) {
                    tempCount++;
                }
            }
        }

        answer.push(tempCount);
    }

    return answer;
}

// let val = solution(["muzi", "frodo", "apeach", "neo"], ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"], 2);
let val = solution(["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 3);
console.log(val)
