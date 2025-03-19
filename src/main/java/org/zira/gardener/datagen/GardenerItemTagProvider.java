package org.zira.gardener.datagen;

import java.util.concurrent.CompletableFuture;

import org.zira.gardener.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.ItemTags;

public class GardenerItemTagProvider extends FabricTagProvider.ItemTagProvider{
    public GardenerItemTagProvider(FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(WrapperLookup wrapperLookup) {
                getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                // .add(ModItems.WOLF_LEATHER_HELMET)
                .add(ModItems.WOLF_LEATHER_CHESTPLATE)
                .add(ModItems.WOLF_LEATHER_LEGGINGS)
                .add(ModItems.WOLF_LEATHER_BOOTS);
    }

}
