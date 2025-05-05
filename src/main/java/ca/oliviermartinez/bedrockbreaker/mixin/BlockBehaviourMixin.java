package ca.oliviermartinez.bedrockbreaker.mixin;

import ca.oliviermartinez.bedrockbreaker.BedrockBreaker;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.class)
public abstract class BlockBehaviourMixin {

    @Inject(method = "getDestroyProgress", at = @At("HEAD"), cancellable = true)
    public void getDestroySpeed(BlockState blockState, Player player, BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<Float> info) {
        if(player.getMainHandItem().is(BedrockBreaker.BEDROCK_BREAKER_ITEM)) {
            if(!blockState.is(Blocks.BEDROCK)) {
                info.setReturnValue(0F);
                return;
            }

            CompoundTag tag = player.getMainHandItem().getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).getUnsafe();
            if(!tag.getBoolean("last_layer") && blockPos.getY() <= player.level().getMinBuildHeight()) {
                info.setReturnValue(0F);
                return;
            }

            if(!tag.getBoolean("the_end") && player.level().dimensionType().effectsLocation().equals(BuiltinDimensionTypes.END.location())) {
                info.setReturnValue(0F);
                return;
            }

            info.setReturnValue(player.getDestroySpeed(blockState) / 0.8F / 30F);
        }
    }

}
