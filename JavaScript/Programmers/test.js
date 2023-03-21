function solution(wallpaper) {
    let answer = [];

    let minX, minY, maxX, maxY;

    minX = 100;
    minY = 100;
    maxX = -1;
    maxY = -1;

    for (let r = 0; r < wallpaper.length; r++) {
        for (let c = 0; c < wallpaper[r].length; c++) {
            if (wallpaper[r][c] === "#") {
                minX = Math.min(minX, r);
                minY = Math.min(minY, c);
                maxX = Math.max(maxX, r);
                maxY = Math.max(maxY, c);
            }
        }
    }

    return [minX, minY, maxX + 1, maxY + 1];
}
