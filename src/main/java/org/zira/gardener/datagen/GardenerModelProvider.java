// package org.zira.gardener.datagen;

// import org.zira.gardener.GardenerReference;
// import org.zira.gardener.ModItems;

// import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
// import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
// import net.minecraft.client.data.BlockStateModelGenerator;
// import net.minecraft.client.data.ItemModelGenerator;
// import net.minecraft.registry.RegistryKey;
// import net.minecraft.util.Identifier;

// public class GardenerModelProvider extends FabricModelProvider {
//     public GardenerModelProvider(FabricDataOutput output) {
//         super(output);
//     }

//     @Override
//     public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

//     }

//     @Override
//     public void generateItemModels(ItemModelGenerator itemModelGenerator) {
//         itemModelGenerator.registerArmor(ModItems.WOLF_LEATHER_HELMET,
//                 RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")),
//                         Identifier.of(GardenerReference.MOD_ID, "wolf_leather")),
//                 "helmet", false);
//         itemModelGenerator.registerArmor(ModItems.WOLF_LEATHER_CHESTPLATE,
//                 RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")),
//                         Identifier.of(GardenerReference.MOD_ID, "wolf_leather")),
//                 "chestplate", false);
//         itemModelGenerator.registerArmor(ModItems.WOLF_LEATHER_LEGGINGS,
//                 RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")),
//                         Identifier.of(GardenerReference.MOD_ID, "wolf_leather")),
//                 "leggings", false);
//         itemModelGenerator.registerArmor(ModItems.WOLF_LEATHER_BOOTS,
//                 RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")),
//                         Identifier.of(GardenerReference.MOD_ID, "wolf_leather")),
//                 "boots", false);
//     }
// }
