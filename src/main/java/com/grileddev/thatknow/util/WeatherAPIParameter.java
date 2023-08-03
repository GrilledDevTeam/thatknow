package com.grileddev.thatknow.util;

public class WeatherAPIParameter {
    private String numOfRows;
    private String pageNo;
    private String dataType;
    private String baseDate;
    private String baseTime;
    private String nx;
    private String ny;
    private GridXY gridXY;

    /**
     * @param numOfRows default : 290
     * @param pageNo  default : 1
     * @param dataType default : JSON
     * @param baseDate default : 어제
     * @param baseTime default : 2300
     * @param nx default : NONE
     * @param ny default : NONE
     */
    public WeatherAPIParameter() 
    {
        numOfRows = "290";
        pageNo = "1";
        dataType = "JSON";
        baseDate = DateToDate.DateToString(DateToDate.yesterday());
        baseTime = "2300";
        gridXY = null;
    }
    
    /**
     * 데이터 개수 설정
     * <p> numOfRows를 발표시간(baseDate, baseTime)과 몇시간의 데이터를 얻을건지(hoursCount)를 이용해 설정 </p>
     * 
     * @param baseDate 발표날짜 설정 , 포맷 : "yyyyMMdd"
     * @param baseTime 발표시간 설정 , 포맷 : "hh00"
     * @param hoursCount 발표시간 1시간 이후 부터 몇개의 정각 데이터를 얻을건지 설정
     */
    public void setNumOfRowsByTime(String baseDate, String baseTime, int hoursCount) {

        /* 
         * 디폴트 개수로 시간마다 12개씩 데이터 +  추가적인 데이터로 특정 시간마다 TMN, TMX가 추가 되기에  
         * 디폴트 개수에서 extraTMX, extraTMN 개수를 더하는 것으로 추가적인 부분은 예외처리 했습니다
         * 리턴 : defaultCount + extraTMNCount + extraTMXCount   (어제 2300 => 290개 리턴)
         */

        int numOfRows;
        int defaultCount = 12 * hoursCount;
        int extraTMXCount = 0;
        int extraTMNCount = 0;

        // ( BaseTime + hoursCount ) 가 매날 6시 , 15시 를 넘긴다면 extra 에 1씩 더해주었습니다
        if (baseTime.equals("0200"))
        {
            if (4 <= hoursCount) // 0200 + 4시간 => 오늘 0600
            {
                extraTMNCount++;
            }
            if (13 <= hoursCount) // 0200 + 13시간 => 오늘 1500
            {
                extraTMXCount++;
            }
            if (28 <= hoursCount) // 0200 + 28시간 => 내일 0600
            {
                extraTMNCount++;
            }
            if (37 <= hoursCount) // 0200 + 37시간 => 내일 1500
            {
                extraTMXCount++;
            }
            if (52 <= hoursCount) // 0200 + 52시간 => 모레 0600
            {
                extraTMNCount++;
            }
            if (61 <= hoursCount) // 0200 + 61시간 => 모레 1500
            {
                extraTMXCount++;
            }
            // 70개 맥스 (API가 보내주는 최대개수 (발표시간마다 다름))  =>  (모레 2400 까지)
        }
        else if (baseTime.equals("0500"))
        {
            if (10 <= hoursCount)
            {
                extraTMXCount++;
            }
            if (25 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (34 <= hoursCount)
            {
                extraTMXCount++;
            }
            if (49 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (58 <= hoursCount)
            {
                extraTMXCount++;
            }
            //67개 맥스 (모레 2400 까지)
        }
        else if (baseTime.equals("0800"))
        {
            if (7 <= hoursCount)
            {
                extraTMXCount++;
            }
            if (22 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (31 <= hoursCount)
            {
                extraTMXCount++;
            }
            if (46 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (55 <= hoursCount)
            {
                extraTMXCount++;
            }
            //64개 맥스 (모레 2400 까지)
        }
        else if (baseTime.equals("1100"))
        {
            if (4 <= hoursCount)
            {
                extraTMXCount++;
            }
            if (19 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (28 <= hoursCount)
            {
                extraTMXCount++;
            }
            if (43 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (52 <= hoursCount)
            {
                extraTMXCount++;
            }
            //61개 맥스 (모레 2400 까지)
        }
        else if (baseTime.equals("1400"))
        {
            if (16 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (25 <= hoursCount)
            {
                extraTMXCount++;
            }
            if (40 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (49 <= hoursCount)
            {
                extraTMXCount++;
            }
            //58개 맥스 (모레 2400 까지)
        }
        else if (baseTime.equals("1700"))
        {
            if (13 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (22 <= hoursCount)
            {
                extraTMXCount++;
            }
            if (37 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (46 <= hoursCount)
            {
                extraTMXCount++;
            }
            if (61 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (70 <= hoursCount)
            {
                extraTMXCount++;
            }
            // 79개 맥스 (글피 2400 까지)
        }
        else if (baseTime.equals("2000"))
        {
            if (10 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (19 <= hoursCount)
            {
                extraTMXCount++;
            }
            if (34 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (43 <= hoursCount)
            {
                extraTMXCount++;
            }
            if (58 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (67 <= hoursCount)
            {
                extraTMXCount++;
            }
            // 76개 맥스 (글피 2400 까지)
        }
        else if (baseTime.equals("2300"))
        {
            if (7 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (16 <= hoursCount)
            {
                extraTMXCount++;
            }
            if (31 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (40 <= hoursCount)
            {
                extraTMXCount++;
            }
            if (55 <= hoursCount)
            {
                extraTMNCount++;
            }
            if (64 <= hoursCount)
            {
                extraTMXCount++;
            }
            // 73개 맥스 (글피 2400 까지)
        }

        numOfRows = defaultCount + extraTMNCount + extraTMXCount;

        this.numOfRows = String.valueOf(numOfRows);
    }


    public void setNumOfRows(String numOfRows) {
        this.numOfRows = numOfRows;
    }


    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }
    

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }


    /**
     * 발표날짜 설정
     * <p> [주의] : "yyyyMMdd" 포맷으로 설정해야 합니다</p>
     * @param BaseDate (예시) "20230729"
     * 
     */
    public void setBaseDate(String baseDate) {
        this.baseDate = baseDate;
    }


    /**
     * 발표시간 설정
     * <p> [주의] : API에서 지정한 날씨데이터 발표시간으로 무조건 설정해야 합니다</p>
     *@param BaseTime (예시)
     * <p> "2300" , "0200" , "0500" , "0800" </p>
     * <p> "1100" , "1400" , "1700" , "2000" 중 하나 입력</p>
     */
    public void setBaseTime(String baseTime) {
        this.baseTime = baseTime;
    }

    public void setGridXY(GridXY gridXY) {
        this.gridXY = new GridXY(gridXY);
        this.nx = gridXY.getX();
        this.ny = gridXY.getY();
    }

    public void setXY(String x, String y) {
        this.gridXY = new GridXY(x, y);
        this.nx = x;
        this.ny = y;
    }

    
    public String getNumOfRows() {
        return numOfRows;
    }

    public String getPageNo() {
        return pageNo;
    }

    public String getDataType() {
        return dataType;
    }

    public String getBaseDate() {
        return baseDate;
    }

    public String getBaseTime() {
        return baseTime;
    }

    public GridXY getGridXY() {
        return gridXY;
    }

    public String getNx() {
        return nx;
    }

    public String getNy() {
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
