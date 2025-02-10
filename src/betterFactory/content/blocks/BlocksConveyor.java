package betterFactory.content.blocks;

import betterFactory.api.IHasInit;
import betterFactory.init.ModItems;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.BufferedItemBridge;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.distribution.Junction;

import static mindustry.type.ItemStack.with;

public class BlocksConveyor implements IHasInit {

    public static Block copperLeadConveyor, copperLeadJunction, copperLeadBridge,
            titaniumAlloyConveyor, titaniumAlloyJunction, titaniumAlloyBridge;

    @Override
    public void init() {
        copperLeadConveyor = new Conveyor("copperLeadConveyor") {{
            requirements(Category.distribution, ItemStack.with(ModItems.copperLeadAlloys, 1));

            speed = 10f / 137.001f;
            displayedSpeed = 10;
        }};
        copperLeadJunction = new Junction("copperLeadJunction") {{
            requirements(Category.distribution, with(ModItems.copperLeadAlloys, 2));

            speed = 18;
            capacity = 6;
            health = 30;
            buildCostMultiplier = 6f;
        }};
        copperLeadBridge = new BufferedItemBridge("copperLeadBridge") {{
            requirements(Category.distribution, with(ModItems.copperLeadAlloys, 6));
            fadeIn = moveArrows = false;
            range = 6;
            speed = 50;
            arrowSpacing = 6f;
            bufferCapacity = 20;
        }};

        titaniumAlloyConveyor = new Conveyor("titaniumAlloyConveyor") {{
            requirements(Category.distribution, ItemStack.with(ModItems.titaniumAlloy, 1));

            speed = 16f / 137.001f;
            displayedSpeed = 10;
        }};
        titaniumAlloyJunction = new Junction("titaniumAlloyJunction") {{
            requirements(Category.distribution, with(ModItems.titaniumAlloy, 2));

            speed = 10;
            capacity = 6;
            health = 30;
            buildCostMultiplier = 6f;
        }};
        titaniumAlloyBridge = new BufferedItemBridge("titaniumAlloyBridge") {{
            requirements(Category.distribution, with(ModItems.titaniumAlloy, 6));
            fadeIn = moveArrows = false;
            range = 6;
            speed = 20;
            arrowSpacing = 6f;
            bufferCapacity = 20;
        }};

    }
}
