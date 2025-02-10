package betterFactory.content.blocks;

import betterFactory.api.IHasInit;
import betterFactory.init.ModItems;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.power.Battery;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.consumers.ConsumeItemExplode;
import mindustry.world.consumers.ConsumeItemFlammable;

import static mindustry.type.ItemStack.with;

public class BlocksPower implements IHasInit {

    public static Block copperLeadBattery, copperLeadBatteryLarge, copperLeadPowerNode, copperLeadPowerNodeLarge, copperLeadSteamGenerator,
            titaniumAlloyBattery, titaniumAlloyBatteryLarge, titaniumAlloyPowerNode, titaniumAlloyPowerNodeLarge, titaniumAlloySteamGenerator;

    @Override
    public void init() {
        copperLeadBattery = new Battery("copperLeadBattery") {{
            requirements(Category.power, with(ModItems.copperLeadAlloys, 20, Items.graphite, 10));
            consumePowerBuffered(8000f);

            baseExplosiveness = 1.5f;
        }};
        copperLeadBatteryLarge = new Battery("copperLeadBatteryLarge") {{
            requirements(Category.power, with(ModItems.copperLeadAlloys, 50, Items.graphite, 10, Items.silicon, 30, Items.titanium, 20));

            size = 3;

            consumePowerBuffered(80000f);

            baseExplosiveness = 5.5f;
        }};
        copperLeadPowerNode = new PowerNode("copperLeadPowerNode") {{
            requirements(Category.power, with(ModItems.copperLeadAlloys, 2));

            maxNodes = 15;
            laserRange = 12;
        }};
        copperLeadPowerNodeLarge = new PowerNode("copperLeadPowerNodeLarge") {{
            requirements(Category.power, with(ModItems.copperLeadAlloys, 10, Items.silicon, 30, Items.titanium, 5));

            size = 2;
            maxNodes = 20;
            laserRange = 20;
        }};
        copperLeadSteamGenerator = new ConsumeGenerator("copperLeadSteamGenerator") {{
            requirements(Category.power, with(ModItems.copperLeadAlloys, 35, Items.graphite, 25, Items.silicon, 30));
            powerProduction = 11f;
            itemDuration = 50f;
            consumeLiquid(Liquids.water, 0.2f);
            hasLiquids = true;
            size = 3;
            generateEffect = Fx.generatespark;

            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.06f;

            consume(new ConsumeItemFlammable());
            consume(new ConsumeItemExplode());
        }};

        titaniumAlloyBattery = new Battery("titaniumAlloyBattery") {{
            requirements(Category.power, with(ModItems.titaniumAlloy, 20, Items.graphite, 20));
            consumePowerBuffered(12000f);

            baseExplosiveness = 2f;
        }};
        titaniumAlloyBatteryLarge = new Battery("titaniumAlloyBatteryLarge") {{
            requirements(Category.power, with(ModItems.titaniumAlloy, 50, Items.graphite, 20, Items.silicon, 30));

            size = 3;

            consumePowerBuffered(120000f);

            baseExplosiveness = 6f;
        }};
        titaniumAlloyPowerNode = new PowerNode("titaniumAlloyPowerNode") {{
            requirements(Category.power, with(ModItems.titaniumAlloy, 2));

            maxNodes = 20;
            laserRange = 15;
        }};
        titaniumAlloyPowerNodeLarge = new PowerNode("titaniumAlloyPowerNodeLarge") {{
            requirements(Category.power, with(ModItems.titaniumAlloy, 10, Items.silicon, 30, Items.graphite, 10));

            size = 2;
            maxNodes = 30;
            laserRange = 30;
        }};
        titaniumAlloySteamGenerator = new ConsumeGenerator("titaniumAlloySteamGenerator") {{
            requirements(Category.power, with(ModItems.titaniumAlloy, 35, Items.graphite, 30, Items.silicon, 30));
            powerProduction = 1020 / 60f;
            itemDuration = 60f;
            consumeLiquid(Liquids.water, 24/60f);
            hasLiquids = true;
            size = 3;
            generateEffect = Fx.generatespark;

            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.06f;

            consume(new ConsumeItemFlammable());
            consume(new ConsumeItemExplode());
        }};
    }
}
