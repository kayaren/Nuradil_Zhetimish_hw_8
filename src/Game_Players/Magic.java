package Game_Players;


public class Magic extends Hero {

    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST,name);
    }

    @Override
    public void appleSuperPower(Boss boss, Hero[] heroes) {
        int upDamage = 30;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0){
            heroes[i].setDamage(heroes[i].getDamage() + upDamage );}

        }
        System.out.println("Magic use Magic");

    }
}
