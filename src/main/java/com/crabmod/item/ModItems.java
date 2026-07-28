package com.crabmod.item;

import com.crabmod.CrabMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CRAB_CLAW = Registry.register(
            Registries.ITEM,
            Identifier.of(CrabMod.MOD_ID, "crab_claw"),
            new Item(new Item.Settings().maxCount(16))
    );

    public static void register() {
        net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register(entries -> entries.add(CRAB_CLAW));
    }
}
