package betterFactory.init;

import betterFactory.api.IHasInit;
import betterFactory.content.blocks.*;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    private final List<IHasInit> initList = new ArrayList<>();

    public void init() {

        initList.add(new BlocksOwn());
        initList.add(new BlocksDrill());
        initList.add(new BlocksConveyor());
        initList.add(new BlocksPower());
        initList.add(new BlocksLiquid());
        initList.add(new BlocksWall());
        initList.add(new BlocksTurret());
        initList.add(new BlocksMulti());
        initList.add(new BlocksLarge());

        for (IHasInit init : initList) {
            init.init();
        }
    }
}
