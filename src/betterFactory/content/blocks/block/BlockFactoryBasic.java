package betterFactory.content.blocks.block;

import arc.math.Mathf;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.blocks.production.GenericCrafter;

public class BlockFactoryBasic extends GenericCrafter {

    public GenericCrafter parentBlock;

    public BlockFactoryBasic(String name, GenericCrafter ParentBlock, int increaseTheMultiplier) {
        super(name);
        this.parentBlock = ParentBlock;

        // 修改血量
        this.health = getParentHealth(this.parentBlock) * increaseTheMultiplier;
        this.itemCapacity = this.parentBlock.itemCapacity * increaseTheMultiplier;
        this.liquidCapacity = this.parentBlock.liquidCapacity * increaseTheMultiplier;

        // 添加输出物品
        if (this.parentBlock.outputsItems()) {
            ItemStack[] itemStacks = new ItemStack[this.parentBlock.outputItems.length];
            for (int i = 0; i < this.parentBlock.outputItems.length; i++) {
                ItemStack temp = this.parentBlock.outputItems[i].copy();
                temp.amount *= increaseTheMultiplier;
                itemStacks[i] = temp;
            }
            this.outputItems = itemStacks;
        } else if (this.parentBlock.outputItem != null) {
            ItemStack temp = this.parentBlock.outputItem.copy();
            temp.amount *= increaseTheMultiplier;
            this.outputItem = temp;
        }
        // 添加输出流体
        if (this.parentBlock.outputLiquids != null) {
            LiquidStack[] liquidStacks = new LiquidStack[this.parentBlock.outputLiquids.length];
            for (int i = 0; i < this.parentBlock.outputLiquids.length; i++) {
                LiquidStack temp = this.parentBlock.outputLiquids[i].copy();
                temp.amount *= increaseTheMultiplier;
                liquidStacks[i] = temp;
            }
            this.outputLiquids = liquidStacks;
        } else if (this.parentBlock.outputLiquid != null) {
            LiquidStack temp = this.parentBlock.outputLiquid.copy();
            temp.amount *= increaseTheMultiplier;
            this.outputLiquid = temp;
        }
    }

    private static int getParentHealth(GenericCrafter parentBlock) {
        int tempHealth = parentBlock.health;
        if (parentBlock.health == -1) {
            boolean round = false;
            float tempScaledHealth = 40.0F;
            if (parentBlock.scaledHealth < 0.0F) {
                float scaling = 1.0F;
                ItemStack[] var3 = parentBlock.requirements;

                for (ItemStack stack : var3) {
                    scaling += stack.item.healthScaling;
                }

                tempScaledHealth *= scaling;
                round = true;
            }

            tempHealth = round ? Mathf.round((float) (parentBlock.size * parentBlock.size) * tempScaledHealth, 5) : (int) ((float) (parentBlock.size * parentBlock.size) * tempScaledHealth);
        }
        return tempHealth;
    }
}
