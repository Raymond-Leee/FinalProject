import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        Player play = new Player("John");
        System.out.println(play.getInventoryInfo());
        System.out.println(play.getPlayerInfo());
        play.save();

        /*
        Monster the = new Monster();
        System.out.println(the.getMonsterInfo());
        the.makeMove();
        System.out.println(the.getMonsterInfo());

        Monster the2 = new Monster();
        System.out.println(the2.getMonsterInfo());
        the2.makeMove();
        System.out.println(the2.getMonsterInfo());

        Monster the3 = new Monster();
        System.out.println(the3.getMonsterInfo());
        the3.makeMove();
        System.out.println(the3.getMonsterInfo());

        Monster the4 = new Monster();
        System.out.println(the4.getMonsterInfo());
        the4.makeMove();
        System.out.println(the4.getMonsterInfo());

        Monster the5 = new Monster();
        System.out.println(the5.getMonsterInfo());
        the5.makeMove();
        System.out.println(the5.getMonsterInfo());

        Monster the6 = new Monster();
        System.out.println(the6.getMonsterInfo());
        the6.makeMove();
        System.out.println(the6.getMonsterInfo());

        Monster the7 = new Monster();
        System.out.println(the7.getMonsterInfo());
        the7.makeMove();
        System.out.println(the7.getMonsterInfo());

        Monster the8 = new Monster();
        System.out.println(the8.getMonsterInfo());
        the8.makeMove();
        System.out.println(the8.getMonsterInfo());

        Monster the9 = new Monster();
        System.out.println(the9.getMonsterInfo());
        the9.makeMove();
        System.out.println(the9.getMonsterInfo());

        Monster the10 = new Monster();
        System.out.println(the10.getMonsterInfo());
        the10.makeMove();
        System.out.println(the10.getMonsterInfo());
        */

        /*
        Floor flo = new Floor();
        System.out.println(flo.getFloorInfo());

        Floor flo2 = new Floor();
        System.out.println(flo2.getFloorInfo());

        Floor flo3 = new Floor();
        System.out.println(flo3.getFloorInfo());

        Floor flo4 = new Floor();
        System.out.println(flo4.getFloorInfo());

        Floor flo5 = new Floor();
        System.out.println(flo5.getFloorInfo());

        Floor flo6 = new Floor();
        System.out.println(flo6.getFloorInfo());

        Floor flo7 = new Floor();
        System.out.println(flo7.getFloorInfo());

        Floor flo8 = new Floor();
        System.out.println(flo8.getFloorInfo());

        Floor flo9 = new Floor();
        System.out.println(flo9.getFloorInfo());

        Floor flo10 = new Floor();
        System.out.println(flo10.getFloorInfo());
        */
    }
}
