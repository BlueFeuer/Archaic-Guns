package com.bluefire.archaicguns.item.modeloverrides;

import com.bluefire.archaicguns.core.ArchaicGuns;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Author: BlueFire
 */
@Mod.EventBusSubscriber(modid = ArchaicGuns.ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public enum SpecialModels
{
    MAGIC_RUNE_A("magic_rune_a"),
    MAGIC_RUNE_A_HALF("magic_rune_a_half"),
    MAGIC_RUNE_B("magic_rune_b"),
    MAGIC_RUNE_B_HALF("magic_rune_b_half"),
    ROTATING_BOLT_LAUNCHER_BASE("rotatingboltlauncher_base"),
    ROTATING_BOLT_LAUNCHER_BULK("rotatingboltlauncher_bulk");

    private ResourceLocation modelLocation;

    private boolean specialModel;

    @OnlyIn(Dist.CLIENT)
    private IBakedModel cachedModel;

    SpecialModels(String modelName)
    {
        this(new ResourceLocation(ArchaicGuns.ID, "item/" + modelName), true);
    }

    SpecialModels(ResourceLocation resource, boolean specialModel)
    {
        this.modelLocation = resource;
        this.specialModel = specialModel;
    }

    @OnlyIn(Dist.CLIENT)
    public IBakedModel getModel()
    {
        if(this.cachedModel == null)
        {
            IBakedModel model = Minecraft.getInstance().getModelManager().getModel(this.modelLocation);
            if(model == Minecraft.getInstance().getModelManager().getMissingModel())
            {
                return model;
            }
            this.cachedModel = model;
        }
        return this.cachedModel;
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void register(ModelRegistryEvent event)
    {
        for(SpecialModels model : values())
        {
            if(model.specialModel)
            {
                ModelLoader.addSpecialModel(model.modelLocation);
            }
        }
    }
}