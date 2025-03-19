package org.zira.gardener.client;

import org.jetbrains.annotations.Nullable;
import org.zira.gardener.GardenerReference;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class WolfLeatherArmorModel extends GeoModel<WolfLeatherArmorItem> {

    @Override
    public Identifier getModelResource(WolfLeatherArmorItem animatable,
            @Nullable GeoRenderer<WolfLeatherArmorItem> renderer) {
        return Identifier.of(GardenerReference.MOD_ID, "geo/wolfleather_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(WolfLeatherArmorItem animatable,
            @Nullable GeoRenderer<WolfLeatherArmorItem> renderer) {
                return Identifier.of(GardenerReference.MOD_ID, "textures/item/armor/wolfleather_armor.png");
    }

    @Override
    public Identifier getAnimationResource(WolfLeatherArmorItem animatable) {
        return Identifier.of(GardenerReference.MOD_ID, "animations/items/armor/wolfleather_armor.animation.json");
    }

}
