package BetterFactory.content.Blocks;

import BetterFactory.API.iHasInit;
import BetterFactory.content.Init.ModItems;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.production.GenericCrafter;

public class BlocksMulti implements iHasInit {
    public static BlockMultiFactory 多线压缩厂;
    public static BlockMultiFactory 多线冶炼厂;
    public static BlockMultiFactory 多线混合厂;
    public static BlockMultiFactory 多线窑炉厂;
    public static BlockMultiFactory 多线压榨厂;
    public static BlockMultiFactory 多线粉碎厂;
    public static BlockMultiFactory 多线熔化厂;
    public static BlockMultiFactory 多线培养厂;
    public static BlockMultiFactory 多线煤炭离心厂;
    public static BlockMultiFactory 多线塑钢厂;
    public static BlockMultiFactory 多线巨浪合金厂;
    public static BlockMultiFactory 多线相织布编织厂;

    @Override
    public void init() {
        多线压缩厂 = new BlockMultiFactory("多线压缩厂", (GenericCrafter) Blocks.graphitePress) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅融合物, 52, Items.graphite, 5));
            this.consumeItem(Items.coal, 8);
        }};
        多线冶炼厂 = new BlockMultiFactory("多线冶炼厂", (GenericCrafter) Blocks.siliconSmelter) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅融合物, 28, Items.graphite, 10, Items.silicon, 5));
            this.consumePower(1.5F);
            this.consumeItems(ItemStack.with(Items.coal, 4, Items.sand, 8));
        }};
        多线混合厂 = new BlockMultiFactory("多线混合厂", (GenericCrafter) Blocks.pyratiteMixer) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅融合物, 36, Items.graphite, 5, Items.pyratite, 5));
            this.consumePower(0.6F);
            this.consumeItems(ItemStack.with(Items.coal, 4, Items.lead, 8, Items.sand, 8));
        }};
        多线窑炉厂 = new BlockMultiFactory("多线窑炉厂", (GenericCrafter) Blocks.kiln) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅融合物, 45, Items.graphite, 30));
            this.consumePower(1.8F);
            this.consumeItems(ItemStack.with(Items.lead, 4, Items.sand, 4));
        }};
        多线压榨厂 = new BlockMultiFactory("多线压榨厂", (GenericCrafter) Blocks.sporePress) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅融合物, 32, Items.graphite, 20));
            this.consumePower(2.1F);
            this.consumeItems(ItemStack.with(Items.sporePod, 4));
        }};
        多线粉碎厂 = new BlockMultiFactory("多线粉碎厂", (GenericCrafter) Blocks.pulverizer) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅融合物, 26, Items.graphite, 10));
            this.consumePower(1.5F);
            this.consumeItems(ItemStack.with(Items.scrap, 4));
        }};
        多线熔化厂 = new BlockMultiFactory("多线熔化厂", (GenericCrafter) Blocks.melter) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅融合物, 32, Items.graphite, 50));
            this.consumePower(3.0F);
            this.consumeItems(ItemStack.with(Items.scrap, 4));
        }};
        多线培养厂 = new BlockMultiFactory("多线培养厂", (GenericCrafter) Blocks.cultivator) {{
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅融合物, 25, Items.silicon, 40, Items.graphite, 40));
            this.consumePower(4.0F);
            this.consumeLiquid(Liquids.water, 1.2F);
        }};
        多线煤炭离心厂 = new BlockMultiFactory("多线煤炭离心厂", (GenericCrafter) Blocks.coalCentrifuge) {{
            this.requirements(Category.crafting, ItemStack.with(Items.titanium, 40, Items.graphite, 60, ModItems.铜铅融合物, 40));
            this.consumePower(2.8F);
            this.consumeLiquid(Liquids.oil, 0.4F);
        }};
        多线塑钢厂 = new BlockMultiFactory("多线塑钢厂", (GenericCrafter) Blocks.plastaniumCompressor) {{
            this.requirements(Category.crafting, ItemStack.with(Items.silicon, 100, ModItems.铜铅融合物, 110, Items.graphite, 70, Items.titanium, 85, Items.plastanium, 5));
            this.consumePower(12.0F);
            this.consumeLiquid(Liquids.oil, 1.0F);
            this.consumeItem(Items.titanium, 8);
        }};
        多线巨浪合金厂 = new BlockMultiFactory("多线巨浪合金厂", (GenericCrafter) Blocks.surgeSmelter) {{
            this.requirements(Category.crafting, ItemStack.with(Items.silicon, 80, ModItems.铜铅融合物, 80, Items.thorium, 70, Items.surgeAlloy, 5));
            this.consumePower(16.0F);
            this.consumeItems(ItemStack.with(Items.copper, 12, Items.lead, 16, Items.titanium, 8, Items.silicon, 12));
        }};
        多线相织布编织厂 = new BlockMultiFactory("多线相织布编织厂", (GenericCrafter) Blocks.phaseWeaver) {{
            this.requirements(Category.crafting, ItemStack.with(Items.silicon, 140, ModItems.铜铅融合物, 120, Items.thorium, 80, Items.phaseFabric, 5));
            this.consumePower(20.0F);
            this.consumeItems(ItemStack.with(Items.thorium, 16, Items.sand, 40));
        }};
    }
}
