package com.grileddev.thatknow.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.Data;

@Data
public class ClothingSetting {

    // 생성자
    private static ClothingSetting instance = new ClothingSetting();
    private ClothingSetting() {
    }
    public static ClothingSetting getInstance(double ATMPCelsius) {
        return instance;
    }

    private HashMap<String , List<Object>> case1 = new HashMap<String , List<Object>>(){
        {
            put("HAT" , createHatList(                
                HatType.NONE
                ));
            put("INNER" , createInnerList(
                InnerType.CROP_TOPS,
                InnerType.SLEEVELESS,
                InnerType.SHORT_SLEEVE,
                InnerType.ONE_PIECE
                ));
            put("BOTTOM" , createBottomList(
                BottomType.SHORTS,
                BottomType.SKIRT,
                BottomType.COTTON_PANTS,
                BottomType.SLACKS,
                BottomType.JEANS
                ));
            put("OUTER" , createOuterList(
                OuterType.NONE
                ));
            put("SHOES" , createShoesList(
                ShoesType.NONE,
                ShoesType.SLIPPERS,
                ShoesType.SANDAL,
                ShoesType.FLAT_SHOES,
                ShoesType.HELLS,
                ShoesType.RUNNING_SHOES
                ));
            put("EXTRA" , createExtraList(
                ExtraType.NONE
                ));
        }
    };

    private HashMap<String , List<Object>> case2 = new HashMap<String , List<Object>>(){
        {
            put("HAT" , createHatList(                
                HatType.NONE
                ));
            put("INNER" , createInnerList(
                InnerType.CROP_TOPS,
                InnerType.SLEEVELESS,
                InnerType.SHORT_SLEEVE,
                InnerType.ONE_PIECE,
                InnerType.LONG_SLEEVE,
                InnerType.SHIRT
                ));
            put("BOTTOM" , createBottomList(
                BottomType.SHORTS,
                BottomType.SKIRT,
                BottomType.COTTON_PANTS,
                BottomType.SLACKS,
                BottomType.JEANS
                ));
            put("OUTER" , createOuterList(
                OuterType.NONE
            ));
            put("SHOES" , createShoesList(
                ShoesType.NONE,
                ShoesType.SLIPPERS,
                ShoesType.SANDAL,
                ShoesType.FLAT_SHOES,
                ShoesType.HELLS,
                ShoesType.RUNNING_SHOES,
                ShoesType.SNEAKERS,
                ShoesType.LOAFERS
                ));
            put("EXTRA" , createExtraList(
                ExtraType.NONE
                ));
        }
    };

    private HashMap<String , List<Object>> case3 = new HashMap<String , List<Object>>(){
        {
            put("HAT" , createHatList(
                HatType.NONE
                ));
            put("INNER" , createInnerList(
                InnerType.SHORT_SLEEVE,
                InnerType.ONE_PIECE,
                InnerType.LONG_SLEEVE,
                InnerType.SHIRT,
                InnerType.SWEATSHIRT,
                InnerType.KNIT
                ));
            put("BOTTOM" , createBottomList(
                BottomType.COTTON_PANTS,
                BottomType.SLACKS,
                BottomType.JEANS
                ));
            put("OUTER" , createOuterList(
                OuterType.NONE,
                OuterType.VEST
                ));
            put("SHOES" , createShoesList(
                ShoesType.NONE,
                ShoesType.FLAT_SHOES,
                ShoesType.HELLS,
                ShoesType.RUNNING_SHOES,
                ShoesType.SNEAKERS,
                ShoesType.LOAFERS
                ));
            put("EXTRA" , createExtraList(
                ExtraType.NONE
                ));
        }
    };

