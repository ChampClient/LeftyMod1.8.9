package com.champ.lefthand.mixins;

import com.champ.lefthand.usage.ToggleScreen;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

@Mixin(GuiIngameMenu.class)
public class MixinGuiIngameMenu extends GuiScreen {

    @Inject(method = "initGui", at = @At("RETURN"))
    private void displayButtons(CallbackInfo ci){
        buttonList.add(new GuiButton(600, 5, 5, mc.fontRendererObj.getStringWidth("LEFT HAND") + 10, fontRendererObj.FONT_HEIGHT + 5, "LEFT HAND"));
        System.out.println("INIT GUI");
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if(button.id == 600){
            System.out.println("INIT TOGGLE SCREEN");
            mc.displayGuiScreen(new ToggleScreen());
        }
    }
}
