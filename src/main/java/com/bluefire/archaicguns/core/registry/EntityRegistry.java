package com.bluefire.archaicguns.core.registry;

import com.bluefire.archaicguns.entity.CartridgeEntity;
import com.bluefire.archaicguns.core.ArchaicGuns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.BiFunction;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, ArchaicGuns.ID);

    public static final RegistryObject<EntityType<CartridgeEntity>> CARTRIDGE = registerProjectile("cartridge", CartridgeEntity::new);

    private static <T extends CartridgeEntity> RegistryObject<EntityType<T>> registerProjectile(String id, BiFunction<EntityType<T>, World, T> function)
    {
        EntityType<T> type = EntityType.Builder.create(function::apply, EntityClassification.MISC)
            .size(0.25F, 0.25F)
            .setTrackingRange(0)
            .disableSummoning()
            .immuneToFire()
            .setShouldReceiveVelocityUpdates(false)
            .setCustomClientFactory((spawnEntity, world) -> null)
            .build(id);
        return REGISTER.register(id, () -> type);
    }
}