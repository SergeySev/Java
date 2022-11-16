package Train.Game.Life.LifeType;

import Train.Game.Life.FloraFauna;

public class Predator extends FloraFauna {
    int hp;

    public void setHp(int hp) {
    }

    public int getAttack() {
        return attack;
    }

    public int getHp() {
        return hp;
    }

    int attack;
    public void behavior(){
    }
    public void attack(Predator attacker, Predator attacked) {
    }
}
