package com.bluefire.archaicguns.item.modeloverrides;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mrcrayfish.guns.Reference;
import com.mrcrayfish.guns.client.GunRenderType;
import com.mrcrayfish.guns.client.handler.AimingHandler;
import com.mrcrayfish.guns.client.handler.RecoilHandler;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.util.RenderUtil;
import com.mrcrayfish.guns.util.OptifineHelper;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import com.bluefire.archaicguns.item.modeloverrides.SpecialModels;
import net.minecraft.util.CooldownTracker;
import net.minecraft.util.math.vector.Vector3f;

public class RotatingBoltLauncherModel implements IOverrideModel
{
    @Override
    public void render(float partialTicks, ItemCameraTransforms.TransformType transformType, ItemStack stack, ItemStack parent, LivingEntity entity, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light, int overlay)
    {
        RenderUtil.renderModel(SpecialModels.ROTATING_BOLT_LAUNCHER_BASE.getModel(), stack, matrixStack, renderTypeBuffer, light, overlay);
        
        if(entity.equals(Minecraft.getInstance().player))
        {
            matrixStack.push();
            matrixStack.translate(0, -6.9 * 0.0625, 0);
            //matrixStack.translate(0, -stack.getTag().getFloat("testest") * 0.0625, 0);
            CooldownTracker tracker = Minecraft.getInstance().player.getCooldownTracker();
            float cooldown = tracker.getCooldown(stack.getItem(), Minecraft.getInstance().getRenderPartialTicks());
            cooldown = (float)easeInBack(cooldown);
            matrixStack.rotate(Vector3f.ZN.rotationDegrees(45F * cooldown));
            matrixStack.translate(0, 6.9 * 0.0625, 0);
            //matrixStack.translate(0, stack.getTag().getFloat("testest") * 0.0625, 0);
            RenderUtil.renderModel(SpecialModels.ROTATING_BOLT_LAUNCHER_BULK.getModel(), stack, matrixStack, renderTypeBuffer, light, overlay);
            matrixStack.pop();
        }
    }

    /**
     * Easing function based on code from https://easings.net/
     */
    /*
    private double easeOutBack(double x)
    {
    	double c1 = 1.70158;
    	double c3 = c1 + 1;

    	return 1 + c3 * Math.pow(x - 1, 3) + c1 * Math.pow(x - 1, 2);
    }
    */
    private double easeInBack(double x)
    {
    	double c1 = 1.70158;
    	double c3 = c1 + 1;

    	return c3 * x * x * x - c1 * x * x;
    }
}