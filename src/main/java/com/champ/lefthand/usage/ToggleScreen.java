package com.champ.lefthand.usage;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class ToggleScreen extends GuiScreen {

    public static boolean isEnabled;

    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(0, 5, 5, mc.fontRendererObj.getStringWidth("X") + 10, fontRendererObj.FONT_HEIGHT + 10, "X"));
        this.buttonList.add(new GuiButton(1, 100, 5, mc.fontRendererObj.getStringWidth("Left Hand On") + 10, fontRendererObj.FONT_HEIGHT + 5, "Left Hand On"));
        this.buttonList.add(new GuiButton(2, 100, 50, mc.fontRendererObj.getStringWidth("left Hand Off") + 10, mc.fontRendererObj.FONT_HEIGHT + 5,"Left Hand Off"));

    }

    @Override
    public void onGuiClosed() {

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawBackground(0);
        mc.fontRendererObj.drawStringWithShadow("MY FIRST MOD", this.width / 2 - 50, this.height / 2 - 50, -1);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if(button.id == 0){
            mc.displayGuiScreen(new GuiIngameMenu());
        }
        if(button.id == 1) {
            isEnabled = true;
        }
        if(button.id == 2){
            isEnabled = false;
        }
    }
}
