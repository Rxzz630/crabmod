package com.crabmod.client.render;

import com.crabmod.CrabMod;
import com.crabmod.entity.CrabEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CrabRenderer extends MobEntityRenderer<CrabEntity, CrabModel> {

    private static final Identifier TEXTURE =
            Identifier.of(CrabMod.MOD_ID, "textures/entity/crab.png");

    public CrabRenderer(EntityRendererFactory.Context context) {
        super(context, new CrabModel(context.getPart(com.crabmod.client.CrabModelLayers.CRAB)), 0.3F);
    }

    @Override
    public Identifier getTexture(CrabEntity entity) {
        return TEXTURE;
    }
}
