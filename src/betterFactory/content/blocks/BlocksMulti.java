package betterFactory.content.blocks;

import betterFactory.api.IHasInit;
import betterFactory.content.blocks.block.BlockMultiFactory;
import betterFactory.init.ModItems;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.Separator;

import static mindustry.type.ItemStack.with;

public class BlocksMulti implements IHasInit {
    public static Block
        // crafting
            multiGraphitePressFactory, multiSiliconSmelterFactory, multiPyratiteFactory, multiKilnFactory, multiSporePressFactory,
            multiPulverizerFactory, multiMelterFactory, multiBlastFactory, multiSeparatorFactory, multiCoalCentrifugeFactory,
            multiPlastaniumFactory, multiCryoffluidFactory, multiPhaseFactory, multiSurgeFactory,
        // production
        multiCultivatorFactory;

    @Override
    public void init() {
        multiGraphitePressFactory = new BlockMultiFactory("multi-graphite-press", (GenericCrafter) Blocks.graphitePress) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.copperLeadAlloys, 50, Items.graphite, 20));
            this.consumeItem(Items.coal, 4);
        }};
        multiSiliconSmelterFactory = new BlockMultiFactory("multi-silicon-smelter", (GenericCrafter) Blocks.siliconSmelter) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.copperLeadAlloys, 25, Items.graphite, 10, Items.silicon, 5));
            this.consumePower(1);
            this.consumeItems(ItemStack.with(Items.coal, 2, Items.sand, 4));
        }};
        multiPyratiteFactory = new BlockMultiFactory("multi-pyratite-mixer", (GenericCrafter) Blocks.pyratiteMixer) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.copperLeadAlloys, 40, Items.graphite, 5, Items.pyratite, 5));
            this.consumePower(0.4F);
            this.consumeItems(ItemStack.with(Items.coal, 2, Items.lead, 4, Items.sand, 4));
        }};
        multiKilnFactory = new BlockMultiFactory("multi-kiln", (GenericCrafter) Blocks.kiln) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.copperLeadAlloys, 45, Items.graphite, 30, Items.metaglass, 5));
            this.consumePower(1.2F);
            this.consumeItems(ItemStack.with(Items.lead, 2, Items.sand, 2));
        }};
        multiSporePressFactory = new BlockMultiFactory("multi-spore-press", (GenericCrafter) Blocks.sporePress) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.copperLeadAlloys, 32, Items.graphite, 20));
            this.consumePower(1.4F);
            this.consumeItems(ItemStack.with(Items.sporePod, 2));
        }};
        multiPulverizerFactory = new BlockMultiFactory("multi-pulverizer", (GenericCrafter) Blocks.pulverizer) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.copperLeadAlloys, 26, Items.graphite, 10));
            this.consumePower(1.0F);
            this.consumeItems(ItemStack.with(Items.scrap, 2));
        }};
        multiMelterFactory = new BlockMultiFactory("multi-melter", (GenericCrafter) Blocks.melter) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.copperLeadAlloys, 32, Items.graphite, 50));
            this.consumePower(2);
            this.consumeItems(ItemStack.with(Items.scrap, 2));
        }};
        multiBlastFactory = new BlockMultiFactory("multi-blast-mixer", (GenericCrafter) Blocks.blastMixer) {{
            requirements(Category.crafting, with(ModItems.copperLeadAlloys, 30, Items.titanium, 30));
            consumePower(0.8f);
            consumeItems(with(Items.pyratite, 2, Items.sporePod, 2));
        }};
        multiSeparatorFactory = new Separator("multi-separator") {{
            requirements(Category.crafting, with(ModItems.copperLeadAlloys, 30, Items.titanium, 30));
            results = with(
                    Items.copper, 10,
                    Items.lead, 6,
                    Items.graphite, 4,
                    Items.titanium, 4
            );
            hasPower = true;
            craftTime = 35f;
            size = 3;

            consumePower(2.2f);
            consumeLiquid(Liquids.slag, 8f / 60f);
        }};
        multiCoalCentrifugeFactory = new BlockMultiFactory("multi-coal-centrifuge", (GenericCrafter) Blocks.coalCentrifuge) {{
            this.requirements(Category.crafting, ItemStack.with(Items.titanium, 40, Items.graphite, 60, ModItems.copperLeadAlloys, 40));
            this.consumePower(1.4F);
            this.consumeLiquid(Liquids.oil, 0.2F);
        }};
        multiPlastaniumFactory = new BlockMultiFactory("multi-plastanium-compressor", (GenericCrafter) Blocks.plastaniumCompressor) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.copperLeadAlloys, 110, Items.silicon, 100, Items.graphite, 70, Items.titanium, 85, Items.plastanium, 5));
            this.consumePower(6);
            this.consumeLiquid(Liquids.oil, 0.5F);
            this.consumeItem(Items.titanium, 4);
        }};
        multiCryoffluidFactory = new BlockMultiFactory("multi-cryofluid-mixer", (GenericCrafter) Blocks.cryofluidMixer) {{
            requirements(Category.crafting, with(ModItems.copperLeadAlloys, 65, Items.silicon, 50, Items.titanium, 60));

            consumePower(2f);
            consumeItem(Items.titanium, 2);
            consumeLiquid(Liquids.water, 12f * 2 / 60f);
        }};
        multiPhaseFactory = new BlockMultiFactory("multi-phase-weaver", (GenericCrafter) Blocks.phaseWeaver) {{
            this.requirements(Category.crafting, ItemStack.with(Items.silicon, 130, ModItems.copperLeadAlloys, 120, Items.thorium, 80, Items.phaseFabric, 5));
            this.consumePower(10);
            this.consumeItems(ItemStack.with(Items.thorium, 8, Items.sand, 20));
        }};
        multiSurgeFactory = new BlockMultiFactory("multi-surge-smelter", (GenericCrafter) Blocks.surgeSmelter) {{
            this.requirements(Category.crafting, ItemStack.with(Items.silicon, 80, ModItems.copperLeadAlloys, 80, Items.thorium, 70, Items.surgeAlloy, 5));
            this.consumePower(8);
            this.consumeItems(ItemStack.with(Items.copper, 6, Items.lead, 8, Items.titanium, 4, Items.silicon, 6));
        }};

        multiCultivatorFactory = new BlockMultiFactory("multi-cultivator", (GenericCrafter) Blocks.cultivator) {{
            this.requirements(Category.production, ItemStack.with(ModItems.copperLeadAlloys, 25, Items.silicon, 40, Items.graphite, 40));
            this.consumePower(80 * 2 / 60f);
            this.consumeLiquid(Liquids.water, 18 * 2 / 60f);
        }};
    }
}
