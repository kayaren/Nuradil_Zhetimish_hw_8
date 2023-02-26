package Game_General;

import Game_Players.*;

import java.util.Random;

public class RPG_Game {

    private static int roundNumber;

    private static void playRound(Boss boss, Hero[] heroes){
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.attack(heroes);
        for (int i = 0; i <heroes.length ; i++) {
            if (heroes[i].getAbility() != boss.getDefence() && heroes[i].getHealth() > 0){
                heroes[i].attack(boss);
                heroes[i].appleSuperPower(boss, heroes);
            }

        }
        printStatistics(boss,heroes);
    }


    public static Random random = new Random();
    public static void  startGame(){
        Boss boss = new Boss(1000, 50,"Alex");
        Warrior warrior = new Warrior(160,20,"Niko");
        Medic doc  = new Medic(140, 15,15,"Star");
        Magic magic = new Magic(150, 30, "Hooxi");
        Berserk berserk = new Berserk(120,40,"Ber");
        Medic assistant = new Medic(105,10, 5,"Mol");
        Hero[] heroes = {warrior,doc,magic,berserk,assistant};

        printStatistics(boss,heroes);
        while (!isGameFinished(boss,heroes)){
            playRound(boss,heroes);
        }
    }

    private static void printStatistics (Boss boss, Hero[] heroes){
        System.out.println("Round" + roundNumber + " ------------ ");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);

        }


    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes){
        if (boss.getHealth() <= 0 ){
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i <heroes.length ; i++) {
            if (heroes[i].getHealth() > 0){
               allHeroesDead = false;
               break;
            }

        }
        if (allHeroesDead){
            System.out.println("Boss won!!!");

        }return allHeroesDead;
    }

}