    private HashMap<String , List<Object>> case4 = new HashMap<String , List<Object>>(){
        {
            put("HAT" , createHatList(
                HatType.NONE
                ));
            put("INNER" , createInnerList(
                InnerType.LONG_SLEEVE,
                InnerType.SHIRT,
                InnerType.SWEATSHIRT,
                InnerType.KNIT
                ));
            put("BOTTOM" , createBottomList(
                BottomType.COTTON_PANTS,
                BottomType.SLACKS,
                BottomType.JEANS
                ));
            put("OUTER" , createOuterList(
                OuterType.NONE,
                OuterType.VEST,
                OuterType.HOODZIPUP,
                OuterType.WINDBREAKER,
                OuterType.BLAZER,
                OuterType.DENIM_JACKET,
                OuterType.CARDIGAN
                ));
            put("SHOES" , createShoesList(
                ShoesType.NONE,
                ShoesType.FLAT_SHOES,
                ShoesType.HELLS,
                ShoesType.RUNNING_SHOES,
                ShoesType.SNEAKERS,
                ShoesType.LOAFERS
                ));
            put("EXTRA" , createExtraList(
                ExtraType.NONE
                ));
        }
    };

    private HashMap<String , List<Object>> case5 = new HashMap<String , List<Object>>(){
        {
            put("HAT" , createHatList(
                HatType.NONE
                ));
            put("INNER" , createInnerList(
                InnerType.LONG_SLEEVE,
                InnerType.SHIRT,
                InnerType.SWEATSHIRT,
                InnerType.KNIT
                ));
            put("BOTTOM" , createBottomList(
                BottomType.COTTON_PANTS,
                BottomType.SLACKS,
                BottomType.JEANS
                ));
            put("OUTER" , createOuterList(
                OuterType.NONE,
                OuterType.VEST,
                OuterType.HOODZIPUP,
                OuterType.WINDBREAKER,
                OuterType.BLAZER,
                OuterType.DENIM_JACKET,
                OuterType.CARDIGAN,
                OuterType.LEATHER_JACKET,
                OuterType.MA_1,
                OuterType.FLEECE,
                OuterType.PADDED_VEST
                ));
            put("SHOES" , createShoesList(
                ShoesType.NONE,
                ShoesType.FLAT_SHOES,
                ShoesType.HELLS,
                ShoesType.RUNNING_SHOES,
                ShoesType.SNEAKERS,
                ShoesType.LOAFERS
                ));
            put("EXTRA" , createExtraList(
                ExtraType.NONE
                ));
        }
    };

    private HashMap<String , List<Object>> case6 = new HashMap<String , List<Object>>(){
        {
            put("HAT" , createHatList(
                HatType.NONE
                ));
            put("INNER" , createInnerList(
                InnerType.LONG_SLEEVE,
                InnerType.SHIRT,
                InnerType.SWEATSHIRT,
                InnerType.KNIT
                ));
            put("BOTTOM" , createBottomList(
                BottomType.COTTON_PANTS,
                BottomType.SLACKS,
                BottomType.JEANS
                ));
            put("OUTER" , createOuterList(
                OuterType.NONE,
                OuterType.BLAZER,
                OuterType.DENIM_JACKET,
                OuterType.CARDIGAN,
                OuterType.LEATHER_JACKET,
                OuterType.MA_1,
                OuterType.FLEECE,
                OuterType.PADDED_VEST,
                OuterType.FIELD_JACKET,
                OuterType.TRENCH_COAT
                ));
            put("SHOES" , createShoesList(
                ShoesType.NONE,
                ShoesType.RUNNING_SHOES,
                ShoesType.SNEAKERS,
                ShoesType.LOAFERS,
                ShoesType.CHELSEA_BOOTS,
                ShoesType.BOOTS
                ));
            put("EXTRA" , createExtraList(
                ExtraType.NONE
                ));
        }
    };

