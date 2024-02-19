package CodingTest.Programmers;

class Solution {
    // 방향 벡터 정의: 상, 하, 좌, 우
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    // '무한대'를 나타내는 상수, 최소 턴 계산에 사용
    private static final int INF = 987654321;

    // 주요 해결 방법을 구현한 메서드
    public int solution(final int[][] board, final int[] aloc, final int[] bloc) {
        // 두 플레이어 위치를 기반으로 최소 턴 수를 계산
        return solve(board, aloc[0], aloc[1], bloc[0], bloc[1])[1];
    }

    // 게임의 승패와 최소 턴 수를 계산하는 메서드
    private int[] solve(final int[][] board, final int r1, final int c1, final int r2, final int c2) {
        // 현재 위치에서 게임이 끝났는지 확인
        if (isFinished(board, r1, c1)) return new int[]{0, 0};

        // 두 플레이어가 같은 위치에 있으면 현재 플레이어 승리
        if (r1 == r2 && c1 == c2) return new int[]{1, 1};

        int minTurn = INF, maxTurn = 0;
        boolean canWin = false;

        // 모든 가능한 이동 시도
        for (int i = 0; i < 4; i++) {
            final int nr = r1 + dr[i];
            final int nc = c1 + dc[i];
            if (!inRange(board, nr, nc) || board[nr][nc] == 0) continue; // 이동할 수 없는 경우

            board[r1][c1] = 0; // 현재 위치에서 이동
            final int[] result = solve(board, r2, c2, nr, nc); // 재귀적으로 다음 턴 계산
            board[r1][c1] = 1; // Undo move

            // 승리할 수 있는 경우와 그렇지 않은 경우를 분리하여 처리
            if (result[0] == 0) { //상대방이 패배한다는 의미 -> 내가 승리
                canWin = true;
                minTurn = Math.min(minTurn, result[1]);
            } else if (!canWin) {
                maxTurn = Math.max(maxTurn, result[1]);
            }
        }

        // 승리할 수 있는 경우 최소 턴, 그렇지 않은 경우 최대 턴 반환
        final int turn = canWin ? minTurn : maxTurn;
        // 승패를 판단하고, 현재 턴을 소모하므로 turn + 1을 반환
        return new int[]{canWin ? 1 : 0, turn + 1};
    }

    // 현재 위치에서 더 이동할 수 있는지 확인하는 메서드
    private boolean isFinished(final int[][] board, final int r, final int c) {
        for (int i = 0; i < 4; i++) {
            final int nr = r + dr[i];
            final int nc = c + dc[i];
            if (inRange(board, nr, nc) && board[nr][nc] == 1) {
                return false; // 이동할 수 있는 위치가 있으면 게임 계속
            }
        }
        return true; // 더 이동할 수 없으면 게임 종료
    }

    // 주어진 위치가 보드판 내에 있는지 확인하는 메서드
    private boolean inRange(final int[][] board, final int r, final int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length;
    }
}
