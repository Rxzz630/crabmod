package com.crabmod.client.render;

import com.crabmod.entity.CrabEntity;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

public class CrabModel extends EntityModel<CrabEntity> {

    private final ModelPart body;
    private final ModelPart legFL, legFR, legBL, legBR;
    private final ModelPart clawLeft, clawRight;

    public CrabModel(ModelPart root) {
        this.body = root.getChild("body");
        this.legFL = root.getChild("leg_fl");
        this.legFR = root.getChild("leg_fr");
        this.legBL = root.getChild("leg_bl");
        this.legBR = root.getChild("leg_br");
        this.clawLeft = root.getChild("claw_left");
        this.clawRight = root.getChild("claw_right");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        root.addChild("body", ModelPartBuilder.create()
                        .uv(0, 0).cuboid(-4.0F, -3.0F, -5.0F, 8.0F, 3.0F, 10.0F),
                ModelTransform.pivot(0.0F, 21.0F, 0.0F));

        root.addChild("leg_fl", ModelPartBuilder.create()
                        .uv(0, 13).cuboid(-3.0F, 0.0F, -1.0F, 3.0F, 3.0F, 2.0F),
                ModelTransform.pivot(-4.0F, 21.0F, -3.0F));

        root.addChild("leg_fr", ModelPartBuilder.create()
                        .uv(0, 18).cuboid(0.0F, 0.0F, -1.0F, 3.0F, 3.0F, 2.0F),
                ModelTransform.pivot(4.0F, 21.0F, -3.0F));

        root.addChild("leg_bl", ModelPartBuilder.create()
                        .uv(0, 13).cuboid(-3.0F, 0.0F, -1.0F, 3.0F, 3.0F, 2.0F),
                ModelTransform.pivot(-4.0F, 21.0F, 3.0F));

        root.addChild("leg_br", ModelPartBuilder.create()
                        .uv(0, 18).cuboid(0.0F, 0.0F, -1.0F, 3.0F, 3.0F, 2.0F),
                ModelTransform.pivot(4.0F, 21.0F, 3.0F));

        root.addChild("claw_left", ModelPartBuilder.create()
                        .uv(20, 0).cuboid(-4.0F, -1.0F, -2.0F, 4.0F, 3.0F, 3.0F),
                ModelTransform.pivot(-6.0F, 20.0F, -5.0F));

        root.addChild("claw_right", ModelPartBuilder.create()
                        .uv(20, 8).cuboid(0.0F, -1.0F, -2.0F, 4.0F, 3.0F, 3.0F),
                ModelTransform.pivot(6.0F, 20.0F, -5.0F));

        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(CrabEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        float walk = MathHelper.clamp(limbDistance, -1.0F, 1.0F);
        float swing = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * walk;
        float swingOpp = MathHelper.cos(limbAngle * 0.6662F + (float) Math.PI) * 1.4F * walk;

        this.legFL.roll = swing;
        this.legBR.roll = swing;
        this.legFR.roll = swingOpp;
        this.legBL.roll = swingOpp;

        this.body.pitch = 0.0F;
        this.body.yaw = MathHelper.sin(limbAngle * 0.3F) * 0.05F * walk;

        boolean raised = entity.isClawRaised();
        float clawAngle = raised ? -0.7F : (MathHelper.cos(animationProgress * 0.05F) * 0.08F);
        this.clawLeft.roll = -clawAngle;
        this.clawRight.roll = clawAngle;
    }

    @Override
    public void render(net.minecraft.client.util.math.MatrixStack matrices, net.minecraft.client.render.VertexConsumer vertices, int light, int overlay, int color) {
        body.render(matrices, vertices, light, overlay, color);
        legFL.render(matrices, vertices, light, overlay, color);
        legFR.render(matrices, vertices, light, overlay, color);
        legBL.render(matrices, vertices, light, overlay, color);
        legBR.render(matrices, vertices, light, overlay, color);
        clawLeft.render(matrices, vertices, light, overlay, color);
        clawRight.render(matrices, vertices, light, overlay, color);
    }
}
