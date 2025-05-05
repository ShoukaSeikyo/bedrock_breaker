package ca.oliviermartinez.bedrockbreaker.item;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;


//? if =1.21.1 {
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.Tool;
//?} else {
//?}

import java.util.List;

public class BedrockBreakerItem extends Item {
    public BedrockBreakerItem(Item.Properties properties) {
        super(properties.durability(64)
                //? if =1.21.1 {
                        .component(DataComponents.TOOL, new Tool(List.of(Tool.Rule.minesAndDrops(List.of(Blocks.BEDROCK), 15.0F)), 1.0F, 1))
                //?} else {
                //?}
        );
    }

    public boolean mineBlock(ItemStack itemStack, Level level, BlockState blockState, BlockPos blockPos, LivingEntity livingEntity) {
        if (!level.isClientSide) {
            itemStack.hurtAndBreak(1, livingEntity, EquipmentSlot.MAINHAND);
        }

        return blockState.is(Blocks.BEDROCK);
    }
}