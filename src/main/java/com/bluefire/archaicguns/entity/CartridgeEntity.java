package com.bluefire.archaicguns.entity;

import com.bluefire.archaicguns.core.Config;
import com.bluefire.archaicguns.core.registry.ItemRegistry;
import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.entity.ProjectileEntity;
import com.mrcrayfish.guns.item.GunItem;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraftforge.common.util.Constants;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effect;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.Explosion.Mode;

public class CartridgeEntity extends ProjectileEntity
{	
	protected float blockBreaking = 0F;
	protected float blastBreaking = 0F;
	protected boolean dropBroken = false;
	protected float explosionStrength = 0.0f;
	protected float knockback = 0.0f;
	protected int burnTime = 0;
	
	protected java.lang.String potionType = "";
	protected int potionStrength = 0;
	protected int potionDuration = 0;
	protected java.lang.String potionTypeTwo = "";
	protected int potionStrengthTwo = 0;
	protected int potionDurationTwo = 0;
	
    public CartridgeEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public CartridgeEntity(EntityType<? extends ProjectileEntity> entityType, World world, LivingEntity shooter, ItemStack weapon, GunItem item, Gun modifiedGun) {
        super(entityType, world, shooter, weapon, item, modifiedGun);
        float projCount = (float)modifiedGun.getGeneral().getProjectileAmount();
		this.blockBreaking = getAttachedFloat(weapon, "BlockBreaking", 0f);
		this.blastBreaking = getAttachedFloat(weapon, "BlastBreaking", 0.31f);
		this.explosionStrength = getAttachedFloat(weapon, "ExplosionStrength", 0f) / projCount;
		this.knockback = getAttachedFloat(weapon, "Knockback", 0f) / projCount;
		this.dropBroken = getAttachedBoolean(weapon, "DropBroken", false);
		this.burnTime = getAttachedInt(weapon, "BurnTime", 0);
		this.potionType = getAttachedString(weapon, "PotionType");
		this.potionTypeTwo = getAttachedString(weapon, "PotionTypeTwo");
		this.potionStrength = getAttachedInt(weapon, "PotionStrength", 1);
		this.potionDuration = getAttachedInt(weapon, "PotionDuration", 60);
		this.potionStrengthTwo = getAttachedInt(weapon, "PotionStrengthTwo", 1);
		this.potionDurationTwo = getAttachedInt(weapon, "PotionDurationTwo", 60);
    }
	
	private static int getAttachedInt(ItemStack weapon, java.lang.String key, int def)
	{
		int value = def;
		if (weapon.getTag().contains(key))
		{
			value = weapon.getTag().getInt(key);
		}
		value += weapon.getTag().getCompound("Attachments").getCompound("Stock").getCompound("tag").getInt(key);
		value += weapon.getTag().getCompound("Attachments").getCompound("Barrel").getCompound("tag").getInt(key);
		value += weapon.getTag().getCompound("Attachments").getCompound("Under_Barrel").getCompound("tag").getInt(key);
		return value;
	}
	
	private static float getAttachedFloat(ItemStack weapon, java.lang.String key, float def)
	{
		float value = def;
		if (weapon.getTag().contains(key))
		{
			value = weapon.getTag().getFloat(key);
		}
		value += weapon.getTag().getCompound("Attachments").getCompound("Stock").getCompound("tag").getFloat(key);
		value += weapon.getTag().getCompound("Attachments").getCompound("Barrel").getCompound("tag").getFloat(key);
		value += weapon.getTag().getCompound("Attachments").getCompound("Under_Barrel").getCompound("tag").getFloat(key);
		return value;
	}
	
	private static boolean getAttachedBoolean(ItemStack weapon, java.lang.String key, boolean def)
	{
		boolean value = def;
		if (weapon.getTag().getBoolean(key) != def)
		{
			value = weapon.getTag().getBoolean(key);
		}
		if (weapon.getTag().getCompound("Attachments").getCompound("Stock").getCompound("tag").getBoolean(key) != def)
		{
			value = weapon.getTag().getBoolean(key);
		}
		if (weapon.getTag().getCompound("Attachments").getCompound("Barrel").getCompound("tag").getBoolean(key) != def)
		{
			value = weapon.getTag().getBoolean(key);
		}
		if (weapon.getTag().getCompound("Attachments").getCompound("Under_Barrel").getCompound("tag").getBoolean(key) != def)
		{
			value = weapon.getTag().getBoolean(key);
		}
		return value;
	}
	
