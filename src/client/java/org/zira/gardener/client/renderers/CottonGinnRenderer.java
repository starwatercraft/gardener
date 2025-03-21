package org.zira.gardener.client.renderers;

import net.fabricmc.api.Environment;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

import org.zira.gardener.client.models.CottonGinnModel;
import org.zira.gardener.client.blocks.CottonGinnBlockEntity;

import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class CottonGinnRenderer extends GeoBlockRenderer<CottonGinnBlockEntity> {

    public CottonGinnRenderer() {
        super(new CottonGinnModel());
    }    
}
