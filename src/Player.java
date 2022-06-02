import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Player {
    private String username;
    private String character;
    private final String[] CHARACTER_LIST = new String[]{"Rogue",       // 1 additional energy per turn
                                                         "Knight",      // 7 additional attack
                                                         "Traveller"};  // 10 additional health
    private final String[] CHARACTER_DESCRIPTION = new String[]{"A lone wolf, the Rogue can stay in battle for quiet a long time.",
                                                                "A protector of the illustrious Autrunian Empire, the Knight has seen the worst of bloody conflicts.",
                                                                "A mysterious outsider, the Traveller has braved the toughest of the environment."};
    private String[] inventory;
    private String weapon;
    private String armourItem;
    private String floor;
    private int health;
    private int energy;
    private int armour;
    private int attack;
    private int roomCount;

    public Player() {
        username = "";
        character = "";
        inventory = new String[2];
        health = 0;
        energy = 3;
        weapon = "";
        armourItem = "";
        roomCount = 0;
    }

    public Player(String username) {
        this.username = username;
        character = "";
        inventory = new String[2];
        health = 100;
        energy = 3;
        weapon = "Shoddy Sword";
        armourItem = "Leather Garments";
        roomCount = 1;
        setInventory();
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

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public void setInventory() {
        inventory[0] = weapon;
        inventory[1] = armourItem;
    }

    public void setSpecificInventory(int i, String str) {
        inventory[i] = str;
    }

    public String getInventoryInfo() {
        PlayerItem playerItem = new PlayerItem();
        String inv = "Inventory\n";
        inv += playerItem.getWeaponInfo(inventory[0]);
        inv += playerItem.getArmourInfo(inventory[1]);
        return inv;
    }

    public String getCharacters() {
        String characters = "";
        for (int i = 0; i < CHARACTER_LIST.length; i++) {
            characters += (i + 1) + ") " + CHARACTER_LIST[i] + "; " + CHARACTER_DESCRIPTION[i] + "\n";
        }
        return characters;
    }

    public String getFloor(Floor flo) {
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
            fw.write("\n" + energy);
            fw.write("\n" + attack);
            fw.write("\n" + armour);
            fw.write("\n" + weapon);
            fw.write("\n" + armourItem);
            fw.write("\n" + floor);
            fw.write("\n" + roomCount);
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }
}
