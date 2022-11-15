package Train.Game;

import Train.Game.Life.FlorFaunType;
import Train.Game.Life.FloraFauna;
import Train.Game.Life.LifeFabric;
import Train.Game.Life.Predator;
import Train.Game.World.WorldFabric;
import Train.Game.World.WorldLayout;
import Train.Game.World.WorldType;

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

        System.out.println("Create Life\n");
        System.out.println("Create plant");
        FloraFauna rose = lifeFabric.createLife(FlorFaunType.PLANT);
        rose.behavior();
        rose.interaction();

        System.out.println("Create herbivore");
        FloraFauna chicken = lifeFabric.createLife(FlorFaunType.HERBIVORES);
        chicken.behavior();
        chicken.interaction();

        System.out.println("Create predator");
        FloraFauna tiger = lifeFabric.createLife(FlorFaunType.PREDATORS);
        tiger.behavior();
        tiger.interaction();

        System.out.println("\nCreate world\n");
        System.out.println("Create sea-world");
        WorldLayout kamino = worldFabric.createWorld(WorldType.MARINE);
        kamino.climateImpact();

        System.out.println("Create desert-world");
        WorldLayout tatuin = worldFabric.createWorld(WorldType.DESERTED);
        tatuin.climateImpact();

        System.out.println("Create tropic-world");
        WorldLayout nabu = worldFabric.createWorld(WorldType.TROPICAL);
        nabu.climateImpact();
    }
}
