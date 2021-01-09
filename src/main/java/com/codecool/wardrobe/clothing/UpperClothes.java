package com.codecool.wardrobe.clothing;

public class UpperClothes extends Clothes {
    public UpperClothes(String brandName, ClothesType type) {

        super(brandName);
        if (checkType(type)){
            super.type = type;
        } else {
            throw new  IllegalArgumentException();
        }
    }




    private boolean checkType(ClothesType type){
        return type == ClothesType.SHIRT || type == ClothesType.BLOUSE;
    }
}
