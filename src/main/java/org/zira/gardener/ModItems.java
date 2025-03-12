package org.zira.gardener;

import java.util.function.Function;

import org.zira.gardener.blocks.HyacinthCropBlock;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item HYACINTH_FLOWER = register("hyacinth_flower", Item::new,
            new Item.Settings().maxCount(16));

    public static final Block HYACINTH_CROP = register("hyacinth_crop", HyacinthCropBlock::new,
            HyacinthCropBlock.Settings
                    .create().nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));

    public static final Item HYACINTH_SEEDS = register("hyacinth_seed",
            HYACINTH_CROP, new Item.Settings().maxCount(64));

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FabricDocsReference.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static Item register(String name, Block block, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FabricDocsReference.MOD_ID, name));

        BlockItem item = new BlockItem(block, settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory,
            AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of("tutorial", path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the
        // ingredients group.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> itemGroup.addAfter(Items.TORCHFLOWER, ModItems.HYACINTH_FLOWER));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> itemGroup.addAfter(Items.TORCHFLOWER_SEEDS, ModItems.HYACINTH_SEEDS));
    }
}