package com.grileddev.thatknow.core;

public class Clothing {}


enum HatType {
    NONE("none",
                    "/image/hat/none.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        }
                    },
    CAP("cap",
                    "/image/hat/cap.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if(ATMPForDressCode >= 28)
                            {
                                setMessage("분기 1");
                            }
                            else if(ATMPForDressCode >= 20)
                            {
                                setMessage("분기 2");
                            }
                            else if(ATMPForDressCode >= 10)
                            {
                                setMessage("분기 3");
                            }
                            else
                            {
                                setMessage("분기 4");
                            }
                        }
                    },
    
    BEANIE("beanie",
                    "/image/hat/beanie.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        }
                    };

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

    public abstract void setMessage(double ATMPForDressCode);

    public void setMessage(String message){
        this.message = message;
    }

    public void setIsRecommended(boolean isRecommended){
        this.isRecommended = isRecommended;
    }
}

enum InnerType {
    NONE("none",
                    "/image/inner/none.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        }
                    },
    CROP_TOPS("cropTops",
                    "/image/inner/cropTops.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    },

    SLEEVELESS("sleeveless",
                    "/image/inner/sleeveless.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    },

    SHORT_SLEEVE("shortSleeve",
                    "/image/inner/shortSleeve.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if (ATMPForDressCode >= 28)
                            {
                                setMessage("분기 1");
                            }
                            else if(ATMPForDressCode >= 20)
                            {
                                setMessage("분기 2");
                            }
                            else
                            {
                                setMessage("분기 3");
                            }
                        }
                    },
    ONE_PIECE("onePiece",
                    "/image/inner/onePiece.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if (ATMPForDressCode >= 28)
                            {
                                setMessage("분기 1");
                            }
                            else if(ATMPForDressCode >= 20)
                            {
                                setMessage("분기 2");
                            }
                            else
                            {
                                setMessage("분기 3");
                            }
                        }
                    },

    LONG_SLEEVE("longSleeve",
                    "/image/inner/longSleeve.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if (ATMPForDressCode >= 28)
                            {
                                setMessage("분기 1");
                            }
                            else if(ATMPForDressCode >= 20)
                            {
                                setMessage("분기 2");
                            }
                            else
                            {
                                setMessage("분기 3");
                            }
                        }
                    },
    
    SHIRT("shirt",
                    "/image/inner/shirt.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if (ATMPForDressCode >= 28)
                            {
                                setMessage("분기 1");
                            }
                            else if(ATMPForDressCode >= 20)
                            {
                                setMessage("분기 2");
                            }
                            else
                            {
                                setMessage("분기 3");
                            }
                        }
                    },
    
    SWEATSHIRT("sweatshirt",
                    "/image/inner/sweatshirt.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if (ATMPForDressCode >= 28)
                            {
                                setMessage("분기 1");
                            }
                            else if(ATMPForDressCode >= 20)
                            {
                                setMessage("분기 2");
                            }
                            else
                            {
                                setMessage("분기 3");
                            }
                        }
                    },
    
    KNIT("knit",
                    "/image/inner/knit.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if (ATMPForDressCode >= 28)
                            {
                                setMessage("분기 1");
                            }
                            else if(ATMPForDressCode >= 20)
                            {
                                setMessage("분기 2");
                            }
                            else
                            {
                                setMessage("분기 3");
                            }
                        }
                    };

    
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

    public abstract void setMessage(double ATMPForDressCode);

    public void setMessage(String message){
        this.message = message;
    }

    public void setIsRecommended(boolean isRecommended){
        this.isRecommended = isRecommended;
    }
}

