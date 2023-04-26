package com.champ.lefthand;

import com.champ.lefthand.mixins.MixinGameSettings;
import com.champ.lefthand.usage.ToggleScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = LeftyMod.MODID, version = LeftyMod.VERSION, name = LeftyMod.NAME)
public class LeftyMod {
    public static final String MODID = "lefthand";
    public static final String VERSION = "1.0";
    public static final String NAME = "Lefty Mod";

    public static LeftyMod INSTANCE = new LeftyMod();

    private static Minecraft mc = Minecraft.getMinecraft();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("STARTING MOD-------------------------------------------");
    }
}
