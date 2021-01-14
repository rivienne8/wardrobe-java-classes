package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;
import com.codecool.wardrobe.clothing.UpperClothes;

import java.util.Optional;
import java.util.UUID;

public class ShirtHanger implements Hanger<UpperClothes> {

    private Optional<UpperClothes> clothesItem = Optional.empty();

    @Override
    public Optional<UpperClothes> takeOff() {
//        System.out.println((clothesItem.toString()));
//        if (clothesItem.isPresent()){
//            Optional<UpperClothes> returnedItem = clothesItem;
//            clothesItem = Optional.empty();
//        }
        Optional<UpperClothes> returnedItem = clothesItem;
        clothesItem = Optional.empty();
        System.out.println("takeOff() closthesItem: " + clothesItem.toString());
        System.out.println("takeOff() returnedITem: " + returnedItem.toString());

        return returnedItem;
    }

    @Override
    public Optional<UpperClothes> takeOff(UUID id) {
        Optional<UpperClothes> returnedItem = Optional.empty();
//        clothesItem.ifPresent(item -> {       //// dlaczego nie dziala ??????????????????????
//            if (item.getId() == id) {
//                returnedItem = clothesItem;
//                clothesItem = Optional.empty();
//                return returnedItem;
//            }
//        });
        if (clothesItem.isPresent()){
            if (clothesItem.get().getId() == id){
//                returnedItem = Optional.ofNullable(clothesItem.get());
                returnedItem = clothesItem;
                clothesItem = Optional.empty();
                System.out.println("Returned item uuid id: " + returnedItem.toString());
                System.out.println("Uuid id after takeOff(id) closthesItem: " + clothesItem.toString());
                return returnedItem;
            }
        }
//            System.out.println(id.toString());
//            System.out.println((Optional.ofNullable(clothesItem)).toString());
            System.out.println("TakeOff If !=id: " + returnedItem.toString());
        return returnedItem;
    }

    @Override
    public void put(UpperClothes item) {
        System.out.println("Na wieszkau: " + clothesItem.toString());
        if (hasSlotFor(item.getType())){
            this.clothesItem = Optional.ofNullable(item); // ????????????????? nullable?
            System.out.println("After put: " + clothesItem.toString());
        } else {
            throw new IllegalStateException("there is no slot for this kind of clothes");
        }
    }

    @Override
    public boolean hasSlotFor(Clothes.ClothesType type) {
        if (clothesItem.isEmpty() && UpperClothes.UpperTypes.contains(type)){
            return true;
        }
        return false;
    }
}