enum BottomType {
    NONE("none",
                    "/image/bottom/none.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        }
                    },
    SHORTS("shorts",
                    "/image/bottom/shorts.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if (ATMPForDressCode >= 28)
                            {
                                setMessage("분기 1");
                            }
                            else if(ATMPForDressCode >= 20)
                            {
                                setMessage("분기 2");
                            }
                            else
                            {
                                setMessage("분기 3");
                            }
                        } 
                    },
    SKIRT("skirt",
                    "/image/bottom/skirt.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                                setMessage("분기 1");
                        } 
                    },
    COTTON_PANTS("cottonPants",
                    "/image/bottom/cottonPants.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if (ATMPForDressCode >= 20)
                            {
                                setMessage("분기 1");
                            }
                            else if(ATMPForDressCode >= 10)
                            {
                                setMessage("분기 2");
                            }
                            else
                            {
                                setMessage("분기 3");
                            }
                        } 
                    },
    SLACKS("slacks",
                    "/image/bottom/slacks.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if (ATMPForDressCode >= 20)
                            {
                                setMessage("분기 1");
                            }
                            else if(ATMPForDressCode >= 10)
                            {
                                setMessage("분기 2");
                            }
                            else
                            {
                                setMessage("분기 3");
                            }
                        } 
                    },
    JEANS("jeans",
                    "/image/bottom/jeans.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if (ATMPForDressCode >= 20)
                            {
                                setMessage("분기 1");
                            }
                            else if(ATMPForDressCode >= 10)
                            {
                                setMessage("분기 2");
                            }
                            else
                            {
                                setMessage("분기 3");
                            }
                        } 
                    },

    THICK_COTTON_PANTS("thickCottonPants",
                    "/image/bottom/thickCottonPants.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    },
    
    THICK_JEANS("thickJeans",
                    "/image/bottom/thickJeans.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    };
 
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

    public abstract void setMessage(double ATMPForDressCode);

    public void setMessage(String message){
        this.message = message;
    }

    public void setIsRecommended(boolean isRecommended){
        this.isRecommended = isRecommended;
    }

}



enum OuterType {
    NONE("none",
                    "/image/outer/none.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        }
                    },
    VEST("vest",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    },
    HOODZIPUP("hoodZipUp",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    },
    WINDBREAKER("windbreaker",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    },
    BLAZER("blazer",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if(ATMPForDressCode >= 20)
                            {
                                setMessage("분기 1");
                            }
                            else
                            {
                                setMessage("분기 2");
                            }
                        } 
                    },
    DENIM_JACKET("denimJacket",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if(ATMPForDressCode >= 20)
                            {
                                setMessage("분기 1");
                            }
                            else
                            {
                                setMessage("분기 2");
                            }
                        } 
                    },
    CARDIGAN("cardigan",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if(ATMPForDressCode >= 20)
                            {
                                setMessage("분기 1");
                            }
                            else
                            {
                                setMessage("분기 2");
                            }
                        } 
                    },
    LEATHER_JACKET("leatherJacket",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    },
    MA_1("ma-1",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    },
    FLEECE("fleece",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    },
    PADDED_VEST("paddedVest",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    },
    FIELD_JACKET("fieldJacket",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    },
    TRENCH_COAT("trenchCoat",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if(ATMPForDressCode >= 20)
                            {
                                setMessage("분기 1");
                            }
                            else
                            {
                                setMessage("분기 2");
                            }
                        } 
                    },
    COAT("coat",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if(ATMPForDressCode >= 20)
                            {
                                setMessage("분기 1");
                            }
                            else
                            {
                                setMessage("분기 2");
                            }
                        } 
                    },
    PADDED_COAT("paddedCoat",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    },
    LONG_PADDED_COAT("longPaddedCoat",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    };
    
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

    public abstract void setMessage(double ATMPForDressCode);

    public void setMessage(String message){
        this.message = message;
    }

    public void setIsRecommended(boolean isRecommended){
        this.isRecommended = isRecommended;
    }
} 


enum ShoesType {
    NONE("none",
                    "/image/shoes/none.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        }
                    },
    SLIPPERS("slippers",
                    "/image/shoes/shoes.png",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    },

    SANDAL("sandal",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if(ATMPForDressCode >= 20)
                            {
                                setMessage("분기 1");
                            }
                            else
                            {
                                setMessage("분기 2");
                            }
                        } 
                    },

    FLAT_SHOES("flatShoes",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    },

    HELLS("hells",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    },

    RUNNING_SHOES("runningShoes",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if(ATMPForDressCode >= 20)
                            {
                                setMessage("분기 1");
                            }
                            else if(ATMPForDressCode >= 10)
                            {
                                setMessage("분기 2");
                            }
                            else
                            {
                                setMessage("분기 3");
                            }
                        } 
                    },

    SNEAKERS("sneakers",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if(ATMPForDressCode >= 20)
                            {
                                setMessage("분기 1");
                            }
                            else if(ATMPForDressCode >= 10)
                            {
                                setMessage("분기 2");
                            }
                            else
                            {
                                setMessage("분기 3");
                            }
                        } 
                    },

    LOAFERS("loafers",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        } 
                    },

    CHELSEA_BOOTS("chelseaBoots",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        }
                    },

    BOOTS("boots",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        }
                    },
    
    RAIN_BOOTS("rainBoots",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        }
                    };


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

    public abstract void setMessage(double ATMPForDressCode);

    public void setMessage(String message){
        this.message = message;
    }

    public void setIsRecommended(boolean isRecommended){
        this.isRecommended = isRecommended;
    }
}

enum ExtraType {
    NONE("none",
                    "/image/extra/none.jpeg",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        }
                    },
    SUNGLASSES("sunglasses",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        }
                    },
                
    SUNCREAM("suncream",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        }
                    },
    
    GLOVES("gloves",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        }
                    },
    
    MUFFLER("muffler",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if(ATMPForDressCode <= 10)
                            {
                                setMessage("분기 1");
                            }
                            else
                            {
                                setMessage("분기 2");
                            }
                        }
                    },
    
    SMALL_UMBRELLA("smallUmbrella",
                    "/image/extra/extra.png",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        }
                    },

    UMBRELLA("umbrella",

                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            setMessage("분기 1");
                        }
                    },
    
    RAIN_COAT("rainCoat",
                    "url",
                    "message",
                    false) {
                        @Override
                        public void setMessage(double ATMPForDressCode)
                        {
                            if(ATMPForDressCode <= 10)
                            {
                                setMessage("분기 1");
                            }
                            else
                            {
                                setMessage("분기 2");
                            }
                        }
                    };

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

    public abstract void setMessage(double ATMPForDressCode);

    public void setMessage(String message){
        this.message = message;
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

