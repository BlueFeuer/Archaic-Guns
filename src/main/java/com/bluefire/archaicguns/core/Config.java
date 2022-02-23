package com.bluefire.archaicguns.core;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Author: Mr. Pineapple
 */
public class Config {
    public static class Common {
        public final ForgeConfigSpec.IntValue literallyNothing;
		/*
        public final ForgeConfigSpec.IntValue dartLossChance;
        public final ForgeConfigSpec.BooleanValue gunJams;
        public final ForgeConfigSpec.IntValue dartJamChance;
        public final ForgeConfigSpec.BooleanValue showJamStatusMessage;
		*/

        Common(ForgeConfigSpec.Builder builder) {
            builder.push("common"); {
                this.literallyNothing = builder.comment("This config does literally nothing. Change it as you wish.").defineInRange("literallyNothing", 10, 0, Integer.MAX_VALUE);
				/*
                this.dartLossChance = builder.comment("The chance of a dart being lost when shot is 1/this number").defineInRange("dartLossMinimum", 20, 0, Integer.MAX_VALUE);
                this.gunJams = builder.comment("Should Toy Guns jam? if set to false the chance will be ignored").define("enableGunJamming", true);
                this.dartJamChance = builder.comment("The chance of a dart being lost is 1/this number").defineInRange("dartJamMinimum", 100, 1, Integer.MAX_VALUE);
                this.showJamStatusMessage = builder.comment("Show a status message when a gun jams").define("showGunJamStatusMessage", true);
				*/

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
