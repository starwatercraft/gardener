package org.zira.gardener.armor;

import java.util.EnumMap;

import org.zira.gardener.GardenerReference;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class GardenerArmorMaterials {
    public static final RegistryKey<ArmorMaterial> WOLF_LEATHER_KEY = RegistryKey.of(
            RegistryKey.ofRegistry(Identifier.of(GardenerReference.MOD_ID, "armor_material")),
            Identifier.of(GardenerReference.MOD_ID, "wolf_leather"));

    public static final ArmorMaterial WOLF_LEATHER_ARMOR_MATERIAL = new ArmorMaterial(5,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 1);
                map.put(EquipmentType.LEGGINGS, 2);
                map.put(EquipmentType.CHESTPLATE, 3);
                map.put(EquipmentType.HELMET, 1);
                map.put(EquipmentType.BODY, 3);
            }), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, ItemTags.REPAIRS_LEATHER_ARMOR,
            RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")),
                    Identifier.of(GardenerReference.MOD_ID, "wolf_leather")));
}