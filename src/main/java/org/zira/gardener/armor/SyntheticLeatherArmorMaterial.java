package org.zira.gardener.armor;

import java.util.Map;

import org.zira.gardener.GardenerReference;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class SyntheticLeatherArmorMaterial {
    public static final int BASE_DURABILITY = 215;

    public static final RegistryKey<EquipmentAsset> SYNTHETIC_ARMOR_MATERIAL_KEY = RegistryKey
            .of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(GardenerReference.MOD_ID, "synthetic"));

    public static final TagKey<Item> REPAIRS_SYNTHETIC_ARMOR = TagKey.of(RegistryKeys.ITEM,
            Identifier.of(GardenerReference.MOD_ID, "synthetic"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            REPAIRS_SYNTHETIC_ARMOR,
            SYNTHETIC_ARMOR_MATERIAL_KEY);
}
