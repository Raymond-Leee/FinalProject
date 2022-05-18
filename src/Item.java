public class Item {
    private String[] weapons = new String[]{"Shoddy Sword",
                                            "Iron Sword",
                                            "Iron Greatsword",
                                            "Steel Mace",
                                            "VT7 High-Frequency Blade"};
    private String[] weaponDescriptions = new String[]{"A poorly made wooden sword. Better than nothing.",
                                                       "An iron sword. Hits harder.",
                                                       "An iron greatsword. Be careful when swinging it.",
                                                       "A steel mace. Things are beginning to pick up.",
                                                       "A VT7 High-Frequency Blade. It'll cut through anything you can imagine."};
    private String[] armours = new String[]{"Leather Garments",
                                            "Chainmail Armour",
                                            "Iron Armour",
                                            "Hunter Garments",
                                            "Exo-suit"};
    private String[] armourDescriptions = new String[]{"It's heavy, but gets the job done.",
                                                       "Forged from the hottest of flames, it's underwhelmingly fragile.",
                                                       "A must have for any seasoned adventurer.",
                                                       "An outfit stolen from another hunter. Perhaps you should wash it.",
                                                       "Cybernetic arm not included."};
    private String[] items = new String[]{"Health Potion",
                                          "Instant Armour", 
                                          "Coffee",
                                          "Glitch Potion",
                                          "Rare Quincy Action Figure",
                                          "Acid Flask"};
    private String[] itemDescriptions = new String[]{"Heals 20 health.",
                                                     "Grants 15 armour.",
                                                     "Adds 1 energy..",
                                                     "Will become a random item.",
                                                     "It's worth a lot, but there's no shop around.",
                                                     "Attacks all monsters for 12 damage."};
    private String weapon;
    private String armour;

    public Item() {
        weapon = "";
        armour = "";
    }

    public String getWeaponInfo(String weap) {
        for (int i = 0; i < weapons.length; i++) {
            if (weap.equals(weapons[i])) {
                weapon += "Weapon: " + weapons[i] + "\n        " + weaponDescriptions[i] + "\n";
            }
        }
        return weapon;
    }

    public String getArmourInfo(String armo) {
        for (int i = 0; i < armours.length; i++) {
            if (armo.equals(armours[i])) {
                armour += "Armour: " + armours[i] + "\n        " + armourDescriptions[i] + "\n";
            }
        }
        return armour;
    }

    public String getItemInfo(String it) {
        for (int i = 0; i < weapons.length; i++) {
            if (it.equals(items[i])) {
                return "Item: " + items[i] + "\n      " + itemDescriptions[i] + "\n";
            }
        }
        return "Item: Empty\n";
    }
}
