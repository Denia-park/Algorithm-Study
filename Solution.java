//조건이 일치하는 음악이 여러 개일 때
//라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다.
//재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
//조건이 일치하는 음악이 없을 때에는 “(None)”을 반환한다.

import java.util.ArrayList;
import java.util.List;

class Solution {
    final int MUSIC_INDEX = 0;
    final int MUSIC_PLAY_TIME = 1;
    final int MUSIC_TITLE = 2;
    final int MUSIC_CODE_IN_PLAY_TIME = 3;
    List<String[]> editMusicInfos;
    public String solution(String neoCode, String[] musicinfos) {
        editMusicInfos = new ArrayList<>();

        int index = 0;
        for (String musicinfo : musicinfos) {
            parsingMusicInfo(musicinfo, index);
            index++;
        }

        List<String[]> matchingMusicArr = new ArrayList<>();

        for (String[] editMusicInfo : editMusicInfos) {
            int matchingIndex = editMusicInfo[MUSIC_CODE_IN_PLAY_TIME].indexOf(neoCode);

            while(matchingIndex != -1 ){
                int endSubStringIndex = (matchingIndex + neoCode.length() + 1) > editMusicInfo[MUSIC_CODE_IN_PLAY_TIME].length() ? matchingIndex + neoCode.length() : matchingIndex + neoCode.length() + 1;
                String cuttingCode = editMusicInfo[MUSIC_CODE_IN_PLAY_TIME].substring(matchingIndex, endSubStringIndex);

                if (isEqualCode(cuttingCode, neoCode)) {
                    matchingMusicArr.add(editMusicInfo);
                    break;
                }

                matchingIndex = editMusicInfo[MUSIC_CODE_IN_PLAY_TIME].indexOf(neoCode, matchingIndex + 1);
            }
        }

        if (matchingMusicArr.size() == 0) {
            return "(None)";
        }

        matchingMusicArr.sort((o1, o2) -> {
            int o1PlayTime = Integer.parseInt(o1[MUSIC_PLAY_TIME]);
            int o2PlayTime = Integer.parseInt(o2[MUSIC_PLAY_TIME]);

            if(o1PlayTime > o2PlayTime) {
                return -1;
            }
            else if (o1PlayTime == o2PlayTime) {
                int o1Index = Integer.parseInt(o1[MUSIC_INDEX]);
                int o2Index = Integer.parseInt(o2[MUSIC_INDEX]);

                return o1Index - o2Index;
            }
            return 1;
        });

        return matchingMusicArr.get(0)[MUSIC_TITLE];
    }

    private boolean isEqualCode(String cuttingCode, String neoCode) {
        String[] cuttingCodeArr = getCodeArr(cuttingCode);
        String[] neoCodeArr = getCodeArr(neoCode);

        int matchingCount = 0;

        for (int i = 0; i <neoCodeArr.length; i++) {
            if (cuttingCodeArr[i].equals(neoCodeArr[i])) {
                matchingCount++;
            }
        }

        return matchingCount == neoCodeArr.length;
    }

    private void parsingMusicInfo(String musicinfo, int index) {
        String[] tempMusicInfoArr = musicinfo.split(",");

        String startTime = tempMusicInfoArr[MUSIC_INDEX];
        String endTime = tempMusicInfoArr[MUSIC_PLAY_TIME];
        String musicTitle = tempMusicInfoArr[MUSIC_TITLE];
        String musicOriginCode = tempMusicInfoArr[MUSIC_CODE_IN_PLAY_TIME];

        String playTime = calculatePlayTime(startTime, endTime);
        String musicPlayCodeInPlayTime = calculateMusicPlayCode(musicOriginCode , playTime);

        String[] MusicInfoArr = {String.valueOf(index), playTime, musicTitle, musicPlayCodeInPlayTime};

        editMusicInfos.add(MusicInfoArr);
    }

    private String calculatePlayTime(String startTime, String endTime) {
        final int HOUR = 0;
        final int MIN = 1;

        String[] startTimeArr = startTime.split(":");
        int startTimeHourToMin = Integer.parseInt(startTimeArr[HOUR]) * 60;
        int startTimeTotalMin = startTimeHourToMin + Integer.parseInt(startTimeArr[MIN]);

        String[] endTimeArr = endTime.split(":");
        int endTimeHourToMin = Integer.parseInt(endTimeArr[HOUR]) * 60;
        int endTimeTotalMin = endTimeHourToMin + Integer.parseInt(endTimeArr[MIN]);

        return "" + (endTimeTotalMin - startTimeTotalMin);
    }

    private String calculateMusicPlayCode(String musicOriginCode, String playTime) {
        String[] musicOriginCodeArr = getCodeArr(musicOriginCode);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Integer.parseInt(playTime); i++) {
            sb.append(musicOriginCodeArr[i % musicOriginCodeArr.length]);
        }

        return sb.toString();
    }

    //B
    //C#
    private String[] getCodeArr(String musicOriginCode) {
        List<String> tempList = new ArrayList<>();

        int codeLength = musicOriginCode.length();

        for (int i = 0; i < codeLength; i++) {
            if (i != codeLength - 1 && musicOriginCode.charAt(i + 1) == '#') {
                tempList.add(musicOriginCode.substring(i, i + 2));
                i++;
            } else {
                tempList.add(musicOriginCode.substring(i, i + 1));
            }
        }

        return tempList.toArray(new String[0]);
    }
}
