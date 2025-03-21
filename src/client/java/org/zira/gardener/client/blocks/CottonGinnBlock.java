package org.zira.gardener.client.blocks;

import java.util.Set;

import org.jetbrains.annotations.Nullable;
import org.zira.gardener.GardenerBlockEntities;
import org.zira.gardener.ModBlocks;
import org.zira.gardener.client.blocks.*;

import com.mojang.serialization.MapCodec;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;

public class CottonGinnBlock extends BlockWithEntity {    
    public CottonGinnBlock(Settings settings){
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CottonGinnBlockEntity(pos, state);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

//     @Nullable
// 	@Override
//    public BlockState getPlacementState(ItemPlacementContext ctx) {
//       return this.getDefaultState().getFluidState()
//    }


// 	public BlockState getStateForPlacement(BlockPlaceContext context) {
// 		return defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
// 	}
}
