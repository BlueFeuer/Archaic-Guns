package com.bluefire.archaicguns.core;

import com.bluefire.archaicguns.entity.CartridgeEntity;
import com.bluefire.archaicguns.core.registry.EntityRegistry;
import com.bluefire.archaicguns.core.registry.ItemRegistry;
import com.bluefire.archaicguns.core.registry.SoundRegistry;
import com.bluefire.archaicguns.core.Config;
import com.bluefire.archaicguns.item.modeloverrides.*;
import com.mrcrayfish.guns.client.render.gun.ModelOverrides;
import com.mrcrayfish.guns.common.ProjectileManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ArchaicGuns.ID)
public class ArchaicGuns {
    public static final String ID = "archaicguns";

    public static final ItemGroup GROUP = new ItemGroup(ID) {
        @Override
        public ItemStack createIcon() {
            ItemStack stack = new ItemStack(ItemRegistry.BLUNDERBUSS.get());
            stack.getOrCreateTag().putInt("AmmoCount", ItemRegistry.BLUNDERBUSS.get().getGun().getGeneral().getMaxAmmo());
            return stack;
        }
    };

    public ArchaicGuns() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.commonSpec);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.register(this);
		
        EntityRegistry.REGISTER.register(bus);
        ItemRegistry.REGISTER.register(bus);
        SoundRegistry.SOUND_REGISTRY.register(bus);
		
        bus.addListener(this::commonSetup);
        bus.addListener(this::onClientSetup);
    }

    void commonSetup(FMLCommonSetupEvent event) {
		//AMMO GO HERE
        ProjectileManager.getInstance().registerFactory(ItemRegistry.CARTRIDGE.get(), (worldIn, entity, weapon, item, modifiedGun) -> new CartridgeEntity(EntityRegistry.CARTRIDGE.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ItemRegistry.SHELL.get(), (worldIn, entity, weapon, item, modifiedGun) -> new CartridgeEntity(EntityRegistry.CARTRIDGE.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ItemRegistry.SLAG.get(), (worldIn, entity, weapon, item, modifiedGun) -> new CartridgeEntity(EntityRegistry.CARTRIDGE.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ItemRegistry.BUCKSHOT.get(), (worldIn, entity, weapon, item, modifiedGun) -> new CartridgeEntity(EntityRegistry.CARTRIDGE.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ItemRegistry.BOLT.get(), (worldIn, entity, weapon, item, modifiedGun) -> new CartridgeEntity(EntityRegistry.CARTRIDGE.get(), worldIn, entity, weapon, item, modifiedGun));
    }
    
    void onClientSetup(FMLClientSetupEvent event)
    {
    	ModelOverrides.register(ItemRegistry.ROTATINGBOLTLAUNCHER.get(), new RotatingBoltLauncherModel());
    	ModelOverrides.register(ItemRegistry.MAGIC_RUNE.get(), new MagicRuneModel());
    }
}
