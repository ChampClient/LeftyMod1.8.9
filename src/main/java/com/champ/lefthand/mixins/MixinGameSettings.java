        package com.champ.lefthand.mixins;

        import com.champ.lefthand.usage.ToggleScreen;
        import net.minecraft.client.Minecraft;
        import net.minecraft.client.settings.GameSettings;
        import net.minecraft.client.settings.KeyBinding;
        import net.minecraftforge.fml.common.Mod;
        import net.minecraftforge.fml.common.event.FMLEvent;
        import net.minecraftforge.fml.common.event.FMLInitializationEvent;
        import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
        import org.apache.commons.lang3.ArrayUtils;
        import org.lwjgl.input.Keyboard;
        import org.spongepowered.asm.mixin.Mixin;
        import org.spongepowered.asm.mixin.Shadow;
        import org.spongepowered.asm.mixin.injection.At;
        import org.spongepowered.asm.mixin.injection.Inject;
        import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

        @Mixin(GameSettings.class)
        public class MixinGameSettings {

            public final KeyBinding OPEN_GUI = new KeyBinding("Open Gui", Keyboard.KEY_H, "Left Hand");

            @Shadow
            public KeyBinding[] keyBindings;

            private void addKeybinds() {
                this.keyBindings = ((KeyBinding[]) ArrayUtils.add(this.keyBindings, this.OPEN_GUI));
            }

            @Inject(at = @At("RETURN"), method = "<init>()V")
            private void injectFirstConstructor(CallbackInfo ci) {
                this.addKeybinds();
            }

            @Inject(at = @At("RETURN"), method = "<init>(Lnet/minecraft/client/Minecraft;Ljava/io/File;)V")
            private void injectSecondConstructor(CallbackInfo ci) {
                this.addKeybinds();
            }
        }
