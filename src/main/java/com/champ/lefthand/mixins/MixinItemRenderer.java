package com.champ.lefthand.mixins;

import com.champ.lefthand.usage.ToggleScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public class MixinItemRenderer {

    @Inject(method = "renderItemInFirstPerson", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;pushMatrix()V", shift = At.Shift.AFTER))
    private void renderItemInFirstPerson(float partialTicks, CallbackInfo ci) {
        //System.out.println("Mixin worked!:))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))");
        if(ToggleScreen.isEnabled) {
            GL11.glScaled(-1.0D, 1.0D, 1.0D);
            GlStateManager.disableCull();
        }
    }
}
