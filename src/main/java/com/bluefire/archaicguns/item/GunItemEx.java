package com.bluefire.archaicguns.item;

import com.bluefire.archaicguns.core.ArchaicGuns;
import com.mrcrayfish.guns.item.GunItem;
import com.mrcrayfish.guns.common.Gun;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.KeybindTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.NonNullList;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Locale;

public class GunItemEx extends GunItem {
	
	private float smokeUp;
	private float smokeRight;
	private float smokeForward;
	private int smokeCount;
	private double smokeSpeed;
	
    public GunItemEx() {
        super(new Item.Properties().maxStackSize(1).group(ArchaicGuns.GROUP));
    }
    
    public GunItemEx(float smokeForward, float smokeUp, float smokeRight, double smokeSpeed, int smokeCount) {
        super(new Item.Properties().maxStackSize(1).group(ArchaicGuns.GROUP));
        this.smokeUp = smokeUp;
        this.smokeRight = smokeRight;
        this.smokeForward = smokeForward;
        this.smokeCount = smokeCount;
        this.smokeSpeed = smokeSpeed;
    }
    
    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> stacks)
    {
        if(this.isInGroup(group))
        {
            ItemStack stack = new ItemStack(this);
            stack.getOrCreateTag().putInt("AmmoCount", this.getGun().getGeneral().getMaxAmmo());
            stack.getTag().putFloat("SmokeUp", this.smokeUp);
            stack.getTag().putFloat("SmokeRight", this.smokeRight);
            stack.getTag().putFloat("SmokeForward", this.smokeForward);
            stack.getTag().putDouble("SmokeSpeed", this.smokeSpeed);
            stack.getTag().putInt("SmokeCount", this.smokeCount);
            stacks.add(stack);
        }
    }
    
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flag) {
        //Add everything from the extended GunItem class
        super.addInformation(stack, worldIn, tooltip, flag);
        //Check if the gun is jammed from the isJammed NBT property
		/*
        if(stack.getTag().getBoolean("isJammed")) {
            //Add a tooltip on how to unjam the gun from the keybind
            tooltip.add(new TranslationTextComponent("info." + ArchaicGuns.ID + ".gun_jammed", (new KeybindTextComponent("key." + ArchaicGuns.ID + ".unjam_gun")).getString().toUpperCase(Locale.ENGLISH)).mergeStyle(TextFormatting.RED));
        }
		*/
    }
}