	private static java.lang.String getAttachedString(ItemStack weapon, java.lang.String key)
	{
		java.lang.String value = "";
		if (weapon.getTag().contains(key))
		{
			value = weapon.getTag().getString(key);
		}
		if (weapon.getTag().getCompound("Attachments").getCompound("Stock").getCompound("tag").contains(key))
		{
			value = weapon.getTag().getCompound("Attachments").getCompound("Stock").getCompound("tag").getString(key);
		}
		if (weapon.getTag().getCompound("Attachments").getCompound("Barrel").getCompound("tag").contains(key))
		{
			value = weapon.getTag().getCompound("Attachments").getCompound("Barrel").getCompound("tag").getString(key);
		}
		if (weapon.getTag().getCompound("Attachments").getCompound("Under_Barrel").getCompound("tag").contains(key))
		{
			value = weapon.getTag().getCompound("Attachments").getCompound("Under_Barrel").getCompound("tag").getString(key);
		}
		return value;
	}

    @Override
    protected void onHitEntity(Entity entity, Vector3d hitVec, Vector3d startVec, Vector3d endVec, boolean headshot) {
        super.onHitEntity(entity, hitVec, startVec, endVec, headshot);
        this.onHit(hitVec.getX(), hitVec.getY(), hitVec.getZ());

		if (entity instanceof LivingEntity)
		{
			LivingEntity entityLiving = (LivingEntity)entity;
			if (this.potionType != "")
			{
				entityLiving.addPotionEffect(new EffectInstance(ForgeRegistries.POTIONS.getValue(new ResourceLocation(this.potionType)), this.potionDuration, this.potionStrength));
			}
			if (this.potionTypeTwo != "")
			{
				entityLiving.addPotionEffect(new EffectInstance(ForgeRegistries.POTIONS.getValue(new ResourceLocation(this.potionTypeTwo)), this.potionDuration, this.potionStrength));
			}
			if (this.knockback != 0)
			{
				double motionX = (endVec.x - startVec.x);
				double motionZ = (endVec.z - startVec.z);
				double f1 = MathHelper.sqrt(motionX * motionX + motionZ * motionZ);
				if (f1 > 0.0F)
				{
					entityLiving.addVelocity(motionX * (double)this.knockback * 0.6000000238418579D / (double)f1, (double)this.knockback*0.1, motionZ * (double)this.knockback * 0.6000000238418579D / (double)f1);
					//entityLiving.setMotion(entityLiving.getMotion().add(0.0f, 0.5f, 0.0f));
				}
			}
			if (this.explosionStrength != 0F)
			{
				createExplosion(this, this.explosionStrength, this.dropBroken);
			}
			if (this.burnTime != 0)
			{
				entity.setFire(burnTime);
			}
		}
    }
	
    @SuppressWarnings("deprecation")
	@Override
    protected void onHitBlock(BlockState state, BlockPos pos, Direction face, double x, double y, double z) {
        super.onHitBlock(state, pos, face, x, y, z);
		Block block = state.getBlock();
        if((state.getBlockHardness(this.world, pos) <= this.blockBreaking && state.getBlockHardness(this.world, pos) >= 0.0F && this.blockBreaking > 0F) || (block.getExplosionResistance() <= this.blastBreaking && block.getExplosionResistance() >= 0.0F && this.blastBreaking > 0F))
		{
			this.world.destroyBlock(pos, this.dropBroken);
			this.blockBreaking = 0F;
			this.blastBreaking = 0F;
		}
		if (this.explosionStrength != 0F)
		{
			createExplosion(this, this.explosionStrength, this.dropBroken);
		}
        this.onHit(x, y, z);
    }
	
    void onHit(double x, double y, double z) {
		//Explosion
    }
}
