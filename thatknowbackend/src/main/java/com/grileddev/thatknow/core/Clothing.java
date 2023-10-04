package com.grileddev.thatknow.core;

public class Clothing {}


enum HatType {
    NONE("none",
                    "/image/hat/none.jpeg",
                    "없음"
                    ,false),
    CAP("cap",
                    "/image/hat/cap.jpeg",
                    "캡",
                    false),
    BEANIE("beanie",
                    "/image/hat/beanie.jpeg",
                    "비니",
                    false);

    private String name;
    private String url;
    private String message;
    private boolean isRecommended;

    private HatType(String name, String url, String message, boolean isRecommended){
        this.name = name;
        this.url = url;
        this.message = message;
        this.isRecommended = isRecommended;
    }

    public String getName(){
        return name;
    }

    public String getUrl(){
        return url;
    }

    public String getMessage(){
        return message;
    }

    public boolean getIsRecommended(){
        return isRecommended;
    }

    public void setIsRecommended(boolean isRecommended){
        this.isRecommended = isRecommended;
    }
}

enum InnerType {
    CROP_TOPS("cropTops",
                    "/image/inner/cropTops.jpeg",
                    "크롭탑",
                    false),
    SLEEVELESS("sleeveless",
                    "/image/inner/sleeveless.jpeg",
                    "민소매",
                    false),
    SHORT_SLEEVE("shortSleeve",
                    "/image/inner/shortSleeve.jpeg",
                    "반팔",
                    false),
    ONE_PIECE("onePiece",
                    "/image/inner/onePiece.jpeg",
                    "원피스",
                    false),
    LONG_SLEEVE("longSleeve",
                    "/image/inner/longSleeve.jpeg",
                    "긴팔",
                    false),
    SHIRT("shirt",
                    "/image/inner/shirt.jpeg",
                    "셔츠",
                    false),
    SWEATSHIRT("sweatShirt",
                    "/image/inner/sweatShirt.jpeg",
                    "맨투맨",
                    false),
    KNIT("knit",
                    "/image/inner/knit.jpeg",
                    "니트",
                    false);
    
    private String name;
    private String url;
    private String message;
    private boolean isRecommended;

    private InnerType(String name, String url, String message, boolean isRecommended){
        this.name = name;
        this.url = url;
        this.message = message;
        this.isRecommended = isRecommended;
    }

    
    public String getName(){
        return name;
    }

    public String getUrl(){
        return url;
    }

    public String getMessage(){
        return message;
    }

    public boolean getIsRecommended(){
        return isRecommended;
    }

    public void setIsRecommended(boolean isRecommended){
        this.isRecommended = isRecommended;
    }
}

enum BottomType {
    SHORTS("shorts",
                    "/image/bottom/shorts.jpeg",
                    "반바지",
                    false),

    SKIRT("skirt",
                    "/image/bottom/skirt.jpeg",
                    "치마",
                    false),

    COTTON_PANTS("cottonPants",
                    "/image/bottom/cottonPants.jpeg",
                    "면바지",
                    false),

    SLACKS("slacks",
                    "/image/bottom/slacks.jpeg",
                    "슬랙스",
                    false),

    JEANS("jeans",
                    "/image/bottom/jeans.jpeg",
                    "청바지",
                    false),

    THICK_COTTON_PANTS("thickCottonPants",
                    "/image/bottom/thickCottonPants.jpeg",
                    "두꺼운면바지",
                    false),
    
    THICK_JEANS("thickJeans",
                    "/image/bottom/thickJeans.jpeg",
                    "두꺼운청바지",
                    false);

    private String name;
    private String url;
    private String message;
    private boolean isRecommended;

    private BottomType(String name, String url, String message, boolean isRecommended) {
        this.name = name;
        this.url = url;
        this.message = message;
        this.isRecommended = isRecommended;
    }

    public String getName(){
        return name;
    }

    public String getUrl(){
        return url;
    }

    public String getMessage(){
        return message;
    }

