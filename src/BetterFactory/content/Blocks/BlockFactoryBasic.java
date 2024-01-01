package BetterFactory.content.Blocks;

import arc.math.Mathf;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.blocks.production.GenericCrafter;

public class BlockFactoryBasic extends GenericCrafter {

    public GenericCrafter ParentBlock;
    public int 增加倍率;

    public BlockFactoryBasic(String name, GenericCrafter ParentBlock, int 增加倍率) {
        super(name);
        this.ParentBlock = ParentBlock;
        this.增加倍率 = 增加倍率;

        // 修改血量
        this.health = getParentHealth(this.ParentBlock) * 增加倍率;
        this.itemCapacity = this.ParentBlock.itemCapacity * 增加倍率;

        // 添加输出物品
        if (this.ParentBlock.outputsItems()) {
            ItemStack[] itemStacks = new ItemStack[this.ParentBlock.outputItems.length];
            for (int i = 0; i < this.ParentBlock.outputItems.length; i++) {
                ItemStack temp = this.ParentBlock.outputItems[i].copy();
                temp.amount *= 增加倍率;
                itemStacks[i] = temp;
            }
            this.outputItems = itemStacks;
        } else if (this.ParentBlock.outputItem != null) {
            ItemStack temp = this.ParentBlock.outputItem.copy();
            temp.amount *= 增加倍率;
            this.outputItem = temp;
        }
        // 添加输出流体
        if (this.ParentBlock.outputLiquids != null) {
            LiquidStack[] liquidStacks = new LiquidStack[this.ParentBlock.outputLiquids.length];
            for (int i = 0; i < this.ParentBlock.outputLiquids.length; i++) {
                LiquidStack temp = this.ParentBlock.outputLiquids[i].copy();
                temp.amount *= 增加倍率;
                liquidStacks[i] = temp;
            }
            this.outputLiquids = liquidStacks;
        } else if (this.ParentBlock.outputLiquid != null) {
            LiquidStack temp = this.ParentBlock.outputLiquid.copy();
            temp.amount *= 增加倍率;
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
