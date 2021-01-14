package com.codecool.wardrobe.clothing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LowerClothes extends Clothes {

    public static List<ClothesType> LowerTypes = Arrays.asList(ClothesType.TROUSERS, ClothesType.SKIRT);



    public LowerClothes(String brandName, ClothesType type) {

        super(brandName);
        try {
            super.type = assignType(type);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }




    private boolean checkType(ClothesType type){
        return type == ClothesType.TROUSERS || type == ClothesType.SKIRT;
    }

    private ClothesType assignType(ClothesType type){
        if (checkType(type)){
            return type;
        } else {
            throw new  IllegalArgumentException();
        }
    }
}
