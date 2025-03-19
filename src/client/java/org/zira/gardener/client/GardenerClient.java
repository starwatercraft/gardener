package org.zira.gardener.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import org.zira.gardener.ModBlocks;
import org.zira.gardener.ModItems;
import org.zira.gardener.armor.GardenerArmorMaterials;

public class GardenerClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HYACINTH_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HYACINTH_FLOWER);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.POTTED_HYACINTH_FLOWER);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.IRIS_FLOWER);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.POTTED_IRIS_FLOWER);

        ModItems.register(
                "wolf_leather_helmet",
                settings -> new WolfLeatherArmorItem(GardenerArmorMaterials.WOLF_LEATHER_ARMOR_MATERIAL,
                        EquipmentType.HELMET, settings),
                new Item.Settings());
        ModItems.register(
                "wolf_leather_chestplate",
                settings -> new WolfLeatherArmorItem(GardenerArmorMaterials.WOLF_LEATHER_ARMOR_MATERIAL,
                        EquipmentType.CHESTPLATE, settings),
                new Item.Settings());
        ModItems.register(
                "wolf_leather_leggings",
                settings -> new WolfLeatherArmorItem(GardenerArmorMaterials.WOLF_LEATHER_ARMOR_MATERIAL,
                        EquipmentType.LEGGINGS, settings),
                new Item.Settings());
        ModItems.register(
                "wolf_leather_boots",
                settings -> new WolfLeatherArmorItem(GardenerArmorMaterials.WOLF_LEATHER_ARMOR_MATERIAL,
                        EquipmentType.BOOTS, settings),
                new Item.Settings());
    }
}