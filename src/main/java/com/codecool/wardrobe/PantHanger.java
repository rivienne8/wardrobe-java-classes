package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;
import com.codecool.wardrobe.clothing.Clothes.ClothesType;
import com.codecool.wardrobe.clothing.LowerClothes;
import com.codecool.wardrobe.clothing.UpperClothes;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PantHanger implements Hanger<Clothes> {

    private Optional<Clothes> clothesUpperItem;
    private Optional<Clothes> clothesLowerItem;

    public PantHanger(){
        this.clothesUpperItem = Optional.empty();
        this.clothesLowerItem = Optional.empty();
    }



    @Override
    public Optional<Clothes> takeOff() {
        //to poniżej nie jest przetestowane
//        Optional<Clothes> oneItem = clothesUpperItem != null ? Optional.of(clothesUpperItem) : Optional.ofNullable(clothesLowerItem);
        Optional<Clothes> returnedItem = Optional.empty();
        if (clothesUpperItem.isPresent()){
            System.out.println("take Off na wieszkau (upper): " + clothesUpperItem);
            returnedItem = clothesUpperItem;
            clothesUpperItem = Optional.empty();
            System.out.println("take Off returnedItem (upper): " + returnedItem);
        } else if (clothesLowerItem.isPresent()){
            returnedItem = clothesLowerItem;
            clothesLowerItem = Optional.empty();
        }
        return  returnedItem;
    }



    @Override
    public Optional<Clothes> takeOff(UUID id) {
        Optional<Clothes> returnedItem = Optional.empty();
        if (clothesUpperItem.isPresent()){
            if (id.equals(clothesUpperItem.get().getId())){
                returnedItem = clothesUpperItem;
                clothesUpperItem = Optional.empty();
            }
        } else if (clothesLowerItem.isPresent()){
            if (id.equals(clothesLowerItem.get().getId())){
                returnedItem = clothesLowerItem;
                clothesUpperItem = Optional.empty();
            }
        }
        return returnedItem;
    }

    @Override
    public void put(Clothes item) {
        System.out.println("Na Lower wieszkau: " + clothesLowerItem.toString() + " " + clothesUpperItem.toString());
        ClothesType itemType = item.getType();
        if (hasSlotFor(itemType)) {
            if (LowerClothes.LowerTypes.contains(itemType)){
                clothesLowerItem = Optional.ofNullable((Clothes) item);

            } else {
                clothesUpperItem = Optional.ofNullable((Clothes) item);
            }
        } else {
            throw new IllegalStateException("there is no slot for this kind of clothes");
        }

    }

    @Override
    public boolean hasSlotFor(ClothesType type) {
        if (clothesUpperItem.isEmpty() && UpperClothes.UpperTypes.contains(type)){
            return true;
        } else if (clothesLowerItem.isEmpty() && LowerClothes.LowerTypes.contains(type)){
            return true;
        } else {
            return false;
        }

    }
}
