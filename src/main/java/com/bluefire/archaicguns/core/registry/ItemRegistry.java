package com.bluefire.archaicguns.core.registry;

import com.bluefire.archaicguns.item.GunItemEx;
import com.bluefire.archaicguns.item.GunModifiers;
import com.bluefire.archaicguns.core.ArchaicGuns;
import com.mrcrayfish.guns.item.AmmoItem;
import com.mrcrayfish.guns.item.GunItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.mrcrayfish.guns.item.attachment.impl.Barrel;
import com.mrcrayfish.guns.item.attachment.impl.Scope;
import com.mrcrayfish.guns.item.attachment.impl.Stock;
import com.mrcrayfish.guns.item.attachment.impl.UnderBarrel;
import com.mrcrayfish.guns.item.UnderBarrelItem;
import com.mrcrayfish.guns.item.BarrelItem;
import com.mrcrayfish.guns.item.ScopeItem;
import com.mrcrayfish.guns.item.StockItem;

public class ItemRegistry {
	
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, ArchaicGuns.ID);

	//GUN GO HERE
    public static final RegistryObject<GunItem> PIPEGUN = REGISTER.register("pipegun", () -> new GunItemEx(1.6f, 1.42f, 0.54f, 0.1d, 15));
    public static final RegistryObject<GunItem> BLUNDERBUSS = REGISTER.register("blunderbuss", () -> new GunItemEx(1.4f, 1.42f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> MUSKET = REGISTER.register("musket", () -> new GunItemEx(1.8f, 1.42f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> COACHGUN = REGISTER.register("coachgun", () -> new GunItemEx(1.6f, 1.36f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> SLAGGER = REGISTER.register("slagger", () -> new GunItemEx(1.25f, 1.24f, 0.54f, 0.06d, 10));
    public static final RegistryObject<GunItem> ROTATINGBOLTLAUNCHER = REGISTER.register("rotatingboltlauncher", () -> new GunItemEx(1.25f, 1.2f, 0.54f, 0.1d, 10));
    public static final RegistryObject<GunItem> REPEATER = REGISTER.register("repeater", () -> new GunItemEx(1.8f, 1.42f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> AGRIFLE = REGISTER.register("agrifle", () -> new GunItemEx(2f, 1.42f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> BOOMSTICK = REGISTER.register("boomstick", () -> new GunItemEx(1.6f, 1.36f, 0.54f, 0.12d, 40));
    public static final RegistryObject<GunItem> REPEATERALT = REGISTER.register("repeateralt", () -> new GunItemEx(1.8f, 1.42f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> BOOMSTICKALT = REGISTER.register("boomstickalt", () -> new GunItemEx(1.6f, 1.36f, 0.54f, 0.12d, 40));
    public static final RegistryObject<GunItem> AGPISTOL = REGISTER.register("agpistol", () -> new GunItemEx(1.2f, 1.42f, 0.54f, 0.1d, 10));
    public static final RegistryObject<GunItem> PIPEGUNRUST = REGISTER.register("pipegunrust", () -> new GunItemEx(1.6f, 1.42f, 0.54f, 0.1d, 15));
    public static final RegistryObject<GunItem> BLUNDERBUSSRUST = REGISTER.register("blunderbussrust", () -> new GunItemEx(1.4f, 1.42f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> MUSKETRUST = REGISTER.register("musketrust", () -> new GunItemEx(1.8f, 1.42f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> COACHGUNRUST = REGISTER.register("coachgunrust", () -> new GunItemEx(1.6f, 1.36f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> SLAGGERRUST = REGISTER.register("slaggerrust", () -> new GunItemEx(1.25f, 1.24f, 0.54f, 0.06d, 10));
    public static final RegistryObject<GunItem> ROTATINGBOLTLAUNCHERRUST = REGISTER.register("rotatingboltlauncherrust", () -> new GunItemEx(1.25f, 1.2f, 0.54f, 0.1d, 10));
    public static final RegistryObject<GunItem> REPEATERRUST = REGISTER.register("repeaterrust", () -> new GunItemEx(1.8f, 1.42f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> AGRIFLERUST = REGISTER.register("agriflerust", () -> new GunItemEx(2f, 1.42f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> BOOMSTICKRUST = REGISTER.register("boomstickrust", () -> new GunItemEx(1.6f, 1.36f, 0.54f, 0.12d, 40));
    public static final RegistryObject<GunItem> REPEATERALTRUST = REGISTER.register("repeateraltrust", () -> new GunItemEx(1.8f, 1.42f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> BOOMSTICKALTRUST = REGISTER.register("boomstickaltrust", () -> new GunItemEx(1.6f, 1.36f, 0.54f, 0.12d, 40));
    public static final RegistryObject<GunItem> AGPISTOLRUST = REGISTER.register("agpistolrust", () -> new GunItemEx(1.2f, 1.42f, 0.54f, 0.1d, 10));
    public static final RegistryObject<GunItem> REPEATERMOSS = REGISTER.register("repeatermoss", () -> new GunItemEx(1.8f, 1.42f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> REPEATERMOSSEVIL = REGISTER.register("repeatermossevil", () -> new GunItemEx(1.8f, 1.42f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> REPEATERMOSSF = REGISTER.register("repeatermossf", () -> new GunItemEx(1.8f, 1.42f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> COACHGUNMOLTEN = REGISTER.register("coachgunmolten", () -> new GunItemEx(1.6f, 1.36f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> COACHGUNVOID = REGISTER.register("coachgunvoid", () -> new GunItemEx(1.6f, 1.36f, 0.54f, 0.1d, 20));
    public static final RegistryObject<GunItem> BOOMSTICKALTMOLTEN = REGISTER.register("boomstickaltmolten", () -> new GunItemEx(1.6f, 1.36f, 0.54f, 0.12d, 40));
    public static final RegistryObject<GunItem> BOOMSTICKMOLTEN = REGISTER.register("boomstickmolten", () -> new GunItemEx(1.6f, 1.36f, 0.54f, 0.12d, 40));
    public static final RegistryObject<GunItem> AGRIFLEMOLTEN = REGISTER.register("agriflemolten", () -> new GunItemEx(2f, 1.42f, 0.54f, 0.1d, 20));
    
    //AMMO GO HERE
    public static final RegistryObject<Item> CARTRIDGE = REGISTER.register("cartridge", () -> new AmmoItem(new Item.Properties().group(ArchaicGuns.GROUP)));
    public static final RegistryObject<Item> SHELL = REGISTER.register("shell", () -> new AmmoItem(new Item.Properties().group(ArchaicGuns.GROUP)));
    public static final RegistryObject<Item> SLAG = REGISTER.register("slag", () -> new AmmoItem(new Item.Properties().group(ArchaicGuns.GROUP)));
    public static final RegistryObject<Item> BUCKSHOT = REGISTER.register("buckshot", () -> new AmmoItem(new Item.Properties().group(ArchaicGuns.GROUP)));
    public static final RegistryObject<Item> BOLT = REGISTER.register("bolt", () -> new AmmoItem(new Item.Properties().group(ArchaicGuns.GROUP)));
    
    //ATTACHMENTS GO HERE
    public static final RegistryObject<Item> MAGIC_RUNE = REGISTER.register("magic_rune", () -> new StockItem(Stock.create(GunModifiers.MAGIC_RUNE), new Item.Properties().maxStackSize(1).group(ArchaicGuns.GROUP), false));
    public static final RegistryObject<Item> MAGIC_RUNE_HALF = REGISTER.register("magic_rune_half", () -> new StockItem(Stock.create(GunModifiers.MAGIC_RUNE), new Item.Properties().maxStackSize(1).group(ArchaicGuns.GROUP), false));
    
}
