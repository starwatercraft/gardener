package org.zira.gardener.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.util.Identifier;
import org.zira.gardener.GardenerReference;
import org.zira.gardener.ModBlocks;
import org.zira.gardener.ModItems;
import org.zira.gardener.armor.GardenerArmorMaterials;
import software.bernie.geckolib.GeckoLib;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.service.GeckoLibNetworking;

public class GardenerClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HYACINTH_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HYACINTH_FLOWER);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.POTTED_HYACINTH_FLOWER);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.IRIS_FLOWER);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.POTTED_IRIS_FLOWER);

        ModItems.register(
                "wolfleather_helmet",
                settings ->
                        new WolfLeatherArmorItem(GardenerArmorMaterials.WOLF_LEATHER_ARMOR_MATERIAL, EquipmentType.HELMET, settings),
                new Item.Settings());
    }

}