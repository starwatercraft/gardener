package org.zira.gardener.blocks;

import static net.minecraft.data.DataProvider.LOGGER;

import org.zira.gardener.ModBlocks;
import org.zira.gardener.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class HyacinthCropBlock extends CropBlock {
    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[] {
            Block.createCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 5.0D, 10.0D),
            Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D),
            Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D),
            Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D)
    };

    public static final int MAX_AGE = 3;

    public HyacinthCropBlock(Settings settings) {
        super(settings);
    };

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {

        // Отримуємо предмет у руці гравця
        ItemStack heldItem = player.getHandItems().iterator().next();

        // Перевіряємо, чи це gardener:garden_knife
        if (heldItem.getItem() == ModItems.GARDEN_KNIFE) {
            // Перевіряємо, чи рослина на максимальній стадії росту
            if (state.get(AGE) == MAX_AGE) {
                // Оновлюємо блок: скидаємо до 0-ї стадії росту
                BlockState blockState = getDefaultState().with(AGE, 0);
                world.setBlockState(pos, blockState);
                heldItem.damage(1, player);
                return blockState;
            }
        }
        return super.onBreak(world, pos, state, player);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.HYACINTH_SEEDS;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[getAge(state)];
    }

    @Override
    protected int getGrowthAmount(World world) {
        return 1;
    }
}
