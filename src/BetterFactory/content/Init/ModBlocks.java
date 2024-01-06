package BetterFactory.content.Init;

import BetterFactory.API.iHasInit;
import BetterFactory.content.Blocks.BlocksLarge;
import BetterFactory.content.Blocks.BlocksMulti;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    private static List<iHasInit> initList = new ArrayList<>(2);

    public static void init() {
        BlocksMulti blocksMulti = new BlocksMulti();
        BlocksLarge blocksLarge = new BlocksLarge();
        initList.add(blocksMulti);
        initList.add(blocksLarge);
        for (iHasInit init : initList) {
            init.init();
        }
    }
}
