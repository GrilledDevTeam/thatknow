package com.grileddev.thatknow.util;

public enum BaseTime {
    BASETIME_0200("0200"),
    BASETIME_0500("0500"),
    BASETIME_0800("0800"),
    BASETIME_1100("1100"),
    BASETIME_1400("1400"),
    BASETIME_1700("1700"),
    BASETIME_2000("2000"),
    BASETIME_2300("2300");

    private String baseTime;

    private BaseTime(String baseTime) {
        this.baseTime = baseTime;
    }

    public String getBaseTime() {
        return toString();
    }

    @Override
    public String toString() {
        return baseTime;
    }
}
