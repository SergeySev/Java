package Train.Game.Life.SeaLife;

import Train.Game.Life.LifeType.Predator;

import java.util.Random;

public class Shark extends Predator {
    int hp = 135;
    int attack = new Random().nextInt(35, 45);

    public void behavior() {
        System.out.println("Shark eating california-set");
    }
    public void attack(Predator attacker, Predator attacked) {
       attacked.setHp(attacker.getAttack());
    }

    public void setHp(int damage) {
        this.hp -= damage;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }
}
