package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;
import com.codecool.wardrobe.clothing.UpperClothes;

import java.util.Optional;
import java.util.UUID;

public class ShirtHanger implements Hanger<UpperClothes> {

    private UpperClothes clothesItem;

    @Override
    public Optional<UpperClothes> takeOff() {
        System.out.println((Optional.ofNullable(clothesItem)).toString());
        clothesItem = null;
        return Optional.ofNullable(clothesItem);
    }

    @Override
    public Optional<UpperClothes> takeOff(UUID id) {
        if (clothesItem.getId().equals(id)){
//            System.out.println(id.toString());
//            System.out.println((Optional.ofNullable(clothesItem)).toString());
            clothesItem = null;
            return Optional.ofNullable(clothesItem);
        }
        return null;
    }

    @Override
    public void put(UpperClothes item) {
        if (hasSlotFor(item.getType())){
            this.clothesItem = item;
        }
    }

    @Override
    public boolean hasSlotFor(Clothes.ClothesType type) {
        if (clothesItem == null){
            return true;
        }
        return false;
    }
}
