package ca.oliviermartinez.bedrockbreaker;

//? if fabric {
/*import net.fabricmc.api.ModInitializer;
*///?}

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//? if neoforge {
import net.neoforged.fml.common.Mod;
@Mod("bedrock_breaker")
//?}
public class BedrockBreaker
//? if fabric {
 /*implements ModInitializer
*///?}
{

    public static final String MOD_ID = "bedrock_breaker";
    public static final String MOD_NAME = "Bedrock Breaker";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    private static BedrockBreaker instance;

    //? if =1.21.1 {
    public static ResourceKey<Item> BEDROCK_BREAKER_RESOURCE_KEY;
    public static Item BEDROCK_BREAKER_ITEM;
    //?} else {
    //?}

    //? if fabric {
    /*@Override
    public void onInitialize() {
        this.init();
    }
    *///?}

    public BedrockBreaker() {
        instance = this;
        //? if neoforge {
        init();
        //?}
    }

    public void init() {
    }
}
