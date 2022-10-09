package com.ssafy.sowlmate.entity.type;

public enum InterestType {
    DAILY("일상"),
    COMEDY("코미디"),
    DANCE("댄스"),
    MUSIC("음악"),
    VIDEO("영화/드라마"),
    MOTION("운동"),
    ENTERTAINMENT("엔터테인먼트"),
    BEAUTY("뷰티"),
    SPORTS("스포츠"),
    FOOD("음식"),
    TRAVEL("여행"),
    ANIMAL("동물"),
    FASHION("패션"),
    BOOK("책"),
    GAME("게임"),
    PHOTO("사진/영상");

    private final String content;

    private InterestType(String s) {
        content = s;
    }

    public String getContent() {
        return content;
    }
}