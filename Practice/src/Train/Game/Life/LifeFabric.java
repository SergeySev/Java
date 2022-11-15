package Train.Game.Life;

public class LifeFabric {
    public FloraFauna createLife(FlorFaunType type) {
        return switch (type) {
            case PLANT -> new Plant();
            case HERBIVORES -> new Herbivore();
            case PREDATORS -> new Predator();
        };
    }
}
