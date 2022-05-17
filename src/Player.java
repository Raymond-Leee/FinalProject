public class Player {
    private String username;
    private String character;
    private String[] inventory;
    private int health;
    private int energy;
    private int armour;
    private int attack;

    public Player(String username, String character) {
        this.username = username;
        this.character = character;
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
        String inv = "Inventory\n";
        for (int i = 0; i < inventory.length; i++) {
            if (i == 0) {
                inv += "Weapon: " + inventory[i] + "\n";
            }
            else if (i == 1) {
                inv += "Armour: " + inventory[i] + "\n";
            }
            else {
                inv += "Item: " + inventory[i] + "\n";
            }
        }
        return inv;
    }

    //public String getPlayerInfo() {
      //  String player = username + "\n";

    //}
}