    public boolean getIsRecommended(){
        return isRecommended;
    }

    public void setIsRecommended(boolean isRecommended){
        this.isRecommended = isRecommended;
    }

}



enum OuterType {
    NONE("none",
                    "/image/outer/none.jpeg",
                    "없음",
                    false),
    VEST("vest",
                    "/image/outer/vest.jpeg",
                    "조끼",
                    false),

    HOODZIPUP("hoodZipUp",
                    "/image/outer/hoodZipUp.jpeg",
                    "후드집업",
                    false),
 
    WINDBREAKER("windbreaker",
                    "/image/outer/windbreaker.jpeg",
                    "바람막이",
                    false),

    BLAZER("blazer",
                    "/image/outer/blazer.jpeg",
                    "블레이저",
                    false),

    DENIM_JACKET("denimJacket",
                    "/image/outer/denimJacket.jpeg",
                    "데님자켓",
                    false),

    CARDIGAN("cardigan",
                    "/image/outer/cardigan.jpeg",
                    "가디건",
                    false),

    LEATHER_JACKET("leatherJacket",
                    "/image/outer/leatherJacket.jpeg",
                    "레더자켓",
                    false),

    MA_1("ma-1",
                    "/image/outer/ma-1.jpeg",
                    "ma-1",
                    false),

    FLEECE("fleece",
                    "/image/outer/fleece.jpeg",
                    "플리스",
                    false),

    PADDED_VEST("paddedVest",
                    "/image/outer/paddedVest.jpeg",
                    "패딩조끼",
                    false),

    FIELD_JACKET("fieldJacket",
                    "/image/outer/fieldJacket.jpeg",
                    "필드자켓",
                    false),

    TRENCH_COAT("trenchCoat",
                    "/image/outer/trenchCoat.jpeg",
                    "트렌치코트",
                    false),

    COAT("coat",
                    "/image/outer/coat.jpeg",
                    "코트",
                    false),

    PADDED_COAT("paddedCoat",
                    "/image/outer/paddedCoat.jpeg",
                    "패딩코트",
                    false),

    LONG_PADDED_COAT("longPaddedCoat",
                    "/image/outer/longPaddedCoat.jpeg",
                    "롱패딩코트",
                    false);

    
    private String name;
    private String url;
    private String message;
    private boolean isRecommended;

    private OuterType(String name, String url, String message, boolean isRecommended){
        this.name = name;
        this.url = url;
        this.message = message;
        this.isRecommended = isRecommended;
    }

    public String getName(){
        return name;
    }

    public String getUrl(){
        return url;
    }

    public String getMessage(){
        return message;
    }

    public boolean getIsRecommended(){
        return isRecommended;
    }

    public void setIsRecommended(boolean isRecommended){
        this.isRecommended = isRecommended;
    }
} 


enum ShoesType {
    NONE("none",
                    "/image/shoes/none.jpeg",
                    "없음",
                    false),

    SLIPPERS("slippers",
                    "/image/shoes/slippers.jpeg",
                    "슬리퍼",
                    false),

    SANDAL("sandal",
                    "/image/shoes/sandal.jpeg",
                    "샌들",
                    false),

    FLAT_SHOES("flatShoes",
                    "/image/shoes/flatShoes.jpeg",
                    "플랫슈즈",
                    false),

    HELLS("hells",
                    "/image/shoes/hells.jpeg",
                    "힐",
                    false),

    RUNNING_SHOES("runningShoes",
                    "/image/shoes/runningShoes.jpeg",
                    "운동화",
                    false),

    SNEAKERS("sneakers",
                    "/image/shoes/sneakers.jpeg",
                    "스니커즈",
                    false),

    LOAFERS("loafers",
                    "/image/shoes/loafers.jpeg",
                    "로퍼",
                    false),

    CHELSEA_BOOTS("chelseaBoots",
                    "/image/shoes/chelseaBoots.jpeg",
                    "첼시부츠",
                    false),

