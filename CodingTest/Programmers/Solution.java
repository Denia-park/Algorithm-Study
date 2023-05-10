package CodingTest.Programmers;

/*
Idea
-90 180 270 도 돌리고
-key를 옮길수있는 만큼 옮기면서 값을 다 확인해보자.
-key는 무조건 lock보다 작다.

time coplexity
-시뮬레이션 문제라서 구현만 하면 가능할듯

data structure
-int[][]
 */

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        //키를 그대로 두고 확인 ~ key 270도 돌려서 확인
        for (int rotateCount = 0; rotateCount < 4; rotateCount++) {
            //처음에는 안돌리고 확인
            if (rotateCount != 0) {
                //한번당 90도 돌리기.
                key = rotateTable90DegreeClockwise(key);
            }

            if (verifyKey(key, lock)) {
                return true;
            }
        }

        return false;
    }

    //90도 돌리게 되면
    //(r,c) -> (c, arrSize - 1 - r )
    private int[][] rotateTable90DegreeClockwise(int[][] key) {
        int size = key.length;
        int[][] newKey = new int[size][size];

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                newKey[r][c] = key[size - 1 - c][r];
            }
        }

        return newKey;
    }

    private boolean verifyKey(int[][] key, int[][] lock) {
        int lockSize = lock.length;
        int keySize = key.length;

        int bigSize = lockSize + (keySize - 1);

        //2개의 lock을 비교하기 위해 key 기반으로 newLock을 만든다.
        for (int sR = 0; sR < bigSize; sR++) {
            for (int sC = 0; sC < bigSize; sC++) {
                int[][] newLock = moveKey(key, sR, sC, lockSize);

                if (verify(lockSize, lock, newLock)) {
                    return true;
                }
            }
        }

        return false;
    }

    //key를 옮긴 경우를 생각하기 위해서
    //큰 배열을 만들고 key 값을 대입 후 필요한 부분만 추출해서 쓴다.
    private int[][] moveKey(int[][] key, int sR, int sC, int lockSize) {
        int keySize = key.length;
        int bigSize = lockSize + (keySize - 1) * 2;
        int[][] bigLock = new int[bigSize][bigSize];
        int[][] rtLock = new int[lockSize][lockSize];

        //bigLock에 값 대입
        for (int r = sR, kR = 0; r < sR + keySize; r++, kR++) {
            for (int c = sC, kC = 0; c < sC + keySize; c++, kC++) {
                bigLock[r][c] = key[kR][kC];
            }
        }

        //값 추출
        for (int nR = keySize - 1, oR = 0; nR < (keySize - 1 + lockSize); nR++, oR++) {
            for (int nC = keySize - 1, oC = 0; nC < keySize - 1 + lockSize; nC++, oC++) {
                rtLock[oR][oC] = bigLock[nR][nC];
            }
        }

        return rtLock;
    }

    private boolean verify(int lockSize, int[][] lock, int[][] newLock) {
        //첨부터 끝까지 도는데
        //lock이 1인데 key가 1이면 안됨
        //lock이 0인데 key도 0이면 안됨
        //lock이 0이고 key가 1이면 OK
        //lock이 1이고 key가 0이면 OK

        //즉 두개가 서로 다르기만 하면 된다.

        //만들어진 lock 과 기존 lock을 비교한다.
        for (int r = 0; r < lockSize; r++) {
            for (int c = 0; c < lockSize; c++) {
                if (lock[r][c] == newLock[r][c]) {
                    return false;
                }
            }
        }

        return true;
    }
}
