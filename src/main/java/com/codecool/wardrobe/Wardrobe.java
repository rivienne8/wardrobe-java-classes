package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;
import com.codecool.wardrobe.clothing.LowerClothes;
import com.codecool.wardrobe.clothing.UpperClothes;

import java.util.UUID;

/**
 * The task of the class is to model a wardrobe.
 */
public class Wardrobe {

    private int limit;


    public Wardrobe(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return 0;
    }

    public int count() {
        return 0;
    }

    public void put(Hanger<? extends Clothes> hanger) {
    }

    public Hanger<? extends Clothes> getHanger(Clothes.ClothesType clothesType) {
        return null;
    }

    public Clothes getClothes(UUID clothesId) {
        return null;
    }

    // The main method with this declaration is the entry point of Java applications.
    public static void main(String[] args) {
        // Create an instance of our class with the test data.
        LowerClothes newitem = new LowerClothes("Zalando", Clothes.ClothesType.TROUSERS);
        UpperClothes newBlouse = new UpperClothes("Zalando", Clothes.ClothesType.SHIRT);
        UpperClothes newBlouse2 = new UpperClothes("Zalando", Clothes.ClothesType.SHIRT);
        Hanger<UpperClothes> wieszak = new ShirtHanger();

        wieszak.put(newBlouse);
//        wieszak.put(newBlouse2);

        wieszak.takeOff();

    }
}
