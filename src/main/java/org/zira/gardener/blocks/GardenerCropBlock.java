package org.zira.gardener.blocks;

import java.util.List;

import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public abstract class GardenerCropBlock extends CropBlock {
    public GardenerCropBlock(Settings settings) {
        super(settings);
    }

    public abstract List<ItemConvertible> cuttedDrop();
}
