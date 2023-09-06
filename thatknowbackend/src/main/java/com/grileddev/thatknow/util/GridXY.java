package com.grileddev.thatknow.util;

public class GridXY {
    private int x;
    private int y;
    
    public GridXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public GridXY(GridXY gridXY) {
        this.x = gridXY.getX();
        this.y = gridXY.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
