package Game_Players;

import Game_General.RPG_Game;

public class Warrior extends Hero  {

    public Warrior(int health, int damage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE,name);
    }

    @Override
    public void appleSuperPower(Boss boss, Hero[] heroes) {
       if (boss.getHealth() > 0 ){
            int coeff = RPG_Game.random.nextInt(9) + 2 ;
            boss.setHealth(boss.getHealth() - coeff * this.getDamage() );
           System.out.println("Warrior hits critically: " + coeff * this.getDamage());
       }

    }
}
