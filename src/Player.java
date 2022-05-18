public class Player {
    private String username;
    private String character;
    private String[] characterList = new String[]{"Rogue",
                                                  "Knight",
                                                  "Shifter"};
    private String[] characterDescription = new String[]{"A lone wolf, the Rogue specialises in being able to do many things at once",
                                                         "A protector of the illustrious Nilian Empire, the Knight specialises in hitting hard",
                                                         "A mysterious outsider, the Shifter is able to inherit the stat buffs of any character"};
    private String[] inventory;
    private int health;
    private int energy;
    private int armour;
    private int attack;

    public Player(String username) {
        this.username = username;
        this.character = "";
        inventory = new String[5];
        for (int i = 0; i < inventory.length; i++) {
            if (i == 0) {
                inventory[i] = "Shoddy Sword";
            }
            else if (i == 1) {
                inventory[i] = "Leather Garments";
            }
            else {
                inventory[i] = "Empty";
            }
        }
    }

    /*public void setInventory(String[] inventory) {
        for (int i = 0; i < inventory.length; i++) {

        }
    }*/

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getInventoryInfo() {
        Item item = new Item();
        String inv = "Inventory\n";
        for (int i = 0; i < inventory.length; i++) {
            if (i == 0) {
                inv += item.getWeaponInfo(inventory[i]);
            }
            else if (i == 1) {
                inv += item.getArmourInfo(inventory[i]);
            }
            else {
                inv += item.getItemInfo(inventory[i]);
            }
        }
        return inv;
    }

    public String getPlayerInfo() {
      return "Player: " + username +
             "\nCharacter: " + character +
             "\nHealth: " + health +
             "\nArmour: " + armour +
             "\nAttack: " + attack;
    }
}
