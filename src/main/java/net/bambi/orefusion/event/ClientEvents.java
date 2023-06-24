package net.bambi.orefusion.event;

import net.bambi.orefusion.OreFusion;
import net.bambi.orefusion.block.entity.ModBlockEntities;
import net.bambi.orefusion.block.entity.renderer.GemInfusingStationBlockEntityRenderer;
import net.bambi.orefusion.client.ThirstHudOverlay;
import net.bambi.orefusion.networking.ModMessages;
import net.bambi.orefusion.networking.packet.DrinkWaterC2SPacket;
import net.bambi.orefusion.networking.packet.ExampleC2SPacket;
import net.bambi.orefusion.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = OreFusion.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinding.DRINKING_KEY.consumeClick()) {
                ModMessages.sendToServer(new DrinkWaterC2SPacket());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = OreFusion.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.DRINKING_KEY);
        }

        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
            event.registerAboveAll("thirst", ThirstHudOverlay.HUD_THIRST);
        }

        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            // event.registerBlockEntityRenderer(ModBlockEntities.GEM_INFUSING_STATION.get(),
            // GemInfusingStationBlockEntityRenderer::new);
        }
    }
}