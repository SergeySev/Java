package Train.Game;

import Train.Game.Life.*;
import Train.Game.Life.LifeType.HerbivoreType;
import Train.Game.Life.LifeType.PlantType;
import Train.Game.Life.LifeType.Predator;
import Train.Game.Life.LifeType.PredatorType;
import Train.Game.World.WorldFabric;
import Train.Game.World.WorldLayout;
import Train.Game.World.WorldType;

import java.util.List;
import java.util.Random;

/*
Реализовать создание разных миров для компьютерной игры с
использованием подходящего паттера проектирования.

В игре есть.
Создать класс, который будет генерировать
континенты (планеты, миры).

Планеты -> мир -> континенты

Мир на каждом континенте характеризуется
наличием пищевых цепочек (растения – травоядные – хищники),

Создать класс, который будет генерировать животных.
На каждом континенте пищевые цепочки
(растения – травоядные – хищники),

конкретные представители флоры и фауны в различных мирах
отличаются.

Характер взаимодействия между животными остается неизменным.
 */
public class Main {

    public static void main(String[] args) {
        WorldFabric worldFabric = new WorldFabric();
        LifeFabric lifeFabric = new LifeFabric();

        worldFabric.createWorld(WorldType.MARINE).climateImpact();

        lifeFabric.createPlant(PlantType.NORI).behavior();
        lifeFabric.createHerbivore(HerbivoreType.REDFISH).behavior();
        lifeFabric.createPredator(PredatorType.SHARK).behavior();
        System.out.println("__________");

        worldFabric.createWorld(WorldType.TROPICAL).climateImpact();
        lifeFabric.createPlant(PlantType.GARLIC).behavior();
        lifeFabric.createHerbivore(HerbivoreType.CHICKEN).behavior();
        lifeFabric.createPredator(PredatorType.GORDONRAMZI).behavior();

        WorldLayout kamino = worldFabric.getWorldFromDB("Kamino");
        System.out.println();
        kamino.climateImpact();
        System.out.println(kamino.getSize());
        System.out.println(kamino.getName());


        List<Predator> group1 = lifeFabric.createGroup(4);
        List<Predator> group2 = lifeFabric.createGroup(5);

        Random random = new Random();
        boolean play = true;
        boolean checkMove = true;
        Predator attacker;
        Predator attacked;
        System.out.println();

        while (play) {
            // chose attacker
            attacker = (checkMove) ? group1.get(random.nextInt(group1.size())) : group2.get(random.nextInt(group1.size()));
            // chose attacked
            attacked = (checkMove) ? group2.get(random.nextInt(group1.size())) : group1.get(random.nextInt(group1.size()));

            // make attack
            attacker.attack(attacker, attacked);
            System.out.println("\nSchark was attack!!!\nShark  №" + (((!checkMove) ? group1.indexOf(attacked) : group2.indexOf(attacked)) + 1 + " has " + attacked.getHp() + " HP\n"));

            System.out.println("Group 1 has hp:");
            for (int i = 0; i < group1.size(); i++) {
                System.out.println("Unit " + (i + 1) + " has " + group1.get(i).getHp() + " HP");
            }
            System.out.println("\nGroup 2 has hp:");
            for (int i = 0; i < group2.size(); i++) {
                System.out.println("Unit " + (i + 1) + " has " + group2.get(i).getHp() + " HP");
            }
            System.out.println("_______________-");
            checkMove = !checkMove;

            group1.removeIf(unit -> unit.getHp() <= 0);
            group2.removeIf(unit -> unit.getHp() <= 0);

            if (group2.size() == 0 || group1.size() == 0) {
                play = false;
                String winner;
                if (group1.size() > 0) {
                    winner = "Group 1";
                } else winner = "Group 2";
                System.out.println("Our winner is " + winner);
            }
        }
    }
}
