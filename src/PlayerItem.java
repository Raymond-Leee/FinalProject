public class PlayerItem {
    private final String[] WEAPONS = new String[]{"Shoddy Sword",               // 45%
                                                  "Iron Sword",                 // 25%
                                                  "Iron Greatsword",            // 20%
                                                  "Steel Mace",                 // 9%
                                                  "VT7 High-Frequency Blade"};  // 1%
    private final String[] WEAPON_DESCRIPTIONS = new String[]{"A poorly made wooden sword. Better than nothing.",
                                                              "An iron sword. Hits harder.",
                                                              "An iron greatsword. Be careful when swinging it.",
                                                              "A steel mace. Things are beginning to pick up.",
                                                              "A VT7 High-Frequency Blade. It'll cut through anything you can imagine."};
    private final String[] ARMOURS = new String[]{"Leather Garments",  // 45%
                                                  "Chainmail Armour",  // 25%
                                                  "Iron Armour",       // 20%
                                                  "Hunter Garments",   // 9%
                                                  "Exo-suit"};         // 1%
    private final String[] ARMOUR_DESCRIPTIONS = new String[]{"It's uncomfortable, but gets the job done.",
                                                              "Forged from the hottest of flames, it's underwhelmingly fragile.",
                                                              "A must have for any seasoned adventurer.",
                                                              "An outfit stolen from another hunter. Perhaps you should wash it.",
                                                              "Cybernetic arm not included."};
    private final String[] ITEMS = new String[]{"Health Potion",
                                                "Instant Armour",
                                                "Coffee",
                                                "Rare Quincy Action Figure",
                                                "Acid Flask"};
    private final String[] ITEM_DESCRIPTIONS = new String[]{"Heals 20 health.",
                                                            "Grants 15 armour.",
                                                            "Adds 1 energy.",
                                                            "It's worth a lot, but there's no shop around.",
                                                            "Attacks all monsters for 12 damage."};
    private String weapon;
    private String armour;

    public PlayerItem() {
        weapon = "";
        armour = "";
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

        }
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
