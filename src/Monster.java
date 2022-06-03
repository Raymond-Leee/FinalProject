import java.util.Arrays;

public class Monster {
     private final String[] MONSTERS = new String[]{"Slime",
                                                   "Wolf",
                                                   "Skeleton",
                                                   "Goblin",
                                                   "Mummy",
                                                   "Ghoul",
                                                   "Stone Golem",
                                                   "Spider",
                                                   "Sand Worm",
                                                   "Hunter"};
    private String monsterType;
    private String monsterTier; // Normal or Elite
    private int monsterHealth;
    private int monsterArmour;
    private int monsterAttack;

    public Monster() {
        int num = (int) (Math.random() * 10);
        int tierDecide = (int) (Math.random() * 10);
        monsterType = MONSTERS[num];
        if (tierDecide > 7) {
            monsterTier = "Elite";
        }
        else {
            monsterTier = "Normal";
        }
        if (monsterTier.equals("Elite")) {
            monsterHealth = 250;
            monsterArmour = 15;
            monsterAttack = 15;
        }
        else {
            monsterHealth = 200;
            monsterArmour = 0;
            monsterAttack = 10;
        }
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public void removeMonsterHealth(int damage) {
        monsterHealth = monsterHealth - damage;
    }

    public void removeMonsterArmour(int damage) {
        monsterArmour = monsterArmour - damage;
    }

    public void setMonsterHealth(int damage) {
        monsterHealth = damage;
    }

    public int getMonsterAttack() {
        return monsterAttack;
    }

    public int getMonsterArmour() {
        return monsterArmour;
    }

    public void setMonsterArmour(int damage) {
        monsterArmour = damage;
    }

    public void makeMove(Player player) {
        int num = (int) (Math.random() * 3) + 1;
        if (num == 1) {
            /* attack player
             * attack hits armour first, remaining attack hits player directly
             */
            int playerArmour = player.getArmour();
            int playerHealth = player.getHealth();
            System.out.println(monsterTier + " " + monsterType + " attacked for " + monsterAttack + " damage!" + "\n");
            if (player.getArmour() > 0) {
                monsterAttack = playerArmour - monsterAttack;
                if (monsterAttack > 0) {
                    player.setHealth(playerHealth - monsterAttack);
                }
            }
            else {
                player.setHealth(playerHealth - monsterAttack);
            }
        }
        if (num == 2) {
            /* block (+5 to +7 defence for normal / +8 to +10 defence for elite)
             * block resets to base value at the start of a new turn
             */
            if (monsterTier.equals("Elite")) {
                int block = (int) (Math.random() * 3) + 8;
                monsterArmour += block;
                System.out.println(monsterTier + " " + monsterType + " gained an additional " + block + " block!" + "\n");
            }
            else {
                int block = (int) (Math.random() * 3) + 5;
                monsterArmour += block;
                System.out.println(monsterTier + " " + monsterType + " gained an additional " + block + " block!" + "\n");
            }
        }
        if (num == 3) {
            /* charge attack (+2 to +4 damage for normal / +5 to +7 damage for elite)
             * attack resets to base value at the start of a new turn
             */
            if (monsterTier.equals("Elite")) {
                int attack = (int) (Math.random() * 3) + 5;
                monsterAttack += attack;
                System.out.println(monsterTier + " " + monsterType + " gained an additional " + attack + " attack!" + "\n");
            }
            else {
                int attack = (int) (Math.random() * 3) + 2;
                monsterAttack += attack;
                System.out.println(monsterTier + " " + monsterType + " gained an additional " + attack + " attack!" + "\n");
            }
        }
    }

    public String monsterAppears() {
        String appear = "";
        if (monsterTier.equals("Elite")) {
            appear = "An " + monsterTier + " " + monsterType + " appears before you!";
        }
        else {
            appear = "A " + monsterTier + " " + monsterType + " appears before you!";
        }
        return appear;
    }

    public String getMonsterInfo() {
        return "Monster Type: " + monsterType +
               "\nMonster Tier: " + monsterTier +
               "\nHealth: " + monsterHealth +
               "\nArmour: " + monsterArmour +
               "\nAttack: " + monsterAttack + "\n";
    }
}
