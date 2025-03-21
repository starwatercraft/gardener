package org.zira.gardener.client.models;

import org.jetbrains.annotations.Nullable;
import org.zira.gardener.GardenerReference;
import org.zira.gardener.client.items.WolfLeatherArmorItem;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class WolfLeatherArmorModel extends GeoModel<WolfLeatherArmorItem> {

    @Override
    public Identifier getModelResource(WolfLeatherArmorItem animatable,
            @Nullable GeoRenderer<WolfLeatherArmorItem> renderer) {
        return Identifier.of(GardenerReference.MOD_ID, "geo/wolf_leather_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(WolfLeatherArmorItem animatable,
            @Nullable GeoRenderer<WolfLeatherArmorItem> renderer) {
                return Identifier.of(GardenerReference.MOD_ID, "textures/armor/wolf_leather_armor.png");
    }

    @Override
    public Identifier getAnimationResource(WolfLeatherArmorItem animatable) {
        return Identifier.of(GardenerReference.MOD_ID, "animations/wolf_leather_armor.animation.json");
    }

}
