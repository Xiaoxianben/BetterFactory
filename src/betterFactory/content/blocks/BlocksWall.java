package betterFactory.content.blocks;

import betterFactory.api.IHasInit;
import betterFactory.init.ModItems;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.meta.Env;

import static mindustry.type.ItemStack.with;

public class BlocksWall implements IHasInit {

    public static Block copperLeadWall, copperLeadWallLarge,
            titaniumAlloyWall, titaniumAlloyWallLarge;

    @Override
    public void init() {
        var wallHealthMultiplier = 4;

        copperLeadWall = new Wall("copperLeadWall") {{
            requirements(Category.defense, with(ModItems.copperLeadAlloys, 6));
            health = 100 * wallHealthMultiplier;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        copperLeadWallLarge = new Wall("copperLeadWallLarge") {{
            requirements(Category.defense, ItemStack.mult(copperLeadWall.requirements, 4));
            health = copperLeadWall.health * 4;
            size = 2;
            envDisabled |= Env.scorching;
        }};

        titaniumAlloyWall = new Wall("titaniumAlloyWall") {{
            requirements(Category.defense, with(ModItems.titaniumAlloy, 6));
            health = 140 * wallHealthMultiplier;
            envDisabled |= Env.scorching;
        }};
        titaniumAlloyWallLarge = new Wall("titaniumAlloyWallLarge") {{
            requirements(Category.defense, ItemStack.mult(titaniumAlloyWall.requirements, 4));
            health = titaniumAlloyWall.health * 4;
            size = 2;
            envDisabled |= Env.scorching;
        }};
    }
}
