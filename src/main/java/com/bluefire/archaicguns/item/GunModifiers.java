package com.bluefire.archaicguns.item;

import com.mrcrayfish.guns.interfaces.IGunModifier;
import net.minecraft.util.math.MathHelper;

/**
 * Author: BlueFire
 */
public class GunModifiers
{
    public static final IGunModifier MAGIC_RUNE = new IGunModifier()
    {
        @Override
        public float modifyProjectileDamage(float damage)
        {
            return damage * 1.0F;
        }
        @Override
        public double modifyFireSoundRadius(double radius)
        {
            return radius * 1.0;
        }
        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 1.0F;
        }
        @Override
        public float recoilModifier()
        {
            return 1.0F;
        }
        @Override
        public float kickModifier()
        {
            return 1.0F;
        }
        @Override
        public float modifyProjectileSpread(float spread)
        {
            return spread * 1.0F;
        }
        @Override
        public int modifyFireRate(int rate)
        {
            //return MathHelper.clamp((int) (rate * 1.25), rate + 1, Integer.MAX_VALUE);
            return MathHelper.clamp(2, (int)((double)rate * (1 / 1 + 0)), 1000);
        }
        @Override
        public double modifyProjectileGravity(double gravity)
        {
            return gravity * 1.0F;
        }
    };
}