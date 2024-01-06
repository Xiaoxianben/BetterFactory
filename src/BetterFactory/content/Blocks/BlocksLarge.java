package BetterFactory.content.Blocks;

import BetterFactory.API.iHasInit;
import BetterFactory.content.Init.ModItems;
import BetterFactory.content.Init.ModLiquids;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.blocks.production.GenericCrafter;

public class BlocksLarge implements iHasInit {
    public static BlockLargeFactory 大型压缩厂;
    public static BlockLargeFactory 大型冶炼厂;
    public static BlockLargeFactory 大型混合厂;
    public static BlockLargeFactory 大型窑炉厂;
    public static BlockLargeFactory 大型压榨厂;
    public static BlockLargeFactory 大型粉碎厂;
    public static BlockLargeFactory 大型熔化厂;
    public static BlockLargeFactory 大型培养厂;
    public static BlockMultiFactory 大型煤炭离心厂;
    public static BlockMultiFactory 大型塑钢厂;
    public static BlockMultiFactory 大型巨浪合金厂;
    public static BlockMultiFactory 大型相织布编织厂;

    @Override
    public void init() {
        大型压缩厂 = new BlockLargeFactory("大型压缩厂", (GenericCrafter) Blocks.graphitePress) {{
            this.hasLiquids = false;
            this.hasItems = true;
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅合金, 52, Items.graphite, 10));
            this.consumePower(1.0F);
            this.consumeItem(Items.coal, 8);
        }};
        大型冶炼厂 = new BlockLargeFactory("大型冶炼厂", (GenericCrafter) Blocks.siliconSmelter) {{
            this.hasLiquids = false;
            this.hasItems = true;
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅合金, 28, Items.graphite, 25, Items.silicon, 20));
            this.consumePower(2.5F);
            this.consumeItems(ItemStack.with(Items.sand, 8));
        }};
        大型混合厂 = new BlockLargeFactory("大型混合厂", (GenericCrafter) Blocks.pyratiteMixer) {{
            this.hasLiquids = false;
            this.hasItems = true;
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅合金, 36, Items.graphite, 15, Items.pyratite, 20));
            this.consumePower(1.0F);
            this.consumeItems(ItemStack.with(Items.coal, 4, Items.sand, 8));
        }};
        大型窑炉厂 = new BlockLargeFactory("大型窑炉厂", (GenericCrafter) Blocks.kiln) {{
            this.hasLiquids = false;
            this.hasItems = true;
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅合金, 45, Items.graphite, 45));
            this.consumePower(2.5F);
            this.consumeItems(ItemStack.with(Items.sand, 4));
        }};
        大型压榨厂 = new BlockLargeFactory("大型压榨厂", (GenericCrafter) Blocks.sporePress) {{
            this.hasLiquids = true;
            this.hasItems = true;
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅合金, 32, Items.graphite, 30));
            this.consumePower(3.0F);
            this.consumeItems(ItemStack.with(Items.sporePod, 4));
        }};
        大型粉碎厂 = new BlockLargeFactory("大型粉碎厂", (GenericCrafter) Blocks.pulverizer) {{
            this.hasLiquids = false;
            this.hasItems = true;
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅合金, 26, Items.graphite, 30));
            this.consumePower(2.5F);
            this.consumeItems(ItemStack.with(Items.scrap, 4));
        }};
        大型熔化厂 = new BlockLargeFactory("大型熔化厂", (GenericCrafter) Blocks.melter) {{
            this.hasLiquids = true;
            this.hasItems = true;
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅合金, 32, Items.graphite, 80));
            this.consumePower(4.0F);
            this.consumeItems(ItemStack.with(Items.scrap, 4));
        }};
        大型培养厂 = new BlockLargeFactory("大型培养厂", (GenericCrafter) Blocks.cultivator) {{
            this.hasLiquids = true;
            this.hasItems = true;
            this.requirements(Category.crafting, ItemStack.with(ModItems.铜铅合金, 25, Items.silicon, 50, Items.graphite, 60));
            this.consumePower(4.0F);
            this.consumeLiquid(Liquids.water, 1.2F);
        }};
        大型煤炭离心厂 = new BlockMultiFactory("大型煤炭离心厂", (GenericCrafter) Blocks.coalCentrifuge) {{
            this.hasLiquids = true;
            this.hasItems = false;
            this.hasPower = true;
            this.requirements(Category.crafting, ItemStack.with(Items.titanium, 45, Items.graphite, 60, ModItems.铜铅合金, 40));
            this.consumePower(3.0F);
            this.consumeLiquid(Liquids.oil, 0.4F);
        }};
        大型塑钢厂 = new BlockMultiFactory("大型塑钢厂", (GenericCrafter) Blocks.plastaniumCompressor) {{
            this.hasLiquids = true;
            this.hasItems = true;
            this.hasPower = true;
            this.requirements(Category.crafting, ItemStack.with(Items.silicon, 100, ModItems.铜铅合金, 120, Items.graphite, 80, Items.titanium, 85, Items.plastanium, 10));
            this.consumePower(12.0F);
            this.consumeLiquid(Liquids.oil, 1.0F);
            this.consumeItem(Items.titanium, 8);
        }};
        大型巨浪合金厂 = new BlockMultiFactory("大型巨浪合金厂", (GenericCrafter) Blocks.surgeSmelter) {{
            this.hasLiquids = true;
            this.hasItems = true;
            this.hasPower = true;
            this.requirements(Category.crafting, ItemStack.with(Items.silicon, 80, ModItems.铜铅合金, 80, Items.thorium, 80, Items.surgeAlloy, 10));
            this.consumePower(16.0F);
            this.consumeLiquids(LiquidStack.with(ModLiquids.铜铅溶液, 0.5));
            this.consumeItems(ItemStack.with(Items.titanium, 10, Items.silicon, 12));
        }};
        大型相织布编织厂 = new BlockMultiFactory("大型相织布编织厂", (GenericCrafter) Blocks.phaseWeaver) {{
            this.hasLiquids = false;
            this.hasItems = true;
            this.hasPower = true;
            this.requirements(Category.crafting, ItemStack.with(Items.silicon, 150, ModItems.铜铅合金, 120, Items.thorium, 80, Items.phaseFabric, 10));
            this.consumePower(20.0F);
            this.consumeItems(ItemStack.with(Items.thorium, 16, Items.sand, 40));
        }};
    }
}
