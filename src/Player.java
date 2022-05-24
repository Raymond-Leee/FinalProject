import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Player {
    private String username;
    private String character;
    private final String[] CHARACTER_LIST = new String[]{"Rogue",
                                                         "Knight",
                                                         "Traveller"};
    private final String[] CHARACTER_DESCRIPTION = new String[]{"A lone wolf, the Rogue can stay in battle for quiet a long time.",
                                                                "A protector of the illustrious Nilian Empire, the Knight specialises in hitting hard.",
                                                                "A mysterious outsider, the Traveller has braved the toughest of the environment."};
    private String[] inventory;
    private String weapon;
    private String armourItem;
    private String item;
    private String floor;
    private int health;
    private int energy;
    private int armour;
    private int attack;

    public Player() {
        username = "";
        character = "";
        inventory = new String[3];
        weapon = "";
        armourItem = "";
        item = "";
    }

    public Player(String username) {
        this.username = username;
        character = "";
        inventory = new String[3];
        weapon = "Shoddy Sword";
        armourItem = "Leather Garments";
        item = "Empty";
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

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getArmourItem() {
        return armourItem;
    }

    public void setArmourItem(String armourItem) {
        this.armourItem = armourItem;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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

    public void setInventory() {
        inventory[0] = weapon;
        inventory[1] = armourItem;
        inventory[2] = item;
    }

    public String getInventoryInfo() {
        PlayerItem playerItem = new PlayerItem();
        String inv = "Inventory\n";
        for (int i = 0; i < inventory.length; i++) {
            if (i == 0) {
                inv += playerItem.getWeaponInfo(inventory[i]);
            }
            else if (i == 1) {
                inv += playerItem.getArmourInfo(inventory[i]);
            }
            else {
                inv += playerItem.getItemInfo(inventory[i]);
            }
        }
        return inv;
    }

    public String getFloor() {
        Floor flo = new Floor();
        floor = flo.getFloorName();
        return floor;
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
            File f = new File("src/player.data");
            f.createNewFile(); // this method will create the file if it does not exist, if it does exist, it does nothing
            FileWriter fw = new FileWriter("src/player.data");
            fw.write(username);
            fw.write("\n" + character);
            fw.write("\n" + health);
            fw.write("\n" + armour);
            fw.write("\n" + attack);
            fw.write("\n" + weapon);
            fw.write("\n" + armourItem);
            fw.write("\n" + item);
            fw.write("\n" + floor);
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }
}
