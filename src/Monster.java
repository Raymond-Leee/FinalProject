import java.util.Arrays;

public class Monster {
    private String[] monster = new String[]{"Slime", "Wolf", "Skeleton", "Goblin", "Mummy", "Ghoul", "Stone Golem", "Spider", "Sand Worm", "Human"};
    private String monsterType;
    private String monsterTier; // Normal or Elite
    private int monsterHealth;
    private int monsterArmour;
    private int monsterAttack;

    public Monster() {
        int num = (int) (Math.random() * 10);
        int tierDecide = (int) (Math.random() * 10);
        monsterType = monster[num];
        if (tierDecide > 7) {
            monsterTier = "Elite";
        }
        else {
            monsterTier = "Normal";
        }
        if (monsterTier.equals("Elite")) {
            monsterHealth = 150;
            monsterArmour = 10;
            monsterAttack = 15;
        }
        else {
            monsterHealth = 100;
            monsterArmour = 0;
            monsterAttack = 10;
        }
        System.out.println(monsterTier + " " + monsterType + " appears before you!");
    }

    public void makeMove() {
        int num = (int) (Math.random() * 3) + 1;
        if (num == 1) {
            /* attack player
             * attack hits armour first, remaining attack hits player directly
             */
        }
        if (num == 2) {
            /* block (+5 to +7 defence for normal / +8 to +10 defence for elite)
             * block resets to base value at the start of a new turn
             */
        }
        if (num == 3) {
            /* charge attack (+2 to +4 damage for normal / +5 to +7 damage for elite)
             * attack resets to base value at the start of a new turn
             */
        }
    }

    public String getMonsterInfo() {
        return "Monster Type: " + monsterType +
               "\nMonster Tier: " + monsterTier +
               "\nHealth: " + monsterHealth +
               "\nArmour: " + monsterArmour +
               "\nAttack: " + monsterAttack + "\n";
    }
}
