package com.grileddev.thatknow.util;

public class WeatherAPIParameter {
    private int numOfRows;
    private int pageNo;
    private String dataType;
    private String baseDate;
    private BaseTime baseTime;
    private int nx;
    private int ny;
    private GridXY gridXY;

    /**
     * @param numOfRows default : 290
     * @param pageNo  default : 1
     * @param dataType default : JSON
     * @param nx default : NONE
     * @param ny default : NONE
     */
    public WeatherAPIParameter() 
    {
        numOfRows = 290;
        pageNo = 1;
        dataType = "JSON";
        gridXY = null;
    }
    
    /**
     * 기상청 발표 시간 : 2, 5, 8, 11, 14, 17, 20, 23에서
     * 현재 시간을 기준으로 가장 최근 발표 날짜로 선택합니다.
     */
    public void setRecentlyBaseTimeAndBaseDate() {
        DateToDate nowDate = DateToDate.now();
        int nowTimeHour = nowDate.toTimeHour();
        int nowTimeMinute = nowDate.toTimeMinute();

        DateToDate baseDate = null;
        BaseTime baseTime = null;

        switch (nowTimeHour)
        {
            case 0:
            case 1:
                baseDate = DateToDate.yesterday();
                baseTime = BaseTime.BASETIME_2300;
                break;

            case 2:
                if(nowTimeMinute < 30)
                {
                    baseDate = DateToDate.yesterday();
                    baseTime = BaseTime.BASETIME_2300;
                    break;
                }
            case 3:
            case 4:
                baseDate = DateToDate.now();
                baseTime = BaseTime.BASETIME_0200;
                break;

            case 5:
                if(nowTimeMinute < 30)
                {
                    baseDate = DateToDate.now();
                    baseTime = BaseTime.BASETIME_0200;
                    break;
                }
            case 6:
            case 7:
                baseDate = DateToDate.now();
                baseTime = BaseTime.BASETIME_0500;
                break;
            
            case 8:
                if(nowTimeMinute < 30)
                {
                    baseDate = DateToDate.now();
                    baseTime = BaseTime.BASETIME_0500;
                    break;
                }
            case 9:
            case 10:
                baseDate = DateToDate.now();
                baseTime = BaseTime.BASETIME_0800;
                break;

            case 11:
                if (nowTimeMinute < 30)
                {
                    baseDate = DateToDate.now();
                    baseTime = BaseTime.BASETIME_0800;
                    break;
                }
            case 12:
            case 13:
                baseDate = DateToDate.now();
                baseTime = BaseTime.BASETIME_1100;
                break;

            case 14:
                if (nowTimeMinute < 30)
                {
                    baseDate = DateToDate.now();
                    baseTime = BaseTime.BASETIME_1100;
                    break;
                }
            case 15:
            case 16:
                baseDate = DateToDate.now();
                baseTime = BaseTime.BASETIME_1400;
                break;

            case 17:
                if (nowTimeMinute < 30)
                {
                    baseDate = DateToDate.now();
                    baseTime = BaseTime.BASETIME_1400;
                    break;
                }
            case 18:
            case 19:
                baseDate = DateToDate.now();
                baseTime = BaseTime.BASETIME_1700;
                break;

            case 20:
                if (nowTimeMinute < 30)
                {
                    baseDate = DateToDate.now();
                    baseTime = BaseTime.BASETIME_1700;
                    break;
                }
            case 21:
            case 22:
                baseDate = DateToDate.now();
                baseTime = BaseTime.BASETIME_2000;
                break;

            case 23:
                if (nowTimeMinute < 30)
                {
                    baseDate = DateToDate.now();
                    baseTime = BaseTime.BASETIME_2000;
                    break;
                }
                else
                {
                    baseDate = DateToDate.now();
                    baseTime = BaseTime.BASETIME_2300;
                    break;
                }
            default:
                System.out.println("Invalid Hours Data" + nowTimeHour);
                break;
        }

        setBaseDate(baseDate);
        setBaseTime(baseTime);
    }

