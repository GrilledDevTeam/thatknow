package com.grileddev.thatknow.core;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class DressCodeSuggestion {

    private List<Item> hatList;
    private List<Item> innerList;   
    private List<Item> bottomList;
    private List<Item> outerList;
    private List<Item> shoesList;
    private List<Item> extraList;

}

@Data
@AllArgsConstructor
class Item {
    private int id;
    private String name;
    private String url;
    private String message;
    private boolean isRecommended;
}
