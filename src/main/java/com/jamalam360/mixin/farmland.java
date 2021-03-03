package com.jamalam360.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.Block;
import net.minecraft.block.FarmlandBlock;

@Mixin(FarmlandBlock.class)
public class farmland extends Block{
    public farmland(Settings settings) {
        super(settings);
    }

    @Inject(method = "Lnet/minecraft/block/FarmlandBlock;setToDirt(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V", at = @At("HEAD"), cancellable = true)
    private static void setToDirt(CallbackInfo info){
        info.cancel();
    }
}