    private HashMap<String , List<Object>> case7 = new HashMap<String , List<Object>>(){
        {
            put("HAT" , createHatList(
                HatType.NONE
                ));            
            put("INNER" , createInnerList(
                InnerType.LONG_SLEEVE,
                InnerType.SHIRT,
                InnerType.SWEATSHIRT,
                InnerType.KNIT
                ));
            put("BOTTOM" , createBottomList(
                BottomType.COTTON_PANTS,
                BottomType.SLACKS,
                BottomType.JEANS,
                BottomType.THICK_COTTON_PANTS,
                BottomType.THICK_JEANS
                ));
            put("OUTER" , createOuterList(
                OuterType.NONE,
                OuterType.LEATHER_JACKET,
                OuterType.MA_1,
                OuterType.FLEECE,
                OuterType.PADDED_VEST,
                OuterType.FIELD_JACKET,
                OuterType.TRENCH_COAT,
                OuterType.COAT
                ));
            put("SHOES" , createShoesList(
                ShoesType.NONE,
                ShoesType.RUNNING_SHOES,
                ShoesType.SNEAKERS,
                ShoesType.LOAFERS,
                ShoesType.CHELSEA_BOOTS,
                ShoesType.BOOTS
                ));
            put("EXTRA" , createExtraList(
                ExtraType.NONE,
                ExtraType.GLOVES_AND_MUFFLER
                ));
        }
    };

    private HashMap<String , List<Object>> case8 = new HashMap<String , List<Object>>(){
        {
            put("HAT" , createHatList(
                HatType.NONE
                ));            
            put("INNER" , createInnerList(
                InnerType.LONG_SLEEVE,
                InnerType.SHIRT,
                InnerType.SWEATSHIRT,
                InnerType.KNIT
                ));
            put("BOTTOM" , createBottomList(
                BottomType.COTTON_PANTS,
                BottomType.SLACKS,
                BottomType.JEANS
                ));
            put("OUTER" , createOuterList(
                OuterType.NONE,
                OuterType.LEATHER_JACKET,
                OuterType.MA_1,
                OuterType.FLEECE,
                OuterType.PADDED_VEST,
                OuterType.FIELD_JACKET,
                OuterType.TRENCH_COAT,
                OuterType.COAT,
                OuterType.PADDED_COAT,
                OuterType.LONG_PADDED_COAT
                ));
            put("SHOES" , createShoesList(
                ShoesType.NONE,
                ShoesType.RUNNING_SHOES,
                ShoesType.SNEAKERS,
                ShoesType.LOAFERS,
                ShoesType.CHELSEA_BOOTS,
                ShoesType.BOOTS
                ));
            put("EXTRA" , createExtraList(
                ExtraType.NONE,
                ExtraType.GLOVES_AND_MUFFLER
                ));
        }
    };



    // ---------------- private method --------------------------------

    private static List<Object> createHatList(HatType...hatTypes) {
        List<Object> hatList = new ArrayList<Object>();

        for (HatType hatType : hatTypes) {
            hatList.add(hatType);
        }

        return hatList;
    }

    private static List<Object> createInnerList(InnerType...innerTypes) {
        List<Object> innerList = new ArrayList<Object>();

        for (InnerType innerType : innerTypes) {
            innerList.add(innerType);
        }

        return innerList;
    }

    private static List<Object> createBottomList(BottomType...bottomTypes) {
        List<Object> bottomList = new ArrayList<Object>();

        for (BottomType bottomType : bottomTypes) {
            bottomList.add(bottomType);
        }

        return bottomList;
    }

    private static List<Object> createOuterList(OuterType...outerTypes) {
        List<Object> outerList = new ArrayList<Object>();

        for (OuterType outerType : outerTypes) {
            outerList.add(outerType);
        }

        return outerList;
    }

    private static List<Object> createShoesList(ShoesType...shoesTypes) {
        List<Object> shoesList = new ArrayList<Object>();

        for (ShoesType shoesType : shoesTypes) {
            shoesList.add(shoesType);
        }

        return shoesList;
    }

    private static List<Object> createExtraList(ExtraType...extraTypes) {
        List<Object> extraList = new ArrayList<Object>();

        for (ExtraType extraType : extraTypes) {
            extraList.add(extraType);
        }

        return extraList;
    }
}
