package org.zira.gardener.items;

import org.zira.gardener.blocks.GardenerCropBlock;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;

public class GardenKnifeItem extends SwordItem {

    public GardenKnifeItem(Settings settings) {
        super(ToolMaterial.STONE, 1f, -2f, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        var blockPos = context.getBlockPos();
        var blockState = context.getWorld().getBlockState(blockPos);
        var block = blockState.getBlock();
        //add log to check block class
        if (GardenerCropBlock.class.isAssignableFrom(block.getClass())) {
            var age = blockState.get(GardenerCropBlock.AGE);
            var gardenerCropBlock = (GardenerCropBlock) block;
            if (age == gardenerCropBlock.getMaxAge()) {
                var newState = blockState.with(GardenerCropBlock.AGE, 0);
                context.getWorld().setBlockState(blockPos, newState);
                //add log what drop is
                System.out.println(gardenerCropBlock.cuttedDrop());
                var drop = gardenerCropBlock.cuttedDrop();
                var world = context.getWorld();
                if (!world.isClient) {
                    for (ItemConvertible item : drop) {
                        var dropItem = new ItemStack(item, 1);
                        ItemScatterer.spawn(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), dropItem);
                    }
                }
                
                context.getStack().damage(1, context.getPlayer());
                return ActionResult.SUCCESS;
            }

        }
        return super.useOnBlock(context);
    }

    // @Override
    // public BlockState onBreak(World world, BlockPos pos, BlockState state,
    // PlayerEntity player) {

    // // Отримуємо предмет у руці гравця
    // ItemStack heldItem = player.getHandItems().iterator().next();

    // // Перевіряємо, чи це gardener:garden_knife
    // if (heldItem.getItem() == ModItems.GARDEN_KNIFE) {
    // // Перевіряємо, чи рослина на максимальній стадії росту
    // if (state.get(AGE) == MAX_AGE) {
    // // Оновлюємо блок: скидаємо до 0-ї стадії росту
    // BlockState blockState = getDefaultState().with(AGE, 0);
    // world.setBlockState(pos, blockState);
    // heldItem.damage(1, player);
    // return blockState;
    // }
    // }
    // return super.onBreak(world, pos, state, player);
    // }

}
