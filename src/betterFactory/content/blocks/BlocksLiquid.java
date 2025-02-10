package betterFactory.content.blocks;

import betterFactory.api.IHasInit;
import betterFactory.init.ModItems;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.production.Pump;

import static mindustry.type.ItemStack.with;

public class BlocksLiquid implements IHasInit {

    public static Block copperLeadPump, titaniumAlloyPump;

    @Override
    public void init() {
        copperLeadPump = new Pump("copperLeadPump") {{
            requirements(Category.liquid, with(ModItems.copperLeadAlloys, 15, Items.metaglass, 10));
            pumpAmount = 14f / 60f;
            liquidCapacity = 20;
        }};

        titaniumAlloyPump = new Pump("titaniumAlloyPump") {{
            requirements(Category.liquid, with(ModItems.titaniumAlloy, 15, Items.metaglass, 20));
            pumpAmount = 24 / 60f;
            liquidCapacity = 30;
        }};
    }
}
