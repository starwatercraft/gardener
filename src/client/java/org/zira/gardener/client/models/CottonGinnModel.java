package org.zira.gardener.client.models;

import org.jetbrains.annotations.Nullable;
import org.zira.gardener.GardenerReference;
import org.zira.gardener.client.blocks.CottonGinnBlockEntity;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class CottonGinnModel extends GeoModel<CottonGinnBlockEntity> {
    @Override
    public Identifier getModelResource(CottonGinnBlockEntity animatable,
            @Nullable GeoRenderer<CottonGinnBlockEntity> renderer) {
        return Identifier.of(GardenerReference.MOD_ID, "geo/cotton_gin.geo.json");
    }

    @Override
    public Identifier getTextureResource(CottonGinnBlockEntity animatable,
            @Nullable GeoRenderer<CottonGinnBlockEntity> renderer) {
                return Identifier.of(GardenerReference.MOD_ID, "textures/block/cotton_gin.png");
    }

    @Override
    public Identifier getAnimationResource(CottonGinnBlockEntity animatable) {
        return Identifier.of(GardenerReference.MOD_ID, "animations/cotton_gin.animation.json");
    }
    
}
