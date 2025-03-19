package org.zira.gardener.client;

import org.zira.gardener.GardenerReference;

import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

@Environment(EnvType.CLIENT)
public class WolfLeatherArmorRenderer extends GeoArmorRenderer<WolfLeatherArmorItem>{

    public WolfLeatherArmorRenderer() {
        super(new WolfLeatherArmorModel());
        // Using DefaultedItemGeoModel like this puts our 'location' as item/armor/example armor in the assets folders.
    }
    
}
