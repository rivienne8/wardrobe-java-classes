package com.codecool.wardrobe.clothing;


import java.util.Arrays;
import java.util.List;

public class UpperClothes extends Clothes {

    public static List<ClothesType> UpperTypes = Arrays.asList(ClothesType.BLOUSE, ClothesType.SHIRT);

    public UpperClothes(String brandName, ClothesType type) {

        super(brandName);
        try {
            super.type = assignType(type);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

//        super.type = assignType(type);
//        if (checkType(type)){
//            super.type = type;
//        } else {
//            throw new  IllegalArgumentException();
//        }
    }




    private boolean checkType(ClothesType type){
        return type == ClothesType.SHIRT || type == ClothesType.BLOUSE;
    }

    private ClothesType assignType(ClothesType type){
        if (checkType(type)){
            return type;
        } else {
            throw new  IllegalArgumentException();
        }
    }

}
