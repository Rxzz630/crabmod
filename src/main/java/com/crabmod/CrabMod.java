package com.crabmod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrabMod implements ModInitializer {
    public static final String MOD_ID = "crabmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("[CrabMod] Menginisialisasi mob Crab...");
        com.crabmod.entity.ModEntities.register();
        com.crabmod.item.ModItems.register();
    }
}
