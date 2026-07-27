package com.crabmod.client;

import com.crabmod.CrabMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class CrabModelLayers {
    public static final EntityModelLayer CRAB =
            new EntityModelLayer(Identifier.of(CrabMod.MOD_ID, "crab"), "main");
}
