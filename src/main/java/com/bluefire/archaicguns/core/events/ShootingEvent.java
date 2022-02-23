package com.bluefire.archaicguns.core.events;

import com.bluefire.archaicguns.item.GunItemEx;
import com.bluefire.archaicguns.core.Config;
import com.bluefire.archaicguns.core.ArchaicGuns;
import com.bluefire.archaicguns.core.registry.SoundRegistry;
import com.mrcrayfish.guns.event.GunFireEvent.Post;
import com.mrcrayfish.guns.client.handler.AimingHandler;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.KeybindTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import java.util.Random;


@Mod.EventBusSubscriber(modid = ArchaicGuns.ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ShootingEvent {
    @SubscribeEvent
    public static void postShoot(Post event) {
        //if(!(event.getStack().getItem() instanceof GunItemEx))
        //    return;
        ItemStack weapon = event.getStack(); 
		LivingEntity shooter = event.getPlayer();
		//shooter.velocityChanged = true;
		//smoke generation
		World playerworld = shooter.getEntityWorld();
		if (getSmokeCount(weapon) > 0 && playerworld.isRemote())
		{
			double shooterX = shooter.getPosX();
			double shooterY = shooter.getPosY();
			double shooterZ = shooter.getPosZ();
			double smokeForward = (double)getSmokeForward(weapon);
			double smokeUp = (double)getSmokeUp(weapon);
			double smokeRight = (double)getSmokeRight(weapon);
			double smokeSpeed = (double)getSmokeSpeed(weapon);
			float smokeFollow = 0.5f;
			Random rand = new Random();
			if(AimingHandler.get().getNormalisedAdsProgress() < 0.4d)
			{
				float yaw = shooter.rotationYaw + 90f;
				if(yaw > 180)
				{
					yaw = yaw - 360f;
				}
				Vector3d move = getVectorFromRotation(0f, yaw);
				double finX = shooterX + (shooter.getLookVec().x * smokeForward) + (move.x * smokeRight);
				double finY = shooterY + (shooter.getLookVec().y * smokeForward) + smokeUp + (move.y * smokeRight);
				double finZ = shooterZ + (shooter.getLookVec().z * smokeForward) + (move.z * smokeRight);
				for (int i = getSmokeCount(weapon); i > 0; i--) {
	                playerworld.addParticle((IParticleData) ForgeRegistries.PARTICLE_TYPES.getValue(new ResourceLocation(getSmokeType(weapon))), true, finX, finY, finZ, (shooter.getLookVec().x * smokeSpeed) + ((rand.nextFloat() - 0.5) * smokeSpeed) + (shooter.getMotion().x * smokeFollow), (shooter.getLookVec().y * smokeSpeed) + ((rand.nextFloat() - 0.25) * smokeSpeed) + (shooter.getMotion().y * smokeFollow), (shooter.getLookVec().z * smokeSpeed) + ((rand.nextFloat() - 0.5) * smokeSpeed) + (shooter.getMotion().z * smokeFollow));
				}
			}
			else
			{
				double finX = shooterX + (shooter.getLookVec().x * smokeForward);
				double finY = shooterY + (shooter.getLookVec().y * smokeForward) + smokeUp + 0.15;
				double finZ = shooterZ + (shooter.getLookVec().z * smokeForward);
				for (int i = getSmokeCount(weapon); i > 0; i--) {
	                playerworld.addParticle((IParticleData) ForgeRegistries.PARTICLE_TYPES.getValue(new ResourceLocation(getSmokeType(weapon))), true, finX, finY, finZ, (shooter.getLookVec().x * smokeSpeed) + ((rand.nextFloat() - 0.5) * smokeSpeed) + (shooter.getMotion().x * smokeFollow), (shooter.getLookVec().y * smokeSpeed) + ((rand.nextFloat() - 0.25) * smokeSpeed) + (shooter.getMotion().y * smokeFollow), (shooter.getLookVec().z * smokeSpeed) + ((rand.nextFloat() - 0.5) * smokeSpeed) + (shooter.getMotion().z * smokeFollow));
	                //playerworld.addParticle((IParticleData) ForgeRegistries.PARTICLE_TYPES.getValue(new ResourceLocation(getSmokeType(weapon))), true, finX, finY, finZ, (shooter.getLookVec().x * smokeSpeed) + ((rand.nextFloat() - 0.5) * smokeSpeed), (shooter.getLookVec().y * smokeSpeed) + ((rand.nextFloat() - 0.5) * smokeSpeed), (shooter.getLookVec().z * smokeSpeed) + ((rand.nextFloat() - 0.5) * smokeSpeed));
				}
			}
		}
		float backblast = 0.0f;
        if(!(event.getStack().getItem() instanceof GunItemEx))
        {
        	backblast = -getAttachedFloat(weapon, "Backblast", 0.0f);
        } else {
			backblast = -getAttachedFloat(weapon, "Backblast", 0.2f);
        }
		shooter.addVelocity(shooter.getLookVec().x * (double)backblast, shooter.getLookVec().y * (double)backblast, shooter.getLookVec().z * (double)backblast);
    }

    private static Vector3d getVectorFromRotation(float pitch, float yaw)
    {
        double f = MathHelper.cos(-yaw * 0.017453292F - (float)Math.PI);
        double f1 = MathHelper.sin(-yaw * 0.017453292F - (float)Math.PI);
        double f2 = -MathHelper.cos(-pitch * 0.017453292F);
        double f3 = MathHelper.sin(-pitch * 0.017453292F);
        return new Vector3d((f1 * f2), f3, (f * f2));
    }
	
	private static float getSmokeForward(ItemStack weapon)
	{
		if (weapon.getTag().contains("SmokeForward"))
		{
			return weapon.getTag().getFloat("SmokeForward");
		}
		else
		{
			return 1.5f;
		}
	}
	
	private static float getSmokeRight(ItemStack weapon)
	{
		if (weapon.getTag().contains("SmokeRight"))
		{
			return weapon.getTag().getFloat("SmokeRight");
		}
		else
		{
			return 0.33f;
		}
	}
	
	private static float getSmokeUp(ItemStack weapon)
	{
		if (weapon.getTag().contains("SmokeUp"))
		{
			return weapon.getTag().getFloat("SmokeUp");
		}
		else
		{
			return 1.2f;
		}
	}
	
	private static java.lang.String getSmokeType(ItemStack weapon)
	{
		if (weapon.getTag().contains("SmokeType"))
		{
			return weapon.getTag().getString("SmokeType");
		}
		else
		{
			return "smoke";
		}
	}
	
	private static double getSmokeSpeed(ItemStack weapon)
	{
		if (weapon.getTag().contains("SmokeSpeed"))
		{
			return weapon.getTag().getDouble("SmokeSpeed");
		}
		else
		{
			return 0.1d;
		}
	}
	
	private static int getSmokeCount(ItemStack weapon)
	{
		if (weapon.getTag().contains("SmokeCount"))
		{
			return weapon.getTag().getInt("SmokeCount");
		}
		else
		{
			return 0;
		}
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
}
