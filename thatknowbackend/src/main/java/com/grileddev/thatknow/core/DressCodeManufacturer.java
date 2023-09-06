package com.grileddev.thatknow.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DressCodeManufacturer {
    
    // 생성자
    private static DressCodeManufacturer instance = new DressCodeManufacturer();
    private DressCodeManufacturer() {
    }
    public static DressCodeManufacturer getInstance() {
        return instance;
    }
     
    private static ClothingSetting clothingSetting;

    // 날씨 추천 (WeatherTypeSuggestion 반환)
    public WeatherTypeSuggestion getWeatherTypeSuggestion(RepresentationJudgementForType representationJudgementForType) {
        return createWeatherTypeSuggestion(representationJudgementForType);
    }

    // 옷 추천 (DressCodeSuggestion 반환)
    public DressCodeSuggestion getDressCodeSuggestion(RepresentationJudgementForDressCode representationJudjmentForDressCode) {
        clothingSetting = ClothingSetting.getInstance(representationJudjmentForDressCode.getATMPCelsiusForDressCode());
        return createDressCodeSuggestion(representationJudjmentForDressCode);
    }




    //--------------------------------------- private method --------------------------------------------


    // -------------------------------- 날씨상태 추천 설정 ------------------------------------------


    private static WeatherTypeSuggestion createWeatherTypeSuggestion(RepresentationJudgementForType representationJudgementForType) {
        WeatherTypeSuggestion weatherTypeSuggestion = new WeatherTypeSuggestion();

        weatherTypeSuggestion.setATMPCelsiusType(representationJudgementForType.getATMPCelsiusType().getString());
        weatherTypeSuggestion.setATMPCelsiusSDType(representationJudgementForType.getATMPCelsiusSDType().getString());
        weatherTypeSuggestion.setTHIType(representationJudgementForType.getTHIType().getString());
        weatherTypeSuggestion.setTHISDType(representationJudgementForType.getTHISDType().getString());
        weatherTypeSuggestion.setWSDType(representationJudgementForType.getWSDType().getString());
        weatherTypeSuggestion.setWSDSDMType(representationJudgementForType.getWSDSDType().getString());
        weatherTypeSuggestion.setPTYType(representationJudgementForType.getPTYType().getString());
        weatherTypeSuggestion.setPTYValidityType(representationJudgementForType.getPTYValidityType().getString());
        weatherTypeSuggestion.setPOPType(representationJudgementForType.getPOPType().getString());
        weatherTypeSuggestion.setPOPSDType(representationJudgementForType.getPOPSDType().getString());
        weatherTypeSuggestion.setSKYType(representationJudgementForType.getSKYType().getString());
        weatherTypeSuggestion.setSKYValidityType(representationJudgementForType.getSKYValidityType().getString());
        weatherTypeSuggestion.setPCPType(representationJudgementForType.getPCPType().getString());
        weatherTypeSuggestion.setPCPSDType(representationJudgementForType.getPCPSDType().getString());
        weatherTypeSuggestion.setSNOType(representationJudgementForType.getSNOType().getString());
        weatherTypeSuggestion.setSNOSDType(representationJudgementForType.getSNOSDType().getString());

        return weatherTypeSuggestion;
    }


    // -------------------------------- 옷 추천 설정 ------------------------------------------


    private static <T extends Enum<T>> void setEnumRecommended(T enumType) {
        switch (enumType.getDeclaringClass().getSimpleName())
        {
            case "HatType":
                HatType enumSpecifyType = (HatType) enumType;
                enumSpecifyType.setIsRecommended(true);
                break;
            case "InnerType":
                InnerType enumSpecifyType2 = (InnerType) enumType;
                enumSpecifyType2.setIsRecommended(true);
                break;
            case "BottomType":
                BottomType enumSpecifyType3 = (BottomType) enumType;
                enumSpecifyType3.setIsRecommended(true);
                break;
            case "OuterType":
                OuterType enumSpecifyType4 = (OuterType) enumType;
                enumSpecifyType4.setIsRecommended(true);
                break;
            case "ShoesType":
                ShoesType enumSpecifyType5 = (ShoesType) enumType;
                enumSpecifyType5.setIsRecommended(true);
                break;
            case "ExtraType":
                ExtraType enumSpecifyType6 = (ExtraType) enumType;
                enumSpecifyType6.setIsRecommended(true);
                break;
        }
    }

    private static <T extends Enum<T>> Object getEnumSettingRecommended(T enumType, Boolean isRecommended)
    {
        switch (enumType.getDeclaringClass().getSimpleName())
        {
            case "HatType":
                HatType enumSpecifyType = (HatType) enumType;
                enumSpecifyType.setIsRecommended(isRecommended);
                return enumSpecifyType;
            case "InnerType":
                InnerType enumSpecifyType2 = (InnerType) enumType;
                enumSpecifyType2.setIsRecommended(isRecommended);
                return enumSpecifyType2;
            case "BottomType":
                BottomType enumSpecifyType3 = (BottomType) enumType;
                enumSpecifyType3.setIsRecommended(isRecommended);
                return enumSpecifyType3;
            case "OuterType":
                OuterType enumSpecifyType4 = (OuterType) enumType;
                enumSpecifyType4.setIsRecommended(isRecommended);
                return enumSpecifyType4;
            case "ShoesType":
                ShoesType enumSpecifyType5 = (ShoesType) enumType;
                enumSpecifyType5.setIsRecommended(isRecommended);
                return enumSpecifyType5;
            case "ExtraType":
                ExtraType enumSpecifyType6 = (ExtraType) enumType;
                enumSpecifyType6.setIsRecommended(isRecommended);
                return enumSpecifyType6;
            default:
                return null;
        }
    }
    
    private HashMap<String, List<Object>> deepCopy(HashMap<String, List<Object>> clothingSetting) {

        HashMap<String, List<Object>> copy = new HashMap<String, List<Object>>();

        Set<String> keySet = clothingSetting.keySet();
        Iterator<String> iterator = keySet.iterator();

        while (iterator.hasNext())
        {
            String key = iterator.next();

            switch (key)
            {
                case "HAT":
                    List<Object> hatList = new ArrayList<Object>();

                    for (Object object : clothingSetting.get("HAT"))
                    {
                        HatType hatEnum = (HatType) object;
                        hatList.add(hatEnum);
                    }

                    copy.put(key, hatList);
                    break;
                case "INNER":
                    List<Object> innerList = new ArrayList<Object>();

                    for (Object object : clothingSetting.get("INNER"))
                    {
                        InnerType innerEnum = (InnerType) object;
                        innerList.add(innerEnum);
                    }

                    copy.put(key, innerList);
                    break;
                case "BOTTOM":
                    List<Object> bottomList = new ArrayList<Object>();

                    for (Object object : clothingSetting.get("BOTTOM"))
                    {
                        BottomType bottomEnum = (BottomType) object;
                        bottomList.add(bottomEnum);
                    }

                    copy.put(key, bottomList);
                    break;
                case "OUTER":
                    List<Object> outerList = new ArrayList<Object>();

                    for (Object object : clothingSetting.get("OUTER"))
                    {
                        OuterType outerEnum = (OuterType) object;
                        outerList.add(outerEnum);
                    }

                    copy.put(key, outerList);
                    break;
                case "SHOES":
                    List<Object> shoesList = new ArrayList<Object>();

                    for (Object object : clothingSetting.get("SHOES"))
                    {
                        ShoesType shoesEnum = (ShoesType) object;
                        shoesList.add(shoesEnum);
                    }

                    copy.put(key, shoesList);
                    break;
                case "EXTRA":
                    List<Object> extraList = new ArrayList<Object>();

                    for (Object object : clothingSetting.get("EXTRA"))
                    {
                        ExtraType extraEnum = (ExtraType) object;
                        extraList.add(extraEnum);
                    }

                    copy.put(key, extraList);
                    break;
            }
        }

        return copy;
    }


    private DressCodeSuggestion createDressCodeSuggestion(RepresentationJudgementForDressCode representationJudjmentForDressCode)
    {

        HashMap<String, List<Object>> suggestionTemp;
        //가독성 설정
        final ATMPCelsiusDressCodeType TEMPERATURE = representationJudjmentForDressCode.getATMPCelsiusDressCodeType();
        final WeatherStateDressCodeType WEATHER_STATE = representationJudjmentForDressCode.getWeatherStateDressCodeType();

        // case1 = 매우더움 옷 세팅
        // case2 = 더움 옷 세팅
        // case3 = 따뜻함 옷 세팅
        // case4 = 온화함 옷 세팅
        // case5 = 보통 옷 세팅
        // case6 = 쌀쌀함 옷 세팅
        // case7 = 춥음 옷 세팅
        // case8 = 매우춥음 옷 세팅
        switch (TEMPERATURE)
        {
            case VERY_HOT:
                switch (WEATHER_STATE)
                {
                    case SUNNY:
                        suggestionTemp = deepCopy(clothingSetting.getCase1());

                        setEnumRecommended(HatType.NONE);
                        suggestionTemp.get("HAT").add(getEnumSettingRecommended(HatType.CAP , false));

                        setEnumRecommended(InnerType.SHORT_SLEEVE);
                        setEnumRecommended(OuterType.NONE);
                        setEnumRecommended(BottomType.SHORTS);
                        setEnumRecommended(ShoesType.SLIPPERS);
                        
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.SUNCREAM, true));
                        break;
                    case RAINY:
                        suggestionTemp = deepCopy(clothingSetting.getCase1());

                        setEnumRecommended(HatType.NONE);
                        suggestionTemp.get("HAT").add(getEnumSettingRecommended(HatType.CAP , false));

                        setEnumRecommended(InnerType.SHORT_SLEEVE);
                        setEnumRecommended(OuterType.NONE);
                        setEnumRecommended(BottomType.SHORTS);
                        setEnumRecommended(ShoesType.SLIPPERS);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.SMALL_UMBRELLA, true));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.UMBRELLA , false));
                        suggestionTemp.get("SHOES").add(getEnumSettingRecommended(ShoesType.RAIN_BOOTS , false));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.RAIN_COAT , false));
                        break;
                    case VERY_RAINY:
                        suggestionTemp = deepCopy(clothingSetting.getCase1());

                        setEnumRecommended(HatType.NONE);
                        suggestionTemp.get("HAT").add(getEnumSettingRecommended(HatType.CAP , false));

                        setEnumRecommended(InnerType.SHORT_SLEEVE);
                        setEnumRecommended(OuterType.NONE);
                        setEnumRecommended(BottomType.SHORTS);
                        setEnumRecommended(ShoesType.SLIPPERS);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.UMBRELLA , true));
                        suggestionTemp.get("SHOES").add(getEnumSettingRecommended(ShoesType.RAIN_BOOTS , false));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.RAIN_COAT , false));
                        break;
                    default :
                        suggestionTemp = deepCopy(clothingSetting.getCase1());
                        break;
                }
                break;
            case HOT:
                switch (WEATHER_STATE)
                {
                    case SUNNY:
                        suggestionTemp = deepCopy(clothingSetting.getCase2());

                        setEnumRecommended(HatType.NONE);
                        suggestionTemp.get("HAT").add(getEnumSettingRecommended(HatType.CAP , false));

                        setEnumRecommended(InnerType.SHORT_SLEEVE);
                        setEnumRecommended(OuterType.NONE);
                        setEnumRecommended(BottomType.COTTON_PANTS);
                        setEnumRecommended(ShoesType.SANDAL);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.SUNCREAM, true));
                        break;
                    case RAINY:
                        suggestionTemp = deepCopy(clothingSetting.getCase2());

                        setEnumRecommended(HatType.NONE);
                        suggestionTemp.get("HAT").add(getEnumSettingRecommended(HatType.CAP , false));

                        setEnumRecommended(InnerType.SHORT_SLEEVE);
                        setEnumRecommended(OuterType.NONE);
                        setEnumRecommended(BottomType.COTTON_PANTS);
                        setEnumRecommended(ShoesType.SANDAL);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.SMALL_UMBRELLA, true));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.UMBRELLA , false));
                        suggestionTemp.get("SHOES").add(getEnumSettingRecommended(ShoesType.RAIN_BOOTS , false));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.RAIN_COAT , false));
                        break;
                    case VERY_RAINY:
                        suggestionTemp = deepCopy(clothingSetting.getCase2());

                        setEnumRecommended(HatType.NONE);
                        suggestionTemp.get("HAT").add(getEnumSettingRecommended(HatType.CAP , false));

                        setEnumRecommended(InnerType.SHORT_SLEEVE);
                        setEnumRecommended(OuterType.NONE);
                        setEnumRecommended(BottomType.COTTON_PANTS);
                        setEnumRecommended(ShoesType.SANDAL);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.UMBRELLA , true));
                        suggestionTemp.get("SHOES").add(getEnumSettingRecommended(ShoesType.RAIN_BOOTS , false));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.RAIN_COAT , false));
                        break;
                    default :
                        suggestionTemp = deepCopy(clothingSetting.getCase2());
                        break;
                }
                break;
            case WARM:
                switch (WEATHER_STATE)
                {
                    case SUNNY:
                        suggestionTemp = deepCopy(clothingSetting.getCase3());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.SHORT_SLEEVE);
                        setEnumRecommended(OuterType.NONE);
                        setEnumRecommended(BottomType.COTTON_PANTS);
                        setEnumRecommended(ShoesType.RUNNING_SHOES);
                        setEnumRecommended(ExtraType.NONE);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.SUNCREAM, false));
                        break;
                    case RAINY:
                        suggestionTemp = deepCopy(clothingSetting.getCase3());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.SHORT_SLEEVE);
                        setEnumRecommended(OuterType.NONE);
                        setEnumRecommended(BottomType.COTTON_PANTS);
                        setEnumRecommended(ShoesType.RUNNING_SHOES);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.SMALL_UMBRELLA, true));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.UMBRELLA , false));
                        suggestionTemp.get("SHOES").add(getEnumSettingRecommended(ShoesType.RAIN_BOOTS , false));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.RAIN_COAT , false));
                        break;
                    case VERY_RAINY:
                        suggestionTemp = deepCopy(clothingSetting.getCase3());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.SHORT_SLEEVE);
                        setEnumRecommended(OuterType.NONE);
                        setEnumRecommended(BottomType.COTTON_PANTS);
                        setEnumRecommended(ShoesType.RUNNING_SHOES);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.UMBRELLA , true));
                        suggestionTemp.get("SHOES").add(getEnumSettingRecommended(ShoesType.RAIN_BOOTS , false));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.RAIN_COAT , false));
                        break;
                    default :
                        suggestionTemp = deepCopy(clothingSetting.getCase3());
                        break;
                }
                break;
            case NORMAL_WARM:
                switch (WEATHER_STATE)
                {
                    case SUNNY:
                        suggestionTemp = deepCopy(clothingSetting.getCase4());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.LONG_SLEEVE);
                        setEnumRecommended(OuterType.NONE);
                        setEnumRecommended(BottomType.COTTON_PANTS);
                        setEnumRecommended(ShoesType.RUNNING_SHOES);

                        setEnumRecommended(ExtraType.NONE);
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.SUNCREAM, false));
                        break;
                    case RAINY:
                        suggestionTemp = deepCopy(clothingSetting.getCase4());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.LONG_SLEEVE);
                        setEnumRecommended(OuterType.NONE);
                        setEnumRecommended(BottomType.COTTON_PANTS);
                        setEnumRecommended(ShoesType.RUNNING_SHOES);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.SMALL_UMBRELLA, true));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.UMBRELLA , false));
                        suggestionTemp.get("SHOES").add(getEnumSettingRecommended(ShoesType.RAIN_BOOTS , false));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.RAIN_COAT , false));
                        break;
                    case VERY_RAINY:
                        suggestionTemp = deepCopy(clothingSetting.getCase4());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.LONG_SLEEVE);
                        setEnumRecommended(OuterType.NONE);
                        setEnumRecommended(BottomType.COTTON_PANTS);
                        setEnumRecommended(ShoesType.RUNNING_SHOES);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.UMBRELLA , true));
                        suggestionTemp.get("SHOES").add(getEnumSettingRecommended(ShoesType.RAIN_BOOTS , false));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.RAIN_COAT , false));
                        break;
                    default :
                        suggestionTemp = deepCopy(clothingSetting.getCase4());
                        break;
                }
                break;
            case NORMAL:
                switch (WEATHER_STATE)
                {
                    case SUNNY:
                        suggestionTemp = deepCopy(clothingSetting.getCase5());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.SWEATSHIRT);
                        setEnumRecommended(OuterType.NONE);
                        setEnumRecommended(BottomType.JEANS);
                        setEnumRecommended(ShoesType.RUNNING_SHOES);
                        setEnumRecommended(ExtraType.NONE);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.SUNCREAM, false));
                        break;
                    case RAINY:
                        suggestionTemp = deepCopy(clothingSetting.getCase5());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.SWEATSHIRT);
                        setEnumRecommended(OuterType.NONE);
                        setEnumRecommended(BottomType.JEANS);
                        setEnumRecommended(ShoesType.RUNNING_SHOES);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.SMALL_UMBRELLA, true));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.UMBRELLA , false));
                        suggestionTemp.get("SHOES").add(getEnumSettingRecommended(ShoesType.RAIN_BOOTS , false));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.RAIN_COAT , false));
                        break;
                    case VERY_RAINY:
                        suggestionTemp = deepCopy(clothingSetting.getCase5());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.SWEATSHIRT);
                        setEnumRecommended(OuterType.NONE);
                        setEnumRecommended(BottomType.JEANS);
                        setEnumRecommended(ShoesType.RUNNING_SHOES);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.UMBRELLA , true));
                        suggestionTemp.get("SHOES").add(getEnumSettingRecommended(ShoesType.RAIN_BOOTS , false));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.RAIN_COAT , false));
                        break;
                    default :
                        suggestionTemp = deepCopy(clothingSetting.getCase5());
                        break;
                }
                break;
            case COOL:
                switch (WEATHER_STATE)
                {
                    case SUNNY:
                        suggestionTemp = deepCopy(clothingSetting.getCase6());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.LONG_SLEEVE);
                        setEnumRecommended(OuterType.DENIM_JACKET);
                        setEnumRecommended(BottomType.JEANS);
                        setEnumRecommended(ShoesType.RUNNING_SHOES);

                        setEnumRecommended(ExtraType.NONE);
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.SUNCREAM, false));
                        break;
                    case RAINY:
                        suggestionTemp = deepCopy(clothingSetting.getCase6());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.LONG_SLEEVE);
                        setEnumRecommended(OuterType.DENIM_JACKET);
                        setEnumRecommended(BottomType.JEANS);
                        setEnumRecommended(ShoesType.RUNNING_SHOES);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.SMALL_UMBRELLA, true));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.UMBRELLA , false));
                        suggestionTemp.get("SHOES").add(getEnumSettingRecommended(ShoesType.RAIN_BOOTS , false));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.RAIN_COAT , false));
                        break;
                    case VERY_RAINY:
                        suggestionTemp = deepCopy(clothingSetting.getCase6());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.LONG_SLEEVE);
                        setEnumRecommended(OuterType.DENIM_JACKET);
                        setEnumRecommended(BottomType.JEANS);
                        setEnumRecommended(ShoesType.RUNNING_SHOES);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.UMBRELLA , true));
                        suggestionTemp.get("SHOES").add(getEnumSettingRecommended(ShoesType.RAIN_BOOTS , false));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.RAIN_COAT , false));
                        break;
                    default :
                        suggestionTemp = deepCopy(clothingSetting.getCase6());
                        break;
                }
                break;
            case COLD:
                switch (WEATHER_STATE)
                {
                    case SUNNY:
                        suggestionTemp = deepCopy(clothingSetting.getCase7());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.LONG_SLEEVE);
                        setEnumRecommended(OuterType.FLEECE);
                        setEnumRecommended(BottomType.THICK_JEANS);
                        setEnumRecommended(ShoesType.RUNNING_SHOES);

                        setEnumRecommended(ExtraType.NONE);
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.SUNCREAM, false));
                        break;
                    case RAINY:
                        suggestionTemp = deepCopy(clothingSetting.getCase7());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.LONG_SLEEVE);
                        setEnumRecommended(OuterType.FLEECE);
                        setEnumRecommended(BottomType.THICK_JEANS);
                        setEnumRecommended(ShoesType.RUNNING_SHOES);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.SMALL_UMBRELLA, true));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.UMBRELLA , false));
                        suggestionTemp.get("SHOES").add(getEnumSettingRecommended(ShoesType.RAIN_BOOTS , false));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.RAIN_COAT , false));
                        break;
                    case VERY_RAINY:
                        suggestionTemp = deepCopy(clothingSetting.getCase7());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.LONG_SLEEVE);
                        setEnumRecommended(OuterType.FLEECE);
                        setEnumRecommended(BottomType.THICK_JEANS);
                        setEnumRecommended(ShoesType.RUNNING_SHOES);
                        
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.UMBRELLA , true));
                        suggestionTemp.get("SHOES").add(getEnumSettingRecommended(ShoesType.RAIN_BOOTS , false));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.RAIN_COAT , false));
                        break;
                    default :
                        suggestionTemp = deepCopy(clothingSetting.getCase7());
                        break;
                }
                break;
            case VERY_COLD:
                switch (WEATHER_STATE)
                {
                    case SUNNY:
                        suggestionTemp = deepCopy(clothingSetting.getCase8());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.LONG_SLEEVE);
                        setEnumRecommended(OuterType.LONG_PADDED_COAT);
                        setEnumRecommended(BottomType.THICK_JEANS);
                        setEnumRecommended(ShoesType.BOOTS);

                        setEnumRecommended(ExtraType.NONE);
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.SUNCREAM, false));
                        break;
                    case RAINY:
                        suggestionTemp = deepCopy(clothingSetting.getCase8());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.LONG_SLEEVE);
                        setEnumRecommended(OuterType.LONG_PADDED_COAT);
                        setEnumRecommended(BottomType.THICK_JEANS);
                        setEnumRecommended(ShoesType.BOOTS);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.SMALL_UMBRELLA, true));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.UMBRELLA , false));
                        suggestionTemp.get("SHOES").add(getEnumSettingRecommended(ShoesType.RAIN_BOOTS , false));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.RAIN_COAT , false));
                        break;
                    case VERY_RAINY:
                        suggestionTemp = deepCopy(clothingSetting.getCase8());

                        setEnumRecommended(HatType.NONE);
                        setEnumRecommended(InnerType.LONG_SLEEVE);
                        setEnumRecommended(OuterType.LONG_PADDED_COAT);
                        setEnumRecommended(BottomType.THICK_JEANS);
                        setEnumRecommended(ShoesType.BOOTS);

                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.UMBRELLA , true));
                        suggestionTemp.get("SHOES").add(getEnumSettingRecommended(ShoesType.RAIN_BOOTS , false));
                        suggestionTemp.get("EXTRA").add(getEnumSettingRecommended(ExtraType.RAIN_COAT , false));
                        break;
                    default :
                        suggestionTemp = deepCopy(clothingSetting.getCase8());
                        break;
                }
                break;
            default:
                suggestionTemp = deepCopy(clothingSetting.getCase5());
                break;
        }

        DressCodeSuggestion dressCodeSuggestion = new DressCodeSuggestion();


        // Enum => Class(Item) 패키징

        Set<String> keySet = suggestionTemp.keySet();
        Iterator<String> iterator = keySet.iterator();

        while (iterator.hasNext())
        {
            switch (iterator.next())
            {
                case "HAT":
                    List<Object> hatEnumList = suggestionTemp.get("HAT");
                    List<Item> hatItemList = new ArrayList<Item>();

                    int hatId = 0;

                    for (Object hatEnum : hatEnumList)
                    {
                        HatType hatEnumSpecify = (HatType) hatEnum;
                        Item hatItem = new Item( ++hatId , hatEnumSpecify.getName() , hatEnumSpecify.getUrl() , hatEnumSpecify.getMessage() , hatEnumSpecify.getIsRecommended());
                        hatItemList.add(hatItem);
                    }

                    dressCodeSuggestion.setHatList(hatItemList);
                    break;
            
                case "INNER":
                    List<Object> innerEnumList = suggestionTemp.get("INNER");
                    List<Item> innerItemList = new ArrayList<Item>();

                    int innerId = 0;

                    for (Object innerEnum : innerEnumList)
                    {
                        InnerType innerEnumSpecify = (InnerType) innerEnum;
                        Item innerItem = new Item(++innerId , innerEnumSpecify.getName() , innerEnumSpecify.getUrl() , innerEnumSpecify.getMessage() , innerEnumSpecify.getIsRecommended());
                        innerItemList.add(innerItem);
                    }

                    dressCodeSuggestion.setInnerList(innerItemList);
                    break;
                
                case "BOTTOM":
                    List<Object> bottomEnumList = suggestionTemp.get("BOTTOM");
                    List<Item> bottomItemList = new ArrayList<Item>();

                    int bottomId = 0;

                    for (Object bottomEnum : bottomEnumList)
                    {
                        BottomType bottomEnumSpecify = (BottomType) bottomEnum;
                        Item bottomItem = new Item( ++bottomId , bottomEnumSpecify.getName() , bottomEnumSpecify.getUrl() , bottomEnumSpecify.getMessage() , bottomEnumSpecify.getIsRecommended());
                        bottomItemList.add(bottomItem);
                    }

                    dressCodeSuggestion.setBottomList(bottomItemList);
                    break;

                case "OUTER":
                    List<Object> outerEnumList = suggestionTemp.get("OUTER");
                    List<Item> outerItemList = new ArrayList<Item>();

                    int outerId = 0;

                    for (Object outerEnum : outerEnumList)
                    {
                        OuterType outerEnumSpecify = (OuterType) outerEnum;
                        Item outerItem = new Item( ++outerId, outerEnumSpecify.getName() , outerEnumSpecify.getUrl() , outerEnumSpecify.getMessage() , outerEnumSpecify.getIsRecommended());
                        outerItemList.add(outerItem);
                    }

                    dressCodeSuggestion.setOuterList(outerItemList);
                    break;

                case "SHOES":
                    List<Object> shoesEnumList = suggestionTemp.get("SHOES");
                    List<Item> shoesItemList = new ArrayList<Item>();

                    int shoesId = 0;

                    for (Object shoesEnum : shoesEnumList)
                    {
                        ShoesType shoesEnumSpecify = (ShoesType) shoesEnum;
                        Item shoesItem = new Item( ++shoesId, shoesEnumSpecify.getName() , shoesEnumSpecify.getUrl() , shoesEnumSpecify.getMessage() , shoesEnumSpecify.getIsRecommended());
                        shoesItemList.add(shoesItem);
                    }

                    dressCodeSuggestion.setShoesList(shoesItemList);
                    break;

                case "EXTRA":
                    List<Object> extraEnumList = suggestionTemp.get("EXTRA");
                    List<Item> extraItemList = new ArrayList<Item>();

                    int extraId = 0;

                    for (Object extraEnum : extraEnumList)
                    {
                        ExtraType extraEnumSpecify = (ExtraType) extraEnum;
                        Item extraItem = new Item( ++extraId , extraEnumSpecify.getName() , extraEnumSpecify.getUrl() , extraEnumSpecify.getMessage() , extraEnumSpecify.getIsRecommended());
                        extraItemList.add(extraItem);
                    }

                    dressCodeSuggestion.setExtraList(extraItemList);
                    break;
            }    
        }
        
        //점검
        /* System.out.println("------------------------------------------------");
        dressCodeSuggestion.getHatList().forEach((item) -> System.out.println(item.getName() + "  " + item.getUrl() + " " + item.getMassage() + item.isRecommended()));
        dressCodeSuggestion.getInnerList().forEach((item) -> System.out.println(item.getName() + "  " + item.getUrl() + " " + item.getMassage() + item.isRecommended()));
        dressCodeSuggestion.getBottomList().forEach((item) -> System.out.println(item.getName() + "  " + item.getUrl() + " " + item.getMassage() + item.isRecommended()));
        dressCodeSuggestion.getOuterList().forEach((item) -> System.out.println(item.getName() + "  " + item.getUrl() + " " + item.getMassage() + item.isRecommended()));
        dressCodeSuggestion.getShoesList().forEach((item) -> System.out.println(item.getName() + "  " + item.getUrl() + " " + item.getMassage() + item.isRecommended()));
        dressCodeSuggestion.getExtraList().forEach((item) -> System.out.println(item.getName() + "  " + item.getUrl() + " " + item.getMassage() + item.isRecommended()));
        System.out.println("------------------------------------------------"); */

        return dressCodeSuggestion;
    }
}