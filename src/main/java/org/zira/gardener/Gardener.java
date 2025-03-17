package org.zira.gardener;

import net.fabricmc.api.ModInitializer;

public class Gardener implements ModInitializer {

    @Override
    public void onInitialize() {
        ModItems.initialize();
        ModBlocks.initialize();
    }
}