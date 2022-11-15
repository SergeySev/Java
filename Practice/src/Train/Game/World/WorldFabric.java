package Train.Game.World;

public class WorldFabric {
    public WorldLayout createWorld(WorldType type) {
        return switch (type) {
            case MARINE -> new Marine();
            case DESERTED -> new Desert();
            case TROPICAL -> new Tropic();
        };
    }
}
