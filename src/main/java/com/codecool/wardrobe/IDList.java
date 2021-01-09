package com.codecool.wardrobe;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IDList {
    public static List<UUID> IdContainer = new ArrayList<>();

    public static boolean idExists(UUID uuid){
        return IdContainer.contains(uuid);
    }
}
