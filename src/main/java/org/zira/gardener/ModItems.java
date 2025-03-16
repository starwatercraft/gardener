package org.zira.gardener;

import java.util.function.Function;

import org.zira.gardener.armor.SyntheticLeatherArmorMaterial;
import org.zira.gardener.items.GardenKnifeItem;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    // ARMOR
    public static final Item SYNTHETIC_HELMET = register(
            "synthetic_helmet",
            settings -> new ArmorItem(SyntheticLeatherArmorMaterial.INSTANCE, EquipmentType.HELMET, settings),
            new Item.Settings()
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(SyntheticLeatherArmorMaterial.BASE_DURABILITY)));

    public static final Item SYNTHETIC_CHESTPLATE = register(
            "synthetic_chestplate",
            settings -> new ArmorItem(SyntheticLeatherArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE, settings),
            new Item.Settings()
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(SyntheticLeatherArmorMaterial.BASE_DURABILITY)));

    public static final Item SYNTHETIC_LEGGINGS = register(
            "synthetic_leggings",
            settings -> new ArmorItem(SyntheticLeatherArmorMaterial.INSTANCE, EquipmentType.LEGGINGS, settings),
            new Item.Settings()
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(SyntheticLeatherArmorMaterial.BASE_DURABILITY)));

    public static final Item SYNTHETIC_BOOTS = register(
            "synthetic_boots",
            settings -> new ArmorItem(SyntheticLeatherArmorMaterial.INSTANCE, EquipmentType.BOOTS, settings),
            new Item.Settings()
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(SyntheticLeatherArmorMaterial.BASE_DURABILITY)));
    //

    public static final Item GARDEN_KNIFE = register(
            "garden_knife",
            settings -> new GardenKnifeItem(settings),
            new Item.Settings().maxDamage(250));

    public static final Item HYACINTH_SEEDS = register("hyacinth_seed",
            ModBlocks.HYACINTH_CROP, new Item.Settings().maxCount(64));

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GardenerReference.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static Item register(String name, Block block, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GardenerReference.MOD_ID, name));

        BlockItem item = new BlockItem(block, settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the
        // ingredients group.

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> itemGroup.addAfter(Items.TORCHFLOWER_SEEDS, ModItems.HYACINTH_SEEDS));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.addAfter(Items.STONE_HOE, ModItems.GARDEN_KNIFE));
    }
}