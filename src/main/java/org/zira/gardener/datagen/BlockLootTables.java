package org.zira.gardener.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import org.zira.gardener.ModBlocks;
import org.zira.gardener.ModItems;

public class BlockLootTables extends FabricBlockLootTableProvider {

    public BlockLootTables(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.HYACINTH_CROP, drops(ModItems.HYACINTH_SEEDS));
        addDrop(ModBlocks.HYACINTH_FLOWER, drops(ModBlocks.HYACINTH_FLOWER));
        addDrop(ModBlocks.POTTED_HYACINTH_FLOWER, drops(ModBlocks.HYACINTH_FLOWER));
        addDrop(ModBlocks.IRIS_FLOWER, drops(ModBlocks.IRIS_FLOWER));
    }
}