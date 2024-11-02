package net.rare_mods.examplemod.mixin;

import net.minecraft.client.Minecraft;
import net.neoforged.fml.loading.FMLLoader;
import net.rare_mods.examplemod.Constants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injected$onClassInit(CallbackInfo callbackInfo) {

        if (FMLLoader.isProduction()) return;

        Constants.LOG.info("Minecraft.class was initialized in a development environment!");
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void injected$onObjInit(CallbackInfo callbackInfo) {

        if (FMLLoader.isProduction()) return;

        Constants.LOG.info("Minecraft was initialized in a development environment!");
    }
}
