package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;
import com.codecool.wardrobe.clothing.Clothes.ClothesType;
import com.codecool.wardrobe.clothing.LowerClothes;
import com.codecool.wardrobe.clothing.UpperClothes;

import java.util.Optional;
import java.util.UUID;

public class PantHanger implements Hanger<Clothes> {

    private UpperClothes clothesUpperItem;
    private LowerClothes clothesLowerItem;


    @Override
    public Optional<Clothes> takeOff() {
        //to poniżej nie jest przetestowane
        Optional<Clothes> oneItem = clothesUpperItem != null ? Optional.of(clothesUpperItem) : Optional.ofNullable(clothesLowerItem);
        return  oneItem;
    }



    @Override
    public Optional<Clothes> takeOff(UUID id) {

        return null;
    }

    @Override
    public void put(Clothes item) {

    }

    @Override
    public boolean hasSlotFor(ClothesType type) {
        return false;
    }
}
