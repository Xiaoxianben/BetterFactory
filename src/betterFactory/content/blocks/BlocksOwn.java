package betterFactory.content.blocks;

import betterFactory.api.IHasInit;
import betterFactory.init.ModItems;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;

import static mindustry.type.ItemStack.with;

public class BlocksOwn implements IHasInit {
    public static Block CopperLeadFactory,  titaniumAlloyFactory, siliconCrystalFactory;

    @Override
    public void init() {
        CopperLeadFactory = new GenericCrafter("copperlead-factory") {{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 50, Items.graphite, 30));

            craftTime = 60;
            size = 2;
            hasItems = hasPower = true;
            description = "将铜铅熔化, 提纯和充分融合，最后熔铸成铜铅合金\n[blue](一堆废话)";
            outputItem = new ItemStack(ModItems.copperLeadAlloys, 1);

            consumeItems(ItemStack.with(Items.copper, 1, Items.lead, 1));
            consumePower(35/60f);
        }};
        titaniumAlloyFactory = new GenericCrafter("titaniumAlloy-factory") {{
            requirements(Category.crafting, with(ModItems.copperLeadAlloys, 50, Items.graphite, 30, Items.titanium, 30));

            craftTime = 60;
            size = 3;
            hasItems = hasPower = true;
            description = "将铜铅钛熔化, 提纯和充分融合，最后熔铸成钛合金\n[blue](一堆废话)";
            outputItem = new ItemStack(ModItems.titaniumAlloy, 1);

            consumeItems(ItemStack.with(ModItems.copperLeadAlloys, 1, Items.titanium, 2));
            consumePower(70/60f);
        }};
//        siliconCrystalFactory = new GenericCrafter("siliconCrystal-factory") {{
//            requirements(Category.crafting, with(ModItems.titaniumAlloy, 50, Items.graphite, 30, Items.silicon, 30));
//
//            craftTime = 60;
//            size = 3;
//            hasItems = hasPower = true;
//            description = "将硅提纯并晶体化";
//            outputItem = new ItemStack(ModItems.siliconCrystal, 1);
//
//            consumeItems(ItemStack.with(Items.silicon, 3));
//            consumePower(60/60f);
//        }};
    }
}
