    package org.nootnoot.fabricchaos.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;
import org.nootnoot.fabricchaos.Fabricchaos;
import org.nootnoot.fabricchaos.ModFluids;
import org.w3c.dom.events.Event;

    @Environment(EnvType.CLIENT)
public class FabricchaosClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {


    FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILLSUSPICIOUSFLUID,ModFluids.FLOWINGSUSPICIOUSFLUID,new SimpleFluidRenderHandler(
                new Identifier("fabricchaos:block/still_suspicious_fluid"),
                new Identifier("fabricchaos:block/flowing_suspicious_fluid")
        ));

    BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),ModFluids.STILLSUSPICIOUSFLUID,ModFluids.FLOWINGSUSPICIOUSFLUID);
    }

}
