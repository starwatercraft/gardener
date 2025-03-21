package org.zira.gardener.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

import org.zira.gardener.GardenerBlockEntities;
import org.zira.gardener.GardenerReference;
import org.zira.gardener.ModBlocks;
import org.zira.gardener.ModItems;
import org.zira.gardener.armor.GardenerArmorMaterials;
import org.zira.gardener.client.items.*;
import org.zira.gardener.client.blocks.*;
import org.zira.gardener.client.renderers.CottonGinnRenderer;

public class GardenerClient implements ClientModInitializer {

    public static final Block COTTON_GIN = ModBlocks.register("cotton_gin", CottonGinnBlock::new,
            AbstractBlock.Settings
                    .create().nonOpaque().noCollision().breakInstantly()
                    .sounds(BlockSoundGroup.WOOD));

    public static final BlockEntityType<CottonGinnBlockEntity> COTTON_GIN_ENTITY = GardenerBlockEntities.register(
            "cotton_gin",
            // For versions 1.21.2 and above,
            // replace `BlockEntityType.Builder` with `FabricBlockEntityTypeBuilder`.
            FabricBlockEntityTypeBuilder.create(CottonGinnBlockEntity::new, COTTON_GIN).build());

    public static final Item WolfLeatherHelmet = ModItems.register(
            "wolf_leather_helmet",
            settings -> new WolfLeatherArmorItem(GardenerArmorMaterials.WOLF_LEATHER_ARMOR_MATERIAL,
                    EquipmentType.HELMET, settings),
            new Item.Settings());
    public static final Item WolfLeatherChestplate = ModItems.register(
            "wolf_leather_chestplate",
            settings -> new WolfLeatherArmorItem(GardenerArmorMaterials.WOLF_LEATHER_ARMOR_MATERIAL,
                    EquipmentType.CHESTPLATE, settings),
            new Item.Settings());
    public static final Item WolfLeatherLeggings = ModItems.register(
            "wolf_leather_leggings",
            settings -> new WolfLeatherArmorItem(GardenerArmorMaterials.WOLF_LEATHER_ARMOR_MATERIAL,
                    EquipmentType.LEGGINGS, settings),
            new Item.Settings());
    public static final Item WolfLeatherBoots = ModItems.register(
            "wolf_leather_boots",
            settings -> new WolfLeatherArmorItem(GardenerArmorMaterials.WOLF_LEATHER_ARMOR_MATERIAL,
                    EquipmentType.BOOTS, settings),
            new Item.Settings());

    @Override
    public void onInitializeClient() {
        ItemGroup.Builder itemGroupCropsBuilder = FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModBlocks.IRIS_FLOWER))
                .displayName(Text.translatable("itemGroup.gardener.crops"));

        ItemGroup.Builder itemGroupMainBuilder = FabricItemGroup.builder()
                .icon(() -> new ItemStack(WolfLeatherHelmet))
                .displayName(Text.translatable("itemGroup.gardener.main"));

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HYACINTH_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.COTTON_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HYACINTH_FLOWER);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.POTTED_HYACINTH_FLOWER);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.IRIS_FLOWER);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.POTTED_IRIS_FLOWER);

        BlockEntityRendererFactories.register(COTTON_GIN_ENTITY, context -> new CottonGinnRenderer());

        itemGroupCropsBuilder.entries((context, entries) -> {
            entries.add(ModBlocks.HYACINTH_FLOWER);
            entries.add(ModBlocks.IRIS_FLOWER);
            entries.add(ModItems.UNPROCESSED_COTTON);
            entries.add(ModItems.HYACINTH_SEEDS);
            entries.add(ModItems.COTTON_SEEDS);
        });

        itemGroupMainBuilder.entries((context, entries) -> {
            entries.add(ModItems.GARDEN_KNIFE);
            entries.add(WolfLeatherHelmet);
            entries.add(WolfLeatherChestplate);
            entries.add(WolfLeatherLeggings);
            entries.add(WolfLeatherBoots);
        });

        ItemGroup itemGroupCrops = itemGroupCropsBuilder.build();
        ItemGroup itemGroupMain = itemGroupMainBuilder.build();

        Registry.register(Registries.ITEM_GROUP, Identifier.of(GardenerReference.MOD_ID, "crop_seeds"), itemGroupCrops);
        Registry.register(Registries.ITEM_GROUP, Identifier.of(GardenerReference.MOD_ID, "main"), itemGroupMain);

    }
}