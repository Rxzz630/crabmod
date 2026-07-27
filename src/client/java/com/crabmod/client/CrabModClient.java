package com.crabmod.client;

import com.crabmod.entity.ModEntities;
import com.crabmod.client.render.CrabModel;
import com.crabmod.client.render.CrabRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class CrabModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(CrabModelLayers.CRAB, CrabModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CRAB, CrabRenderer::new);
    }
}
