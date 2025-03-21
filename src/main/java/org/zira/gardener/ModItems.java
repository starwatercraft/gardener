package org.zira.gardener;

import java.util.function.Function;

import org.zira.gardener.items.GardenKnifeItem;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    // Tools
    public static final Item GARDEN_KNIFE = register(
            "garden_knife",
            settings -> new GardenKnifeItem(settings),
            new Item.Settings().maxDamage(250));
    
    //Plants
    public static final Item UNPROCESSED_COTTON = register("unprocessed_cotton",
    Item::new, new Item.Settings().maxCount(64));

    // Seeds Crops
    public static final Item COTTON_SEEDS = register("cotton_seed",
            ModBlocks.COTTON_CROP, new Item.Settings().maxCount(64));

    public static final Item HYACINTH_SEEDS = register("hyacinth_seed",
            ModBlocks.HYACINTH_CROP, new Item.Settings().maxCount(64));

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM,
                Identifier.of(GardenerReference.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static Item register(String name, Block block, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM,
                Identifier.of(GardenerReference.MOD_ID, name));

        BlockItem item = new BlockItem(block, settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
    }
}