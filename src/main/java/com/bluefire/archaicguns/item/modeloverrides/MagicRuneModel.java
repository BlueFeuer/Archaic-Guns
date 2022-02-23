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

/**
 * Author: MrCrayfish
 */
public class MagicRuneModel implements IOverrideModel
{
    @Override
    public void render(float partialTicks, ItemCameraTransforms.TransformType transformType, ItemStack stack, ItemStack parent, LivingEntity entity, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light, int overlay)
    {
        if(parent.getTag().getInt("size") == 1)
        {
        	//with NBT
        	if(AimingHandler.get().getNormalisedAdsProgress() < 0.25d)
        	{
        		RenderUtil.renderModel(SpecialModels.MAGIC_RUNE_B.getModel(), stack, matrixStack, renderTypeBuffer, light, overlay);
        	} else {
        		RenderUtil.renderModel(SpecialModels.MAGIC_RUNE_B_HALF.getModel(), stack, matrixStack, renderTypeBuffer, light, overlay);
        	}
        }
        else {
        	//default
        	if(AimingHandler.get().getNormalisedAdsProgress() < 0.15d)
        	{
        		RenderUtil.renderModel(SpecialModels.MAGIC_RUNE_A.getModel(), stack, matrixStack, renderTypeBuffer, light, overlay);
        	} else {
        		RenderUtil.renderModel(SpecialModels.MAGIC_RUNE_A_HALF.getModel(), stack, matrixStack, renderTypeBuffer, light, overlay);
        	}
        }
    }
}