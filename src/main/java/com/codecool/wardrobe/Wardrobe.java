package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;
import com.codecool.wardrobe.clothing.LowerClothes;
import com.codecool.wardrobe.clothing.UpperClothes;

import java.util.*;

/**
 * The task of the class is to model a wardrobe.
 */
public class Wardrobe {

    private final int limit;
//    private static int hangerCounter;

    public List<Hanger> hangers;


    public Wardrobe(int limit) {

        this.limit = assignLimit(limit);
        this.hangers = new ArrayList<>();
    }




    private int assignLimit(int limit) {
        if (limit > 120){
            throw new IllegalArgumentException("Maximum limit is 120.");
        } else {
            return limit;
        }
    }

    public int getLimit() {
        return this.limit;
    }

    public int count() {
        return hangers.size();
    }

    public void put(Hanger<? extends Clothes> hanger) {

        if (hangers.size() < getLimit()){
            hangers.add(hanger);
        } else {
            throw new IllegalStateException("The wardrobe currently is full.");
        }
    }

    public Hanger<? extends Clothes> getHanger(Clothes.ClothesType clothesType) {


            Optional<Hanger> emptyHanger = hangers.stream()
                    .filter(hanger -> hanger.hasSlotFor(clothesType))
                    .findFirst();

            if (emptyHanger.isPresent()){
                return emptyHanger.get();
            } else {
                throw new NoSuchElementException("No empty hangers for your clothes");
            }
    }

    public Clothes getClothes(UUID clothesId) {

        Optional<Clothes> itemClothes = hangers.stream()
                .map(h -> h.takeOff(clothesId))
                .filter(Optional::isPresent)
                .map(o -> (Clothes)o.get())   ///??????????????????? dlaczego trzeba rzutować
                .findFirst();


        if (itemClothes.isEmpty()){
            throw new NoSuchElementException("Clothes not found.");
        }
        return itemClothes.get();
    }

    // The main method with this declaration is the entry point of Java applications.
    public static void main(String[] args) {
        // Create an instance of our class with the test data.
        LowerClothes newitem = new LowerClothes("Zalando", Clothes.ClothesType.TROUSERS);
        UpperClothes newBlouse = new UpperClothes("Zalando", Clothes.ClothesType.SHIRT);
        UpperClothes newBlouse2 = new UpperClothes("Zalando", Clothes.ClothesType.SHIRT);
        LowerClothes spodnie = new LowerClothes("Guess", Clothes.ClothesType.TROUSERS);
        Hanger<UpperClothes> wieszak = new ShirtHanger();

//        wieszak.put(newBlouse);
//        wieszak.put(newBlouse2);

//        wieszak.takeOff();
//        wieszak.put(newBlouse2);
        Hanger<Clothes> dolnyWieszak = new PantHanger();
        dolnyWieszak.put(newBlouse2);
        dolnyWieszak.takeOff();

    }
}
