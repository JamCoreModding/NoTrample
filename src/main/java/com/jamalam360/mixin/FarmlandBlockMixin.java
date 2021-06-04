package com.jamalam360.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.Block;
import net.minecraft.block.FarmlandBlock;

@Mixin(FarmlandBlock.class)
public class FarmlandBlockMixin extends Block {
    public FarmlandBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "onLandedUpon(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/Entity;F)V", at = @At("HEAD"), cancellable = true)
    public void onLandedUpon(World world, BlockPos pos, Entity entity, float distance, CallbackInfo info) {
        if (entity instanceof PlayerEntity) {
            Iterable<ItemStack> armorItems = entity.getArmorItems();

            for (ItemStack itemStack : armorItems) {
                if (((ArmorItem) itemStack.getItem()).getSlotType() == EquipmentSlot.FEET) {
                    if (EnchantmentHelper.getLevel(Enchantments.FEATHER_FALLING, itemStack) > 0){
                        info.cancel();
                    }
                }
            }
        }
    }
}