    /**
     * 데이터 개수 설정
     * <p> numOfRows를 발표시간(baseTime) 한시간 이후 부터 몇 시간 이후까지 데이터 갯수를 설정한다. </p>
     * @param baseTime 발표시간 설정 , 포맷 : "hh00"
     * @param afterHours 발표시간 1시간 이후 부터 몇개의 정각 데이터를 얻을건지 설정
     */
    public void setNumOfRowsByBaseDateAfterHours(int afterHours) {
        /* 
         * 디폴트 개수로 시간마다 12개씩 데이터 +  추가적인 데이터로 특정 시간마다 TMN, TMX가 추가 되기에  
         * 디폴트 개수에서 extraTMX, extraTMN 개수를 더하는 것으로 추가적인 부분은 예외처리 했습니다
         * 리턴 : defaultCount + extraTMNCount + extraTMXCount   (어제 2300 => 290개 리턴)
         */

        int extraTMXCount = 0;
        int extraTMNCount = 0;

        // ( BaseTime + afterHours ) 가 매날 6시 , 15시 를 넘긴다면 extra 에 1씩 더해주었습니다
        switch(baseTime)
        {
            case BASETIME_0200:
                if (4 <= afterHours) // 0200 + 4시간 => 오늘 0600
                {
                    extraTMNCount++;
                }
                if (13 <= afterHours) // 0200 + 13시간 => 오늘 1500
                {
                    extraTMXCount++;
                }
                if (28 <= afterHours) // 0200 + 28시간 => 내일 0600
                {
                    extraTMNCount++;
                }
                if (37 <= afterHours) // 0200 + 37시간 => 내일 1500
                {
                    extraTMXCount++;
                }
                if (52 <= afterHours) // 0200 + 52시간 => 모레 0600
                {
                    extraTMNCount++;
                }
                if (61 <= afterHours) // 0200 + 61시간 => 모레 1500
                {
                    extraTMXCount++;
                }
                // 70개 맥스 (API가 보내주는 최대개수 (발표시간마다 다름))  =>  (모레 2400 까지)
                break;
        
            case BASETIME_0500:
                if (10 <= afterHours)
                {
                    extraTMXCount++;
                }
                if (25 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (34 <= afterHours)
                {
                    extraTMXCount++;
                }
                if (49 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (58 <= afterHours)
                {
                    extraTMXCount++;
                }
                // 67개 맥스 (모레 2400 까지)
                break;

            case BASETIME_0800:
    
                if (7 <= afterHours)
                {
                    extraTMXCount++;
                }
                if (22 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (31 <= afterHours)
                {
                    extraTMXCount++;
                }
                if (46 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (55 <= afterHours)
                {
                    extraTMXCount++;
                }
                // 64개 맥스 (모레 2400 까지)
                break;

            case BASETIME_1100:
                if (4 <= afterHours)
                {
                    extraTMXCount++;
                }
                if (19 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (28 <= afterHours)
                {
                    extraTMXCount++;
                }
                if (43 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (52 <= afterHours)
                {
                    extraTMXCount++;
                }
                // 61개 맥스 (모레 2400 까지)
                break;

            case BASETIME_1400:
                if (16 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (25 <= afterHours)
                {
                    extraTMXCount++;
                }
                if (40 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (49 <= afterHours)
                {
                    extraTMXCount++;
                }
                // 58개 맥스 (모레 2400 까지)
                break;

            case BASETIME_1700:
                if (13 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (22 <= afterHours)
                {
                    extraTMXCount++;
                }
                if (37 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (46 <= afterHours)
                {
                    extraTMXCount++;
                }
                if (61 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (70 <= afterHours)
                {
                    extraTMXCount++;
                }
                // 79개 맥스 (글피 2400 까지)
                break;

            case BASETIME_2000:
                if (10 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (19 <= afterHours)
                {
                    extraTMXCount++;
                }
                if (34 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (43 <= afterHours)
                {
                    extraTMXCount++;
                }
                if (58 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (67 <= afterHours)
                {
                    extraTMXCount++;
                }
                // 76개 맥스 (글피 2400 까지)
                break;

            case BASETIME_2300:
                if (7 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (16 <= afterHours)
                {
                    extraTMXCount++;
                }
                if (31 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (40 <= afterHours)
                {
                    extraTMXCount++;
                }
                if (55 <= afterHours)
                {
                    extraTMNCount++;
                }
                if (64 <= afterHours)
                {
                    extraTMXCount++;
                }
                // 73개 맥스 (글피 2400 까지)
                break;

            default:
                System.out.println("baseTime invalid");
                break;
        }

        final int commonValueCount = 12 * afterHours;

        this.numOfRows = commonValueCount + extraTMNCount + extraTMXCount;
    }


    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }


    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setBaseDate(DateToDate baseDate) {
        this.baseDate = baseDate.toDateString();
    }


    /**
     * 발표시간 설정
     * <p> [주의] : API에서 지정한 날씨데이터 발표시간으로 설정해야 합니다</p>
     *@param BaseTime (예시)
     * <p> "2300" , "0200" , "0500" , "0800" </p>
     * <p> "1100" , "1400" , "1700" , "2000" 중 하나 입력</p>
     */
    public void setBaseTime(BaseTime baseTime) {
        this.baseTime = baseTime;
    }

    public void setGridXY(GridXY gridXY) {
        this.gridXY = new GridXY(gridXY);
        this.nx = gridXY.getX();
        this.ny = gridXY.getY();
    }

    public void setXY(int x, int y) {
        this.gridXY = new GridXY(x, y);
        this.nx = x;
        this.ny = y;
    }

    
    public int getNumOfRows() {
        return numOfRows;
    }

    public int getPageNo() {
        return pageNo;
    }

    public String getDataType() {
        return dataType;
    }

    public String getBaseDate() {
        return baseDate;
    }

    public String getBaseTime() {
        return baseTime.toString();
    }

    public GridXY getGridXY() {
        return gridXY;
    }

    public int getNx() {
        return nx;
    }

    public int getNy() {
        return ny;
    }

    @Override
    public String toString() {
        final String data =  "numOfRows=" + numOfRows + "&" + "pageNo=" + pageNo + "&"
                + "dataType=" + dataType + "&" + "base_date=" + baseDate + "&" + "base_time=" + baseTime + "&" + "nx="
                + nx + "&" + "ny=" + ny;

        return data;
    }
}