    BOOTS("boots",
                    "/image/shoes/boots.jpeg",
                    "부츠",
                    false),
    
    RAIN_BOOTS("rainBoots",
                    "/image/shoes/rainBoots.jpeg",
                    "레인부츠",
                    false);

    private String name;
    private String url;
    private String message;
    private boolean isRecommended;

    private ShoesType(String name, String url, String message, boolean isRecommended){
        this.name = name;
        this.url = url;
        this.message = message;
        this.isRecommended = isRecommended;
    }

    public String getName(){
        return name;
    }

    public String getUrl(){
        return url;
    }

    public String getMessage(){
        return message;
    }

    public boolean getIsRecommended(){
        return isRecommended;
    }

    public void setIsRecommended(boolean isRecommended){
        this.isRecommended = isRecommended;
    }
}

enum ExtraType {
    NONE("none",
                    "/image/extra/none.jpeg",
                    "없음",
                    false),
    SUNGLASSES("sunglasses",
                    "/image/extra/sunglasses.jpeg",
                    "선글라스",
                    false),

    SUNCREAM("suncream",
                    "/image/extra/suncream.jpeg",
                    "선크림",
                    false),
 
    GLOVES_AND_MUFFLER("glovesAndMuffler",
                    "/image/extra/glovesAndMuffler.jpeg",
                    "장갑, 머플러",
                    false),

    UMBRELLA("umbrella",
                    "/image/extra/umbrella.jpeg",
                    "우산",
                    false),
    
    RAIN_COAT("rainCoat",
                    "/image/extra/rainCoat.jpeg",
                    "레인코트",
                    false);

    private String name;
    private String url;
    private String message;
    private boolean isRecommended;

    private ExtraType(String name, String url, String message, boolean isRecommended){
        this.name = name;
        this.url = url;
        this.message = message;
        this.isRecommended = isRecommended;
    }

    public String getName(){
        return name;
    }

    public String getUrl(){
        return url;
    }

    public String getMessage(){
        return message;
    }

    public boolean getIsRecommended(){
        return isRecommended;
    }

    public void setIsRecommended(boolean isRecommended){
        this.isRecommended = isRecommended;
    }
}

//cropTops

// 위에 적은 옷 종류 모두 기록 한글로
// hat
    // 캡
    // 비니
// inner
    // 여름옷 (민소매, 큷)
    // 반팔
    // 원피스
    // 긴팔
    // 셔츠
    // 맨투맨
    // 니트
// bottom
    // 반바지
    // 치마
    // 면바지
    // 슬랙스
    // 청바지
    // 두꺼운면바지
    // 두꺼운청바지
// outer
    // 조끼
    // 후드집업
    // 바람막이
    // 블레이저
    // 데님자켓
    // 가디건
    // 레더자켓
    // ma-1
    // 플리스
    // 패딩조끼
    // 필드자켓
    // 트렌치코트
    // 코트
    // 패딩코트
    // 롱패딩코트
// shoes
    // 슬리퍼
    // 샌들
    // 플랫슈즈
    // 힐
    // 운동화
    // 스니커즈
    // 로퍼
    // 첼시부츠
    // 부츠
    // 레인부츠
// extra
    // 선글라스
    // 선크림
    // 장갑
    // 머플러
    // 작은우산
    // 우산
    // 레인코트


// 영어버전

// outer
    // vest
    // hoodZipUp
    // windbreaker
    // blazer
    // denimJacket
    // cardigan
    // leatherJacket
    // ma-1
    // fleece
    // paddedVest
    // fieldJacket
    // trenchCoat
    // coat
    // paddedCoat
    // longPaddedCoat
// shoes
    // slippers
    // sandal
    // flatShoes
    // hells
    // runningShoes
    // sneakers
    // loafers
    // chelseaBoots
    // boots
    // rainBoots
// extra
    // sunglasses
    // suncream
    // gloves
    // muffler
    // smallUmbrella
    // umbrella
    // rainCoat

