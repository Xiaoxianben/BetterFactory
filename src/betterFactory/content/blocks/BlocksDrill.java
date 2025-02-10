package betterFactory.content.blocks;

import betterFactory.api.IHasInit;
import betterFactory.init.ModItems;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.Category;
import mindustry.world.blocks.production.Drill;

import static mindustry.type.ItemStack.with;

public class BlocksDrill implements IHasInit {

    public static Drill copperLeadDrill, titaniumAlloyDrill;

    @Override
    public void init() {
        copperLeadDrill = new Drill("copperLeadDrill") {{
            requirements(Category.production, with(ModItems.copperLeadAlloys, 20, Items.graphite, 10));

            size = 2;
            tier = 3;
            drillTime = size * size * 60 / 2f;

            consumeLiquid(Liquids.water, 0.06f).boost();
        }};

        titaniumAlloyDrill = new Drill("titaniumAlloyDrill") {{
            requirements(Category.production, with(ModItems.titaniumAlloy, 30, Items.graphite, 30, Items.silicon, 30));

            size = 3;
            tier = 4;
            drillTime = size * size * 60 / 2.4f;
            hasPower = true;

            consumePower(1.10f);
            consumeLiquid(Liquids.water, 0.08f).boost();
        }};
    }
}
