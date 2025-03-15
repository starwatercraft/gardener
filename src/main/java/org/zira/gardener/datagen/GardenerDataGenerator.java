package org.zira.gardener.datagen;

import org.zira.gardener.GardenerReference;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.util.Identifier;

public class GardenerDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createBuiltinResourcePack(Identifier.of(GardenerReference.MOD_ID));

        pack.addProvider(BlockLootTables::new);
    }
}
