package Game_Players;

public class Berserk extends Hero {

    private int saveDamage;

    public int getSaveDamage() {
        return saveDamage;
    }

    public void setSaveDamage(int saveDamage) {
        this.saveDamage = saveDamage;
    }

    public void setBlockDamage(int saveDamage) {
        this.saveDamage = saveDamage;
    }

    public Berserk(int health, int damage,String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT,name);
    }

    @Override
    public void appleSuperPower(Boss boss, Hero[] heroes) {

    }
    public void hit (Boss boss){
        if (this.getHealth() > 0 && boss.getHealth() > 0 ){
            boss.setHealth(boss.getHealth() - this.getDamage() - this.getSaveDamage());
        }
    }
}
