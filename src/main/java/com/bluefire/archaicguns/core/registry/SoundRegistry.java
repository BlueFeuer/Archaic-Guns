package com.bluefire.archaicguns.core.registry;

import com.bluefire.archaicguns.core.ArchaicGuns;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUND_REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ArchaicGuns.ID);

    //GUN GO HERE
    public static final RegistryObject<SoundEvent> ITEM_PIPEGUN_SHOOT = register("item.pipegun.fire");
    public static final RegistryObject<SoundEvent> ITEM_PIPEGUN_RELOAD = register("item.pipegun.reload");
    public static final RegistryObject<SoundEvent> ITEM_BLUNDERBUSS_SHOOT = register("item.blunderbuss.fire");
    public static final RegistryObject<SoundEvent> ITEM_BLUNDERBUSS_RELOAD = register("item.blunderbuss.reload");
    public static final RegistryObject<SoundEvent> ITEM_MUSKET_SHOOT = register("item.musket.fire");
    public static final RegistryObject<SoundEvent> ITEM_MUSKET_RELOAD = register("item.musket.reload");
    public static final RegistryObject<SoundEvent> ITEM_COACHGUN_SHOOT = register("item.coachgun.fire");
    public static final RegistryObject<SoundEvent> ITEM_COACHGUN_RELOAD = register("item.coachgun.reload");
    public static final RegistryObject<SoundEvent> ITEM_SLAGGER_SHOOT = register("item.slagger.fire");
    public static final RegistryObject<SoundEvent> ITEM_SLAGGER_RELOAD = register("item.slagger.reload");
    public static final RegistryObject<SoundEvent> ITEM_ROTATINGBOLTLAUNCHER_SHOOT = register("item.rotatingboltlauncher.fire");
    public static final RegistryObject<SoundEvent> ITEM_ROTATINGBOLTLAUNCHER_RELOAD = register("item.rotatingboltlauncher.reload");
    public static final RegistryObject<SoundEvent> ITEM_REPEATER_SHOOT = register("item.repeater.fire");
    public static final RegistryObject<SoundEvent> ITEM_REPEATER_RELOAD = register("item.repeater.reload");
    public static final RegistryObject<SoundEvent> ITEM_AGRIFLE_SHOOT = register("item.agrifle.fire");
    public static final RegistryObject<SoundEvent> ITEM_AGRIFLE_RELOAD = register("item.agrifle.reload");
    public static final RegistryObject<SoundEvent> ITEM_BOOMSTICK_SHOOT = register("item.boomstick.fire");
    public static final RegistryObject<SoundEvent> ITEM_BOOMSTICK_RELOAD = register("item.boomstick.reload");
    public static final RegistryObject<SoundEvent> ITEM_REPEATERALT_SHOOT = register("item.repeateralt.fire");
    public static final RegistryObject<SoundEvent> ITEM_REPEATERALT_RELOAD = register("item.repeateralt.reload");
    public static final RegistryObject<SoundEvent> ITEM_BOOMSTICKALT_SHOOT = register("item.boomstickalt.fire");
    public static final RegistryObject<SoundEvent> ITEM_BOOMSTICKALT_RELOAD = register("item.boomstickalt.reload");
    public static final RegistryObject<SoundEvent> ITEM_AGPISTOL_SHOOT = register("item.agpistol.fire");
    public static final RegistryObject<SoundEvent> ITEM_AGPISTOL_RELOAD = register("item.agpistol.reload");
    public static final RegistryObject<SoundEvent> ITEM_PIPEGUNRUST_SHOOT = register("item.pipegunrust.fire");
    public static final RegistryObject<SoundEvent> ITEM_PIPEGUNRUST_RELOAD = register("item.pipegunrust.reload");
    public static final RegistryObject<SoundEvent> ITEM_BLUNDERBUSSRUST_SHOOT = register("item.blunderbussrust.fire");
    public static final RegistryObject<SoundEvent> ITEM_BLUNDERBUSSRUST_RELOAD = register("item.blunderbussrust.reload");
    public static final RegistryObject<SoundEvent> ITEM_MUSKETRUST_SHOOT = register("item.musketrust.fire");
    public static final RegistryObject<SoundEvent> ITEM_MUSKETRUST_RELOAD = register("item.musketrust.reload");
    public static final RegistryObject<SoundEvent> ITEM_COACHGUNRUST_SHOOT = register("item.coachgunrust.fire");
    public static final RegistryObject<SoundEvent> ITEM_COACHGUNRUST_RELOAD = register("item.coachgunrust.reload");
    public static final RegistryObject<SoundEvent> ITEM_SLAGGERRUST_SHOOT = register("item.slaggerrust.fire");
    public static final RegistryObject<SoundEvent> ITEM_SLAGGERRUST_RELOAD = register("item.slaggerrust.reload");
    public static final RegistryObject<SoundEvent> ITEM_ROTATINGBOLTLAUNCHERRUST_SHOOT = register("item.rotatingboltlauncherrust.fire");
    public static final RegistryObject<SoundEvent> ITEM_ROTATINGBOLTLAUNCHERRUST_RELOAD = register("item.rotatingboltlauncherrust.reload");
    public static final RegistryObject<SoundEvent> ITEM_REPEATERRUST_SHOOT = register("item.repeaterrust.fire");
    public static final RegistryObject<SoundEvent> ITEM_REPEATERRUST_RELOAD = register("item.repeaterrust.reload");
    public static final RegistryObject<SoundEvent> ITEM_AGRIFLERUST_SHOOT = register("item.agriflerust.fire");
    public static final RegistryObject<SoundEvent> ITEM_AGRIFLERUST_RELOAD = register("item.agriflerust.reload");
    public static final RegistryObject<SoundEvent> ITEM_BOOMSTICKRUST_SHOOT = register("item.boomstickrust.fire");
    public static final RegistryObject<SoundEvent> ITEM_BOOMSTICKRUST_RELOAD = register("item.boomstickrust.reload");
    public static final RegistryObject<SoundEvent> ITEM_REPEATERALTRUST_SHOOT = register("item.repeateraltrust.fire");
    public static final RegistryObject<SoundEvent> ITEM_REPEATERALTRUST_RELOAD = register("item.repeateraltrust.reload");
    public static final RegistryObject<SoundEvent> ITEM_BOOMSTICKALTRUST_SHOOT = register("item.boomstickaltrust.fire");
    public static final RegistryObject<SoundEvent> ITEM_BOOMSTICKALTRUST_RELOAD = register("item.boomstickaltrust.reload");
    public static final RegistryObject<SoundEvent> ITEM_AGPISTOLRUST_SHOOT = register("item.agpistolrust.fire");
    public static final RegistryObject<SoundEvent> ITEM_AGPISTOLRUST_RELOAD = register("item.agpistolrust.reload");
    public static final RegistryObject<SoundEvent> ITEM_REPEATERMOSS_SHOOT = register("item.repeatermoss.fire");
    public static final RegistryObject<SoundEvent> ITEM_REPEATERMOSS_RELOAD = register("item.repeatermoss.reload");
    public static final RegistryObject<SoundEvent> ITEM_REPEATERMOSSEVIL_SHOOT = register("item.repeatermossevil.fire");
    public static final RegistryObject<SoundEvent> ITEM_REPEATERMOSSEVIL_RELOAD = register("item.repeatermossevil.reload");
    public static final RegistryObject<SoundEvent> ITEM_REPEATERMOSSF_SHOOT = register("item.repeatermossf.fire");
    public static final RegistryObject<SoundEvent> ITEM_REPEATERMOSSF_RELOAD = register("item.repeatermossf.reload");
    public static final RegistryObject<SoundEvent> ITEM_COACHGUNMOLTEN_SHOOT = register("item.coachgunmolten.fire");
    public static final RegistryObject<SoundEvent> ITEM_COACHGUNMOLTEN_RELOAD = register("item.coachgunmolten.reload");
    public static final RegistryObject<SoundEvent> ITEM_COACHGUNVOID_SHOOT = register("item.coachgunvoid.fire");
    public static final RegistryObject<SoundEvent> ITEM_COACHGUNVOID_RELOAD = register("item.coachgunvoid.reload");
    public static final RegistryObject<SoundEvent> ITEM_BOOMSTICKALTMOLTEN_SHOOT = register("item.boomstickaltmolten.fire");
    public static final RegistryObject<SoundEvent> ITEM_BOOMSTICKALTMOLTEN_RELOAD = register("item.boomstickaltmolten.reload");
    public static final RegistryObject<SoundEvent> ITEM_BOOMSTICKMOLTEN_SHOOT = register("item.boomstickmolten.fire");
    public static final RegistryObject<SoundEvent> ITEM_BOOMSTICKMOLTEN_RELOAD = register("item.boomstickmolten.reload");
    public static final RegistryObject<SoundEvent> ITEM_AGRIFLEMOLTEN_SHOOT = register("item.agriflemolten.fire");
    public static final RegistryObject<SoundEvent> ITEM_AGRIFLEMOLTEN_RELOAD = register("item.agriflemolten.reload");


    private static RegistryObject<SoundEvent> register(String key) {
        return SOUND_REGISTRY.register(key, () -> new SoundEvent(new ResourceLocation(ArchaicGuns.ID, key)));
    }
}
