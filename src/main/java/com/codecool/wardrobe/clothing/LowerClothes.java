package com.codecool.wardrobe.clothing;

public class LowerClothes extends Clothes {


    public LowerClothes(String brandName, ClothesType type) {

        super(brandName);
        super.type = type;
        if (checkType(type)){
            super.type = type;
        } else {
            throw new  IllegalArgumentException();
        }
    }




    private boolean checkType(ClothesType type){
        return type == ClothesType.TROUSERS || type == ClothesType.SKIRT;
    }


}
