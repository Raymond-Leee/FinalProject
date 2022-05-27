public class PlayerItem {
    private final String[] WEAPONS = new String[]{"Shoddy Sword",               // 40%
                                                  "Iron Sword",                 // 30%
                                                  "Iron Greatsword",            // 20%
                                                  "Steel Dagger",                 // 9%
                                                  "VT7 High-Frequency Blade"};  // 1%
    private final String[] WEAPON_DESCRIPTIONS = new String[]{"A poorly made wooden sword. Better than nothing.",
                                                              "An iron sword. Hits harder.",
                                                              "An iron greatsword. Be careful when swinging it.",
                                                              "A steel dagger. Able to slice through the air in an instant.",
                                                              "A VT7 High-Frequency Blade. Whatever stands in your way will be dead before they even know it."};
    private final String[] ARMOURS = new String[]{"Leather Garments",  // 40%
                                                  "Chainmail Armour",  // 30%
                                                  "Iron Armour",       // 20%
                                                  "Hunter Garments",   // 9%
                                                  "Exo-suit"};         // 1%
    private final String[] ARMOUR_DESCRIPTIONS = new String[]{"It's uncomfortable, but gets the job done.",
                                                              "Forged from the hottest of flames, it's underwhelmingly fragile.",
                                                              "A must have for any seasoned adventurer.",
                                                              "An outfit stolen from another hunter. Perhaps you should wash it.",
                                                              "Cybernetic arm not included."};
    private final String[] ITEMS = new String[]{"Health Potion",              // 20%
                                                "Instant Armour",             // 20%
                                                "Coffee",                     // 20%
                                                "Rare Quincy Action Figure",  // 20%
                                                "Acid Flask"};                // 20%
    private final String[] ITEM_DESCRIPTIONS = new String[]{"Heals 20 health.",
                                                            "Grants 15 armour.",
                                                            "Adds 1 energy.",
                                                            "It's worth a lot, but there's no shop around.",
                                                            "Attacks all monsters for 12 damage."};
    private String weapon;
    private String armour;
    private String item;

    public PlayerItem() {
        weapon = "";
        armour = "";
        item = "";
    }

    public String rollWeapon() {
        int determineWeapon = (int) (Math.random() * 100) + 1;
        if (determineWeapon > 99) {
            weapon = WEAPONS[4];
        }
        else if (determineWeapon > 90) {
            weapon = WEAPONS[3];
        }
        else if (determineWeapon > 70) {
            weapon = WEAPONS[2];
        }
        else if (determineWeapon > 40) {
            weapon = WEAPONS[1];
        }
        else {
            weapon = WEAPONS[0];
        }
        return weapon;
    }

    public String rollArmour() {
        int determineArmour = (int) (Math.random() * 100) + 1;
        if (determineArmour > 99) {
            armour = ARMOURS[4];
        }
        else if (determineArmour > 90) {
            armour = ARMOURS[3];
        }
        else if (determineArmour > 70) {
            armour = ARMOURS[2];
        }
        else if (determineArmour > 40) {
            armour = ARMOURS[1];
        }
        else {
            armour = ARMOURS[0];
        }
        return armour;
    }

    public String rollItem() {
        int determineItem = (int) (Math.random() * 5);
        item = ITEMS[determineItem];
        return item;
    }

    public String getWeaponInfo(String weap) {
        for (int i = 0; i < WEAPONS.length; i++) {
            if (weap.equalsIgnoreCase(WEAPONS[i])) {
                weapon += "Weapon: " + WEAPONS[i] + "\n        " + WEAPON_DESCRIPTIONS[i] + "\n";
            }
        }
        return weapon;
    }

    public String getArmourInfo(String armo) {
        for (int i = 0; i < ARMOURS.length; i++) {
            if (armo.equalsIgnoreCase(ARMOURS[i])) {
                armour += "Armour: " + ARMOURS[i] + "\n        " + ARMOUR_DESCRIPTIONS[i] + "\n";
            }
        }
        return armour;
    }

    public String getItemInfo(String it) {
        for (int i = 0; i < ITEMS.length; i++) {
            if (it.equalsIgnoreCase(ITEMS[i])) {
                return "Item: " + ITEMS[i] + "\n      " + ITEM_DESCRIPTIONS[i] + "\n";
            }
        }
        return "Item: Empty\n";
    }
}
