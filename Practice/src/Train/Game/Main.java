package Train.Game;

import Train.Game.Life.*;
import Train.Game.Life.LifeType.HerbivoreType;
import Train.Game.Life.LifeType.PlantType;
import Train.Game.Life.LifeType.PredatorType;
import Train.Game.World.WorldFabric;
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

        worldFabric.createWorld(WorldType.MARINE).climateImpact();

        lifeFabric.createPlant(PlantType.NORI).behavior();
        lifeFabric.createHerbivore(HerbivoreType.REDFISH).behavior();
        lifeFabric.createPredator(PredatorType.SHARK).behavior();
        System.out.println("__________");

        worldFabric.createWorld(WorldType.TROPICAL).climateImpact();
        lifeFabric.createPlant(PlantType.GARLIC).behavior();
        lifeFabric.createHerbivore(HerbivoreType.CHICKEN).behavior();
        lifeFabric.createPredator(PredatorType.GORDONRAMZI).behavior();


    }
}
