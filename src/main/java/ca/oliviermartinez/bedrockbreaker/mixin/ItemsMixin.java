package ca.oliviermartinez.bedrockbreaker.mixin;

import ca.oliviermartinez.bedrockbreaker.BedrockBreaker;
import ca.oliviermartinez.bedrockbreaker.item.BedrockBreakerItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Items.class)
public abstract class ItemsMixin {

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void onClinit(CallbackInfo info) {
        //? if =1.21.1 {
        BedrockBreaker.BEDROCK_BREAKER_RESOURCE_KEY = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(BedrockBreaker.MOD_ID, "bedrock_breaker"));
        BedrockBreaker.BEDROCK_BREAKER_ITEM = Items.registerItem(BedrockBreaker.BEDROCK_BREAKER_RESOURCE_KEY, new BedrockBreakerItem(new Item.Properties()));
        //?} else {
        //?}
    }

}
