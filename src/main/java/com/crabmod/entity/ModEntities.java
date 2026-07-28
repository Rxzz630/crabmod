package com.crabmod.entity;

import com.crabmod.CrabMod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final RegistryKey<EntityType<?>> CRAB_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrabMod.MOD_ID, "crab"));

    public static final EntityType<CrabEntity> CRAB = Registry.register(
            Registries.ENTITY_TYPE,
            CRAB_KEY,
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CrabEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 0.5f))
                    .build(CRAB_KEY)
    );

    public static void register() {
        FabricDefaultAttributeRegistry.register(CRAB, CrabEntity.createCrabAttributes());
    }
}
