import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class Player {
    private String username;
    private String character;
    private String[] characterList = new String[]{"Rogue",
                                                  "Knight",
                                                  "Traveller"};
    private String[] characterDescription = new String[]{"A lone wolf, the Rogue can stay in battle for quiet a long time.",
                                                         "A protector of the illustrious Nilian Empire, the Knight specialises in hitting hard.",
                                                         "A mysterious outsider, the Traveller has braved the toughest of the environment."};
    private ArrayList<String> inventory;
    private int health;
    private int energy;
    private int armour;
    private int attack;

    public Player() {
        this.username = "";
        this.character = "";
        inventory = new ArrayList<String>();
        inventory.add("Shoddy Sword");
        inventory.add("Leather Garments");
        inventory.add("Empty");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

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

    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }

    public String getInventoryInfo() {
        Item item = new Item();
        String inv = "Inventory\n";
        for (int i = 0; i < inventory.size(); i++) {
            if (i == 0) {
                inv += item.getWeaponInfo(inventory.get(i));
            }
            else if (i == 1) {
                inv += item.getArmourInfo(inventory.get(i));
            }
            else {
                inv += item.getItemInfo(inventory.get(i));
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

    public void save() {
        try {
            File f = new File("src/person.data");
            f.createNewFile(); // this method will create the file if it does not exist, if it does exist, it does nothing
            FileWriter fw = new FileWriter("src/person.data");
            fw.write(username);
            fw.write("\n" + character);
            fw.write("\n" + health);
            fw.write("\n" + armour);
            fw.write("\n" + attack);
            fw.write("\n" + getInventoryInfo());
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }
}
