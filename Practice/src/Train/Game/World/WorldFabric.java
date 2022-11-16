package Train.Game.World;

import java.util.HashMap;
import java.util.Map;

public class WorldFabric {
    public WorldLayout createWorld(WorldType type) {
        return switch (type) {
            case MARINE -> new Marine();
            case DESERTED -> new Desert();
            case TROPICAL -> new Tropic();
        };
    }
    public Map<String, WorldLayout> worldDB() {
        WorldLayout kamino = new Marine();
        kamino.setSize(2);
        kamino.setName("Kamino");

        WorldLayout tatuin = new Marine();
        tatuin.setSize(5);
        tatuin.setName("Tatuin");

        WorldLayout nabu = new Marine();
        nabu.setSize(3);
        nabu.setName("Nabu");

        Map<String, WorldLayout> worlds= new HashMap<>();
        worlds.put("Kamino", kamino);
        worlds.put("Tatuin", tatuin);
        worlds.put("Nabu", nabu);
        return worlds;
    }

    public WorldLayout getWorldFromDB(String key) {
        Map<String, WorldLayout> worldb = worldDB();
        return worldb.get(key);

    }
}
