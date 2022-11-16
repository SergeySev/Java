package Train.Game.Life;

import Train.Game.Life.LandLife.Chicken;
import Train.Game.Life.LandLife.Garlic;
import Train.Game.Life.LandLife.GordonRamzi;
import Train.Game.Life.LifeType.*;
import Train.Game.Life.SeaLife.Nori;
import Train.Game.Life.SeaLife.RedFish;
import Train.Game.Life.SeaLife.Shark;

import java.util.ArrayList;
import java.util.List;

public class LifeFabric {
    public Plant createPlant(PlantType type) {
        return switch (type) {
            case NORI -> new Nori();
            case GARLIC -> new Garlic();
        };
    }
    public Herbivore createHerbivore(HerbivoreType type) {
        return switch (type) {
            case REDFISH -> new RedFish();
            case CHICKEN -> new Chicken();
        };
    }
    public Predator createPredator(PredatorType type) {
        return switch (type) {
            case SHARK -> new Shark();
            case GORDONRAMZI -> new GordonRamzi();
        };
    }

    public List<Predator> createGroup(int quantityUnity) {
        List<Predator> group = new ArrayList<>();
        for (int i = 0; i < quantityUnity; i++) {
            group.add(new Shark());
        }
        return group;
    }
}
