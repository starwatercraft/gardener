package org.zira.gardener;

import java.util.function.Function;

import org.zira.gardener.blocks.IrisFlowerBlock;
import org.zira.gardener.blocks.HyacinthCropBlock;
import org.zira.gardener.blocks.HyacinthFlowerBlock;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block HYACINTH_FLOWER = register("hyacinth_flower", HyacinthFlowerBlock::new,
            HyacinthFlowerBlock.Settings
                    .create().nonOpaque().noCollision().breakInstantly()
                    .sounds(BlockSoundGroup.GRASS));

    public static final Block IRIS_FLOWER = register("iris_flower", IrisFlowerBlock::new,
            IrisFlowerBlock.Settings
                    .create().nonOpaque().noCollision().breakInstantly()
                    .sounds(BlockSoundGroup.GRASS));

    public static final Block POTTED_IRIS_FLOWER = registerPotBlock("potted_iris_flower", IRIS_FLOWER,
            Block.Settings.copy(Blocks.POTTED_ALLIUM).nonOpaque());

    public static final Block POTTED_HYACINTH_FLOWER = registerPotBlock("potted_hyacinth_flower", HYACINTH_FLOWER,
            Block.Settings.copy(Blocks.POTTED_ALLIUM).nonOpaque());

    public static final Block HYACINTH_CROP = register("hyacinth_crop", HyacinthCropBlock::new,
            HyacinthCropBlock.Settings
                    .create().nonOpaque().noCollision().ticksRandomly().breakInstantly()
                    .sounds(BlockSoundGroup.CROP));

    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory,
            AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of("gardener", path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }

    // return register(id, (settings) -> {
    // return new BedBlock(color, settings);
    // }, Settings.create().mapColor((state) -> {

    public static Block registerPotBlock(String name, Block block, Block.Settings settings) {
        final Identifier identifier = Identifier.of("gardener", name);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        // Use Blocks.register instead of Registry.register
        return Blocks.register(registryKey, (blockSettings) -> new FlowerPotBlock(block, blockSettings),
                settings);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.TORCHFLOWER, ModBlocks.HYACINTH_FLOWER);
                    itemGroup.addAfter(ModBlocks.HYACINTH_FLOWER, ModBlocks.IRIS_FLOWER);
                });
    }
}
