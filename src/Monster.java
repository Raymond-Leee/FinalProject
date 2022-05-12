public class Monster {
    private String monsterType;
    private String monsterTier; // Normal or Elite

    public void makeMove() {
        int num = (int) (Math.random() * 3) + 1;
        if (num == 1) {
            // attack
        }
        if (num == 2) {
            // block
        }
        if (num == 3) {
            // use special (unique to monster type)
        }
    }
}
