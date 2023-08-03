package com.grileddev.thatknow.util;

public class GridXY {
    private String x;
    private String y;
    
    public GridXY(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public GridXY(GridXY gridXY) {
        this.x = gridXY.getX();
        this.y = gridXY.getY();
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }
}
