package com.crabmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class CrabEntity extends AnimalEntity {

    private static final TrackedData<Boolean> CLAW_RAISED =
            DataTracker.registerData(CrabEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public CrabEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createCrabAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 6.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.14)
                .add(EntityAttributes.STEP_HEIGHT, 1.0);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(CLAW_RAISED, false);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalEntity.FleeEntityGoal<>(this, PlayerEntity.class, 6.0F, 1.4, 1.4));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    public boolean isClawRaised() {
        return this.dataTracker.get(CLAW_RAISED);
    }

    public void setClawRaised(boolean raised) {
        this.dataTracker.set(CLAW_RAISED, raised);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.isClawRaised() && this.age % 10 == 0) {
            this.setClawRaised(false);
        }
    }
}
