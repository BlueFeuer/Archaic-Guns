package com.bluefire.archaicguns.core;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class Config {
    public static class Common {
        public final ForgeConfigSpec.IntValue literallyNothing;
		
        Common(ForgeConfigSpec.Builder builder) {
            builder.push("common"); {
                this.literallyNothing = builder.comment("This config does literally nothing. Change it as you wish.").defineInRange("literallyNothing", 10, 0, Integer.MAX_VALUE);
            }
            builder.pop();
        }
    }
	
    static final ForgeConfigSpec commonSpec;
    public static final Config.Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonSpec = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }
}
