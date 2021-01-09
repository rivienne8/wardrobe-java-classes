package com.codecool.wardrobe.clothing;

import com.codecool.wardrobe.IDList;

import java.util.UUID;

public class Clothes {
    private UUID id;
    private final String brandName;

    protected ClothesType type;

    public Clothes(String brandName) {
        this.brandName = brandName;
        this.id = generateId();

    }

    private UUID generateId(){
        UUID id = UUID.randomUUID();
        while (IDList.idExists(id)){
            id = UUID.randomUUID();
        }
        IDList.IdContainer.add(id);
        return id;
    }



    public UUID getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public ClothesType getType() {
        return this.type;
    }

    public enum ClothesType {
        SHIRT,
        BLOUSE,
        TROUSERS,
        SKIRT
    }
}
