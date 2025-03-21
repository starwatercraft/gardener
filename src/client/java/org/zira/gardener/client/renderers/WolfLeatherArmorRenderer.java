package org.zira.gardener.client.renderers;

import net.fabricmc.api.Environment;

import org.zira.gardener.client.items.WolfLeatherArmorItem;

import net.fabricmc.api.EnvType;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import org.zira.gardener.client.models.WolfLeatherArmorModel;


@Environment(EnvType.CLIENT)
public class WolfLeatherArmorRenderer extends GeoArmorRenderer<WolfLeatherArmorItem>{
    public WolfLeatherArmorRenderer() {
        super(new WolfLeatherArmorModel());
        // Using DefaultedItemGeoModel like this puts our 'location' as item/armor/example armor in the assets folders.
    }
    
}
